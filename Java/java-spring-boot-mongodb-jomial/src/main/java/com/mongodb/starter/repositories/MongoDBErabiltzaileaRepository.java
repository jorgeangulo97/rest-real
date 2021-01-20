package com.mongodb.starter.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.WriteModel;
import com.mongodb.starter.models.Erabiltzailea;
import org.bson.BsonDocument;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class MongoDBErabiltzaileaRepository implements ErabiltzaileaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Erabiltzailea> erabiltzaileaCollection;

    @PostConstruct
    void init() {
        erabiltzaileaCollection = client.getDatabase("jomial").getCollection("erabiltzailea", Erabiltzailea.class);
    }

    @Override
    public Erabiltzailea save(Erabiltzailea erabiltzailea) {
        erabiltzailea.setErabiltzailea_id(new ObjectId());
        erabiltzaileaCollection.insertOne(erabiltzailea);
        return erabiltzailea;
    }

    @Override
    public List<Erabiltzailea> saveAll(List<Erabiltzailea> hotel) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                hotel.forEach(e -> e.setErabiltzailea_id(new ObjectId()));
                erabiltzaileaCollection.insertMany(clientSession, hotel);
                return hotel;
            }, txnOptions);
        }
    }

    @Override
    public List<Erabiltzailea> findAll() {
        return erabiltzaileaCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Erabiltzailea> findAll(List<String> ids) {
        return erabiltzaileaCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    @Override
    public Erabiltzailea findOne(String id) {
        return erabiltzaileaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public long count() {
        return erabiltzaileaCollection.countDocuments();
    }

    @Override
    public long delete(String id) {
        return erabiltzaileaCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> erabiltzaileaCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(),
                    txnOptions);
        }
    }

    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> erabiltzaileaCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public Erabiltzailea update(Erabiltzailea erabiltzailea) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return erabiltzaileaCollection.findOneAndReplace(eq("_id", erabiltzailea.getErabiltzailea_id()), erabiltzailea, options);
    }

    @Override
    public long update(List<Erabiltzailea> erabiltzaileak) {
        List<WriteModel<Erabiltzailea>> writes = erabiltzaileak.stream()
                                                 .map(e -> new ReplaceOneModel<>(eq("_id", e.getErabiltzailea_id()), e))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> erabiltzaileaCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
