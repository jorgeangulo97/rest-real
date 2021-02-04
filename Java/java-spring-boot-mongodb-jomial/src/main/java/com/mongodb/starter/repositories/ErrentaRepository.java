package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Errenta;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author angulo.jorge
 */
@Repository
public interface ErrentaRepository {

    /**
     *
     * @param errenta
     * @return
     */
    Errenta save(Errenta errenta);

    /**
     *
     * @param errentak
     * @return
     */
    List<Errenta> saveAll(List<Errenta> errentak);

    /**
     *
     * @return
     */
    List<Errenta> findAll();

    /**
     *
     * @param ids
     * @return
     */
    List<Errenta> findAll(List<String> ids);
    
    /**
     *
     * @param emaila
     * @return
     */

    List<Errenta> findAllEmail(String emaila);
    
    /**
     *
     * @param id
     * @return
     */
    Errenta findOne(String id);

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
     * @param errenta
     * @return
     */
    Errenta update(Errenta errenta);

    /**
     *
     * @param errentak
     * @return
     */
    long update(List<Errenta> errentak);

}
