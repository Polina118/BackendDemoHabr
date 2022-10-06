package com.backend.demoHabr.User_roles;

import com.backend.demoHabr.Roles.Roles;
import com.backend.demoHabr.Roles.RolesRepository;
import com.backend.demoHabr.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class User_RolesService {

    RolesRepository rolesRepository;
    UserRolesRepository userRolesRepository;

    @Autowired
    public User_RolesService(RolesRepository rolesRepository, UserRolesRepository userRolesRepository) {
       this.rolesRepository = rolesRepository;
       this.userRolesRepository = userRolesRepository;
    }

//    public void addRole(int userId, String roleValue) {
//        Optional<Roles> optionalRoles = rolesRepository.findRoleByValue(roleValue);
//        if (optionalRoles.isEmpty())
//            throw new IllegalStateException("role " + roleValue + "doesn't exists");
//        int roleId = optionalRoles.get().getId();
//        Optional<User_roles> optionalUserRoles = userRolesRepository.findByRequest(userId, roleId);
//        if (optionalUserRoles.isEmpty())
//            throw new IllegalStateException("");
//        optionalUserRoles.get().setRoleId(roleId);
//        optionalUserRoles.get().setUserId(userId);
//    }
}
