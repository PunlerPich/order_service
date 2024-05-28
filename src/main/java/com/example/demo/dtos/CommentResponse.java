package com.example.demo.dtos;

import com.example.demo.entities.Comment;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CommentResponse {
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private Long postId;
    private String username;

    public CommentResponse(Comment comment){
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.postId = comment.getPost().getPostId();
        this.username = comment.getUser().getFullName();
    }
}
