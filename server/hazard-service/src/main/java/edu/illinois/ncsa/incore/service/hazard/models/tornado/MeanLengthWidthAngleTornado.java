package edu.illinois.ncsa.incore.service.hazard.models.tornado;

import com.vividsolutions.jts.geom.Coordinate;
import edu.illinois.ncsa.incore.service.hazard.models.tornado.utils.TornadoUtils;

import java.util.ArrayList;
import java.util.List;

public class MeanLengthWidthAngleTornado extends Tornado{

    public void createTornado(TornadoParameters tornadoParameters) {

        String efRating = tornadoParameters.getEfRating();

        double meanDistance = TornadoUtils.computeMeanLength(efRating);
        double meanWidth = TornadoUtils.computeMeanWidth(efRating);
        double meanAngle = TornadoUtils.computeMeanAngle(efRating);

        tornadoWidths = new ArrayList<Double>();
        this.tornadoWidths.add(meanWidth);

        Coordinate startPtCoordinate = new Coordinate(tornadoParameters.getStartLongitude(), tornadoParameters.getStartLatitude());
        Coordinate endPtCoordinate = TornadoUtils.calculateDestination(startPtCoordinate, meanAngle, meanDistance);

        this.efBoxes.add(this.computeTornadoEFBoxWidths(startPtCoordinate, endPtCoordinate, meanWidth, efRating));

        List<Double> endLongitude = new ArrayList<Double>();
        List<Double> endLatitude = new ArrayList<Double>();
        endLongitude.add(endPtCoordinate.x);
        endLatitude.add(endPtCoordinate.y);

        tornadoParameters.setEndLongitude(endLongitude);
        tornadoParameters.setEndLatitude(endLatitude);

        this.tornadoParameters = tornadoParameters;
    }

    @Override
    public boolean requiresEndPoint() {
        return true;
    }
}
