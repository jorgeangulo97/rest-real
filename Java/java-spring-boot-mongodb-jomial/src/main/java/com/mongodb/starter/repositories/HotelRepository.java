package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository {

    Hotel save(Hotel hotel);

    List<Hotel> saveAll(List<Hotel> hotels);

    List<Hotel> findAll();

    List<Hotel> findAll(List<String> ids);

    Hotel findOne(String id);

    long count();

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    Hotel update(Hotel hotel);

    long update(List<Hotel> hotels);

}
