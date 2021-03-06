/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Omar Elabd, Nathan Tolbert
 */

package edu.illinois.ncsa.incore.service.dfr3.controllers;

import edu.illinois.ncsa.incore.common.auth.IAuthorizer;
import edu.illinois.ncsa.incore.common.auth.Privileges;
import edu.illinois.ncsa.incore.common.dao.ISpaceRepository;
import edu.illinois.ncsa.incore.common.exceptions.IncoreHTTPException;
import edu.illinois.ncsa.incore.common.models.Space;
import edu.illinois.ncsa.incore.common.utils.UserInfoUtils;
import edu.illinois.ncsa.incore.service.dfr3.daos.IFragilityDAO;
import edu.illinois.ncsa.incore.service.dfr3.models.FragilitySet;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;


@SwaggerDefinition(
    info = @Info(
        version = "v0.6.3",
        description = "IN-CORE Service For Fragilities and Fragility mappings",

        title = "IN-CORE v2 Fragility Service API",
        contact = @Contact(
            name = "IN-CORE Dev Team",
            email = "incore-dev@lists.illinois.edu",
            url = "https://incore.ncsa.illinois.edu"
        ),
        license = @License(
            name = "Mozilla Public License 2.0 (MPL 2.0)",
            url = "https://www.mozilla.org/en-US/MPL/2.0/"
        )
    ),

    consumes = {"application/json"},
    produces = {"application/json"},
    schemes = {SwaggerDefinition.Scheme.HTTP}
)


@Api(value = "fragilities", authorizations = {})
@Path("fragilities")
public class FragilityController {
    private static final Logger logger = Logger.getLogger(FragilityController.class);

    private String username;

    @Inject
    IAuthorizer authorizer;
    @Inject
    private IFragilityDAO fragilityDAO;
    @Inject
    private ISpaceRepository spaceRepository;

    @Inject
    public FragilityController(
        @ApiParam(value = "User credentials.", required = true) @HeaderParam("x-auth-userinfo") String userInfo) {
        this.username = UserInfoUtils.getUsername(userInfo);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Gets list of fragilities", notes = "Apply filters to get the desired set of fragilities")
    public List<FragilitySet> getFragilities(@ApiParam(value = "demand type filter", example = "PGA") @QueryParam("demand") String demandType,
                                             @ApiParam(value = "hazard type  filter", example = "earthquake") @QueryParam("hazard") String hazardType,
                                             @ApiParam(value = "Inventory type", example = "building") @QueryParam("inventory") String inventoryType,
                                             @ApiParam(value = "not implemented", hidden = true) @QueryParam("author") String author,
                                             @ApiParam(value = "Legacy fragility Id from v1") @QueryParam("legacy_id") String legacyId,
                                             @ApiParam(value = "Fragility creator's username") @QueryParam("creator") String creator,
                                             @ApiParam(value = "Name of space") @DefaultValue("") @QueryParam("space") String spaceName,
                                             @ApiParam(value = "Skip the first n results") @QueryParam("skip") int offset,
                                             @ApiParam(value = "Limit no of results to return") @DefaultValue("100") @QueryParam("limit") int limit) {
        Map<String, String> queryMap = new HashMap<>();

        if (legacyId != null) {
            queryMap.put("legacyId", legacyId);
        }

        if (demandType != null) {
            queryMap.put("demandType", demandType);
        }

        if (hazardType != null) {
            queryMap.put("hazardType", hazardType);
        }

        if (inventoryType != null) {
            queryMap.put("inventoryType", inventoryType);
        }

        if (creator != null) {
            queryMap.put("creator", creator);
        }

        List<FragilitySet> fragilitySets;

        if (queryMap.isEmpty()) {
            fragilitySets = this.fragilityDAO.getFragilities();
        } else {
            fragilitySets = this.fragilityDAO.queryFragilities(queryMap);
        }

        if (!spaceName.equals("")) {
            Space space = spaceRepository.getSpaceByName(spaceName);
            if (space == null) {
                throw new IncoreHTTPException(Response.Status.NOT_FOUND, "Could not find a space with name " + spaceName);
            }
            if (!authorizer.canRead(username, space.getPrivileges())) {
                throw new IncoreHTTPException(Response.Status.FORBIDDEN, username + " is not authorized to read the space " + spaceName);
            }
            List<String> spaceMembers = space.getMembers();

            fragilitySets = fragilitySets.stream()
                .filter(fragility -> spaceMembers.contains(fragility.getId()))
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
            return fragilitySets;
        }

        Set<String> membersSet = authorizer.getAllMembersUserHasReadAccessTo(username, spaceRepository.getAllSpaces());

        List<FragilitySet> accessibleFragilities = fragilitySets.stream()
            .filter(b -> membersSet.contains(b.getId()))
            .skip(offset)
            .limit(limit)
            .collect(Collectors.toList());

        return accessibleFragilities;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Create a fragility set", notes = "Post a fragility set to the dfr3 service")
    public FragilitySet uploadFragilitySet(@ApiParam(value = "json representing the fragility set") FragilitySet fragilitySet) {
        fragilitySet.setCreator(username);
        String fragilityId = this.fragilityDAO.saveFragility(fragilitySet);

        Space space = spaceRepository.getSpaceByName(username);
        if (space == null) {
            space = new Space(username);
            space.setPrivileges(Privileges.newWithSingleOwner(username));
        }
        space.addMember(fragilityId);
        spaceRepository.addSpace(space);

        return fragilitySet;
    }

    @GET
    @Path("{fragilityId}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Gets a fragility by Id", notes = "Get a particular fragility based on the id provided")
    public FragilitySet getFragilityById(@ApiParam(value = "fragility id", example = "5b47b2d8337d4a36187c6727") @PathParam("fragilityId") String id) {
        Optional<FragilitySet> fragilitySet = this.fragilityDAO.getFragilitySetById(id);

        if (fragilitySet.isPresent()) {
            if (authorizer.canUserReadMember(username, id, spaceRepository.getAllSpaces())) {
                return fragilitySet.get();
            } else {
                throw new IncoreHTTPException(Response.Status.FORBIDDEN, this.username + " does not have privileges to access the fragility with id " + id);
            }
        }
        throw new IncoreHTTPException(Response.Status.NOT_FOUND, "Could not find a fragility set with id " + fragilitySet);
    }

    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Search for a text in all fragilities", notes = "Gets all fragilities that contain a specific text")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "No fragilities found with the searched text")
    })
    public List<FragilitySet> findFragilities(@ApiParam(value = "Text to search by", example = "steel") @QueryParam("text") String text,
                                              @ApiParam(value = "Skip the first n results") @QueryParam("skip") int offset,
                                              @ApiParam(value = "Limit no of results to return") @DefaultValue("100") @QueryParam("limit") int limit) {
            List<FragilitySet> sets = new ArrayList<>();
            Optional<FragilitySet> fs = this.fragilityDAO.getFragilitySetById(text);
            if (fs.isPresent()) {
                sets.add(fs.get());
            } else {
                sets = this.fragilityDAO.searchFragilities(text);
            }

            Set<String> membersSet = authorizer.getAllMembersUserHasReadAccessTo(username, spaceRepository.getAllSpaces());

            List<FragilitySet> accessibleFragilities = sets.stream()
                .filter(b -> membersSet.contains(b.getId()))
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());

            return accessibleFragilities;

    }

}
