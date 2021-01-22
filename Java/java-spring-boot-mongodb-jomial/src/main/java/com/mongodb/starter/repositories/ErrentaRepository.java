package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Errenta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrentaRepository {

    Errenta save(Errenta errenta);

    List<Errenta> saveAll(List<Errenta> errentak);

    List<Errenta> findAll();

    List<Errenta> findAll(List<String> ids);

    Errenta findOne(String id);

    long count();

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    Errenta update(Errenta errenta);

    long update(List<Errenta> errentak);

}
