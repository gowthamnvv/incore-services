package edu.illinois.ncsa.incore.repo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.util.JSON;
import edu.illinois.ncsa.incore.repo.json.objects.ColumnMetadata;
import edu.illinois.ncsa.incore.repo.json.objects.Mapping;
import edu.illinois.ncsa.incore.repo.json.objects.Metadata;
import edu.illinois.ncsa.incore.repo.json.objects.TableMetadata;
import org.apache.commons.io.FilenameUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.geojson.feature.FeatureJSON;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


@Path("")
public class RepoService {
    public static final String REPO_SERVER_URL = "https://earthquake.ncsa.illinois.edu/";
    public static final String REPO_PROP_DIR = "ergo-repo/properties/";
    public static final String REPO_DS_DIR = "ergo-repo/datasets/";
    public static final String REPO_PROP_URL = REPO_SERVER_URL + REPO_PROP_DIR;
    public static final String REPO_DS_URL = REPO_SERVER_URL + REPO_DS_DIR;
    public static final String SERVER_URL_PREFIX = "http://localhost:8080/repo/api/datasets/";
    public static final String MONGO_URL = "mongodb://localhost:27017";
    public static final String GEO_DB_NAME = "geoJsonDB";


    // list all the metadatas in the repository information as json
    // zipped dataset can be downloaded when the location get clicked
    @GET
    @Path("/datasets")
    @Produces(MediaType.APPLICATION_JSON)
    // test this with
    // http://localhost:8080/repo/api/datasets
    public Response getDirectoryListJson(){
        String dirStr = loadDirectoryListJsonString();
//        return(dirStr);
//        return new MvzDataset(dirStr);
        return Response.ok(dirStr).status(Response.Status.OK).build();
    }

