package com.lcwd.user.service.Controllers;

import com.lcwd.user.service.services.UserService;
import com.lcwd.user.service.entities.User; // ✅ Correct import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;
    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
    User SavedUser = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(SavedUser);

    }
    //single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId)
    {
        Optional<User> userOptional = userRepositories.findById(userId);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
//        User user = userService.getUser(userId);
//        return ResponseEntity.ok(user);
    }
    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
