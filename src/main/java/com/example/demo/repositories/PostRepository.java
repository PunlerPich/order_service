package com.example.demo.repositories;

import com.example.demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findByPostId(Long postId);
}
