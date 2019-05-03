package com.socialo.controllers;

import com.socialo.dto.CommentsDTO;
import com.socialo.dto.LikeDTO;
import com.socialo.dto.PostDTO;
import com.socialo.models.Comments;
import com.socialo.models.Like;
import com.socialo.models.Post;
import com.socialo.models.UploadFile;
import com.socialo.services.implementations.AmazonClient;
import com.socialo.services.CommentsService;
import com.socialo.services.LikeService;
import com.socialo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
@CrossOrigin
public class PostController {

    @Autowired
    PostService service;

    @Autowired
    LikeService likeService;

    @Autowired
    CommentsService commentsService;

    @Autowired
    AmazonClient amazonService;

    @PostMapping("/")
    public ResponseEntity<PostDTO> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(this.service.create(post), HttpStatus.OK);
    }

    @PostMapping("/like")
    public ResponseEntity<LikeDTO> createLike(@RequestBody Like like) {
        return new ResponseEntity<>(this.likeService.create(like), HttpStatus.CREATED);
    }

    @DeleteMapping("/like/{id}")
    public ResponseEntity unlikePost(@PathVariable Long id){
        likeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getAll(@PathVariable Long id) {
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get-by-date")
    public ResponseEntity<List<PostDTO>> getAllByDate() {
        return new ResponseEntity<>(this.service.getAllOrderedByDate(), HttpStatus.OK);
    }

    @GetMapping("/my-posts/{userId}")
    public ResponseEntity<List<PostDTO>> getByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(this.service.getPostsByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentsDTO> createComment(@RequestBody Comments comment){
        return new ResponseEntity<>(this.commentsService.create(comment), HttpStatus.OK);
    }

    @PostMapping("/upload-file")
    public UploadFile uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonService.uploadFile(file);
    }

}
