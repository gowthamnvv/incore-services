/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Omar Elabd, Nathan Tolbert
 */

package edu.illinois.ncsa.incore.service.fragility.controllers;

import edu.illinois.ncsa.incore.common.auth.IAuthorizer;
import edu.illinois.ncsa.incore.common.auth.Privileges;
import edu.illinois.ncsa.incore.common.dao.ISpaceRepository;
import edu.illinois.ncsa.incore.common.models.Space;
import edu.illinois.ncsa.incore.service.fragility.daos.IFragilityDAO;
import edu.illinois.ncsa.incore.service.fragility.daos.IMappingDAO;
import edu.illinois.ncsa.incore.service.fragility.models.FragilitySet;
import edu.illinois.ncsa.incore.service.fragility.models.MappingSet;
import edu.illinois.ncsa.incore.service.fragility.models.dto.MappingRequest;
import edu.illinois.ncsa.incore.service.fragility.models.dto.MappingResponse;
import edu.illinois.ncsa.incore.service.fragility.models.mapping.FragilityMapper;
import edu.illinois.ncsa.incore.service.fragility.models.mapping.MatchFilterMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.*;
import ncsa.tools.common.exceptions.ParseException;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.stream.Collectors;

@Api(value="mappings", authorizations = {})
@Path("mappings")
public class MappingController {
    private static final Logger logger = Logger.getLogger(MappingController.class);

    @Inject
    private IMappingDAO mappingDAO;
    @Inject
    private IFragilityDAO fragilityDAO;

    @Inject
    private ISpaceRepository spaceRepository;

    @Inject
    private IAuthorizer authorizer;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Gets list of fragility mappings", notes="Apply filters to get the desired set of fragility mappings")
    public List<MappingSet> getMappings(@HeaderParam("X-Credential-Username") String username,
                                        @ApiParam(value = "hazard type  filter", example= "earthquake") @QueryParam("hazard") String hazardType,
                                        @ApiParam(value = "Inventory type", example="building") @QueryParam("inventory") String inventoryType,
                                        @ApiParam(value = "Fragility creator's username") @QueryParam("creator") String creator,
                                        @ApiParam(value = "Name of space") @DefaultValue("") @QueryParam("space") String spaceName,
                                        @ApiParam(value = "Skip the first n results") @QueryParam("skip") int offset,
                                        @ApiParam(value = "Limit no of results to return") @DefaultValue("100") @QueryParam("limit") int limit) {

        Map<String, String> queryMap = new HashMap<>();

        if (hazardType != null) {
            queryMap.put("hazardType", hazardType);
        }

        if (inventoryType != null) {
            queryMap.put("inventoryType", inventoryType);
        }

        if (creator != null) {
            queryMap.put("creator", creator);
        }

        List<MappingSet> mappingSets;

        if (queryMap.isEmpty()) {
            mappingSets = this.mappingDAO.getMappingSets();
        } else {
            mappingSets = this.mappingDAO.queryMappingSets(queryMap);
        }
        if (!spaceName.equals("")) {
            Space space = spaceRepository.getSpaceByName(spaceName);
            if (space == null) {
                throw new NotFoundException();
            }
            if (!authorizer.canRead(username, space.getPrivileges())) {
                throw new NotAuthorizedException(username + " is not authorized to read the space " + spaceName);
            }
            List<String> spaceMembers = space.getMembers();

            mappingSets = mappingSets.stream()
                .filter(mapping -> spaceMembers.contains(mapping.getId()))
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
            if (mappingSets.size() == 0) {
                throw new NotFoundException("No mappings were found in space " + spaceName);
            }
            return mappingSets;
        }
        Set<String> membersSet = authorizer.getAllMembersUserHasReadAccessTo(username, spaceRepository.getAllSpaces());

        return mappingSets.stream()
            .filter(b -> membersSet.contains(b.getId()))
            .skip(offset)
            .limit(limit)
            .collect(Collectors.toList());
    }

