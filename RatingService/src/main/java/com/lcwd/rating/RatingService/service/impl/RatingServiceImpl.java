package com.lcwd.rating.RatingService.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repository.RatingRepository;
import com.lcwd.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RatingServiceImpl extends RatingService
{
    private static final Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);
    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        Rating saved = repository.save(rating);
        logger.info("Saved Rating: " + saved);
        return saved;//repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        List<Rating> ratings = repository.findAll();
        logger.info("Fetched Ratings: " + ratings);
        return ratings;//repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> ratings = repository.findByUserId(userId);
        logger.info("Fetched Ratings for userId {}: {}", userId, ratings);
        return ratings;
        //return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
       // return repository.findByHotelId(hotelId);
        List<Rating> ratings = repository.findByHotelId(hotelId);
        logger.info("Fetched Ratings for hotelId {}: {}", hotelId, ratings);  // Logging ratings fetched by hotelId
        return ratings;
    }
}
