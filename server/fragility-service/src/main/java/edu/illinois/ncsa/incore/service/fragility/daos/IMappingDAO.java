/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Omar Elabd
 *******************************************************************************/

package edu.illinois.ncsa.incore.service.fragility.daos;

import edu.illinois.ncsa.incore.service.fragility.models.MappingSet;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IMappingDAO {
    void initialize();
    List<MappingSet> getMappingSets();
    Optional<MappingSet> getMappingSetById(String id);
    List<MappingSet> queryMappingSets(Map<String, String> queryMap, int offset, int limit);
    void saveMappingSet(MappingSet mappingSet);
}