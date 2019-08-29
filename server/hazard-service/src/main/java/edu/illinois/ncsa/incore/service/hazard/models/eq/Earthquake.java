/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.models.eq;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.illinois.ncsa.incore.common.data.models.jackson.JsonDateSerializer;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "eqType")
@JsonSubTypes({@JsonSubTypes.Type(value = EarthquakeDataset.class, name = "dataset"), @JsonSubTypes.Type(value = EarthquakeModel.class, name = "model")})
@XmlRootElement
public abstract class Earthquake {
    @Id
    @Property("_id")
    private ObjectId id;

    public void setName(String name) {
        this.name = name;
    }

    // Friendly name of defined earthquake
    private String name;
    private String description;

    private Date date = new Date();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return this.name;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
