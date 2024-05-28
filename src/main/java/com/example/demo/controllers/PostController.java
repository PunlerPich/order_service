package com.example.demo.controllers;

import com.example.demo.dtos.PostRequest;
import com.example.demo.dtos.PostResponse;
import com.example.demo.entities.Post;
import com.example.demo.exceptions.InvalidPostException;
import com.example.demo.repositories.PostRepository;
import com.example.demo.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request, Authentication authentication) throws InvalidPostException {
        String content = request.getContent(); // Now you can get the content using the getter
        String username = authentication.getName();

        Post createdPost = postService.createPost(content, username);
        PostResponse response = new PostResponse(createdPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}