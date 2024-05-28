package com.example.demo.dtos;

import com.example.demo.entities.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {

        private Long postId;
        private String content;
        private LocalDateTime createdAt;
        private String username;
        public PostResponse(Post post) {
                this.postId = post.getPostId();
                this.content = post.getContent();
                this.createdAt = post.getCreatedAt();
                this.username = post.getUser().getEmail();
        }
}
