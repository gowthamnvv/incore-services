/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Omar Elabd, Nathan Tolbert
 */

package edu.illinois.ncsa.incore.service.dfr3.models;

import ncsa.tools.common.exceptions.ParseException;

import java.util.Map;

public class StandardFragilityCurve extends FragilityCurve {
    public double[] alpha;
    public double[] beta;
    public AlphaType alphaType;
    public CurveType curveType;
    public Map<Integer, String> rules;


    public StandardFragilityCurve() {
        super();
    }

    public StandardFragilityCurve(double[] alpha, double[] beta, AlphaType alphaType, CurveType curveType, String label, Map<Integer, String> rules) throws ParseException {
        super(label);

        // alpha and beta parameters are in pairs, so they must have the same length
        if (alpha.length != beta.length) {
            throw new ParseException("Alpha and beta parameters need to be in the same shape.");
        }
        this.alpha = alpha;
        this.beta = beta;
        this.alphaType = alphaType;
        this.curveType = curveType;
        this.rules = rules;
    }
}
