/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Chris Navarro (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.tornado.types;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WindHazardResult {
    private String demandType = "Wind";
    private String demandUnits;
    private double hazardValue;

    public WindHazardResult(String demandUnits, double hazardValue) {
        this.hazardValue = hazardValue;
        this.demandUnits = demandUnits;
    }

    public double getHazardValue() {
        return hazardValue;
    }

    public String getDemandUnits() {
        return this.demandUnits;
    }

    public String getDemandType() {
        return this.demandType;
    }
}
