package edu.illinois.ncsa.incore.service.semantics.daos;
import com.mongodb.MongoClientURI;

import java.util.*;

import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.*;


public class MongoDBTypeDAO extends MongoDAO implements ITypeDAO {

    private List<Document> typeList;

    public MongoDBTypeDAO(MongoClientURI mongoClientURI) {
        super(mongoClientURI);
    }

    @Override
    public void initialize() {
        super.initializeDataStore();
        this.loadTypes();
    }

    @Override
    public List<Document> getTypes() {
        this.loadTypes();
        return this.typeList;
    }

    private void loadTypes() {
        this.typeList = (List<Document>) this.dataStoreType.find().into(new ArrayList<Document>());

    }

    @Override
    public Optional<List<Document>> getTypeByUri(String uri, String version) {
        List<Document> matchedTypeList;

        // version can be all, latest or specific version
        if (version.equals("all") || version.equals("latest")) {
            // due to latest and all need to be restricted by space
            // check latest later
            matchedTypeList = (List<Document>) this.dataStoreType
                .find(eq("url", uri)).into(new ArrayList<Document>());
        } else {
            matchedTypeList = (List<Document>) this.dataStoreType.find(and(eq("url", uri),
                eq("openvocab:versionnumber", version))).into(new ArrayList<Document>());
        }

        if (matchedTypeList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(matchedTypeList);
        }

    }

    @Override
    public Optional<List<Document>> searchType(String typeName){
        List<Document> typeList = (List<Document>) this.dataStoreType.find().into(new ArrayList<Document>());
        List<Document> matchTypeList = new ArrayList<Document>();

        for (Document datsetType : typeList){
            String title = datsetType.get("dc:title").toString();
            if (title.toLowerCase().contains(typeName.toLowerCase())){
                matchTypeList.add(datsetType);
            }
        }

        if (matchTypeList.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(matchTypeList);
        }
    }

    private Boolean checkNewType(Document newType){

        if (newType.get("@context") != null
            && newType.get("dc:license") != null
            && newType.get("dc:title") != null
            && newType.get("dc:description") != null
            && newType.get("url") != null
            && newType.get("openvocab:versionnumber") != null
            && newType.get("tableSchema") != null){

            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String postType(Document newType) {
        if (newType != null && checkNewType(newType)) {
            // insert new type
            this.dataStoreType.insertOne(newType);

            return newType.getObjectId("_id").toString();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String deleteType(String id) {
        this.dataStoreType.findOneAndDelete(eq("_id", new ObjectId(id)));
        return id;
    }


}
