package com.backend.demoHabr.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

    List<Posts> findAllByTitleContaining(String title);

}
