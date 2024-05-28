package com.example.demo.services;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.exceptions.InvalidPostException;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CommentService {


    private CommentRepository commentRepository;


    private PostRepository postRepository; // For fetching post by ID


    private UserService userService; // Optional, if needed

    public Comment createComment(Long postId, String content) throws InvalidPostException {
        User currentUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found")); // Get authenticated user
        Post post = postRepository.findById(postId).orElseThrow(() -> new InvalidPostException("Post not found with ID: " + postId));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(currentUser);
        comment.setPost(post);

        return commentRepository.save(comment);
    }
}
