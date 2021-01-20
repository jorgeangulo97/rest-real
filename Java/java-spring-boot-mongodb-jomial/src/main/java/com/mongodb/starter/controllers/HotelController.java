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

@RestController
@RequestMapping("/api")
public class HotelController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HotelController.class);
    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostMapping("hotel")
    @ResponseStatus(HttpStatus.CREATED)
    public Hotel postHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @PostMapping("hotels")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Hotel> postHotels(@RequestBody List<Hotel> hotels) {
        return hotelRepository.saveAll(hotels);
    }

    @GetMapping("hotels")
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("hotel/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
        Hotel hotel = hotelRepository.findOne(id);
        if (hotel == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("hotels/{ids}")
    public List<Hotel> getHotels(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return hotelRepository.findAll(listIds);
    }

    @GetMapping("hotels/count")
    public Long getCount() {
        return hotelRepository.count();
    }

    @DeleteMapping("hotel/{id}")
    public Long deleteHotel(@PathVariable String id) {
        return hotelRepository.delete(id);
    }

    @DeleteMapping("hotels/{ids}")
    public Long deleteHotels(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return hotelRepository.delete(listIds);
    }

    @DeleteMapping("hotels")
    public Long deleteHotels() {
        return hotelRepository.deleteAll();
    }

    @PutMapping("hotel")
    public Hotel putHotel(@RequestBody Hotel hotel) {
        return hotelRepository.update(hotel);
    }

    @PutMapping("hotels")
    public Long putHotel(@RequestBody List<Hotel> hotels) {
        return hotelRepository.update(hotels);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
