package edu.illinois.ncsa.incore.repo;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import org.apache.commons.io.FilenameUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.geojson.feature.FeatureJSON;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FilenameUtils;

@Path("/datasets")
public class RepoService {
    public static final String[] EXTENSIONS_TO_GRAB = new String[]{"dbf", "prj", "shp", "shx"};

    // The Java method will process HTTP GET requests like the following:
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0$Shelby_County_RES31224702005658$converted$all_bldgs_ver5_WGS1984
    //http://localhost:8080/repo/api/datasets/edu.illinois.ncsa.ergo.eq.buildings.schemas.buildingInventoryVer5.v1.0$Shelby_County_RES31224702005658$converted$all_bldgs_ver5_WGS1984
    @GET
    @Path("{datasetId}/geojson")
    @Produces(MediaType.APPLICATION_JSON)

    public String getDatasetById(@PathParam("datasetId") String id ) {
        File dataset = null;
        try {
            dataset = loadDataFromRepository(id);
            return formatAsGeoJson(dataset);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
        }
    }

    @GET
    @Path("{datasetId}")
    @Produces(MediaType.APPLICATION_XML)

    public void getMetadataById(@PathParam("datasetId") String id) {
        System.out.println("metadata called");
        File dataset = null;
        try {
            loadMetadataFromRepository(id);
//            return formatAsGeoJson(dataset);
        } catch (IOException e) {
            e.printStackTrace();;
//            return "{\"error:\" + \"" + e.getLocalizedMessage() + "\"}";
        }

//        return "";
    }

    private String formatAsGeoJson(File shapefile) throws IOException {
        //TODO: this should return the data in geoJSON format
        String geoJson;

        shapefile.setReadOnly();

        ShapefileDataStore store = new ShapefileDataStore(shapefile.toURI().toURL());
        SimpleFeatureSource source = store.getFeatureSource();
        SimpleFeatureCollection featureCollection = source.getFeatures();
        FeatureJSON fjson = new FeatureJSON();

        try (StringWriter writer = new StringWriter()) {
            fjson.writeFeatureCollection(featureCollection, writer);
            geoJson = writer.toString();
        }

        deleteTmpDir(shapefile);

        return geoJson;
    }

    private void deleteTmpDir(File shapefile) {
        String fileName = shapefile.getAbsolutePath();
        String filePath = fileName.substring(0, fileName.lastIndexOf(shapefile.separator));
        int extLoc = shapefile.getName().indexOf(".");
        String extName = shapefile.getName().substring(extLoc);
        String fileNameWithNoExt = FilenameUtils.removeExtension(fileName);

        for (String extension : EXTENSIONS_TO_GRAB) {
            String delFileName = fileNameWithNoExt + "." + extension;
            File delFile = new File(delFileName);
            try {
                if (delFile.delete()) {
                    System.out.println("file deleted: " + delFileName);
                } else {
                    System.out.println("file did not deleted: " + delFileName);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        File delDir = new File(filePath);
        try {
            delDir.delete();
            System.out.println("Directory deleted: " + filePath);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private File loadDataFromRepository(String id) throws IOException {
        String urlPart = id.replace("$", "/");
        String shapefileDatasetUrl = "https://earthquake.ncsa.illinois.edu/ergo-repo/datasets/" + urlPart;
        String baseName = FilenameUtils.getBaseName(shapefileDatasetUrl);

        String tempDir = Files.createTempDirectory("repo_download_").toString();
        for (String extension : EXTENSIONS_TO_GRAB) {
            HttpDownloader.downloadFile(shapefileDatasetUrl + "." + extension, tempDir);
        }

        //ok, now the files should be here with the shapefile
        String shapefile = tempDir + File.separator + baseName + ".shp";

        return new File(shapefile);
    }

    private void loadMetadataFromRepository(String id) throws IOException {
        String urlPart = id.replace("$", "/");
        System.out.println(urlPart);
        String shapefileDatasetUrl = "https://earthquake.ncsa.illinois.edu/ergo-repo/properties/" + urlPart;
        System.out.println(shapefileDatasetUrl);
        String baseName = FilenameUtils.getBaseName(shapefileDatasetUrl);
//        return new File(metadataFile);
    }
}