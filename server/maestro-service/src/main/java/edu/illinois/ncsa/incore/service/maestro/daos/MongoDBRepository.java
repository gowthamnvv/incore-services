/*******************************************************************************
 * Copyright (c) 2019 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Mozilla Public License v2.0 which accompanies this distribution,
 * and is available at https://www.mozilla.org/en-US/MPL/2.0/
 *
 * Contributors:
 * Indira Gutierrez (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.maestro.daos;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import edu.illinois.ncsa.incore.service.maestro.models.Analysis;
import edu.illinois.ncsa.incore.service.maestro.models.AnalysisMetadata;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MongoDBRepository implements IRepository {
    private String hostUri;
    private String databaseName;
    private int port;
    private MongoClientURI mongoClientURI;

    private Datastore dataStore;
    private List<Analysis> analyses;

    public MongoDBRepository() {
        this.port = 27017;
        this.hostUri = "localhost";
        this.databaseName = "maestrodb";
    }

    public MongoDBRepository(String hostUri, String databaseName, int port) {
        this.databaseName = databaseName;
        this.hostUri = hostUri;
        this.port = port;
    }

    public MongoDBRepository(MongoClientURI mongoClientURI) {
        this.mongoClientURI = mongoClientURI;
        this.databaseName = mongoClientURI.getDatabase();
    }

    @Override
    public void initialize() {
        this.initializeDataStore();
    }

    @Override
    public List<Analysis> getAllAnalyses(){
        this.loadServices();
        return this.analyses;
    }

    @Override
    public List<Analysis> getAnalysis(Map<String, String> queryMap, int offset, int limit){
        Query<Analysis> query = this.dataStore.createQuery(Analysis.class);

        for (Map.Entry<String, String> queryEntry : queryMap.entrySet()) {
            query.filter(queryEntry.getKey(), queryEntry.getValue());
        }

        List <Analysis> analyses = query.offset(offset).limit(limit).asList();

        return analyses;
    }

    @Override
    public Analysis getAnalysisById(String id) {
        return this.dataStore.get(Analysis.class, new ObjectId(id));
    }

    @Override
    public Analysis addAnalysis(Analysis analysis) {
         String id = this.dataStore.save(analysis).getId().toString();
         return getAnalysisById(id);
    }

    @Override
    public Datastore getDataStore() {
        return this.dataStore;
    }

    private void initializeDataStore() {
        MongoClient client = new MongoClient(mongoClientURI);

        Set<Class> classesToMap = new HashSet<>();
        Morphia morphia = new Morphia(classesToMap);
        classesToMap.add(Analysis.class);
        Datastore morphiaStore = morphia.createDatastore(client, databaseName);
        morphiaStore.ensureIndexes();

        this.dataStore = morphiaStore;
    }

    private void loadServices() {
        List<Analysis> analyses = this.dataStore.createQuery(Analysis.class).asList();
        this.analyses = analyses;
    }

}
