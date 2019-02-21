/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Omar Elabd, Nathan Tolbert
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.fragility.models;

import edu.illinois.ncsa.incore.common.auth.Privileges;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Entity("FragilitySet")
public class FragilitySet {
    @Id
    private ObjectId id;

    @XmlTransient
    private String legacyId;

    private String description;

    private List<String> authors = new ArrayList<>();
    private PaperReference paperReference;

    private String resultUnit;
    private String resultType;
    private String demandType;
    private String demandUnits;

    private String hazardType;
    private String inventoryType;

    private List<FragilityCurve> fragilityCurves;
    private Privileges privileges;
    private String creator;

    public FragilitySet() { }

    public FragilitySet(String legacyId, String description, List<String> authors, PaperReference paperReference, String resultUnit,
                        String resultType, String demandType, String demandUnits, String hazardType, String inventoryType,
                        List<FragilityCurve> fragilityCurves) {
        this.legacyId = legacyId;
        this.description = description;
        this.authors = authors;
        this.paperReference = paperReference;
        this.resultUnit = resultUnit;
        this.resultType = resultType;
        this.demandType = demandType;
        this.demandUnits = demandUnits;
        this.hazardType = hazardType;
        this.inventoryType = inventoryType;
        this.fragilityCurves = fragilityCurves;
    }

    // region Getters
    public String getId() {
        if (id == null) {
            return null;
        } else {
            return id.toHexString();
        }
    }

    public String getLegacyId() {
        return legacyId;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public PaperReference getPaperReference() {
        return paperReference;
    }

    public String getResultUnit() {
        return resultUnit;
    }

    public String getResultType() {
        return resultType;
    }

    public String getDemandType() {
        return demandType;
    }

    public String getDemandUnits() {
        return demandUnits;
    }

    public String getHazardType() {
        return hazardType;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public List<FragilityCurve> getFragilityCurves() {
        return fragilityCurves;
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        this.privileges = privileges;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }
    // endregion
}
