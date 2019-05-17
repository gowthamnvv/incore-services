/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 *   Contributors:
 *   Yong Wook Kim (NCSA) - initial API and implementation
 *   Diego Calderon (NCSA)
 *******************************************************************************/


package edu.illinois.ncsa.incore.service.data.controllers;

import edu.illinois.ncsa.incore.common.auth.IAuthorizer;
import edu.illinois.ncsa.incore.common.auth.PrivilegeLevel;
import edu.illinois.ncsa.incore.common.dao.ISpaceRepository;
import edu.illinois.ncsa.incore.common.models.Space;
import edu.illinois.ncsa.incore.common.auth.Privileges;
import edu.illinois.ncsa.incore.common.config.Config;
import edu.illinois.ncsa.incore.common.utils.JsonUtils;
import edu.illinois.ncsa.incore.service.data.dao.IRepository;
import edu.illinois.ncsa.incore.service.data.models.Dataset;
import edu.illinois.ncsa.incore.service.data.models.FileDescriptor;
import edu.illinois.ncsa.incore.service.data.models.NetworkData;
import edu.illinois.ncsa.incore.service.data.models.NetworkDataset;
import edu.illinois.ncsa.incore.service.data.models.Space;
import edu.illinois.ncsa.incore.service.data.models.impl.FileStorageDisk;
import edu.illinois.ncsa.incore.service.data.utils.FileUtils;
import edu.illinois.ncsa.incore.service.data.utils.GeoserverUtils;
import edu.illinois.ncsa.incore.service.data.utils.GeotoolsUtils;
import edu.illinois.ncsa.incore.service.data.utils.DataJsonUtils;
import io.swagger.annotations.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ywkim on 7/26/2017.
 */

