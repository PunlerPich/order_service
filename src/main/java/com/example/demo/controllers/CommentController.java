package com.example.demo.controllers;

import com.example.demo.dtos.CommentRequest;
import com.example.demo.dtos.CommentResponse;
import com.example.demo.entities.Comment;

import com.example.demo.exceptions.InvalidPostException;
import com.example.demo.services.CommentService;
import com.example.demo.services.PostService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;



        @PostMapping
        public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest request) throws InvalidPostException {
            Comment comment = commentService.createComment(request.getPostId(), request.getContent());
            return ResponseEntity.ok(new CommentResponse(comment));
        }

}

