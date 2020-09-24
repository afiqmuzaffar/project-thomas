package app.mccall;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

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

public class Thomas {

    private MongoClient mongoClient = null;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> mongoCollection;

    private InputStream parserModelInputStream;
    private ParserModel parserModel;
    private Parser parser;
    private Parse parse;

    private void configureDB() {
        mongoDatabase = mongoClient.getDatabase("thomasdb");
        mongoCollection = mongoDatabase.getCollection("db");
    }

    public boolean initDB() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create();
            configureDB();
            return true;
        } else
            System.out.println("<project-thomas> Error: Database already initialized");
        return false;
    }

    public boolean initDB(ConnectionString address) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(address);
            configureDB();
            return true;
        } else
            System.out.println("<project-thomas> Error: Database already initialized");
        return false;
    }

    public boolean initDB(String hostname) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(MongoClientSettings.builder()
                    .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(hostname))))
                    .build());
            configureDB();
            return true;
        } else
            System.out.println("<project-thomas> Error: Database already initialized");
        return false;
    }

    public boolean initDB(String hostname, int port) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(MongoClientSettings.builder()
                    .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(hostname, port))))
                    .build());
            configureDB();
            return true;
        } else
            System.out.println("<project-thomas> Error: Database already initialized");
        return false;
    }

    public boolean initParser(String dataset) {
        try {
            parserModelInputStream = new FileInputStream(dataset);
            parserModel = new ParserModel(parserModelInputStream);
            parser = ParserFactory.create(parserModel);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Optional<String> send(String message) {
        return Optional.of(ParserTool.parseLine(message, parser, 1).toString());
    }

    public void log(final String message) {
        System.out.println(message);
    }
}
