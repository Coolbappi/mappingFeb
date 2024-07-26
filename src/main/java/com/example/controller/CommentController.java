package com.example.controller;

import com.example.entity.Comment;
import com.example.service.CommentService;
import com.example.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1/comment")
public class CommentController {
    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment, @RequestParam long postId) {
        Comment comment1 = postService.createComment(comment, postId);
        return new ResponseEntity<>(comment1, HttpStatus.OK);
    }

}
