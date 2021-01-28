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
     * @param erabiltzailea
     * @return
     */
    @PostMapping("erabiltzailea")
    @ResponseStatus(HttpStatus.CREATED)
    public Erabiltzailea postErabiltzailea(@RequestBody Erabiltzailea erabiltzailea) {
        return erabiltzaileaRepository.save(erabiltzailea);
    }

    /**
     *
     * @param erabiltzaileak
     * @return
     */
    @PostMapping("erabiltzaileak")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Erabiltzailea> postErabiltzailea(@RequestBody List<Erabiltzailea> erabiltzaileak) {
        return erabiltzaileaRepository.saveAll(erabiltzaileak);
    }

    /**
     *
     * @return
     */
    @GetMapping("erabiltzaileak")
    public List<Erabiltzailea> getErabiltzaileak() {
        return erabiltzaileaRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("erabiltzailea/{id}")
    public ResponseEntity<Erabiltzailea> getErabiltzailea(@PathVariable String id) {
        Erabiltzailea erabiltzailea = erabiltzaileaRepository.findOne(id);
        if (erabiltzailea == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(erabiltzailea);
    }

    /**
     *
     * @param ids
     * @return
     */
    @GetMapping("erabiltzaileak/{ids}")
    public List<Erabiltzailea> getErabiltzaileak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return erabiltzaileaRepository.findAll(listIds);
    }

    /**
     *
     * @return
     */
    @GetMapping("erabiltzaileak/count")
    public Long getCount() {
        return erabiltzaileaRepository.count();
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("erabiltzailea/{id}")
    public Long deleteErabiltzailea(@PathVariable String id) {
        return erabiltzaileaRepository.delete(id);
    }

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping("erabiltzaileak/{ids}")
    public Long deleteErabiltzaileak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return erabiltzaileaRepository.delete(listIds);
    }

    /**
     *
     * @return
     */
    @DeleteMapping("erabiltzaileak")
    public Long deleteErabiltzaileak() {
        return erabiltzaileaRepository.deleteAll();
    }

    /**
     *
     * @param erabiltzailea
     * @return
     */
    @PutMapping("erabiltzailea")
    public Erabiltzailea putErabiltzailea(@RequestBody Erabiltzailea erabiltzailea) {
        return erabiltzaileaRepository.update(erabiltzailea);
    }

    /**
     *
     * @param erabiltzaileak
     * @return
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
