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
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param errenta Errenta klasearen instantzia
     * @return gordetzen den errenta
     */
    @Override
    public Errenta save(Errenta errenta) {
        errenta.setId(new ObjectId());
        errentaCollection.insertOne(errenta);
        return errenta;
    }

    /**
     *
     * @param errenta Errenta instantziaren lista
     * @return gordetzen diren errentak
     */
    @Override
    public List<Errenta> saveAll(List<Errenta> errenta) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                errenta.forEach(e -> e.setId(new ObjectId()));
                errentaCollection.insertMany(clientSession, errenta);
                return errenta;
            }, txnOptions);
        }
    }

    /**
     *
     * @return errenta guztiak bilatu
     */
    @Override
    public List<Errenta> findAll() {
        return errentaCollection.find().into(new ArrayList<>());
    }

    /**
     *
     * @param ids errenten id-en String lista bat
     * @return sartutako id-en errentak bilatu
     */
    @Override
    public List<Errenta> findAll(List<String> ids) {
        return errentaCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    /**
     *
     * @param emaila errentaren emaila
     * @return sartutako emailaren araberaz objektu guztiak bueltatzen ditu.
     */
    @Override
    public List<Errenta> findAllEmail(@RequestParam(value="emaila") String emaila) {
        return errentaCollection.find(eq("emaila", emaila)).into(new ArrayList<>());
    }
    
    /**
     *
     * @param id errentaren id-a
     * @return sartutako id-aren errenta bilatu
     */
    @Override
    public Errenta findOne(String id) {
        return errentaCollection.find(eq("_id", new ObjectId(id))).first();
    }
    
    /**
     *
     * @return zenbat errenta daude (zenbakizko balioa)
     */
    @Override
    public long count() {
        return errentaCollection.countDocuments();
    }

    /**
     *
     * @param id errenta baten id-a
     * @return sartutako id-aren errenta ezabatu
     */
    @Override
    public long delete(String id) {
        return errentaCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    /**
     *
     * @param ids errenten id-en String lista bat
     * @return sartutako id-en errentak ezabatu
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
     * @return errenta guztiak ezabatu
     */
    @Override
    public long deleteAll() {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> errentaCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    /**
     *
     * @param errenta Errenta klasearen instantzia
     * @return sartutako errenta eguneratu
     */
    @Override
    public Errenta update(Errenta errenta) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return errentaCollection.findOneAndReplace(eq("_id", errenta.getId()), errenta, options);
    }

    /**
     *
     * @param errentak Errenta klasearen instantzien lista
     * @return
     */
    @Override
    public long update(List<Errenta> errentak) {
        List<WriteModel<Errenta>> writes = errentak.stream()
                                                 .map(e -> new ReplaceOneModel<>(eq("_id", e.getId()), e))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> errentaCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
