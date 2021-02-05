package com.mongodb.starter.repositories;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author angulo.jorge
 */
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

    /**
     *
     * @param erabiltzailea Erabiltzailea klasearen instantzia
     * @return gordetzen den erabiltzailea 
     */
    @Override
    public Erabiltzailea save(Erabiltzailea erabiltzailea) {
        erabiltzailea.setId(new ObjectId());
        erabiltzaileaCollection.insertOne(erabiltzailea);
        return erabiltzailea;
    }

    /**
     *
     * @param erabiltzailea Erabiltzailea klasearen instantziaren lista 
     * @return gordetzen diren erabiltzaileak
     */
    @Override
    public List<Erabiltzailea> saveAll(List<Erabiltzailea> erabiltzailea) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                erabiltzailea.forEach(e -> e.setId(new ObjectId()));
                erabiltzaileaCollection.insertMany(clientSession, erabiltzailea);
                return erabiltzailea;
            }, txnOptions);
        }
    }

    /**
     *
     * @return erabiltzaile guztiak bilatu
     */
    @Override
    public List<Erabiltzailea> findAll() {
        return erabiltzaileaCollection.find().into(new ArrayList<>());
    }

    /**
     *
     * @param ids erabiltzaileen id-en String lista bat
     * @return sartutako id-en erabiltzaileak bilatu
     */
    @Override
    public List<Erabiltzailea> findAll(List<String> ids) {
        return erabiltzaileaCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    /**
     *
     * @param id erabiltzailearen id-a
     * @return sartutako id-aren erabiltzailea bilatu
     */
    @Override
    public Erabiltzailea findOne(String id) {
        return erabiltzaileaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Erabiltzailea findOneUser(@RequestParam String erabiltzailea, @RequestParam String pasahitza) {
        return erabiltzaileaCollection.find(and(eq("erabiltzailea", erabiltzailea), eq("pasahitza", pasahitza))).first(); 
    }
    /**
     *
     * @return zenbat erabiltzaile daude (zenbakizko balioa)
     */
    @Override
    public long count() {
        return erabiltzaileaCollection.countDocuments();
    }

    /**
     *
     * @param id erabiltzaile baten id-a
     * @return sartutako id-aren erabiltzailea ezabatu
     */
    @Override
    public long delete(String id) {
        return erabiltzaileaCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    /**
     *
     * @param ids erabiltzaileen id-en String lista bat
     * @return sartutako id-en erabiltzaileak ezabatu
     */
    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> erabiltzaileaCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(),
                    txnOptions);
        }
    }

    /**
     *
     * @return erabiltzaile guztiak ezabatu
     */
    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> erabiltzaileaCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    /**
     *
     * @param erabiltzailea Erabiltzailea klasearen instantzia
     * @return sartutako erabiltzailea eguneratu
     */
    @Override
    public Erabiltzailea update(Erabiltzailea erabiltzailea) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return erabiltzaileaCollection.findOneAndReplace(eq("_id", erabiltzailea.getId()), erabiltzailea, options);
    }

    /**
     *
     * @param erabiltzaileak Erabiltzailea klasearen instantzien lista
     * @return 
     */
    @Override
    public long update(List<Erabiltzailea> erabiltzaileak) {
        List<WriteModel<Erabiltzailea>> writes = erabiltzaileak.stream()
                                                 .map(e -> new ReplaceOneModel<>(eq("_id", e.getId()), e))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> erabiltzaileaCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
