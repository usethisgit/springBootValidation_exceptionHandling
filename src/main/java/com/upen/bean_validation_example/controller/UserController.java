package com.upen.bean_validation_example.controller;

import com.upen.bean_validation_example.dto.UserDto;
import com.upen.bean_validation_example.exception.UserNotFoundException;
import com.upen.bean_validation_example.model.User;
import com.upen.bean_validation_example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto){
        return new ResponseEntity<>(service.createUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping("/user{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUserById(userId));
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }
}
