/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.eq;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "hazardType")
@JsonSubTypes({@JsonSubTypes.Type(value = DeterministicHazardDataset.class, name = "deterministic"), @JsonSubTypes.Type(value = ProbabilisticHazardDataset.class, name = "probabilistic")})
public abstract class HazardDataset {
    private String datasetId;
    private String demandType;
    private String demandUnits;
    private double period;

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public String getDemandType() {
        return demandType;
    }

    public void setDemandType(String demandType) {
        this.demandType = demandType;
    }

    public String getDemandUnits() {
        return demandUnits;
    }

    public void setDemandUnits(String demandUnits) {
        this.demandUnits = demandUnits;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

}
