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
import com.mongodb.starter.models.Errenta;
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

/**
 *
 * @author angulo.jorge
 */
@Repository
public class MongoDBErrentaRepository implements ErrentaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Errenta> errentaCollection;

    @PostConstruct
    void init() {
        errentaCollection = client.getDatabase("jomial").getCollection("errenta", Errenta.class);
    }

    /**
     *
     * @param errenta
     * @return
     */
    @Override
    public Errenta save(Errenta errenta) {
        errenta.setErrenta_id(new ObjectId());
        errentaCollection.insertOne(errenta);
        return errenta;
    }

    /**
     *
     * @param errenta
     * @return
     */
    @Override
    public List<Errenta> saveAll(List<Errenta> errenta) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                errenta.forEach(e -> e.setErrenta_id(new ObjectId()));
                errentaCollection.insertMany(clientSession, errenta);
                return errenta;
            }, txnOptions);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Errenta> findAll() {
        return errentaCollection.find().into(new ArrayList<>());
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public List<Errenta> findAll(List<String> ids) {
        return errentaCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Errenta findOne(String id) {
        return errentaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    /**
     *
     * @return
     */
    @Override
    public long count() {
        return errentaCollection.countDocuments();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public long delete(String id) {
        return errentaCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> errentaCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(),
                    txnOptions);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> errentaCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    /**
     *
     * @param errenta
     * @return
     */
    @Override
    public Errenta update(Errenta errenta) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return errentaCollection.findOneAndReplace(eq("_id", errenta.getErrenta_id()), errenta, options);
    }

    /**
     *
     * @param errentak
     * @return
     */
    @Override
    public long update(List<Errenta> errentak) {
        List<WriteModel<Errenta>> writes = errentak.stream()
                                                 .map(e -> new ReplaceOneModel<>(eq("_id", e.getErrenta_id()), e))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> errentaCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
