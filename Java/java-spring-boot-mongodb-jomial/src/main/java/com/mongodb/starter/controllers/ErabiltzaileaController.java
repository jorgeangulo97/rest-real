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

@RestController
@RequestMapping("/api")
public class ErabiltzaileaController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ErabiltzaileaController.class);
    private final ErabiltzaileaRepository erabiltzaileaRepository;

    public ErabiltzaileaController(ErabiltzaileaRepository erabiltzaileaRepository) {
        this.erabiltzaileaRepository = erabiltzaileaRepository;
    }

    @PostMapping("erabiltzailea")
    @ResponseStatus(HttpStatus.CREATED)
    public Erabiltzailea postErabiltzailea(@RequestBody Erabiltzailea erabiltzailea) {
        return erabiltzaileaRepository.save(erabiltzailea);
    }

    @PostMapping("erabiltzaileak")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Erabiltzailea> postHotels(@RequestBody List<Erabiltzailea> erabiltzaileak) {
        return erabiltzaileaRepository.saveAll(erabiltzaileak);
    }

    @GetMapping("erabiltzaileak")
    public List<Erabiltzailea> getErabiltzaileak() {
        return erabiltzaileaRepository.findAll();
    }

    @GetMapping("erabiltzailea/{id}")
    public ResponseEntity<Erabiltzailea> getErabiltzailea(@PathVariable String id) {
        Erabiltzailea erabiltzailea = erabiltzaileaRepository.findOne(id);
        if (erabiltzailea == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(erabiltzailea);
    }

    @GetMapping("erabiltzaileak/{ids}")
    public List<Erabiltzailea> getErabiltzaileak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return erabiltzaileaRepository.findAll(listIds);
    }

    @GetMapping("erabiltzaileak/count")
    public Long getCount() {
        return erabiltzaileaRepository.count();
    }

    @DeleteMapping("erabiltzailea/{id}")
    public Long deleteErabiltzailea(@PathVariable String id) {
        return erabiltzaileaRepository.delete(id);
    }

    @DeleteMapping("erabiltzaileak/{ids}")
    public Long deleteErabiltzaileak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return erabiltzaileaRepository.delete(listIds);
    }

    @DeleteMapping("erabiltzaileak")
    public Long deleteErabiltzaileak() {
        return erabiltzaileaRepository.deleteAll();
    }

    @PutMapping("erabiltzailea")
    public Erabiltzailea putErabiltzailea(@RequestBody Erabiltzailea erabiltzailea) {
        return erabiltzaileaRepository.update(erabiltzailea);
    }

    @PutMapping("erabiltzaileak")
    public Long putErabiltzailea(@RequestBody List<Erabiltzailea> erabiltzaileak) {
        return erabiltzaileaRepository.update(erabiltzaileak);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
