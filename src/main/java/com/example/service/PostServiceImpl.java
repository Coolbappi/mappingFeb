package com.example.service;


import com.example.dto.PostDto;
import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private  CommentRepository commentRepository;
    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = maptoEntity(postDto);
        Post saveEntity = postRepository.save(post);
        PostDto postDto1 = mapToDto(saveEntity);
        return postDto1;
    }

    @Override
    public Comment createComment(Comment comment, long postId) {
        Post byId = postRepository.findById(postId).get();
        comment.setPost(byId);
        System.err.println(comment);
        var savedComment = commentRepository.save(comment);
        return savedComment;

    }

    @Override
    @Transactional
    public String removePost(long postId) {
        commentRepository.deleteByPostId(postId);
        postRepository.deleteById(postId);
        return "Post with id " + postId + " has been deleted";
    }

    Post maptoEntity(PostDto dto){
        Post entity = new Post();
//        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        return entity;

    }
    PostDto mapToDto(Post entity){
        PostDto dto = new PostDto();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
