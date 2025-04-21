package com.lcwd.user.service.services.impl;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepositories;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        // Generate unique user ID
        user.setUserId(UUID.randomUUID().toString());
        return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }

    @Override
    public User getUser(String userId) {
        // Get user from DB
        User user = userRepositories.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given ID not found: " + userId));
        logger.info("User found: {}", user);

        // Fetch ratings of the user from Rating Service
        Rating[] ratingsArray = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/users/" + userId,
                Rating[].class
        );

        logger.info("Ratings for user {}: {}", userId, Arrays.toString(ratingsArray));

        // Set ratings in the user object
        user.setRatings(Arrays.asList(ratingsArray));

        return user;
    }
}