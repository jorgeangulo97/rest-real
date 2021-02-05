package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Erabiltzailea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;
import com.mongodb.starter.repositories.ErabiltzaileaRepository;

/**
 *
 * @author angulo.jorge
 */
@RestController
@RequestMapping("/api")
public class ErabiltzaileaController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ErabiltzaileaController.class);
    private final ErabiltzaileaRepository erabiltzaileaRepository;

    /**
     *
     * @param erabiltzaileaRepository
     */
    public ErabiltzaileaController(ErabiltzaileaRepository erabiltzaileaRepository) {
        this.erabiltzaileaRepository = erabiltzaileaRepository;
    }

    /**
     *
     * @param erabiltzailea Erabiltzailea klasearen instantzia
     * @return sartutako erabiltzailea gorde
     */
    @PostMapping("erabiltzailea")
    @ResponseStatus(HttpStatus.CREATED)
    public Erabiltzailea postErabiltzailea(@RequestBody Erabiltzailea erabiltzailea) {
        return erabiltzaileaRepository.save(erabiltzailea);
    }

    /**
     *
     * @param erabiltzaileak Erabiltzailea klasearen hainbat instantzia
     * @return sartutako erabiltzaileak gorde
     */
    @PostMapping("erabiltzaileak")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Erabiltzailea> postErabiltzaileak(@RequestBody List<Erabiltzailea> erabiltzaileak) {
        return erabiltzaileaRepository.saveAll(erabiltzaileak);
    }

    /**
     *
     * @return rabiltzaile guztiak bilatu
     */
    @GetMapping("erabiltzaileak")
    public List<Erabiltzailea> getErabiltzaileak() {
        return erabiltzaileaRepository.findAll();
    }

    /**
     *
     * @param id Erabiltzailea instantziaren id-a
     * @return sartutako id-a duen lehengo erabiltzailea bilatu
     */
    @GetMapping("erabiltzailea/{id}")
    public ResponseEntity<Erabiltzailea> getErabiltzailea(@PathVariable String id) {
        Erabiltzailea erabiltzailea = erabiltzaileaRepository.findOne(id);
        if (erabiltzailea == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(erabiltzailea);
    }
    
    @GetMapping("erabiltzailea/erabiltzailea/pasahitza")
    public ResponseEntity<Erabiltzailea> getErabiltzaileaUser(@RequestParam(value= "erabiltzailea") String erabiltzailea, @RequestParam(value= "pasahitza") String pasahitza) {
        Erabiltzailea erabiltzaile = erabiltzaileaRepository.findOneUser(erabiltzailea, pasahitza);
        if (erabiltzaile == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(erabiltzaile);
    }

    /**
     *
     * @param ids hainbat erabiltzaileen id-ak
     * @return sartutako id-en erabiltzaileak bilatu
     */
    @GetMapping("erabiltzaileak/{ids}")
    public List<Erabiltzailea> getErabiltzaileak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return erabiltzaileaRepository.findAll(listIds);
    }

    /**
     *
     * @return zenbat erabiltzaile daude (zenbakizko balioa)
     */
    @GetMapping("erabiltzaileak/count")
    public Long getCount() {
        return erabiltzaileaRepository.count();
    }

    /**
     *
     * @param id erabiltzaile baten id-a
     * @return sartutako id-aren erabiltzailea ezabatu
     */
    @DeleteMapping("erabiltzailea/{id}")
    public Long deleteErabiltzailea(@PathVariable String id) {
        return erabiltzaileaRepository.delete(id);
    }

    /**
     *
     * @param ids hainbat erabiltzaileen id-ak
     * @return sartutako id-en erabiltzaileak borratu
     */
    @DeleteMapping("erabiltzaileak/{ids}")
    public Long deleteErabiltzaileak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return erabiltzaileaRepository.delete(listIds);
    }

    /**
     *
     * @return erabiltzaile guztiak borratu
     */
    @DeleteMapping("erabiltzaileak")
    public Long deleteErabiltzaileak() {
        return erabiltzaileaRepository.deleteAll();
    }

    /**
     *
     * @param erabiltzailea Erabiltzailea klasearen instantzia bat
     * @return sartutako erabiltzailea eguneratu
     */
    @PutMapping("erabiltzailea")
    public Erabiltzailea putErabiltzailea(@RequestBody Erabiltzailea erabiltzailea) {
        return erabiltzaileaRepository.update(erabiltzailea);
    }

    /**
     *
     * @param erabiltzaileak Erabiltzailea klasearen hainbat instantzia
     * @return sartutako erabiltzailea eguneratu
     */
    @PutMapping("erabiltzaileak")
    public Long putErabiltzailea(@RequestBody List<Erabiltzailea> erabiltzaileak) {
        return erabiltzaileaRepository.update(erabiltzaileak);
    }

    /**
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
