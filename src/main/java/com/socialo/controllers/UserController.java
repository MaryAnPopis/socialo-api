package com.socialo.controllers;

import com.socialo.dto.UserDTO;
import com.socialo.exception.ErrorResponse;
import com.socialo.models.User;
import com.socialo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/signup")
    public ResponseEntity<Object> post(@RequestBody User user) {
        return this.service.isPresent(user) ? new ResponseEntity<>(new ErrorResponse("User already exist!", false) ,HttpStatus.OK) : new ResponseEntity<>(this.service.create(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        return this.service.isPresent(user) ? new ResponseEntity<>(this.service.login(user), HttpStatus.OK) : new ResponseEntity<>(new ErrorResponse("The user doesn't exist!", false) ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getById(@PathVariable Long id){
        return  new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

}
