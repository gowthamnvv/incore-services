/*******************************************************************************
 * Copyright (c) 2017 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the BSD-3-Clause which accompanies this distribution,
 * and is available at https://opensource.org/licenses/BSD-3-Clause
 *
 * Contributors:
 * Chris Navarro (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.eq.utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import edu.illinois.ncsa.incore.common.config.Config;
import edu.illinois.ncsa.incore.service.hazard.HazardDataset;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opengis.coverage.PointOutsideCoverageException;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.TransformException;

import java.awt.geom.Point2D;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Misc utility functions for doing conversion of hazard types and units
 */
public class HazardUtil {
    private static final Logger logger = Logger.getLogger(HazardUtil.class);
    public static final String HAZARD = "hazard";

    public static final String units_g = "g";
    public static final String units_cm = "cm";
    // Constant string expressions appearing throughout hazard code
    public static final String NONE = "None";
    public static final String PGA = "PGA";
    public static final String PGV = "PGV";
    public static final String PGD = "PGD";
    public static final String SA = "SA";
    public static final String SD = "SD";
    public static final String SV = "SV";
    public static final String LIQUEFACTION_PGD = "liquefactionPGD";
    private static final String units_percg = "%g";
    // Metric
    private static final String units_m = "meters";
    private static final String units_cms = "cm/s";
    private static final String units_ins = "in/s";
    // English
    private static final String units_in = "in";
    private static final String units_ft = "feet";
    private static final String sa_pgv = "sapgv";
    private static final String pga_pgd = "pgapgd";
    private static final String pga_pga = "pgapga";
    private static final String sa_sa = "sasa";
    private static final String sa_sv = "sasv";
    private static final String sa_sd = "sasd";
    private static final String sd_sd = "sdsd";
    private static final String pgv_pgv = "pgvpgv";
    private static final String FAULT_LENGTH = "Length";
    private static final String FAULT_WIDTH = "Width";
    public static double R_EARTH = 6373.0; // km
    // NEHRP Site Amplification
    // XXX: should this be a table dataset so it can be changed in the future?
    static double[][] short_period = {{0.8, 1.0, 1.2, 1.6, 2.5}, {0.8, 1.0, 1.2, 1.4, 1.7}, {0.8, 1.0, 1.1, 1.2, 1.2},
        {0.8, 1.0, 1.0, 1.1, 0.9}, {0.8, 1.0, 1.0, 1.0, 0.9}};
    static double[] shortPeriodIntervals = {0.25, 0.5, 0.75, 1.0, 1.25};
    static double[][] long_period = {{0.8, 1.0, 1.7, 2.4, 3.5}, {0.8, 1.0, 1.6, 2.0, 3.2}, {0.8, 1.0, 1.5, 1.8, 2.8},
        {0.8, 1.0, 1.4, 1.6, 2.4}, {0.8, 1.0, 1.3, 1.5, 2.4}};
    static double[] longPeriodIntervals = {0.1, 0.2, 0.3, 0.4, 0.5};

    public static int getSiteClassAsInt(String siteClass) {
        int siteClassInt = -1;
        if (siteClass.equalsIgnoreCase("A")) {
            siteClassInt = 0;
        } else if (siteClass.equalsIgnoreCase("B")) {
            siteClassInt = 1;
        } else if (siteClass.equalsIgnoreCase("C")) {
            siteClassInt = 2;
        } else if (siteClass.equalsIgnoreCase("D")) {
            siteClassInt = 3;
        } else if (siteClass.equalsIgnoreCase("E")) {
            siteClassInt = 4;
        } else if (siteClass.equalsIgnoreCase("F")) {
            siteClassInt = 5;
        }

        return siteClassInt;
    }

    /**
     * @param period
     * @param hazard
     * @return
     */
    public static double convertMotionsToBC(String period, double hazard) {
        double convertedHazard = hazard;

        if (period == null) {
//            logger.warn("Null period, returning unconverted hazard value");
            return convertedHazard;
        }

        // Convert to B/C and the assume site class D
        if (period.equalsIgnoreCase(PGA)) {
            convertedHazard *= 1.52;
        } else if (period.equalsIgnoreCase("0.2")) {
            convertedHazard *= 1.76;
        } else if (period.equalsIgnoreCase("0.3")) {
            convertedHazard *= 1.72;
        } else if (period.equalsIgnoreCase("1.0") || period.equalsIgnoreCase("1")) {
            convertedHazard *= 1.34;
        }
        return convertedHazard;
    }

