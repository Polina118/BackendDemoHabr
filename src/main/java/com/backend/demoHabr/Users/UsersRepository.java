package com.backend.demoHabr.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("SELECT u FROM users u WHERE u.email = ?1")
    Optional<Users> findUserByEmail(String email);
}
