package com.backend.demoHabr.Subchapt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubchapterRepository extends JpaRepository<Subchapt, Integer> {

//    @Query("SELECT s FROM subchapt s WHERE s.name = ?1")
//    Optional<Subchapt> findSubchaptByName(String name);
}
