package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author angulo.jorge
 */
@Repository
public interface HotelRepository {

    /**
     *
     * @param hotel
     * @return
     */
    Hotel save(Hotel hotel);

    /**
     *
     * @param hotels
     * @return
     */
    List<Hotel> saveAll(List<Hotel> hotels);

    /**
     *
     * @return
     */
    List<Hotel> findAll();

    /**
     *
     * @param ids
     * @return
     */
    List<Hotel> findAll(List<String> ids);

    /**
     *
     * @param kokalekua
     * @return
     */
    List<Hotel> findAllbyKokalekua(String kokalekua);
    
    /**
     *
     * @param id
     * @return
     */
    Hotel findOne(String id);

    /**
     *
     * @return
     */
    long count();

    /**
     *
     * @param id
     * @return
     */
    long delete(String id);

    /**
     *
     * @param ids
     * @return
     */
    long delete(List<String> ids);

    /**
     *
     * @return
     */
    long deleteAll();

    /**
     *
     * @param hotel
     * @return
     */
    Hotel update(Hotel hotel);

    /**
     *
     * @param hotels
     * @return
     */
    long update(List<Hotel> hotels);

}
