package com.backend.demoHabr.Users;

import com.backend.demoHabr.User_roles.User_RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UsersController {

    private final UsersService usersService;
    private final User_RolesService userRolesService;

    @Autowired
    public UsersController(UsersService usersService, User_RolesService userRolesService) {
        this.usersService = usersService;
        this.userRolesService = userRolesService;
    }

    @GetMapping
    public List<Users> getUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping(path = "/create")
    public void createUser(@RequestBody Users user){
        usersService.createUser(user);
    }

    @PostMapping(path = "/byemail")
    public void findUserByEmail(@RequestParam String email){
        usersService.getByLogin(email);
    }

    @PostMapping(path = "/addrole")
    public void addRole(@RequestBody RequestAddRole request){
        userRolesService.addRole(request.userId, request.value);
    }

    @DeleteMapping(path = "{userId}")
    public void DeleteStudent(@PathVariable("userId") int id){
        usersService.deleteClient(id);
    }

}