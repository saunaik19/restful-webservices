package com.saurabh.example.restful.restfulwebservices.controller;

import com.saurabh.example.restful.restfulwebservices.dto.User;
import com.saurabh.example.restful.restfulwebservices.exceptions.UserNotFoundException;
import com.saurabh.example.restful.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    //retiveAllUsers
    //GET /users
    @GetMapping("/users")
    public List<User> allUsers(){
        return userService.findAll();
    }


    //retriveUser
    //GET /users/{userId}
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> UserByName(@PathVariable("userId") Integer userId){
        User foundUser=userService.findOne(userId);
        return new ResponseEntity<>(foundUser,HttpStatus.OK);
    }

    //Save user
    //POST /users
    //input if user is created
    //output //CREATED & ouput of url
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser=userService.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();
        //return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable("userId") Integer userId){
        User deletedUser=userService.delete(userId);
        if(Objects.isNull(deletedUser))
            throw new UserNotFoundException("UserNotFound to delete");
        return new ResponseEntity(deletedUser,HttpStatus.OK);
    }

}
