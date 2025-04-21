package com.lcwd.rating.RatingService.service;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;  // Private access for this field is correct

    // Method to create a rating
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Method to get all ratings
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    // Method to get ratings by userId
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    // Method to get ratings by hotelId
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
