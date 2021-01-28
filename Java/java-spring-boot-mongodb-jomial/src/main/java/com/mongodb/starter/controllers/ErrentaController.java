package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Errenta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;
import com.mongodb.starter.repositories.ErrentaRepository;

/**
 *
 * @author angulo.jorge
 */
@RestController
@RequestMapping("/api")
public class ErrentaController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ErrentaController.class);
    private final ErrentaRepository errentaRepository;

    /**
     *
     * @param errentaRepository
     */
    public ErrentaController(ErrentaRepository errentaRepository) {
        this.errentaRepository = errentaRepository;
    }

    /**
     *
     * @param errenta
     * @return
     */
    @PostMapping("errenta")
    @ResponseStatus(HttpStatus.CREATED)
    public Errenta postErrenta(@RequestBody Errenta errenta) {
        return errentaRepository.save(errenta);
    }

    /**
     *
     * @param errentak
     * @return
     */
    @PostMapping("errentak")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Errenta> postErrenta(@RequestBody List<Errenta> errentak) {
        return errentaRepository.saveAll(errentak);
    }

    /**
     *
     * @return
     */
    @GetMapping("errentak")
    public List<Errenta> getErrentak() {
        return errentaRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("errenta/{id}")
    public ResponseEntity<Errenta> getErrenta(@PathVariable String id) {
        Errenta errenta = errentaRepository.findOne(id);
        if (errenta == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(errenta);
    }

    /**
     *
     * @param ids
     * @return
     */
    @GetMapping("errentak/{ids}")
    public List<Errenta> getErrentak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return errentaRepository.findAll(listIds);
    }

    /**
     *
     * @return
     */
    @GetMapping("errentak/count")
    public Long getCount() {
        return errentaRepository.count();
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("errenta/{id}")
    public Long deleteErrenta(@PathVariable String id) {
        return errentaRepository.delete(id);
    }

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping("errentak/{ids}")
    public Long deleteErrentak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return errentaRepository.delete(listIds);
    }

    /**
     *
     * @return
     */
    @DeleteMapping("errentak")
    public Long deleteErrentak() {
        return errentaRepository.deleteAll();
    }

    /**
     *
     * @param errenta
     * @return
     */
    @PutMapping("errenta")
    public Errenta putErrenta(@RequestBody Errenta errenta) {
        return errentaRepository.update(errenta);
    }

    /**
     *
     * @param errentak
     * @return
     */
    @PutMapping("errentak")
    public Long putErrenta(@RequestBody List<Errenta> errentak) {
        return errentaRepository.update(errentak);
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
