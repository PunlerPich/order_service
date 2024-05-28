package com.example.demo.dtos;

import lombok.Data;

@Data
public class CommentRequest {
    private Long postId;
    private String content;
}
