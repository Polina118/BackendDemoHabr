package com.backend.demoHabr.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

   // List<Posts> findByTitleContaining(String subtitle);

    @Query("SELECT p FROM posts p WHERE p.user_id = ?1")
    List<Posts> findAllByUserId(Integer userId);

//   @Query("SELECT p FROM posts p WHERE p.subchapter_id= ?1")
//    List<Posts> findAllByChapterId(Integer subchapterId);
}
