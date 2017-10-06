package edu.illinois.ncsa.incore.services.hazard.dataaccess;

import com.mongodb.MongoClient;
import edu.illinois.ncsa.incore.services.hazard.models.eq.ScenarioEarthquake;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MongoDBRepository implements IRepository {
    private String hostUri;
    private String databaseName;
    private int port;

    private Datastore dataStore;
    private List<ScenarioEarthquake> scenarioEarthquakes;

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

    @Override
    public void initialize()
    {
        this.initializeDataStore();
    }

    private void initializeDataStore() {
        MongoClient client = new MongoClient(hostUri, port);

        Set<Class> classesToMap = new HashSet<>();
        Morphia morphia = new Morphia(classesToMap);
        classesToMap.add(ScenarioEarthquake.class);
        Datastore morphiaStore = morphia.createDatastore(client, databaseName);
        morphiaStore.ensureIndexes();

        this.dataStore = morphiaStore;
    }

    @Override
    public ScenarioEarthquake getScenarioEarthquakeById(String id) {
        return this.dataStore.get(ScenarioEarthquake.class, new ObjectId(id));
    }

    @Override
    public ScenarioEarthquake addScenarioEarthquake(ScenarioEarthquake scenarioEarthquake) {
        this.dataStore.save(scenarioEarthquake);
        String id = this.dataStore.save(scenarioEarthquake).getId().toString();
        return getScenarioEarthquakeById(id);
    }

    @Override
    public List<ScenarioEarthquake> getScenarioEarthquakes() {
        if(this.scenarioEarthquakes == null) {
            loadScenarioEarthquakes();
        }

        return this.scenarioEarthquakes;
    }

    @Override
    public Datastore getDataStore() {
        return this.dataStore;
    }

    private void loadScenarioEarthquakes() {
        this.scenarioEarthquakes = this.dataStore.createQuery(ScenarioEarthquake.class).asList();
    }
}