    @GET
    @Path("{mappingSetId}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Gets a fragility mapping set by Id", notes="Get a particular fragility mapping set based on the id provided")
    public MappingSet getMappingSetById(@HeaderParam("X-Credential-Username") String username,
                                        @ApiParam(value="hexadecimal fragility mapping id", example = "5b47b2d9337d4a36187c7563") @PathParam("mappingSetId") String id) {
        Optional<MappingSet> mappingSet = this.mappingDAO.getMappingSetById(id);

        if (mappingSet.isPresent()) {
            MappingSet actual = mappingSet.get();
            if (authorizer.canUserReadMember(username, id, spaceRepository.getAllSpaces())) {
                return actual;
            }
            throw new ForbiddenException();
        } else {
            throw new NotFoundException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Create a fragility Mapping", notes="Post a fragility mapping set that maps a fragility to an inventory's attributes")
    public MappingSet uploadMapping(@HeaderParam("X-Credential-Username") String username,
                                    @ApiParam(value="json representing the fragility mapping") MappingSet mappingSet) {
        mappingSet.setCreator(username);

        String id = this.mappingDAO.saveMappingSet(mappingSet);

        Space space = spaceRepository.getSpaceByName(username);
        if (space == null) {
            space = new Space(username);
            space.setPrivileges(Privileges.newWithSingleOwner(username));
        }
        space.addMember(id);
        spaceRepository.addSpace(space);

        return mappingSet;
    }

    @POST
    @Path("{mappingSetId}/matched")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Map each inventory to a fragility set Id based on the input mapping Id",
        notes = "Returns a json where key is the inventory id that is mapped to a fragility set id based on the input mapping id")
    public MappingResponse mapFragilities(@HeaderParam("X-Credential-Username") String username,
                                          @PathParam("mappingSetId") String mappingSetId,
                                          MappingRequest mappingRequest) throws ParseException {

        Map<String, FragilitySet> fragilitySetMap = new HashMap<>();
        Map<String, String> fragilityMap = new HashMap<>();

        List<Space> allSpaces = spaceRepository.getAllSpaces();

        boolean canReadMapping = authorizer.canUserReadMember(username, mappingSetId, allSpaces);
        if (!canReadMapping) {
            throw new ForbiddenException();
        }

        Optional<MappingSet> mappingSet = this.mappingDAO.getMappingSetById(mappingSetId);

        if (!mappingSet.isPresent()) {
            throw new BadRequestException();
        }

        MatchFilterMap matchFilterMap = mappingSet.get().asMatchFilterMap();

        FragilityMapper mapper = new FragilityMapper();

        mapper.addMappingSet(matchFilterMap);

        List<Feature> features = new ArrayList<>();

        if (mappingRequest.mappingSubject.inventory instanceof FeatureCollection) {
            features = ((FeatureCollection) mappingRequest.mappingSubject.inventory).getFeatures();
        }

        if (mappingRequest.mappingSubject.inventory instanceof Feature) {
            features = new ArrayList<>();
            features.add((Feature) mappingRequest.mappingSubject.inventory);
        }

        Map<String, FragilitySet> queriedFragilitySets = new HashMap<>();
        for (Feature feature : features) {
            String fragilityKey = mapper.getFragilityFor(mappingRequest.mappingSubject.schemaType.toString(),
                feature.getProperties(), mappingRequest.parameters);

            if (ObjectId.isValid(fragilityKey)) {
                FragilitySet currFragility = null;
                if (queriedFragilitySets.containsKey(fragilityKey)) {
                    currFragility = queriedFragilitySets.get(fragilityKey);
                } else {
                    Optional<FragilitySet> fragilitySet = this.fragilityDAO.getFragilitySetById(fragilityKey);
                    if (fragilitySet.isPresent()) {
                        if (authorizer.canUserReadMember(username, fragilityKey, allSpaces)) {
                            currFragility = fragilitySet.get();
                        }
                        // if currFagility is set to null for a queried fragility,
                        // it means we already read the fragility and determined that it doesn't have read access.
                        queriedFragilitySets.put(fragilityKey, currFragility);
                    }
                }

                // If we found a matching fragility and user has read access to it
                if (currFragility != null) {
                    fragilitySetMap.put(fragilityKey, currFragility);
                    fragilityMap.put(feature.getId(), fragilityKey);
                }
            }
        }

        // Construct response
        MappingResponse mappingResponse = new MappingResponse(fragilitySetMap, fragilityMap);

        return mappingResponse;
    }


}
