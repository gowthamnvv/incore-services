/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Omar Elabd, Nathan Tolbert
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.dfr3.models;

import org.mongodb.morphia.annotations.Entity;
import java.util.List;

@Entity("FragilitySet")
public class FragilitySet extends DFR3Set {

    protected String demandType;
    protected String demandUnits;
    private List<FragilityCurve> fragilityCurves;

    public String getDemandType() {
    return demandType;
}

    public String getDemandUnits() {
        return demandUnits;
    }

    public List<FragilityCurve> getFragilityCurves() {
        return fragilityCurves;
    }

}