    /**
     * @param hazard
     * @return
     */
    public static String stripPeriod(String hazard) {
        hazard = hazard.replaceAll("[0-9]*", "");
        hazard = hazard.replaceAll("\\.*", "");
        hazard = hazard.replaceAll("sec", "");
        hazard = hazard.replaceAll(" ", "");
        if ("".equals(hazard))
        {
            hazard = "Sa";
        }
        return hazard;
    }

    /**
     * @param hazard
     * @return
     */
    public static double getPeriod(String hazard) {
        hazard = hazard.replaceAll("[ a-zA-Z]*", "");
        try {
            return Double.parseDouble(hazard);
        } catch (NumberFormatException e) {
            return 0.0;
        }

    }

    /**
     * @param p1
     * @param p2
     * @return
     * @throws TransformException
     */
    public static double findDistance(Point p1, Point p2) throws TransformException {
        DefaultGeographicCRS crs = new DefaultGeographicCRS(DefaultGeographicCRS.WGS84);
        Coordinate c1 = new Coordinate(p1.getX(), p1.getY());
        Coordinate c2 = new Coordinate(p2.getX(), p2.getY());

        return JTS.orthodromicDistance(c1, c2, crs) / 1000.0;
    }

    /**
     * @param location
     * @param gc
     * @return
     * @throws PointOutsideCoverageException
     */
    public static double findRasterPoint(Point location, GridCoverage2D gc) throws PointOutsideCoverageException {
        double[] dest = null;
        final Point2D.Double point = new Point2D.Double();
        point.x = location.getX();
        point.y = location.getY();
        DirectPosition dp = new DirectPosition2D(location.getX(), location.getY());
        dest = gc.evaluate(dp, dest);
        if (Double.isNaN(dest[0])) {
            dest[0] = 0.0;
        }

        return dest[0];
    }

