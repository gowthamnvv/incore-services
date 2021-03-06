/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Chris Navarro (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.eq.utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import edu.illinois.ncsa.incore.service.hazard.HazardConstants;
import edu.illinois.ncsa.incore.service.hazard.models.eq.EqParameters;
import edu.illinois.ncsa.incore.service.hazard.models.eq.HazardDataset;
import edu.illinois.ncsa.incore.service.hazard.models.eq.Site;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.opengis.coverage.PointOutsideCoverageException;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.TransformException;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

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
    public static final String units_in = "in";
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

    public static double convertHazard(double hazard, String fromUnits, double t, String fromHazardType, String toUnits,
                                       String toHazardType) {
        double hazardVal = convertHazardType(hazard, fromUnits, t, fromHazardType, toUnits, toHazardType);
        if (Double.isNaN(hazardVal)) {
            hazardVal = 0.0;
        }
        // not really sure that we should use 0.0 for infinite values, but we
        // know there's no way we want them in our actual values
        if (Double.isInfinite(hazardVal)) {
            hazardVal = 0.0;
        }
        return hazardVal;

    }

    /**
     * @param hazard      Hazard Input
     * @param units0      Units of the hazard input
     * @param t           Period, if applicable to the conversion
     * @param hazardType0 Type of hazard input
     * @param units1      Units of the required hazard
     * @param hazardType1 Type of required hazard
     * @return
     */
    private static double convertHazardType(double hazard, String units0, double t, String hazardType0, String units1, String hazardType1) {
        String concat = hazardType0.concat(hazardType1);
        if (concat.equalsIgnoreCase(sa_pgv)) {
            double pgv_from_sa = convertSAToPGV(hazard, units0, units1);
            return convertHazard(pgv_from_sa, units_cms, 0.0, PGV, units1, PGV);
        } else if (concat.equalsIgnoreCase(pga_pga)) {
            return getCorrectUnitsOfPGA(hazard, units0, units1);
        } else if (concat.equalsIgnoreCase(sa_sa)) {
            return getCorrectUnitsOfSA(hazard, units0, units1);
        } else if (concat.equalsIgnoreCase(sa_sd)) {
            return convertSAToSD(hazard, t, units0, units1);
        } else if (concat.equalsIgnoreCase(sa_sv)) {
            return convertSAToSV(hazard, t, units0);
        } else if (concat.equalsIgnoreCase(sd_sd)) {
            return getCorrectUnitsOfSD(hazard, units0, units1);
        } else if (concat.equalsIgnoreCase(pga_pgd)) {
            // logger.debug( "***************hazard val in: " + hazard );
            return convertPGAToPGD(hazard, units0, units1);
        } else if (concat.equalsIgnoreCase(pgv_pgv)) {
            // logger.debug( "***************hazard val in: " + hazard );
            return getCorrectUnitsOfPGV(hazard, units0, units1);
        }
        return hazard;
    }

    /**
     * @param sa_1   1.0 Second Spectral Acceleration
     * @param units0 Units of the SA value
     * @return PGV in cm/sec
     */
    private static double convertSAToPGV(double sa_1, String units0, String units1) {
        double hazard = sa_1;
        if (units_g.equalsIgnoreCase(units0)) {

        } else if (units_percg.equalsIgnoreCase(units0)) {
            hazard /= 100.0;
        }

        return ((386.4 * hazard) / (2 * Math.PI)) * 2.54 / 1.65;
    }

    /**
     * @param pga
     * @param units0
     * @param units1
     * @return
     */
    private static double convertPGAToPGD(double pga, String units0, String units1) {
        // XXX: assuming ground type B here, that's not always true, how do we
        // handle that?
        double hazard = pga;
        if (units_g.equalsIgnoreCase(units0)) {
            hazard *= 9.80;
        } else if (units_percg.equalsIgnoreCase(units0)) {
            hazard = hazard * 9.8 / 100.0;
        } else {
            logger.warn("unknown units in converting PGA to PGD, returning base hazard: " + hazard);
        }
        return getCorrectUnitsOfPGD(convertPGAToPGD(hazard, 1.2, 0.5, 2.0), "m", units1);
    }

    /**
     * @param pga Peak Ground Acceleration in m/s^2
     * @param s   Constant for specific ground type
     * @param t_c Constant for specific ground type
     * @param t_d Constant for specific ground type
     * @return Peak Ground Displacement in meters
     */
    private static double convertPGAToPGD(double pga, double s, double t_c, double t_d) {
        return (0.025 * pga * s * t_c * t_d);
    }

    /**
     * @param sa     spectral acceleration
     * @param t      period
     * @param units0 units of Sa
     * @return spectral displacement in cm
     */
    private static double convertSAToSD(double sa, double t, String units0, String units1) {
        sa = getCorrectUnitsOfSA(sa, units0, units_g);
        return getCorrectUnitsOfSD(sa * 9.78 * Math.pow(t, 2) * 2.54, units_cm, units1);
    }

    /**
     * @param sa     spectral acceleration
     * @param t      period
     * @param units0 units of Sa
     * @return spectral velocity in cm/s
     */
    private static double convertSAToSV(double sa, double t, String units0) {
        sa = getCorrectUnitsOfSA(sa, units0, units_g);
        return sa * 9.8 * t / (2 * Math.PI);
    }

    /**
     * @param pga
     * @param units0
     * @param units1
     * @return
     */
    public static double getCorrectUnitsOfPGA(double pga, String units0, String units1) {
        if (units1 != null && units1.equalsIgnoreCase(units0)) {
            return pga;
        } else if (units_g.equalsIgnoreCase(units1) && units_percg.equalsIgnoreCase(units0)) {
            return pga / 100.0;
        } else {
            logger.warn("Unknown PGA unit, returning unconverted pga value");
            // Unknown type
            return pga;
        }
    }

    /**
     * @param pgd
     * @param units0
     * @param units1
     * @return
     */
    public static double getCorrectUnitsOfPGD(double pgd, String units0, String units1) {
        if (units0 != null && units0.equalsIgnoreCase(units1)) {
            return pgd;
        } else if (units_m.equalsIgnoreCase(units0) || "m".equalsIgnoreCase(units0) && units_ft.equalsIgnoreCase(units1)) {
            return pgd * 3.2808399;
        } else if (units_m.equalsIgnoreCase(units0) || "m".equalsIgnoreCase(units0) && units_cm.equalsIgnoreCase(units1)) {
            return pgd * 100.0;
        } else {
            // Unknown type
            logger.warn("PGD unit type was " + units0 + ", but no conversion is implemented for units of " + units1);
            return pgd;
        }
    }

    /**
     * @param sa
     * @param units0
     * @param units1
     * @return
     */
    public static double getCorrectUnitsOfSA(double sa, String units0, String units1) {
        if (units1 != null && units1.equalsIgnoreCase(units0)) {
            return sa;
        } else if (units_g.equalsIgnoreCase(units1) && units_percg.equalsIgnoreCase(units0)) {
            return sa / 100.0;
        } else {
            // Unknown type
            logger.warn("Unknown SA unit, returning unconverted sa value");
            return sa;
        }
    }

    /**
     * @param sd
     * @param units0
     * @param units1
     * @return
     */
    public static double getCorrectUnitsOfSD(double sd, String units0, String units1) {
        if (units1 != null && units1.equalsIgnoreCase(units0)) {
            return sd;
        } else if (units_in.equalsIgnoreCase(units1) && units_cm.equalsIgnoreCase(units0)) {
            return sd / 2.54;
        } else if (units_cm.equalsIgnoreCase(units1) && units_in.equalsIgnoreCase(units0)) {
            return sd * 2.54;
        } else {
            // Unknown type
            logger.warn("Unknown SD unit, returning unconverted sd value");
            return sd;
        }
    }

    /**
     * @param pgv
     * @param units0
     * @param units1
     * @return
     */
    public static double getCorrectUnitsOfPGV(double pgv, String units0, String units1) {
        if (units1 != null && units1.equalsIgnoreCase(units0)) {
            return pgv;
        } else if (units_ins.equalsIgnoreCase(units1) && units_cms.equalsIgnoreCase(units0)) {
            return pgv / 2.54;
        } else {
            logger.warn("Unknown pgv unit, returning unconverted pgv value");
            return pgv;
        }
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
        if ("".equals(hazard)) {
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

    /**
     * @param hazardType0
     * @param period
     * @return
     */
    public static String[] findHazardConversionTypes(String hazardType0, double period) {
        if (PGA.equalsIgnoreCase(hazardType0)) {
            String[] s = {PGA, PGD};
            return s;
        } else if (SA.equalsIgnoreCase(hazardType0)) {
            if (Double.compare(period, 1.0) == 0) {
                String[] s = {"Sa", "Sd", "Sv", PGV};
                return s;
            } else {
                String[] s = {"Sa", "Sd", "Sv"};
                return s;
            }
        } else {
            String[] s = {hazardType0};
            return s;
        }
    }

    public static HazardDataset findHazard(List<HazardDataset> hazardDataset, String demandHazard, String period, boolean exactOnly) {
        return findHazard(hazardDataset, demandHazard, Double.parseDouble(period), exactOnly);

    }

    public static HazardDataset findHazard(List<HazardDataset> hazardDataset, String demandHazard, double period, boolean exactOnly) {
        String demandHazardMotion = stripPeriod(demandHazard);
        List<HazardDataset> matches = new LinkedList<>();
        for (HazardDataset dataset : hazardDataset) {
            if (dataset.getDemandType().equalsIgnoreCase(demandHazardMotion)) {
                matches.add(dataset);
                // return r;
            }
        }

        if (matches.size() == 0) {
            // Second Attempt, now we look for conversion possibilities
            for (HazardDataset dataset : hazardDataset) {

                double rasterPeriod = dataset.getPeriod();

                String[] conversions = HazardUtil.findHazardConversionTypes(dataset.getDemandType(), rasterPeriod);
                for (String s : conversions) {
                    if (s.equalsIgnoreCase(demandHazardMotion)) {
                        if (!matches.contains(dataset)) {
                            matches.add(dataset);
                        }
                    }
                }
            }
        }

        // if we're looking for exact period matches only, don't bother with
        // that stuff later that looks for the closest period...

        if (exactOnly) {
            for (HazardDataset rasterDataset : matches) {
                double rasterPeriod = rasterDataset.getPeriod();
                if (Math.abs(rasterPeriod - period) < .001) {
                    return rasterDataset;
                }
            }
            return null;
        }

        if (matches.size() == 0) {
            logger.debug("Did not find appropriate hazard or a conversion");
            logger.debug("Fragility curve requires hazard type: " + demandHazard);
            logger.debug("Here are the hazard types we have: ");
            for (HazardDataset dataset : hazardDataset) {
                logger.debug(dataset.getDemandType());
            }
            return null;
        } else if (matches.size() == 1) {
            return matches.get(0);
        } else {
            HazardDataset returnVal = matches.get(0);
            double period_diff = Math.abs(period - returnVal.getPeriod());
            for (int i = 1; i < matches.size(); i++) {
                double tmp = Math.abs(period - matches.get(i).getPeriod());
                if (tmp < period_diff) {
                    period_diff = tmp;
                    returnVal = matches.get(i);
                }
            }

            return returnVal;
        }

    }

    public static String[] getHazardDemandComponents(String fullDemandType) {
        String[] demandParts = {"0.0", fullDemandType};
        if (fullDemandType.equalsIgnoreCase(PGA) || fullDemandType.equalsIgnoreCase(PGV) || fullDemandType.equalsIgnoreCase(PGD)) {
            return demandParts;
        } else {
            String[] demandSplit = fullDemandType.split(" ");
            demandParts[0] = demandSplit[0].trim();
            demandParts[1] = demandSplit[1].trim();

            return demandParts;
        }
    }

    public static String getFullDemandType(String period, String demandType) {
        return getFullDemandType(Double.parseDouble(period), demandType);
    }

    public static String getFullDemandType(double period, String demandType) {
        if (demandType.equalsIgnoreCase(PGA) || demandType.equalsIgnoreCase(PGV) || demandType.equalsIgnoreCase(PGD)) {
            return demandType;
        } else {
            return Double.toString(period) + " " + demandType.trim();
        }
    }

    /**
     *
     * @param site
     * @param sourceSite
     * @return
     */
    public static double[] computeOriginalDistance(Site site, Site sourceSite) {
        double[] originalDistance = new double[3];
        double longitudeSite = site.getLocation().getX();
        double latitudeSite = site.getLocation().getY();
        double longitudeSource = sourceSite.getLocation().getX();
        double latitudeSource = sourceSite.getLocation().getY();
        double hypocentralDepth = sourceSite.getDepth();

        originalDistance[0] = (longitudeSite - longitudeSource) * Math.PI * R_EARTH / 180.0;
        originalDistance[1] = (latitudeSite - latitudeSource) * Math.PI * R_EARTH / 180.0;
        originalDistance[2] = hypocentralDepth;

        return originalDistance;
    }

    /***
     * Checks if the file types match the list of allowable file extensions.
     * @param fileParts
     * @return
     */
    public static boolean validateEqDatasetTypes(List<FormDataBodyPart> fileParts){
        for (FormDataBodyPart filePart:fileParts) {
            String fileExt = FilenameUtils.getExtension(filePart.getContentDisposition().getFileName());
            if(!HazardConstants.EQ_DATASET_TYPES_ALLOWED.contains(fileExt)){
                return false;
            }
        }
        return true;
    }

    public static Site getSourceSite(EqParameters ruptureParameters) {
        double srcLatitude = ruptureParameters.getSrcLatitude();
        double srcLongitude = ruptureParameters.getSrcLongitude();
        double depth = ruptureParameters.getDepth();
        Site sourceSite = new Site(new GeometryFactory().createPoint(new Coordinate(srcLongitude, srcLatitude)), depth);

        return sourceSite;
    }

    public static int getReverseFaultingFactorFlag(double rakeAngle)
    {
        if (rakeAngle > 30 && rakeAngle < 150) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int getNormalFaultingFactorFlag(double rakeAngle)
    {
        if (rakeAngle > -150.0 && rakeAngle < -30.0) {
            return 1;
        } else {
            return 0;
        }
    }
}
