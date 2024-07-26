package com.example.controller;


import com.example.dto.PostDto;

import com.example.service.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1/post")
public class PostController {

    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto dtos = postService.createPost(postDto);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam long postId) {
        String deleteMsg = postService.removePost(postId);
        return new ResponseEntity<>(deleteMsg, HttpStatus.NO_CONTENT);
    }


}
