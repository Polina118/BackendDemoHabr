package com.backend.demoHabr.Roles;

import com.backend.demoHabr.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    @Query("SELECT r FROM roles r WHERE r.value = ?1")
    Optional<Roles> findRoleByValue(String value);
}
