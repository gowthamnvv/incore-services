/*******************************************************************************
 * Copyright (c) 2018 University of Illinois and others.  All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the BSD-3-Clause which accompanies this distribution,
 * and is available at https://opensource.org/licenses/BSD-3-Clause
 *
 * Contributors:
 * Chris Navarro (NCSA) - initial API and implementation
 *******************************************************************************/
package edu.illinois.ncsa.incore.service.hazard.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import edu.illinois.ncsa.incore.service.hazard.models.tornado.ScenarioTornado;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MongoDBTornadoRepository implements ITornadoRepository {
    private String hostUri;
    private String databaseName;
    private int port;
    private MongoClientURI mongoClientURI;

    private Datastore dataStore;

    public MongoDBTornadoRepository() {
        this.port = 27017;
        this.hostUri = "localhost";
        this.databaseName = "hazarddb";
    }

    public MongoDBTornadoRepository(String hostUri, String databaseName, int port) {
        this.databaseName = databaseName;
        this.hostUri = hostUri;
        this.port = port;
    }

    public MongoDBTornadoRepository(MongoClientURI mongoClientURI) {
        this.mongoClientURI = mongoClientURI;
        this.databaseName = mongoClientURI.getDatabase();
    }

    @Override
    public void initialize() {
        this.initializeDataStore();
    }

    private void initializeDataStore() {
        MongoClient client = new MongoClient(mongoClientURI);

        Set<Class> classesToMap = new HashSet<>();
        Morphia morphia = new Morphia(classesToMap);
        classesToMap.add(ScenarioTornado.class);
        Datastore morphiaStore = morphia.createDatastore(client, mongoClientURI.getDatabase());
        morphiaStore.ensureIndexes();
        this.dataStore = morphiaStore;
    }

    @Override
    public List<ScenarioTornado> getScenarioTornadoes() {
        List<ScenarioTornado> scenarioTornadoes = this.dataStore.createQuery(ScenarioTornado.class).asList();
        return scenarioTornadoes;
    }

    @Override
    public ScenarioTornado addScenarioTornado(ScenarioTornado scenarioTornado) {
        String id = this.dataStore.save(scenarioTornado).getId().toString();
        return getScenarioTornadoById(id);
    }

    @Override
    public ScenarioTornado getScenarioTornadoById(String id) {
        return this.dataStore.get(ScenarioTornado.class, new ObjectId(id));
    }

    @Override
    public Datastore getDataStore() {
        return this.dataStore;
    }
}
