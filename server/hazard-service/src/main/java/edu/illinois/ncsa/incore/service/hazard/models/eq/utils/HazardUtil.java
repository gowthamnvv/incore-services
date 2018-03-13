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
import com.vividsolutions.jts.geom.Point;
import edu.illinois.ncsa.incore.common.config.Config;
import edu.illinois.ncsa.incore.service.hazard.HazardDataset;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opengis.coverage.PointOutsideCoverageException;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.TransformException;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

/**
 * Misc utility functions for doing conversion of hazard types and units
 */
public class HazardUtil {
    public static final String HAZARD = "hazard"; //$NON-NLS-1$

    public static final String units_g = "g"; //$NON-NLS-1$
    public static final String units_cm = "cm"; //$NON-NLS-1$
    // Constant string expressions appearing throughout hazard code
    public static final String NONE = "None";
    public static final String PGA = "PGA"; //$NON-NLS-1$
    public static final String PGV = "PGV"; //$NON-NLS-1$
    public static final String PGD = "PGD"; //$NON-NLS-1$
    public static final String SA = "SA"; //$NON-NLS-1$
    public static final String SD = "SD"; //$NON-NLS-1$
    public static final String SV = "SV"; //$NON-NLS-1$
    public static final String LIQUEFACTION_PGD = "liquefactionPGD"; //$NON-NLS-1$
    private static final String units_percg = "%g"; //$NON-NLS-1$
    // Metric
    private static final String units_m = "meters"; //$NON-NLS-1$
    private static final String units_cms = "cm/s"; //$NON-NLS-1$
    private static final String units_ins = "in/s"; //$NON-NLS-1$
    // English
    private static final String units_in = "in"; //$NON-NLS-1$
    private static final String units_ft = "feet"; //$NON-NLS-1$
    private static final String sa_pgv = "sapgv"; //$NON-NLS-1$
    private static final String pga_pgd = "pgapgd"; //$NON-NLS-1$
    private static final String pga_pga = "pgapga"; //$NON-NLS-1$
    private static final String sa_sa = "sasa"; //$NON-NLS-1$
    private static final String sa_sv = "sasv"; //$NON-NLS-1$
    private static final String sa_sd = "sasd"; //$NON-NLS-1$
    private static final String sd_sd = "sdsd"; //$NON-NLS-1$
    private static final String pgv_pgv = "pgvpgv"; //$NON-NLS-1$
    private static final String FAULT_LENGTH = "Length"; //$NON-NLS-1$
    private static final String FAULT_WIDTH = "Width"; //$NON-NLS-1$
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
//            logger.warn("Null period, returning unconverted hazard value"); //$NON-NLS-1$
            return convertedHazard;
        }

        // Convert to B/C and the assume site class D
        if (period.equalsIgnoreCase(PGA)) {
            convertedHazard *= 1.52;
        } else if (period.equalsIgnoreCase("0.2")) { //$NON-NLS-1$
            convertedHazard *= 1.76;
        } else if (period.equalsIgnoreCase("0.3")) { //$NON-NLS-1$
            convertedHazard *= 1.72;
        } else if (period.equalsIgnoreCase("1.0") || period.equalsIgnoreCase("1")) { //$NON-NLS-1$//$NON-NLS-2$
            convertedHazard *= 1.34;
        }
        return convertedHazard;
    }

    /**
     * @param hazard
     * @return
     */
    public static String stripPeriod(String hazard) {
        hazard = hazard.replaceAll("[0-9]*", ""); //$NON-NLS-1$ //$NON-NLS-2$
        hazard = hazard.replaceAll("\\.*", "");//$NON-NLS-1$ //$NON-NLS-2$
        hazard = hazard.replaceAll("sec", "");//$NON-NLS-1$ //$NON-NLS-2$
        hazard = hazard.replaceAll(" ", "");//$NON-NLS-1$ //$NON-NLS-2$
        if ("".equals(hazard)) //$NON-NLS-1$
        {
            hazard = "Sa"; //$NON-NLS-1$
        }
        return hazard;
    }

    /**
     * @param hazard
     * @return
     */
    public static double getPeriod(String hazard) {
        hazard = hazard.replaceAll("[ a-zA-Z]*", ""); //$NON-NLS-1$ //$NON-NLS-2$
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

}
