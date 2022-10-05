package com.backend.demoHabr.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

    List<Posts> findByTitleContaining(String subtitle);

    @Query("SELECT p FROM posts p WHERE p.title = ?1")
    Optional<Posts> findByTitle(String title);

    @Query("SELECT p FROM posts p WHERE p.description = ?1")
    Optional<Posts> findByDescription(String description);
}
