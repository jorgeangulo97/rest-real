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
     * @param hotel
     * @return
     */
    @PostMapping("hotel")
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel postHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     *
     * @param hotels
     * @return
     */
    @PostMapping("hotels")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Hotel> postHotels(@RequestBody List<Hotel> hotels) {
        return hotelRepository.saveAll(hotels);
    }

    /**
     *
     * @return
     */
    @GetMapping("hotels")
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("hotel/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        Hotel hotel = hotelRepository.findOne(id);
        if (hotel == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(hotel);
    }

    /**
     *
     * @param ids
     * @return
     */
    @GetMapping("hotels/{ids}")
    public List<Hotel> getHotels(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return hotelRepository.findAll(listIds);
    }
    
    /**
     *
     * @param kokalekua
     * @return
     */
    @GetMapping("hotels/kokalekua")
    public List<Hotel> getHotelsKokalekua(@RequestParam(value= "kokalekua") String kokalekua) {
        return hotelRepository.findAllbyKokalekua(kokalekua);
    }

    /**
     *
     * @return
     */
    @GetMapping("hotels/count")
    public Long getCount() {
        return hotelRepository.count();
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("hotel/{id}")
    public Long deleteHotel(@PathVariable String id) {
        return hotelRepository.delete(id);
    }

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping("hotels/{ids}")
    public Long deleteHotels(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return hotelRepository.delete(listIds);
    }

    /**
     *
     * @return
     */
    @DeleteMapping("hotels")
    public Long deleteHotels() {
        return hotelRepository.deleteAll();
    }

    /**
     *
     * @param hotel
     * @return
     */
    @PutMapping("hotel")
    public Hotel putHotel(@RequestBody Hotel hotel) {
        return hotelRepository.update(hotel);
    }

    /**
     *
     * @param hotels
     * @return
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
