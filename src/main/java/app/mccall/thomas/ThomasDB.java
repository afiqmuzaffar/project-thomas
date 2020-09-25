package app.mccall.thomas;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ThomasDB {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    private void init() {
        mongoDatabase = mongoClient.getDatabase("thomasdb");
        mongoCollection = mongoDatabase.getCollection("db");
    }

    public ThomasDB() {
        mongoClient = MongoClients.create();
        init();
    }

    public ThomasDB(final ConnectionString address) {
        mongoClient = MongoClients.create(address);
        init();
    }

    public ThomasDB(final String hostname) {
        mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(hostname)))).build());
        init();
    }

    public boolean initDB(final String hostname, int port) {
        mongoClient = MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(hostname, port))))
                .build());
        init();
        return true;
    }

    protected void query() {

    }

}
