package com.socialo.controllers;

import com.socialo.exception.ErrorResponse;
import com.socialo.models.Tag;
import com.socialo.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tag")
@CrossOrigin
public class TagController {


    @Autowired
    TagsService service;

    @PostMapping("/")
    public ResponseEntity<Tag> login(@RequestBody Tag tag) {
        return this.service.isPresent(tag) ? new ResponseEntity(new ErrorResponse("The tag already exists!", false),HttpStatus.BAD_REQUEST) : new ResponseEntity<>(this.service.create(tag), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

}
