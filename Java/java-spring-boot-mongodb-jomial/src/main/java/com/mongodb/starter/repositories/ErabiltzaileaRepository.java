package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Erabiltzailea;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author angulo.jorge
 */
@Repository
public interface ErabiltzaileaRepository {

    /**
     *
     * @param erabiltzailea
     * @return
     */
    Erabiltzailea save(Erabiltzailea erabiltzailea);

    /**
     *
     * @param erabiltzaileak
     * @return
     */
    List<Erabiltzailea> saveAll(List<Erabiltzailea> erabiltzaileak);

    /**
     *
     * @return
     */
    List<Erabiltzailea> findAll();

    /**
     *
     * @param ids
     * @return
     */
    List<Erabiltzailea> findAll(List<String> ids);

    /**
     *
     * @param id
     * @return
     */
    Erabiltzailea findOne(String id);

    Erabiltzailea findOneUser(String izena, String pasahitza);
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
     * @param erabiltzailea
     * @return
     */
    Erabiltzailea update(Erabiltzailea erabiltzailea);

    /**
     *
     * @param erabiltzaileak
     * @return
     */
    long update(List<Erabiltzailea> erabiltzaileak);

}