    @GET
    @Path("datasets/query")
    @Produces(MediaType.APPLICATION_JSON)
    // test with the following line
    // http://localhost:8080/repo/api/datasets/query?type=edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0
//    public List<MvzDataset> getJsonObjTest(@QueryParam("type") String inTypeId) {
//     public List<MvzDataset> getJsonObjTest(@QueryParam("type") String inTypeId , @HeaderParam("X-Credential-Username") String username) {
    public List<MvzDataset> getJsonObjTest (@QueryParam("type") String inTypeId , @HeaderParam("HTTP_USER_AGENT") String username, @Context HttpHeaders headers) {
        String userAgent = headers.getRequestHeader("user-agent").get(0);
        System.out.println(username);
        String propUrl = REPO_PROP_URL + inTypeId;
        File metadata = null;

        List<String> resourceUrls = getDirectoryContent(propUrl, inTypeId);
        List<MvzDataset> mvzDatasets = new ArrayList<MvzDataset>();

        for (String rUrl: resourceUrls) {
            MvzDataset mvzDataset = new MvzDataset();
            mvzDataset = createMvzDatasetFromMetadata(rUrl);
            mvzDatasets.add(mvzDataset);
        }

        return mvzDatasets;
    }

//    list all the metadata belonged to type id. data can be downloaded by clicking location
//    metadata converted as POJO object
    @GET
    @Path("/datasets/test")
    @Produces(MediaType.APPLICATION_JSON)
    // test this with
    // http://localhost:8080/repo/api/datasets/test?type=edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0
    public Response getDatasetById(@QueryParam("type") String typeId) {
        String propUrl = REPO_PROP_URL + typeId;
        File metadata = null;

        List<String> resourceUrls = getDirectoryContent(propUrl, typeId);
        String outJsonStr = "[\n";
        String combinedId = "";

        for (String rUrl: resourceUrls) {
            outJsonStr = outJsonStr;

            try {
                metadata = loadMetadataFromRepository(rUrl);
                outJsonStr = outJsonStr + RepoUtils.formatMetadataAsJson(metadata, rUrl, SERVER_URL_PREFIX) +",\n";
            } catch (IOException e) {
                e.printStackTrace();;
                String err = "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
//                return (new MvzDataset(err));
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }
        outJsonStr = outJsonStr.substring(0, outJsonStr.length() - 2);
        outJsonStr = outJsonStr + "\n]";

//        return new MvzDataset(outJsonStr);
        return Response.ok(outJsonStr).status(Response.Status.OK).build();
    }

    // directory listing
    @GET
    @Path("/datasets/list")     // this should be changed later for the appropriate line
    @Produces(MediaType.TEXT_HTML)
    // test this with
    // http://localhost:8080/repo/api/datasets/list
    public String getDirectoryList() {
        try {
            return (loadDirectoryList());
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
        }
    }

    // create geoJson of shapefile dataset
    @GET
    @Path("/datasets/{typeid}/{datasetId}/geojson")
//    @Produces("application/vnd.geo+json")
    @Produces(MediaType.APPLICATION_JSON)
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0/Shelby_County_RES31224702005658/geojson
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.lifeline.schemas.powerFacilityTopo.v1.0/Memphis_Electric_Power_Facility_with_Topology_for_INA1213389330789/geojson
    public Response getDatasetById(@PathParam("typeid") String typeId , @PathParam("datasetId") String datasetId ) {
        File dataset = null;
        String combinedId = typeId + "/" + datasetId + "/converted/";
        String fileName = "";
        try{
            fileName = RepoUtils.loadFileNameFromRepository(combinedId, RepoUtils.EXTENSION_SHP, REPO_DS_URL);
            if (fileName.length() > 0) {
                dataset = new File(fileName);
                String outJson = RepoUtils.formatDatasetAsGeoJson(dataset);
                return Response.ok(outJson).status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }catch (IOException e) {
            e.printStackTrace();
            String err = "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

//    list the dataset belonged to type
    @GET
    @Path("/datasets/{typeId}")
    @Produces(MediaType.TEXT_HTML)
//    http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0
    public String getDirectoryListWithId(@PathParam("typeId") String typeId) {
        try {
            return (loadDirectoryList(typeId));
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
        }
    }

    // see the metadata json of the dataset. data can be downloaded by clicking location
    @GET
    @Path("/datasets/{typeId}/{datasetId}")
    @Produces(MediaType.APPLICATION_JSON)
//    http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0/Shelby_County_RES31224702005658
    public MvzDataset getMetadataById(@PathParam("typeId") String typeId, @PathParam("datasetId") String datasetId) {
        String combinedId = typeId + "/" + datasetId;
        MvzDataset mvzDataset = createMvzDatasetFromMetadata(combinedId);

        return mvzDataset;
    }

    // download zipped dataset file
    @GET
    @Path("/datasets/{typeId}/{datasetId}/files")
    @Produces(MediaType.TEXT_PLAIN)
    // http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0/Shelby_County_RES31224702005658/files
    public File getShapefileById(@PathParam("typeId") String typeId, @PathParam("datasetId") String datasetId) {
        File dataset = null;

        String combinedId = typeId + "/" + datasetId + "/converted/";
        try{
            dataset = loadZipdataFromRepository(combinedId);
            return dataset;
        }catch (IOException e) {
            e.printStackTrace();
//            return "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
            return null;
        }
    }

    @GET
    @Path("/datasets/{typeId}/{datasetId}/ingest")
    @Produces(MediaType.TEXT_PLAIN)
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0/Shelby_County_RES31224702005658/ingest
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.lifeline.schemas.powerFacilityTopo.v1.0/Memphis_Electric_Power_Facility_with_Topology_for_INA1213389330789/ingest
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.decisionsupport.schemas.buildingCollapseRateTable.v1.0/HAZUS_Table_13.8_Collapse_Rates1209053226524/ingest
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.decisionsupport.schemas.buildingDisruptionCost.v1.0/Building_Disruption_Cost1168019087905/ingest
    public String ingestDatasetToMongo(@PathParam("typeId") String typeId, @PathParam("datasetId") String datasetId) {
        // check if it is shapefile or csv
        String combinedId = typeId + "/" + datasetId + "/converted/";
        int fileType = RepoUtils.checkDataFormatFromRepository(combinedId, REPO_DS_URL);

        if (fileType >= RepoUtils.TYPE_NUMBER_MULTI) {
            return "There are multiple file formats in the directory.";
        }

        if (fileType == RepoUtils.TYPE_NUMBER_SHP) {    // ingest shapefile into mongodb
            return  RepoUtils.ingestShpfileToMongo(typeId, datasetId, MONGO_URL, GEO_DB_NAME, REPO_DS_URL);
        } else if (fileType == RepoUtils.TYPE_NUMBER_CSV) { // ingest table into mongodb
            return RepoUtils.ingestTableToMongo(typeId, datasetId, MONGO_URL, GEO_DB_NAME, REPO_DS_URL);
        }

        return "Dataset ingested";
    }

    private MvzDataset createMvzDatasetFromMetadata(String inUrl){
        MvzDataset mvzDataset = new MvzDataset();
        try {
            File metadata = loadMetadataFromRepository(inUrl);
            mvzDataset = setMvzDataset(metadata, inUrl);

        } catch (IOException e) {
            e.printStackTrace();;
            String err = "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
        }

        return mvzDataset;
    }

    private MvzDataset setMvzDataset(File metadataFile, String rUrl) throws IOException {
        MvzDataset mvzDataset = new MvzDataset();

        String xmlString = "";
        metadataFile.setReadOnly();
        Reader metadataReader = new InputStreamReader(new FileInputStream(metadataFile), "UTF-16");
        char metaCharBuffer[] = new char[2048];
        int len;
        while ((len = metadataReader.read(metaCharBuffer, 0, metaCharBuffer.length)) != -1) {
            xmlString = xmlString + new String(metaCharBuffer, 0, len);
        }
        metadataReader.close();
        RepoUtils.deleteTmpDir(metadataFile, RepoUtils.EXTENSION_META);

        // remove metadata file extestion from inId if there is any
        String tmpEndStr = rUrl.substring(rUrl.lastIndexOf('.') + 1);
        if (tmpEndStr.equals(RepoUtils.EXTENSION_META)) {
            rUrl = rUrl.substring(0, rUrl.length() - 4);
        }

        String datasetPropertyName = "";
        String name = "";
        String version = "";
        String dataFormat = "";
        String typeId = "";
        String featureTypeName = "";
        String convertedFeatureTypeName = "";
        String geometryType = "";
        String location = "";
        String description = "";
//        String schema = "";
//        String from = "";
//        String to = "";
//        boolean isMaevizMapping = false;
//        boolean isMetadata = false;

        try {
            JSONObject metaJsonObj = XML.toJSONObject(xmlString);
            JSONObject metaInfoObj = null;
            JSONObject locObj = null;
            if (metaJsonObj.has(RepoUtils.TAG_PROPERTIES_GIS)) {
                metaInfoObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_GIS);
                locObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_GIS).getJSONObject(RepoUtils.TAG_DATASET_ID);
                featureTypeName = metaInfoObj.get(RepoUtils.TAG_FEATURE_TYPE_NAME).toString();
                convertedFeatureTypeName = metaInfoObj.get(RepoUtils.TAG_CONVERTED_FEATURE_TYPE_NAME).toString();
                geometryType = metaInfoObj.get(RepoUtils.TAG_GEOMETRY_TYPE).toString();
                datasetPropertyName = RepoUtils.TAG_PROPERTIES_GIS;
                mvzDataset.setFeaturetypeName(featureTypeName);
                mvzDataset.setConvertedFeatureTypeName(convertedFeatureTypeName);
                mvzDataset.setGeometryType(geometryType);
            }
            if (metaJsonObj.has(RepoUtils.TAG_PROPERTIES_MAP)) {
                metaInfoObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_MAP);
                locObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_MAP).getJSONObject(RepoUtils.TAG_DATASET_ID);
                datasetPropertyName = RepoUtils.TAG_PROPERTIES_MAP;
            }
            if (metaJsonObj.has(RepoUtils.TAG_PROPERTIES_FILE)) {
                metaInfoObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_FILE);
                locObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_FILE).getJSONObject(RepoUtils.TAG_DATASET_ID);
                datasetPropertyName = RepoUtils.TAG_PROPERTIES_FILE;
            }
            if (metaJsonObj.has(RepoUtils.TAG_PROPERTIES_RASTER)) {
                metaInfoObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_RASTER);
                locObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_RASTER).getJSONObject(RepoUtils.TAG_DATASET_ID);
                datasetPropertyName = RepoUtils.TAG_PROPERTIES_RASTER;
            }
            if (metaJsonObj.has(RepoUtils.TAG_PROPERTIES_SCENARIO)) {
                metaInfoObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_SCENARIO);
                locObj = metaJsonObj.getJSONObject(RepoUtils.TAG_PROPERTIES_SCENARIO).getJSONObject(RepoUtils.TAG_DATASET_ID);
                datasetPropertyName = RepoUtils.TAG_PROPERTIES_SCENARIO;
            }

            name = metaInfoObj.get(RepoUtils.TAG_NAME).toString();
            version = metaInfoObj.get(RepoUtils.TAG_VERSION).toString();
            dataFormat = metaInfoObj.get(RepoUtils.TAG_DATA_FORMAT).toString();
            typeId = metaInfoObj.get(RepoUtils.TAG_TYPE_ID).toString();
            location = locObj.get(RepoUtils.TAG_LOCATION).toString();
            description = locObj.get(RepoUtils.TAG_DESCRIPTION).toString();

            mvzDataset.setDatasetPropertyName(datasetPropertyName);
            mvzDataset.setName(name);
            mvzDataset.setVersion(version);
            mvzDataset.setDataFormat(dataFormat);
            mvzDataset.setTypeId(typeId);
            mvzDataset.datasetId.setDescription(description);
            mvzDataset.datasetId.setLocation(location);

            // check maeviz-mapping object and set
            if (metaInfoObj.has(RepoUtils.TAG_MAEVIZ_MAPPING)) {
                List<Mapping> mappings = new LinkedList<Mapping>();
                mvzDataset.maevizMapping.setSchema(metaInfoObj.getJSONObject(RepoUtils.TAG_MAEVIZ_MAPPING).get(RepoUtils.TAG_SCHEMA).toString());
                if (metaInfoObj.getJSONObject(RepoUtils.TAG_MAEVIZ_MAPPING).get(RepoUtils.TAG_MAPPING) instanceof JSONObject) {
                    JSONObject mappingJsonObj = (JSONObject) metaInfoObj.getJSONObject(RepoUtils.TAG_MAEVIZ_MAPPING).get(RepoUtils.TAG_MAPPING);
                    Mapping m = new Mapping();
                    m.setFrom(mappingJsonObj.get(RepoUtils.TAG_FROM).toString());
                    m.setTo(mappingJsonObj.get(RepoUtils.TAG_FROM).toString());
                    mappings.add(m);
                    mvzDataset.maevizMapping.setMapping(mappings);
                } else if (metaInfoObj.getJSONObject(RepoUtils.TAG_MAEVIZ_MAPPING).get(RepoUtils.TAG_MAPPING) instanceof JSONArray){
                    JSONArray mappingJsonArray = (JSONArray) metaInfoObj.getJSONObject(RepoUtils.TAG_MAEVIZ_MAPPING).get(RepoUtils.TAG_MAPPING);
                    for (int i = 0; i < mappingJsonArray.length(); i++) {
                        JSONObject mappingJsonObj = (JSONObject) mappingJsonArray.get(i);
                        Mapping m = new Mapping();
                        m.setFrom(mappingJsonObj.get(RepoUtils.TAG_FROM).toString());
                        m.setTo(mappingJsonObj.get(RepoUtils.TAG_FROM).toString());
                        mappings.add(m);
                    }
                    mvzDataset.maevizMapping.setMapping(mappings);
                }
            }

            // check metadata object and set
            if (metaInfoObj.has(RepoUtils.TAG_METADATA)) {
                List<ColumnMetadata> columnMetadatas = new LinkedList<ColumnMetadata>();
                if (((JSONObject) metaInfoObj.getJSONObject(RepoUtils.TAG_METADATA).get(RepoUtils.TAG_TABLE_METADATA)).get(RepoUtils.TAG_COLUMN_METADATA) instanceof JSONObject) {
                    JSONObject columnMetadataObj = (JSONObject)((JSONObject) metaInfoObj.getJSONObject(RepoUtils.TAG_METADATA).get(RepoUtils.TAG_TABLE_METADATA)).getJSONObject(RepoUtils.TAG_TABLE_METADATA);
                    Metadata metadata = new Metadata();
                    ColumnMetadata columnMetadata = new ColumnMetadata();
                    columnMetadata.setFriendlyName(columnMetadataObj.getJSONObject(RepoUtils.TAG_FRIENDLY_NAME).toString());
                    columnMetadata.setFieldLength(Integer.parseInt(columnMetadataObj.getJSONObject(RepoUtils.TAG_FIELD_LENGTH).toString()));
                    columnMetadatas.add(columnMetadata);
                    metadata.tableMetadata.setColumnMetadata(columnMetadatas);
                    mvzDataset.setMetadata(metadata);
                } else if (((JSONObject) metaInfoObj.getJSONObject(RepoUtils.TAG_METADATA).get(RepoUtils.TAG_TABLE_METADATA)).get(RepoUtils.TAG_COLUMN_METADATA) instanceof JSONArray) {
                    JSONArray columnMetadataArray = (JSONArray)((JSONObject) metaInfoObj.getJSONObject(RepoUtils.TAG_METADATA).get(RepoUtils.TAG_TABLE_METADATA)).get(RepoUtils.TAG_COLUMN_METADATA);
                    Metadata metadata = new Metadata();
                    TableMetadata tableMetadata = new TableMetadata();
                    for (int i = 0; i < columnMetadataArray.length(); i++) {
                        ColumnMetadata columnMetadata = new ColumnMetadata();
                        JSONObject columnMetadataObj = (JSONObject) columnMetadataArray.get(i);
                        if (columnMetadataObj.has(RepoUtils.TAG_FRIENDLY_NAME)) {
                            columnMetadata.setFriendlyName(columnMetadataObj.get(RepoUtils.TAG_FRIENDLY_NAME).toString());
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_FIELD_LENGTH)) {
                            columnMetadata.setFieldLength(Integer.parseInt(columnMetadataObj.get(RepoUtils.TAG_FIELD_LENGTH).toString()));
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_UNIT)) {
                            columnMetadata.setUnit(columnMetadataObj.get(RepoUtils.TAG_UNIT).toString());
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_COLUMN_ID)) {
                            columnMetadata.setColumnId(columnMetadataObj.get(RepoUtils.TAG_COLUMN_ID).toString());
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_FIELD_LENGTH)) {
                            columnMetadata.setSigFigs(Integer.parseInt(columnMetadataObj.get(RepoUtils.TAG_FIELD_LENGTH).toString()));
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_UNIT_TYPE)) {
                            columnMetadata.setUnitType(columnMetadataObj.get(RepoUtils.TAG_UNIT_TYPE).toString());
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_IS_NUMERIC)) {
                            columnMetadata.setIsNumeric((boolean)columnMetadataObj.get(RepoUtils.TAG_IS_NUMERIC));
                        }
                        if (columnMetadataObj.has(RepoUtils.TAG_IS_RESULT)) {
                            columnMetadata.setIsResult((boolean)columnMetadataObj.get(RepoUtils.TAG_IS_RESULT));
                        }
                        columnMetadatas.add(columnMetadata);
                    }
                    metadata.tableMetadata.setColumnMetadata(columnMetadatas);
                    mvzDataset.setMetadata(metadata);

                }
            }

            String newUrl = SERVER_URL_PREFIX + rUrl + "/files";
            locObj.put(RepoUtils.TAG_LOCATION, newUrl);
            String jsonString = metaJsonObj.toString(RepoUtils.INDENT_SPACE);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mvzDataset;
    }

    private Mapping setMapping(JSONObject mappingJsonObj) {
        Mapping m = new Mapping();
        m.setFrom(mappingJsonObj.get(RepoUtils.TAG_FROM).toString());
        m.setTo(mappingJsonObj.get(RepoUtils.TAG_FROM).toString());

        return m;
    }

    private File loadZipdataFromRepository(String inId) throws IOException {
        String urlPart = inId.replace("$", "/");
        String fileDatasetUrl = REPO_DS_URL + urlPart;
        String baseName = FilenameUtils.getBaseName(fileDatasetUrl);
        String tempDir = Files.createTempDirectory("repo_download_").toString();
        String realUrl = RepoUtils.getRealUrl(fileDatasetUrl);
        List<String> fileList = RepoUtils.createFileListFromUrl(fileDatasetUrl);

        for (int i=0; i < fileList.size();i++) {
            HttpDownloader.downloadFile(realUrl + fileList.get(i), tempDir);
        }

        String zipfile = tempDir + File.separator + baseName + ".zip";

        // create zip file
        byte[] buffer = new byte[1024];
        FileOutputStream fileOS = new FileOutputStream(zipfile);
        ZipOutputStream zipOS = new ZipOutputStream(fileOS);
        for (int i=0; i < fileList.size();i++) {
            ZipEntry zEntry = new ZipEntry(fileList.get(i));
            zipOS.putNextEntry(zEntry);

            FileInputStream in = new FileInputStream(tempDir + File.separator + fileList.get(i));
            int index;
            while ((index = in.read(buffer)) > 0) {
                zipOS.write(buffer, 0, index);
            }
            in.close();
        }

        zipOS.closeEntry();
        zipOS.close();
        System.out.println("zip file has been created");
        return new File(zipfile);
    }

    // get directory list in the root directory and crate one big json file using mvz files located under each directory
    private String loadDirectoryListJsonString(){
        String outStr = "[\n";
        String tmpRepoUrl = REPO_PROP_URL;

        List<String> resHref = getDirectoryContent(tmpRepoUrl, "");

        for (String tmpUrl: resHref) {
            String metaDirUrl = REPO_PROP_URL + tmpUrl;
            List<String> metaHref = getDirectoryContent(metaDirUrl, "");
            for (String metaFileName: metaHref) {
                String fileExtStr = FilenameUtils.getExtension(metaFileName);
                // get only the mvz file
                if (fileExtStr.equals(RepoUtils.EXTENSION_META)) {
                    String combinedId = tmpUrl + "/" + metaFileName;
                    File metadataFile = null;
                    try {
                        metadataFile = loadMetadataFromRepository(combinedId);
                        String jsonStr = RepoUtils.formatMetadataAsJson(metadataFile, combinedId, SERVER_URL_PREFIX);
                        outStr = outStr + jsonStr + ",\n";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        outStr = outStr.substring(0, outStr.length() - 2);
        outStr = outStr + "\n]";

        return outStr;
    }

    private String loadDirectoryList() {
        String outHtml = createListHtml("");
        return outHtml;
    }

    private String loadDirectoryList(String inId) {
        String outHtml = createListHtml(inId);
        return outHtml;
    }

    private String createListHtml(String inId){

        String outHtml = "<HTML><BODY>";
        String tmpRepoUrl = "";
        if (inId.length() > 0) {
            tmpRepoUrl = REPO_DS_URL + inId;
        } else {
            tmpRepoUrl = REPO_PROP_URL;
        }

        List<String> resHref = getDirectoryContent(tmpRepoUrl, inId);

        for (String tmpUrl: resHref) {
            // get only the last elemente after back slashes
            if (inId.length() > 0) {
                String[] linkUrls = tmpUrl.split("/");
                outHtml = outHtml + "<a href =\"" + tmpUrl + "\">" + linkUrls[linkUrls.length - 1] + "</a>";
            } else {
                outHtml = outHtml + "<a href =\"" + tmpUrl + "\">" + tmpUrl + "</a>";
            }
            outHtml = outHtml + "</BR>";
        }

        outHtml = outHtml + "</BODY></HTML>";
        return outHtml;
    }

    private List<String> getDirectoryContent(String inUrl, String inId){
        List<String> outList = new LinkedList<String>();
        Sardine sardine = SardineFactory.begin();
        try {
            List<DavResource> resources = sardine.list(inUrl);

            for (DavResource res : resources) {
                String[] tmpUrls = res.getHref().toString().split("/");
                String tmpUrl = "";
                if (inId.length() > 0) {
                    tmpUrl = tmpUrls[tmpUrls.length - 2] + "/" + tmpUrls[tmpUrls.length - 1];
                } else {
                    tmpUrl = tmpUrls[tmpUrls.length - 1];
                }

                if (!tmpUrls[tmpUrls.length -1].equals(inId)) {
                    outList.add(tmpUrl);
                }
            }
            Collections.sort(outList, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outList;
    }

    private File loadMetadataFromRepository(String inId) throws IOException {
        String urlPart = inId.replace("$", "/");
        String[] urlStrs = urlPart.split("/converted/");    // split the url using the folder name "converted"
        String metadataUrl = REPO_PROP_URL + urlStrs[0];
        // what if there is a dot in the basename? avoid use getBasename
//        String baseName = FilenameUtils.getBaseName(metadataUrl);
        String baseNameStrs[] = urlStrs[0].split("/");
        String baseName = baseNameStrs[baseNameStrs.length - 1];
        String tempDir = Files.createTempDirectory("repo_download_").toString();

        // check if metadataUrl ends with EXTENSION_META that is .mvz
        String tmpEndStr = metadataUrl.substring(metadataUrl.lastIndexOf('.') + 1);
        if (!tmpEndStr.equals(RepoUtils.EXTENSION_META)) {
            HttpDownloader.downloadFile(metadataUrl + "." + RepoUtils.EXTENSION_META, tempDir);
        } else {
            // remove mvz extension from the basename
            baseNameStrs = baseName.split("." + RepoUtils.EXTENSION_META);
            baseName = baseNameStrs[0];
            HttpDownloader.downloadFile(metadataUrl, tempDir);
        }

        String metadataFile = tempDir + File.separator + baseName + "." + RepoUtils.EXTENSION_META;

        return new File(metadataFile);
    }

}