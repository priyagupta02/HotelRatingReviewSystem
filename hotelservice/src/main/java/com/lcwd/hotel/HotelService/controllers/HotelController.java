package com.lcwd.hotel.HotelService.controllers;

import com.lcwd.hotel.HotelService.entites.Hotel;
import com.lcwd.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel created = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

    }
    @GetMapping ("/{hotelId}")
    public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());

    }
    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable String hotelId) {
        hotelService.delete(hotelId);
        return ResponseEntity.ok("Hotel with ID " + hotelId + " deleted successfully.");
    }

}
