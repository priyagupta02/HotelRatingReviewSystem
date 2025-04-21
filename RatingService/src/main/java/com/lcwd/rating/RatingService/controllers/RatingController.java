package com.lcwd.rating.RatingService.controllers;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repository.RatingRepository;
import com.lcwd.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ratings")
public class RatingController
{
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

    }
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        List<Rating> ratings = ratingService.getRatings();
        System.out.println("Returned Ratings: " + ratings);
        return ResponseEntity.ok(ratingService.getRatings());

    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));

    }
    @GetMapping ("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
    return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));

}


}

