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
import com.mongodb.starter.models.Hotel;
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
public class MongoDBHotelRepository implements HotelRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Hotel> hotelCollection;

    @PostConstruct
    void init() {
        hotelCollection = client.getDatabase("jomial").getCollection("hotel", Hotel.class);
    }

    /**
     *
     * @param hotel
     * @return
     */
    @Override
    public Hotel save(Hotel hotel) {
        hotel.setHotel_id(new ObjectId());
        hotelCollection.insertOne(hotel);
        return hotel;
    }

    /**
     *
     * @param hotel
     * @return
     */
    @Override
    public List<Hotel> saveAll(List<Hotel> hotel) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> {
                hotel.forEach(h -> h.setHotel_id(new ObjectId()));
                hotelCollection.insertMany(clientSession, hotel);
                return hotel;
            }, txnOptions);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Hotel> findAll() {
        return hotelCollection.find().into(new ArrayList<>());
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public List<Hotel> findAll(List<String> ids) {
        return hotelCollection.find(in("_id", mapToObjectIds(ids))).into(new ArrayList<>());
    }

    /**
     *
     * @param kokalekuak
     * @return
     */
    @Override
    public List<Hotel> findAllbyKokalekua(@RequestParam(value= "kokalekua") String kokalekuak) {
        return hotelCollection.find(in("kokalekua", kokalekuak)).into(new ArrayList<>());
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Hotel findOne(String id) {
        return hotelCollection.find(eq("_id", new ObjectId(id))).first();
    }

    /**
     *
     * @return
     */
    @Override
    public long count() {
        return hotelCollection.countDocuments();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public long delete(String id) {
        return hotelCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public long delete(List<String> ids) {
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> hotelCollection.deleteMany(clientSession, in("_id", mapToObjectIds(ids))).getDeletedCount(),
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
            return clientSession.withTransaction(() -> hotelCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    /**
     *
     * @param hotel
     * @return
     */
    @Override
    public Hotel update(Hotel hotel) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return hotelCollection.findOneAndReplace(eq("_id", hotel.getHotel_id()), hotel, options);
    }

    /**
     *
     * @param hotels
     * @return
     */
    @Override
    public long update(List<Hotel> hotels) {
        List<WriteModel<Hotel>> writes = hotels.stream()
                                                 .map(h -> new ReplaceOneModel<>(eq("_id", h.getHotel_id()), h))
                                                 .collect(Collectors.toList());
        try (ClientSession clientSession = client.startSession()) {
            return clientSession.withTransaction(() -> hotelCollection.bulkWrite(clientSession, writes).getModifiedCount(), txnOptions);
        }
    }

    private List<ObjectId> mapToObjectIds(List<String> ids) {
        return ids.stream().map(ObjectId::new).collect(Collectors.toList());
    }
}
