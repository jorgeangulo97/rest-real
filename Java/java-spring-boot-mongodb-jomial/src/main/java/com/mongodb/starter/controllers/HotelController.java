package com.mongodb.starter.controllers;

import com.mongodb.starter.models.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;
import com.mongodb.starter.repositories.HotelRepository;

/**
 *
 * @author angulo.jorge
 */
@RestController
@RequestMapping("/api")
public class HotelController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HotelController.class);
    private final HotelRepository hotelRepository;

    /**
     *
     * @param hotelRepository
     */
    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     *
     * @param hotel Hotel klasearen instantzia da
     * @return sartutako hotela gorde
     */
    @PostMapping("hotel")
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel postHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     *
     * @param hotels Hotel klasearen hainbat instantzia dira
     * @return hotel bat baino gehiago gorde
     */
    @PostMapping("hotels")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Hotel> postHotels(@RequestBody List<Hotel> hotels) {
        return hotelRepository.saveAll(hotels);
    }

    /**
     *
     * @return hotel guztiak bilatu
     */
    @GetMapping("hotels")
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    /**
     *
     * @param id hotel instantziaren id-a
     * @return sartutako id-a duen lehengo hotela bilatu
     */
    @GetMapping("hotel/{id}")
    public Hotel getHotel(@PathVariable String id) {
        Hotel hotel = hotelRepository.findOne(id);
        return hotel;
    }

    /**
     *
     * @param ids hainbat hotelen id-ak
     * @return sartutako id-en hotelak bilatu
     */
    @GetMapping("hotels/{ids}")
    public List<Hotel> getHotels(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return hotelRepository.findAll(listIds);
    }
    
    /**
     *
     * @param kokalekua Hotel instantziaren kokalekua
     * @return sartutako kokalekuko hotel guztiak bilatu
     */
    @GetMapping("hotels/kokalekua")
    public List<Hotel> getHotelsKokalekua(@RequestParam(value= "kokalekua") String kokalekua) {
        return hotelRepository.findAllbyKokalekua(kokalekua);
    }

    /**
     *
     * @return zenbat hotel daude (zenbakizko balioa)
     */
    @GetMapping("hotels/count")
    public Long getCount() {
        return hotelRepository.count();
    }

    /**
     *
     * @param id hotel baten id-a
     * @return hotel id-aren errenta ezabatu
     */
    @DeleteMapping("hotel/{id}")
    public Long deleteHotel(@PathVariable String id) {
        return hotelRepository.delete(id);
    }

    /**
     *
     * @param ids hainbat hotelen id-ak
     * @return sartutako id-en hotelak borratu
     */
    @DeleteMapping("hotels/{ids}")
    public Long deleteHotels(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return hotelRepository.delete(listIds);
    }

    /**
     *
     * @return hotel guztiak borratu
     */
    @DeleteMapping("hotels")
    public Long deleteHotels() {
        return hotelRepository.deleteAll();
    }

    /**
     *
     * @param hotel Hotel klasearen instantzia bat 
     * @return sartutako hotela eguneratu
     */
    @PutMapping("hotel")
    public Hotel putHotel(@RequestBody Hotel hotel) {
        return hotelRepository.update(hotel);
    }

    /**
     *
     * @param hotels Hotel klasearen hainbat instantzia
     * @return sartutako errentak eguneratu
     */
    @PutMapping("hotels")
    public Long putHotel(@RequestBody List<Hotel> hotels) {
        return hotelRepository.update(hotels);
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
