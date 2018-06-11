/*******************************************************************************
 * Copyright (c) 2017 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the BSD-3-Clause which accompanies this distribution,
 * and is available at https://opensource.org/licenses/BSD-3-Clause
 *
 * Contributors:
 * Chris Navarro (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.eq.types;

import edu.illinois.ncsa.incore.service.hazard.models.eq.attenuations.BaseAttenuation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SeismicHazardResult {
    private String period;
    private String demand;
    private String units;
    private double hazardValue;

    public SeismicHazardResult(double hazardValue, String hazardType, String demand, String demandUnits) {
        this.hazardValue = hazardValue;
        this.period = hazardType;
        this.units = demandUnits;
        this.demand = demand;
    }
    public SeismicHazardResult(double hazardValue, String hazardType, String demand) {
        this.hazardValue = hazardValue;
        this.period = hazardType;
        this.units = BaseAttenuation.getUnits(hazardType);
        this.demand = demand;
    }

    public SeismicHazardResult(double hazardValue, String hazardType) {
        this.hazardValue = hazardValue;
        this.period = hazardType;
        this.units = BaseAttenuation.getUnits(hazardType);
    }

    public double getHazardValue() {
        return hazardValue;
    }

    public String getPeriod() {
        return period;
    }

    public String getUnits() {
        return units;
    }

    public String getDemand() {
        return demand;
    }
}
