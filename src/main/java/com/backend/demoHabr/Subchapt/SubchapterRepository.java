package com.backend.demoHabr.Subchapt;

import com.backend.demoHabr.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubchapterRepository extends JpaRepository<Subchapt, Integer> {

//    @Query("SELECT s FROM subchapt s WHERE s.name = ?1")
//    Optional<Subchapt> findSubchaptByName(String name);
}
