/*******************************************************************************
 * Copyright (c) 2017 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the BSD-3-Clause which accompanies this distribution,
 * and is available at https://opensource.org/licenses/BSD-3-Clause
 *
 * Contributors:
 * Chris Navarro (NCSA) - initial API and implementation
 * Yong Wook Kim (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.tornado.utils;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.operation.buffer.BufferOp;
import edu.illinois.ncsa.incore.service.hazard.HazardDataset;
import edu.illinois.ncsa.incore.service.hazard.models.tornado.ScenarioTornado;
import edu.illinois.ncsa.incore.service.hazard.models.tornado.TornadoHazard;
import edu.illinois.ncsa.incore.service.hazard.models.tornado.TornadoParameters;
import edu.illinois.ncsa.incore.service.hazard.models.tornado.types.EFBox;
import org.apache.log4j.Logger;
import org.geotools.data.DataStore;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.AttributeTypeBuilder;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.json.JSONArray;
import org.json.JSONObject;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.GeometryDescriptor;
import org.opengis.feature.type.GeometryType;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TornadoUtils {

    private static final Logger logger = Logger.getLogger(TornadoUtils.class);

    private static GeometryFactory geometryFactory = new GeometryFactory();

    /**
     * Returns the EF rating as an integer value
     *
     * @param efRating EF tornado rating
     * @return EF rating as an integer
     */
    public static int getEFRating(String efRating) {
        switch (efRating) {
            case "EF0":
                return 0;
            case "EF1":
                return 1;
            case "EF2":
                return 2;
            case "EF3":
                return 3;
            case "EF4":
                return 4;
            case "EF5":
                return 5;
            default:
                return -1;
        }
    }

    /**
     * Calculates tornado path distance
     *
     * @param tornadoPath LineString representing the tornado path
     * @return Distance
     */
    public static double calcDistanceCoords(LineString tornadoPath) {
        // convert LineString to LineSegem ent for the necessary process
        Coordinate[] coords = tornadoPath.getCoordinates();

        // the test only contains one segment, it will work on only one line
        LineSegment seg = new LineSegment(coords[0], coords[1]);

        return seg.getLength();
    }

    public static double computeMeanWidth(String efRating) {
        int efRatingValue = TornadoUtils.getEFRating(efRating);

        try (BufferedReader input = new BufferedReader(new InputStreamReader(TornadoUtils.class.getClassLoader().getResourceAsStream("/hazard/tornado/73-2012_torn_edit.txt")))) {
            String line = null;
            int ratingCount = 0;
            int intensity = 0;
            double tmpWidth = 0.0;
            double efWidth = 0.0;

            while ((line = input.readLine()) != null) {
                String[] values = line.split("\t"); //$NON-NLS-1$
                intensity = Integer.parseInt(values[3]);
                if (intensity == efRatingValue) {
                    tmpWidth = Double.parseDouble(values[11]);
                    // Only count values that have known width values
                    if (tmpWidth > 0.0) {
                        ratingCount++;
                        efWidth += tmpWidth;
                    }
                }
            }

            efWidth /= ratingCount;

            double meanWidth = efWidth * TornadoHazard.YARD_TO_METERS;

            return meanWidth;
        } catch (IOException e) {
            e.printStackTrace();
            // logger.error("Failed to read tornado historical data", e); //$NON-NLS-1$
        }

        return 0;
    }

    /**
     * Create a line from a given line with the given length
     *
     * @param length
     * @param tornadoPath
     * @return
     */
    public static LineString createPathWithLength(Double length, LineString tornadoPath) {
        // TODO consider moving this to a utility method
        // convert LineString to LineSegement for the necessary process
        Coordinate[] coords = tornadoPath.getCoordinates();

        // the test only contains one segment, it will work on only one line
        LineSegment seg = new LineSegment(coords[0], coords[1]);

        double segLength = seg.getLength();
        double startFrac = 0;
        double endFrac = 0;

        if (length > segLength) {
            // Check if we've hit a case of rounding error making length > segLength
            if ((length - segLength) / segLength < 0.0005) {
                length = segLength;
                startFrac = 0.5 - (length / segLength) / 2;
                endFrac = 0.5 + (length / segLength) / 2;
            } else {
                logger.error("The length is longer than the Tornado Path."); //$NON-NLS-1$
                throw new IllegalArgumentException("The length is longer than the Tornado Path.s"); //$NON-NLS-1$
            }
        } else {
            // create the length fraction
            startFrac = 0.5 - (length / segLength) / 2;
            endFrac = 0.5 + (length / segLength) / 2;
        }

        Coordinate startPt = seg.pointAlong(startFrac);
        Coordinate endPt = seg.pointAlong(endFrac);
        LineString outPath = geometryFactory.createLineString(new Coordinate[]{startPt, endPt});

        return outPath;
    }

    public static double[] getLengthMultiplier(String efRating) {
        int efRatingValue = TornadoUtils.getEFRating(efRating);

        // Find Length Multiplier
        switch (efRatingValue) {
            case 0:
                return TornadoHazard.ef0LenRate;
            case 1:
                return TornadoHazard.ef1LenRate;
            case 2:
                return TornadoHazard.ef2LenRate;
            case 3:
                return TornadoHazard.ef3LenRate;
            case 4:
                return TornadoHazard.ef4LenRate;
            case 5:
                return TornadoHazard.ef5LenRate;
            default:
                return null;
        }
    }

    /**
     * Create polygon with given coordinate. This method can only have one internal polygon to represent the EF boxes
     *
     * @param coordOut
     * @param coordIn
     * @return
     */
    public static Polygon createPolygon(Coordinate[] coordOut, Coordinate[] coordIn) {
        LinearRing ring = geometryFactory.createLinearRing(coordOut);
        LinearRing[] holes;
        if (coordIn == null) {
            holes = null;
        } else {
            holes = new LinearRing[1];
            holes[0] = geometryFactory.createLinearRing(coordIn);
        }

        return geometryFactory.createPolygon(ring, holes);
    }

    public static LineString createTornadoPath(TornadoParameters tornadoParameters, int numSimulation) {
        Coordinate startPtCoordinate = new Coordinate(tornadoParameters.getStartLongitude(), tornadoParameters.getStartLatitude());
        Coordinate endPtCoordinate = null;
        if(tornadoParameters.getEndLatitude().size() == tornadoParameters.getNumSimulations()) {
            endPtCoordinate = new Coordinate(tornadoParameters.getEndLongitude().get(numSimulation), tornadoParameters.getEndLatitude().get(numSimulation));
        } else {
            endPtCoordinate = new Coordinate(tornadoParameters.getEndLongitude().get(0), tornadoParameters.getEndLatitude().get(0));
        }

        Coordinate[] coords = new Coordinate[]{startPtCoordinate, endPtCoordinate};
        return geometryFactory.createLineString(coords);
    }

    public static SimpleFeatureCollection createTornadoGeometry(ScenarioTornado scenarioTornado) {

        DefaultFeatureCollection collection = new DefaultFeatureCollection();
        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
        // FeatureTypeBuilder builder = FeatureTypeBuilder.newInstance("Tornado output"); //$NON-NLS-1$

        AttributeTypeBuilder attBuilder = new AttributeTypeBuilder();
        attBuilder.setName("the_geom"); //$NON-NLS-1$
        attBuilder.setBinding(Polygon.class);
        attBuilder.crs(DefaultGeographicCRS.WGS84);
        GeometryType geomType = attBuilder.buildGeometryType();
        GeometryDescriptor geomDesc = attBuilder.buildDescriptor("the_geom", geomType); //$NON-NLS-1$

        builder.setName(TornadoHazard.TORNADO_SCHEMA_NAME);
        builder.add(geomDesc);
        builder.add(TornadoHazard.SIMULATION, Integer.class);
        builder.add(TornadoHazard.EF_RATING_FIELD, String.class);

        SimpleFeatureType schema = builder.buildFeatureType();
        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(schema);
        for (int simulation = 0; simulation < scenarioTornado.getTornadoParameters().getNumSimulations(); simulation++) {
            LineString tornadoPath = TornadoUtils.createTornadoPath(scenarioTornado.getTornadoParameters(), simulation);
            EFBox efbox = scenarioTornado.getEfBoxes().get(simulation);
            List<Geometry> geometry = createTornadoGeometry(scenarioTornado.getTornadoParameters(), efbox.getEfBoxWidths(), tornadoPath);

            for (int index = 0; index < geometry.size(); index++) {
                featureBuilder.add(geometry.get(index));
                featureBuilder.add(simulation);
                featureBuilder.add("EF" + (geometry.size() - index - 1));
                SimpleFeature feature = featureBuilder.buildFeature(null);
                collection.add(feature);
            }

        }

        return collection;
    }

    public static List<Geometry> createTornadoGeometry(TornadoParameters tornadoParameters, List<Double> efBoxWidths, LineString tornadoPath) {

        // Tornado Parameters
        String efRating = tornadoParameters.getEfRating();

        List<LineString> tmpPaths = new ArrayList<LineString>();
        double tmpLength = 0;

        double boxLength = TornadoUtils.calcDistanceCoords(tornadoPath);

        // TODO Either get this from the model in case it overrides the parent class length multipliers or if model stores polygons, this method can be removed
        // EF box length multipliers
        double[] efLengthRate = TornadoUtils.getLengthMultiplier(efRating);

        for (int i = 0; i < efLengthRate.length; i++) {
            tmpLength = tmpLength + boxLength * (efLengthRate[i] / 100);
            tmpPaths.add(createPathWithLength(tmpLength, tornadoPath));
        }

        // geometry for calculating buffer
        ArrayList<Geometry> efBoxes = new ArrayList<Geometry>();
        // polygon geometry with inner polygon (hole)
        List<Geometry> efBoxPolys = new ArrayList<Geometry>();
        Geometry tmpPoly = null;

        for (int index = 0; index < efBoxWidths.size(); index++) {
            double efWidth = efBoxWidths.get(index);

            efBoxes.add(tmpPaths.get(index).buffer(efWidth, 10, BufferOp.CAP_BUTT));
            if (index == 0) {
                tmpPoly = createPolygon(efBoxes.get(index).getCoordinates(), null);
            } else {
                tmpPoly = createPolygon(efBoxes.get(index).getCoordinates(), efBoxes.get(index - 1).getCoordinates());
            }
            efBoxPolys.add(tmpPoly);
        }

        return efBoxPolys;

    }

    public static File[] createTornadoShapefile(DefaultFeatureCollection featureCollection) throws IOException {

        Transaction transaction = null;
        File incoreWorkDirectory = null;
        try {
            incoreWorkDirectory = File.createTempFile("incore", ".dir");
            incoreWorkDirectory.delete();
            incoreWorkDirectory.mkdirs();

            File hazardFile = new File(incoreWorkDirectory, "tornado.shp");

            DataStore dataStore = new ShapefileDataStore(hazardFile.toURI().toURL());
            dataStore.createSchema(featureCollection.getSchema());
            SimpleFeatureStore featureStore = (SimpleFeatureStore) dataStore.getFeatureSource(dataStore.getNames().get(0));
            transaction = featureStore.getTransaction();

            featureStore.addFeatures(featureCollection);

        } finally {
            if(transaction != null) {
                transaction.commit();
                transaction.close();

                return incoreWorkDirectory.listFiles();
            }
        }
        return null;
    }

    public static JSONObject getTornadoDatasetObject(String title, String creator, String description) {
        JSONArray spaces = new JSONArray();
        if (creator != null) {
            spaces.put(creator);
        }
        spaces.put(HazardDataset.ERGO_SPACE);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(HazardDataset.SCHEMA, TornadoHazard.TORNADO_SCHEMA_NAME);
        jsonObject.put(HazardDataset.TYPE, TornadoHazard.TORNADO_HAZARD_TYPE);
        jsonObject.put(HazardDataset.TITLE, title);
        jsonObject.put(HazardDataset.SOURCE_DATASET, "");
        jsonObject.put(HazardDataset.FORMAT, TornadoHazard.SHAPEFILE_FORMAT);
        jsonObject.put(HazardDataset.DESCRIPTION, description);
        jsonObject.put(HazardDataset.SPACES, spaces);

        return jsonObject;
    }

}
