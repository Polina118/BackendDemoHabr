package com.backend.demoHabr.Chapter;

import com.backend.demoHabr.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

    @Query("SELECT c FROM chapter c WHERE c.name = ?1")
    Optional<Chapter> findChapterByName(String name);
}
