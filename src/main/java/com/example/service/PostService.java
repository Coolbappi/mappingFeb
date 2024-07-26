package com.example.service;

import com.example.dto.PostDto;
import com.example.entity.Comment;
import com.example.entity.Post;

public interface PostService {
    PostDto createPost(PostDto postDto);


    Comment createComment(Comment comment, long postId);

    String removePost(long postId);
}