    public static String createRasterDataset(File rasterFile, String title, String creator, String description) throws IOException {

        // CMN: we could go through Kong, but then we would need a token
        String dataEndpoint = "http://localhost:8080/";
        String dataEndpointProp = Config.getConfigProperties().getProperty("dataservice.url");
        if (dataEndpointProp != null && !dataEndpointProp.isEmpty()) {
            dataEndpoint = dataEndpointProp;
            if (!dataEndpoint.endsWith("/")) {
                dataEndpoint += "/";
            }
        }

        JSONArray spaces = new JSONArray();
        if (creator != null) {
            spaces.put(creator);
        }
        spaces.put(HazardDataset.ERGO_SPACE);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(HazardDataset.SCHEMA, HazardDataset.DETERMINISTIC_HAZARD_SCHEMA);
        jsonObject.put(HazardDataset.TYPE, HazardDataset.DETERMINISTIC_HAZARD_TYPE);
        jsonObject.put(HazardDataset.TITLE, title);
        jsonObject.put(HazardDataset.SOURCE_DATASET, "");
        jsonObject.put(HazardDataset.FORMAT, HazardDataset.RASTER_FORMAT);
        jsonObject.put(HazardDataset.DESCRIPTION, description);
        jsonObject.put(HazardDataset.SPACES, spaces);

        HttpClientBuilder builder = HttpClientBuilder.create();
        HttpClient httpclient = builder.build();

        String requestUrl = dataEndpoint + HazardDataset.DATASETS_ENDPOINT;
        HttpPost httpPost = new HttpPost(requestUrl);
        httpPost.setHeader(HazardDataset.X_CREDENTIAL_USERNAME, creator);

        MultipartEntityBuilder params = MultipartEntityBuilder.create();
        params.addTextBody(HazardDataset.DATASET_PARAMETER, jsonObject.toString());

        HttpResponse response = null;
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseStr = null;

        httpPost.setEntity(params.build());
        response = httpclient.execute(httpPost);
        responseStr = responseHandler.handleResponse(response);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            JSONObject object = new JSONObject(responseStr);

            String datasetId = object.getString("id");
            requestUrl += "/" + datasetId + "/" + HazardDataset.DATASETS_FILES;

            params = MultipartEntityBuilder.create();
            params.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            params.addBinaryBody(HazardDataset.FILE_PARAMETER_, rasterFile);

            // Attach file
            httpPost = new HttpPost(requestUrl);
            httpPost.setHeader(HazardDataset.X_CREDENTIAL_USERNAME, creator);
            httpPost.setEntity(params.build());

            response = httpclient.execute(httpPost);
            responseStr = responseHandler.handleResponse(response);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return datasetId;
            }
        }

        return null;
    }

    public static FeatureCollection getFeatureCollection(String datasetId, String creator) {


        String dataEndpoint = "http://localhost:8080/";
        String dataEndpointProp = Config.getConfigProperties().getProperty("dataservice.url");
        if (dataEndpointProp != null && !dataEndpointProp.isEmpty()) {
            dataEndpoint = dataEndpointProp;
            if (!dataEndpoint.endsWith("/")) {
                dataEndpoint += "/";
            }
        }

        InputStream inputStream = null;
        try {
            HttpClientBuilder builder = HttpClientBuilder.create();
            HttpClient httpclient = builder.build();

            String requestUrl = dataEndpoint + HazardDataset.DATASETS_ENDPOINT + "/" + datasetId + "/blob";
            HttpGet httpGet = new HttpGet(requestUrl);
            httpGet.setHeader(HazardDataset.X_CREDENTIAL_USERNAME, creator);

            HttpResponse response = null;

            response = httpclient.execute(httpGet);
            inputStream = response.getEntity().getContent();
        } catch(IOException e) {
           // TODO add logging
           logger.error(e);
        }

        File incoreWorkDirectory = null;
        try {
            incoreWorkDirectory = File.createTempFile("incore", ".dir");
            incoreWorkDirectory.delete();
            incoreWorkDirectory.mkdirs();
        } catch(IOException e) {
            logger.error("Error creating temporary directory.", e);
            return null;
        }

        String filename = "shapefile.zip";
        File file = new File(incoreWorkDirectory, filename);

        try(BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))
        ) {

            int inByte;
            while ((inByte = bis.read()) != -1) {
                bos.write(inByte);
            }

        } catch(IOException e) {

            logger.error(e);
        }


        URL inSourceFileUrl = null;
        byte[] buffer = new byte[1024];
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while(zipEntry != null){
                String fileName = zipEntry.getName();
                File newFile = new File(incoreWorkDirectory, fileName);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();

                String fileExt = FilenameUtils.getExtension(newFile.getName());
                if (fileExt.equalsIgnoreCase("shp")) {
                    inSourceFileUrl = newFile.toURI().toURL();
                }
                zipEntry = zis.getNextEntry();
            }
        } catch(IOException e) {
           logger.error("Error unzipping shapefile", e);
           return null;
        }

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("url", inSourceFileUrl);

            DataStore dataStore = DataStoreFinder.getDataStore(map);
            String typeName = dataStore.getTypeNames()[0];

            FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
            dataStore.dispose();
            SimpleFeatureCollection inputFeatures = (SimpleFeatureCollection) source.getFeatures();
            return inputFeatures;
        } catch(IOException e) {
            logger.error("Error reading shapefile");
            return null;
        }

    }

public static SimpleFeature getPointInPolygon(Point point, SimpleFeatureCollection featureCollection)
    {
        SimpleFeature feature = null;
        boolean found = false;

        SimpleFeatureIterator geologyIterator = featureCollection.features();
        try {
            while (geologyIterator.hasNext() && !found) {
                // String featureId = featureIdIterator.next();
                SimpleFeature f = geologyIterator.next();

                Object polygonObject = f.getAttribute(0);
                if (polygonObject instanceof Polygon) {
                    Polygon polygon = (Polygon) polygonObject;
                    found = polygon.contains(point);
                    if (found) {
                        feature = f;
                    }
                } else {
                    MultiPolygon attribute = (MultiPolygon) polygonObject;
                    for (int i = 0; i < attribute.getNumGeometries(); i++) {
                        Polygon p = (Polygon) attribute.getGeometryN(i);

                        found = p.contains(point);
                        if (found) {
                            i = attribute.getNumGeometries();
                            feature = f;
                        }
                    }
                }
            }
        } finally {
            geologyIterator.close();
        }

        return feature;
    }

}
