package com.example.demo.services;

import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.exceptions.InvalidPostException;
import com.example.demo.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;



    public Post createPost(String content, String email) throws InvalidPostException {
        if (content == null || content.trim().isEmpty()) {
            throw new InvalidPostException("Post content cannot be empty.");
        }

        // Correctly handle Optional<User>
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Post newPost = new Post();
        newPost.setContent(content);
        newPost.setUser(user); // Use the retrieved User object

        try {
            return postRepository.save(newPost);
        } catch (DataAccessException e) {
            // Consider a more specific exception type if appropriate
            throw new RuntimeException("Error saving post.", e);
        }
    }


}
