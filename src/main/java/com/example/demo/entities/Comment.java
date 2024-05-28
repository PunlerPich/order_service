package com.example.demo.entities;



import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Many-to-One Relationship
    @ManyToOne(fetch = FetchType.LAZY) // Use LAZY fetching for performance
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY) // Use LAZY fetching for performance
    @JoinColumn(name = "postId", nullable = false)
    private Post post;
}