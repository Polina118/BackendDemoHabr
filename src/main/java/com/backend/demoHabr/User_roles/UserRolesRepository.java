package com.backend.demoHabr.User_roles;

import com.backend.demoHabr.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRolesRepository extends JpaRepository<User_roles, Integer>{

    @Query("SELECT ur FROM user_roles ur WHERE ur.userId = ?1 AND ur.RoleId = ?2")
    Optional<User_roles> findByRequest(int userId, int RoleId);

}
