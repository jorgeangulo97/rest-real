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
     * @param errenta Errenta klasearen instantzia da
     * @return sartutako errenta gorde
     */
    @PostMapping("errenta")
    @ResponseStatus(HttpStatus.CREATED)
    public Errenta postErrenta(@RequestBody Errenta errenta) {
        return errentaRepository.save(errenta);
    }

    /**
     *
     * @param errentak Errenta klasearen hainbat instantzia dira
     * @return errenta bat baino gehiago gorde
     */
    @PostMapping("errentak")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Errenta> postErrentak(@RequestBody List<Errenta> errentak) {
        return errentaRepository.saveAll(errentak);
    }

    /**
     *
     * @return errenta guztiak bilatu
     */
    @GetMapping("errentak")
    public List<Errenta> getErrentak() {
        return errentaRepository.findAll();
    }

    /**
     *
     * @param id Errenta instantziaren id-a
     * @return sartutako id-a duen lehengo errenta bilatu
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
     * @param emaila Errenta instantziaren emaila
     * @return sartutako emaila duen errenta guztiak bilatzen ditu
     */
    @GetMapping("errenta/emaila")
    public List<Errenta> getErrentaEmail(@RequestParam(value="emaila") String emaila) {
        return errentaRepository.findAllEmail(emaila);
    }

    /**
     *
     * @param ids hainbat errentaren id-ak
     * @return sartutako id-en errentak bilatu
     */
    @GetMapping("errentak/{ids}")
    public List<Errenta> getErrentak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return errentaRepository.findAll(listIds);
    }

    /**
     *
     * @return zenbat errenta daude (zenbakizko balioa)
     */
    @GetMapping("errentak/count")
    public Long getCount() {
        return errentaRepository.count();
    }

    /**
     *
     * @param id errenta baten id-a
     * @return sartutako id-aren errenta ezabatu
     */
    @DeleteMapping("errenta/{id}")
    public Long deleteErrenta(@PathVariable String id) {
        return errentaRepository.delete(id);
    }

    /**
     *
     * @param ids hainbat errentaren id-ak
     * @return sartutako id-en enrrentak borratu
     */
    @DeleteMapping("errentak/{ids}")
    public Long deleteErrentak(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return errentaRepository.delete(listIds);
    }

    /**
     *
     * @return errenta guztiak borratu
     */
    @DeleteMapping("errentak")
    public Long deleteErrentak() {
        return errentaRepository.deleteAll();
    }

    /**
     *
     * @param errenta Errenta klasearen instantzia bat
     * @return sartutako errenta eguneratu
     */
    @PutMapping("errenta")
    public Errenta putErrenta(@RequestBody Errenta errenta) {
        return errentaRepository.update(errenta);
    }

    /**
     *
     * @param errentak Errenta klasearen hainbat instantzia
     * @return sartutako errentak eguneratu
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
