package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Erabiltzailea;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErabiltzaileaRepository {

    Erabiltzailea save(Erabiltzailea erabiltzailea);

    List<Erabiltzailea> saveAll(List<Erabiltzailea> erabiltzaileak);

    List<Erabiltzailea> findAll();

    List<Erabiltzailea> findAll(List<String> ids);

    Erabiltzailea findOne(String id);

    long count();

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    Erabiltzailea update(Erabiltzailea erabiltzailea);

    long update(List<Erabiltzailea> erabiltzaileak);

}