@SwaggerDefinition(
    info = @Info(
        description = "IN-CORE Data Service for creating and accessing datasets",
        version = "v0.3.0",
        title = "IN-CORE v2 Data Service API",
        contact = @Contact(
            name = "IN-CORE Dev Team",
            email = "incore-dev@lists.illinois.edu",
            url = "https://incore2.ncsa.illinois.edu"
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

@Api(value = "datasets", authorizations = {})

@Path("datasets")
public class DatasetController {
    private static final String DATA_REPO_FOLDER = Config.getConfigProperties().getProperty("data.repo.data.dir");
    private static final String GEOSERVER_ENABLE = Config.getConfigProperties().getProperty("geoserver.enable");
    private static final String POST_PARAMENTER_NAME = "name";
    private static final String POST_PARAMENTER_FILE = "file";
    private static final String POST_PARAMENTER_FILE_LINK = "link-file";
    private static final String POST_PARAMENTER_FILE_NODE = "node-file";
    private static final String POST_PARAMENTER_FILE_GRAPH = "graph-file";
    private static final String POST_PARAMENTER_META = "parentdataset";
    private static final String POST_PARAMETER_DATASET_ID = "datasetId";
    private static final String UPDATE_OBJECT_NAME = "property name";
    private static final String UPDATE_OBJECT_VALUE = "property value";
    private static final String WEBDAV_SPACE_NAME = "incore";
    private static final Logger logger = Logger.getLogger(DatasetController.class);

    @Inject
    private IRepository repository;

    @Inject
    private ISpaceRepository spaceRepository;

    @Inject
    private IAuthorizer authorizer;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Gets a dataset from the Dataset collection", notes = "")
    public Dataset getDatasetbyId(@HeaderParam("X-Credential-Username") String username,
                                  @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String datasetId) {
        Dataset dataset = repository.getDatasetById(datasetId);
        if (dataset == null) {
            logger.error("Error finding dataset with the id of " + datasetId);
            throw new NotFoundException("Error finding dataset with the id of " + datasetId);
        }

        //feeling lucky, try to get dataset directly from user's space
        Space space = spaceRepository.getSpaceByName(username);
        if (space != null && space.hasMember(datasetId) ) {
            return dataset;
        }

        if (authorizer.canUserReadMember(username, datasetId, spaceRepository.getAllSpaces())) {
            return dataset;
        }

        throw new ForbiddenException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Gets a list of datasets", notes = "Can filter by type, title, creator etc.")
    public List<Dataset> getDatasets(@HeaderParam("X-Credential-Username") String username,
                                     @ApiParam(value = "DataType of IN-CORE datasets. Can filter by partial datatype strings. ex: ergo:buildingInventoryVer5, ergo:census",
                                         required = false) @QueryParam("type") String typeStr,
                                     @ApiParam(value = "Title of dataset. Can filter by partial title strings", required = false) @QueryParam("title") String titleStr,
                                     @ApiParam(value = "Username of the creator", required = false) @QueryParam("creator") String creator,
                                     @ApiParam(value = "Name of space") @DefaultValue("") @QueryParam("space") String spaceName,
                                     @ApiParam(value = "Skip the first n results") @QueryParam("skip") int offset,
                                     @ApiParam(value = "Limit no of results to return") @DefaultValue("100") @QueryParam("limit") int limit
    ) {
        List<Dataset> datasets;
        if (typeStr != null && titleStr == null) {  // query only for the type
            datasets = repository.getDatasetByType(typeStr);
        } else if (typeStr == null && titleStr != null) {   // query only for the title
            datasets = repository.getDatasetByTitle(titleStr);
        } else if (typeStr != null && titleStr != null) {   // query for both type and title
            datasets = repository.getDatasetByTypeAndTitle(typeStr, titleStr);
        } else {
            datasets = repository.getAllDatasets();
        }

        if (datasets == null) {
            logger.error("Error finding dataset");
            throw new NotFoundException("Error finding dataset");
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
            datasets = datasets.stream()
                .filter(hurricane -> spaceMembers.contains(hurricane.getId()))
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
            if (datasets.size() == 0) {
                throw new NotFoundException("No hurricanes were found in space " + spaceName);
            }
            return datasets;
        }
        //get all datasets that the user can read
        Set<String> userMembersSet = authorizer.getAllMembersUserHasReadAccessTo(username, spaceRepository.getAllSpaces());

        //return the intersection between all datasets, and the ones the user can read
        List<Dataset> accesibleDatasets = datasets.stream()
            .filter(dataset -> userMembersSet.contains(dataset.getId()))
            .skip(offset)
            .limit(limit)
            .collect(Collectors.toList());

        if(accesibleDatasets.size() > 0) {
            return accesibleDatasets;
        }
        throw new ForbiddenException();
    }

    @GET
    @Path("{id}/blob")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @ApiOperation(value = "Returns a zip file that contains all the files attached to a dataset specified by {id}", notes = "")
    public Response getFileByDataset(@HeaderParam("X-Credential-Username") String username,
                                     @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String datasetId) {
        File outFile = null;
        Dataset dataset = getDatasetbyId(username, datasetId);

        try {
            outFile = FileUtils.loadFileFromService(dataset, repository, false, "");
        } catch (IOException e) {
            logger.error("Error creating temp directory for " + datasetId, e);
            throw new InternalServerErrorException("Error creating temp directory for " + datasetId, e);
        } catch (URISyntaxException e) {
            logger.error("Error creating file with given url for " + datasetId, e);
            throw new InternalServerErrorException("Error creating file with given url for " + datasetId, e);
        }

        if (outFile != null) {
            String fileName = outFile.getName();
            return Response.ok(outFile, MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();
        } else {
            logger.error("Error finding output zip file for " + datasetId);
            throw new NotFoundException("Error finding output zip file for " + datasetId);
        }
    }


    @GET
    @Path("{id}/files")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Gets the list of files associated with the dataset and their metadata", notes = "")

    public List<FileDescriptor> getDatasetsFiles(@HeaderParam("X-Credential-Username") String username,
                                                 @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String datasetId) {
        Dataset dataset = getDatasetbyId(username, datasetId);

        List<FileDescriptor> fds = dataset.getFileDescriptors();
        if (fds == null) {
            logger.error("Error finding FileDescriptor from the dataset with the id of " + datasetId);
            throw new NotFoundException("Error finding FileDescriptor from the dataset with the id of " + datasetId);
        }
        return fds;
    }


    @GET
    @Path("{id}/files/{file_id}/blob")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @ApiOperation(value = "Returns a file that is attached to a FileDescriptor of a dataset", notes = "")
    public Response getFileByFileDescriptor(@HeaderParam("X-Credential-Username") String username,
                                            @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String id,
                                            @ApiParam(value = "FileDescriptor Object Id", required = true) @PathParam("file_id") String fileId) {
        File outFile = null;
        Dataset dataset = getDatasetbyId(username, id);

        List<FileDescriptor> fds = dataset.getFileDescriptors();
        String dataUrl = "";
        String fdId = "";
        String fileName = "";

        for (FileDescriptor fd : fds) {
            fdId = fd.getId();
            if (fdId.equals(fileId)) {
                dataUrl = FilenameUtils.concat(DATA_REPO_FOLDER, fd.getDataURL());
                fileName = fd.getFilename();
            }
        }

        if (!dataUrl.equals("")) {
            outFile = new File(dataUrl);
            outFile.renameTo(new File(outFile.getParentFile(), fileName));
        }

        if (outFile != null) {
            return Response.ok(outFile, MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();
        } else {
            logger.error("Error finding output file.");
            throw new NotFoundException("Error finding output file.");
        }
    }


    @GET
    @Path("{id}/files/{file_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Gets metadata of a file associated to a dataset", notes = "")
    public FileDescriptor getFileByDatasetIdFileDescriptor(@HeaderParam("X-Credential-Username") String username,
                                                           @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String id,
                                                           @ApiParam(value = "FileDescriptor Object Id", required = true) @PathParam("file_id") String fileId) {
        Dataset dataset = getDatasetbyId(username, id);

        List<FileDescriptor> fds = dataset.getFileDescriptors();
        String fdId = "";
        FileDescriptor fileDescriptor = null;


        for (FileDescriptor fd : fds) {
            fdId = fd.getId();
            if (fdId.equals(fileId)) {
                fileDescriptor = fd;
                break;
            }
        }

        if (fileDescriptor == null) {
            logger.error("Error finding FileDescriptor with the id of " + fileId);
            throw new NotFoundException("Error finding FileDescriptor with the id of " + fileId);
        }
        return fileDescriptor;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Ingest dataset object as json", notes = "Files have to uploaded to the dataset separately using {id}/files endpoint")
    public Dataset ingestDataset(@HeaderParam("X-Credential-Username") String username,
                                 @ApiParam(value = "JSON representing an input dataset", required = true) @FormDataParam("dataset") String inDatasetJson) {
        if (username == null) {
            logger.error("Credential user name should be provided.");
            throw new BadRequestException("Credential user name should be provided.");
        }

        boolean isJsonValid = JsonUtils.isJSONValid(inDatasetJson);
        if (isJsonValid != true) {
            logger.error("Posted json is not a valid json.");
            throw new BadRequestException("Posted json is not a valid json.");
        }

        boolean isDatasetParameterValid = DataJsonUtils.isDatasetParameterValid(inDatasetJson);
        if (isDatasetParameterValid != true) {
            logger.error("Posted json is not a valid json.");
            throw new BadRequestException("Posted json has wrong parameter");
        }

        String title = "";
        String dataType = "";
        String sourceDataset = "";
        String format = "";
        String fileName = "";
        String description = "";

        // create DataWolf POJO object
        Dataset dataset = new Dataset();
        if (isJsonValid) {
            title = JsonUtils.extractValueFromJsonString(FileUtils.DATASET_TITLE, inDatasetJson);
            dataType = JsonUtils.extractValueFromJsonString(FileUtils.DATASET_TYPE, inDatasetJson);
            sourceDataset = JsonUtils.extractValueFromJsonString(FileUtils.DATASET_SOURCE_DATASET, inDatasetJson);
            format = JsonUtils.extractValueFromJsonString(FileUtils.DATASET_FORMAT, inDatasetJson);
            fileName = JsonUtils.extractValueFromJsonString(FileUtils.DATASET_FILE_NAME, inDatasetJson);
            description = JsonUtils.extractValueFromJsonString(FileUtils.DATASET_DESCRIPTION, inDatasetJson);

            dataset.setTitle(title);
            dataset.setCreator(username);
            dataset.setDataType(dataType);
            dataset.setDescription(description);
            dataset.setSourceDataset(sourceDataset);
            dataset.setFormat(format);
            dataset.setPrivileges(Privileges.newWithSingleOwner(username));

            // add network information in the dataset
            if (format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
                NetworkDataset networkDataset = JsonUtils.createNetworkDataset(inDatasetJson);
                dataset.setNetworkDataset(networkDataset);
            }

            dataset = repository.addDataset(dataset);
            if (dataset == null) {
                logger.error("Error finding dataset with the id of " + dataset.getId());
                throw new NotFoundException("Error finding dataset with the id of " + dataset.getId());
            }

            String id = dataset.getId();

            Space space = spaceRepository.getSpaceByName(username);
            if(space == null){
                space = new Space(username);
                space.addMember(id);
                space.setPrivileges(Privileges.newWithSingleOwner(username));
                spaceRepository.addSpace(space);
            } else {
                space.addMember(id);
                spaceRepository.addSpace(space);
            }

        }

        return dataset;
    }


    @DELETE
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @ApiOperation(value = "Deletes a dataset", notes = "Also deletes attached information like files and geoserver layer")
    public Dataset deleteDataset(@HeaderParam("X-Credential-Username") String username,
                                 @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String datasetId) {
        if (username == null) {
            logger.error("Credential user name should be provided.");
            throw new BadRequestException("Credential user name should be provided.");
        }

        Dataset dataset = getDatasetbyId(username, datasetId);

        if (dataset == null) {
            throw new NotFoundException();
        }

        String format = dataset.getFormat();

        if (authorizer.canUserDeleteMember(username, datasetId, spaceRepository.getAllSpaces())) {
            // remove id from spaces
            List<Space> spaces = spaceRepository.getAllSpaces();
            for(Space space : spaces){
                if(space.hasMember(datasetId)){
                    space.removeMember(datasetId);
                    spaceRepository.addSpace(space);
                }
            }
            // remove dataset
            dataset = repository.deleteDataset(datasetId);
            if (dataset != null) {
                // remove files
                List<FileDescriptor> fds = dataset.getFileDescriptors();
                if (fds.size() > 0) {
                    for (FileDescriptor fd : fds) {
                        File file = new File(FilenameUtils.concat(DATA_REPO_FOLDER, fd.getDataURL()));
                        FileUtils.deleteTmpDir(file);

                    }
                }
                // remove geoserver layer
                if (format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
                        // remove network dataset
                        boolean linkRemoved = GeoserverUtils.removeLayerFromGeoserver(datasetId, "_link");
                        boolean nodeRemoved = GeoserverUtils.removeLayerFromGeoserver(datasetId, "_node");
                        boolean storeRemoved = GeoserverUtils.removeStoreFromGeoserver(datasetId);
                    } else {
                        boolean layerRemoved = GeoserverUtils.removeLayerFromGeoserver(datasetId);
                    }

}
        } else {
            throw new NotAuthorizedException(username + " is not authorized to delete the dataset");
        }

        return dataset;
    }


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/files")
    @ApiOperation(value = "Upload file(s) to attach to a dataset", notes = "GIS files like shp, tif etc. are also uploaded to IN-CORE geoserver")
    public Dataset uploadFiles(@HeaderParam("X-Credential-Username") String username,
                               @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String datasetId,
                               @ApiParam(value = "Form inputs representing the file(s). The id/key of each input file has to be 'file'", required = true)
                                   FormDataMultiPart inputs) {
        if (username == null) {
            logger.error("Credential user name should be provided.");
            throw new BadRequestException("Credential user name should be provided.");
        }
        if (!authorizer.canUserModifyMember(username, datasetId, spaceRepository.getAllSpaces())) {
            throw new NotAuthorizedException(username + " has no permission to modify the dataset " + datasetId);
        }
        // adding geoserver flag
        // if this flas is false, the data will not be uploaded to geoserver
        boolean enableGeoserver = false;
        if (GEOSERVER_ENABLE.equalsIgnoreCase("true")) {
            enableGeoserver = true;
        }

        int bodyPartSize = inputs.getBodyParts().size();
        String objIdStr = datasetId;
        String inJson = "";
        String paramName = "";
        Dataset dataset = getDatasetbyId(username, objIdStr);

        // get data format to see if it is a network dataset
        String format = dataset.getFormat();
        String linkFileName = null;
        String nodeFileName = null;
        String graphFileName = null;

        // check if there is link, node, and graph files are presented in the bodypart
        if (format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
            boolean isLinkPresented = false;
            boolean isNodePresented = false;
            boolean isGraphPresented = false;

            for (int i = 0; i < bodyPartSize; i++) {
                paramName = inputs.getBodyParts().get(i).getContentDisposition().getParameters().get(POST_PARAMENTER_NAME);
                if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE_LINK)) {
                    String tmpName = inputs.getBodyParts().get(i).getContentDisposition().getFileName();
                    String fileExt = FilenameUtils.getExtension(tmpName);
                    if (fileExt.equalsIgnoreCase(FileUtils.EXTENSION_SHP)) {
                        isLinkPresented = true;
                        linkFileName = tmpName;
                    }
                } else if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE_NODE)) {
                    String tmpName = inputs.getBodyParts().get(i).getContentDisposition().getFileName();
                    String fileExt = FilenameUtils.getExtension(tmpName);
                    if (fileExt.equalsIgnoreCase(FileUtils.EXTENSION_SHP)) {
                        isNodePresented = true;
                        nodeFileName = tmpName;
                    }
                } else if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE_GRAPH)) {
                    graphFileName = inputs.getBodyParts().get(i).getContentDisposition().getFileName();
                    isGraphPresented = true;
                }
            }

            if (isLinkPresented == false) {
                logger.error("Error finding link file");
                throw new NotFoundException("Error finding link file with the id of " + datasetId);
            } else if (isNodePresented == false) {
                logger.error("Error finding node file");
                throw new NotFoundException("Error finding node file with the id of " + datasetId);
            } else if (isGraphPresented == false) {
                logger.error("Error finding graph file");
                throw new NotFoundException("Error finding graph file with the id of " + datasetId);
            }
        }

        boolean isJsonValid = false;
        boolean isGeoserver = false;
        boolean isAsc = false;
        boolean isShp = false;
        boolean isTif = false;
        boolean isJoin = false;

        int file_counter = 0;
        int link_counter = 0;
        int node_counter = 0;
        int graph_counter = 0;
        for (int i = 0; i < bodyPartSize; i++) {
            paramName = inputs.getBodyParts().get(i).getContentDisposition().getParameters().get(POST_PARAMENTER_NAME);
            if (paramName.equals(POST_PARAMENTER_FILE) || paramName.equals(POST_PARAMENTER_FILE_LINK) ||
                paramName.equals(POST_PARAMENTER_FILE_NODE) || paramName.equals(POST_PARAMENTER_FILE_GRAPH)) {
                String fileName = inputs.getBodyParts().get(i).getContentDisposition().getFileName();
                String fileExt = FilenameUtils.getExtension(fileName);
                if (fileExt.equalsIgnoreCase("shp") || fileExt.equalsIgnoreCase("asc") ||
                    fileExt.equalsIgnoreCase("tif")) {
                    isGeoserver = true;
                    if (fileExt.equalsIgnoreCase("asc")) {
                        isAsc = true;
                    } else if (fileExt.equalsIgnoreCase("tif")) {
                        isTif = true;
                    } else if (fileExt.equalsIgnoreCase("shp")) {
                        isShp = true;
                    }
                }
                InputStream is = null;
                if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE)) {
                    is = (InputStream) inputs.getFields(paramName).get(file_counter).getValueAs(InputStream.class);
                    file_counter++;
                } else if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE_LINK)) {
                    is = (InputStream) inputs.getFields(paramName).get(link_counter).getValueAs(InputStream.class);
                    link_counter++;
                } else if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE_NODE)) {
                    is = (InputStream) inputs.getFields(paramName).get(node_counter).getValueAs(InputStream.class);
                    node_counter++;
                } else if (paramName.equalsIgnoreCase(POST_PARAMENTER_FILE_GRAPH)) {
                    is = (InputStream) inputs.getFields(paramName).get(graph_counter).getValueAs(InputStream.class);
                    graph_counter++;
                }

                if (is != null) {
                    FileDescriptor fd = new FileDescriptor();
                    FileStorageDisk fsDisk = new FileStorageDisk();

                    fsDisk.setFolder(DATA_REPO_FOLDER);
                    try {
                        fd = fsDisk.storeFile(fileName, is);
                        fd.setFilename(fileName);
                    } catch (IOException e) {
                        logger.error("Error storing files of the dataset with the id of " + datasetId);
                        throw new NotFoundException("Error string files of the dataset with the id of " + datasetId);
                    }
                    dataset.addFileDescriptor(fd);
                }
            }
        }

        // add link, node, graph file name to dataset
        if (format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
            NetworkDataset networkDataset = dataset.getNetworkDataset();
            NetworkData link = networkDataset.getLink();
            NetworkData node = networkDataset.getNode();
            NetworkData graph = networkDataset.getGraph();
            link.setFileName(linkFileName);
            node.setFileName(nodeFileName);
            graph.setFileName(graphFileName);
            networkDataset.setLink(link);
            networkDataset.setNode(node);
            networkDataset.setGraph(graph);
            dataset.setNetworkDataset(networkDataset);
        }

        repository.addDataset(dataset);

        // check if there is a source dataset, if so it will be joined to source dataset
        String sourceDataset = dataset.getSourceDataset();

        // join it if it is a table dataset with source dataset existed
        if (sourceDataset.length() > 0 && format.equalsIgnoreCase("table")) {
            isJoin = true;
            isGeoserver = true;
        }

        List<FileDescriptor> dataFDs = dataset.getFileDescriptors();
        List<File> files = new ArrayList<File>();
        File zipFile = null;
        boolean isShpfile = false;

        if (format.equalsIgnoreCase(FileUtils.FORMAT_SHAPEFILE) || format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
            for (int i = 0; i < dataFDs.size(); i++) {
                FileDescriptor sfd = dataFDs.get(i);
                String shpLoc = FilenameUtils.concat(DATA_REPO_FOLDER, sfd.getDataURL());
                File shpFile = new File(shpLoc);
                files.add(shpFile);
                //get file, if the file is in remote, use http downloader
                String fileExt = FilenameUtils.getExtension(shpLoc);
                if (fileExt.equalsIgnoreCase(FileUtils.EXTENSION_SHP)) {
                    isShpfile = true;
                }
            }
            try {
                // create GUID if there is no GUID in the table
                boolean isGuid = true;
                boolean isLinkGuid = true;
                boolean isNodeGuid = true;
                if (format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
                    isLinkGuid = GeotoolsUtils.createGUIDinShpfile(dataset, files, linkFileName);
                    if (isLinkGuid) {
                        logger.debug("The link shapefile already has guid field");
                    }
                    isNodeGuid = GeotoolsUtils.createGUIDinShpfile(dataset, files, nodeFileName);
                    if (isNodeGuid) {
                        logger.debug("The node shapefile already has guid field");
                    }
                } else {
                    isGuid = GeotoolsUtils.createGUIDinShpfile(dataset, files);
                    if (isGuid) {
                        logger.debug("The shapefile already has guid field");
                    }
                }

            } catch (IOException e) {
                logger.error("Error creating temp directory in guid creation process ", e);
                throw new InternalServerErrorException("Error creating temp directory in guid creation process ", e);
            }
        }
        repository.addDataset(dataset);

        if (enableGeoserver && isGeoserver) {
            if (isJoin) {
                // todo: the join process for the network dataset should be added in here
                try {
                    zipFile = FileUtils.joinShpTable(dataset, repository, true);
                    GeoserverUtils.uploadShpZipToGeoserver(dataset.getId(), zipFile);
                } catch (IOException e) {
                    logger.error("Error making temp directory in joining process ", e);
                    throw new InternalServerErrorException("Error making temp directory in joining process ", e);
                } catch (URISyntaxException e) {
                    logger.error("Error making file using dataset's location url in table join process ", e);
                    throw new InternalServerErrorException("Error making file using dataset's location uri in table join process ", e);
                }
            } else {
                try {
                    if (format.equalsIgnoreCase(FileUtils.FORMAT_NETWORK)) {
                        GeoserverUtils.networkDatasetUploadToGeoserver(dataset, repository);
                    } else {
                        GeoserverUtils.datasetUploadToGeoserver(dataset, repository, isShp, isTif, isAsc);
                    }
                } catch (IOException e) {
                    logger.error("Error uploading dataset to geoserver ", e);
                    throw new InternalServerErrorException("Error uploading dataset to geoserver ", e);
                } catch (URISyntaxException e) {
                    logger.error("Error making file using dataset's location url ", e);
                    throw new InternalServerErrorException("Error making file using dataset's location uri ", e);
                }
            }
        }

        return dataset;
    }

    @PUT
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @ApiOperation(value = "Updates the dataset's JSON associated with a dataset id", notes = "This will not upload file content of the dataset to the server, " +
        "they should be done separately using {id}/files endpoint")
    public Object updateObject(@HeaderParam("X-Credential-Username") String username,
                               @ApiParam(value = "Dataset Id from data service", required = true) @PathParam("id") String datasetId,
                               @ApiParam(value = "JSON representing an input dataset", required = true) @FormDataParam("update") String inDatasetJson) {
        if (username == null) {
            logger.error("Credential user name should be provided.");
            throw new BadRequestException("Credential user name should be provided.");
        }
        boolean isJsonValid = JsonUtils.isJSONValid(inDatasetJson);
        if (!isJsonValid) {
            logger.error("Posted json is not a valid json.");
            throw new BadRequestException("Posted json is not a valid json.");
        }
        if (!authorizer.canUserModifyMember(username, datasetId, spaceRepository.getAllSpaces())) {
            throw new NotAuthorizedException(username + " has no permission to modify the dataset " + datasetId);
        }

        Dataset dataset = repository.getDatasetById(datasetId);
        if (dataset == null) {
            throw new NotFoundException();
        }

        String propName = JsonUtils.extractValueFromJsonString(UPDATE_OBJECT_NAME, inDatasetJson);
        String propVal = JsonUtils.extractValueFromJsonString(UPDATE_OBJECT_VALUE, inDatasetJson);
        dataset = repository.updateDataset(datasetId, propName, propVal);
        return dataset;

    }

    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Search for a text in all datasets", notes="Gets all datasets that contain a specific text")
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "No datasets found with the searched text")
    })
    public List<Dataset> findDatasets(@HeaderParam("X-Credential-Username") String username,
                                              @ApiParam(value="Text to search by", example = "building") @QueryParam("text") String text,
                                              @ApiParam(value = "Skip the first n results") @QueryParam("skip") int offset,
                                              @ApiParam(value = "Limit no of results to return") @DefaultValue("100") @QueryParam("limit") int limit) {
        List<Dataset> datasets = this.repository.searchDatasets(text);
        if (datasets.size() == 0) {
            throw new NotFoundException();
        }

        Set<String> membersSet = authorizer.getAllMembersUserHasReadAccessTo(username, spaceRepository.getAllSpaces());

        datasets = datasets.stream()
            .filter(dataset -> membersSet.contains(dataset.getId()))
            .skip(offset)
            .limit(limit)
            .collect(Collectors.toList());

        if (datasets.size() == 0) {
            throw new NotAuthorizedException(username + " has no permission to access the datasets that match the search criteria");
        }

        return datasets;
    }
}
