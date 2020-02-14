package edu.illinois.ncsa.incore.service.hazard.models.eq.attenuations;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import edu.illinois.ncsa.incore.service.hazard.models.eq.EqParameters;
import edu.illinois.ncsa.incore.service.hazard.models.eq.FaultMechanism;
import edu.illinois.ncsa.incore.service.hazard.models.eq.Site;
import edu.illinois.ncsa.incore.service.hazard.models.eq.attenuations.AbrahamsonSilvaKamai2014;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbrahamsonSilvaKamai2014Test {
    private AbrahamsonSilvaKamai2014 attenuation;

    @BeforeAll
    public void before() throws Exception {
        double latitude = 35.927;
        double longitude = -89.919;
        double focaldepth = 10.0;
        double magnitude = 7.9;

        Map<String, String> faultTypeMap = new HashMap<>();
        faultTypeMap.put(AbrahamsonSilvaKamai2014.class.getSimpleName(), FaultMechanism.STRIKE_SLIP);
        EqParameters ruptureParameters = new EqParameters();

        ruptureParameters.setFaultTypeMap(faultTypeMap);
        ruptureParameters.setMagnitude(magnitude);
        ruptureParameters.setSrcLatitude(latitude);
        ruptureParameters.setSrcLongitude(longitude);
        ruptureParameters.setDepth(focaldepth);
        ruptureParameters.setRakeAngle(176.0);
        ruptureParameters.setDipAngle(90.0);
        ruptureParameters.setAzimuthAngle(130.0);
        ruptureParameters.setDepth2p5KmPerSecShearWaveVelocity(2.0);
        ruptureParameters.setRegion("California");

        attenuation = new AbrahamsonSilvaKamai2014();
        attenuation.setRuptureParameters(ruptureParameters);
    }

    @Test
    public void testGetValue() throws Exception {
        String period = "0.2";
        double latitude = 35.07899;// 35.927;
        double longitude = -90.017;// -90.05;

        GeometryFactory factory = new GeometryFactory();
        Site site = new Site(factory.createPoint(new Coordinate(longitude, latitude)));

        double hazard = attenuation.getValue(period, site);

        double expected = 0.17415367;
        assertEquals(expected, hazard, expected * 0.05);
    }
}
