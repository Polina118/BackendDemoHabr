package com.backend.demoHabr.Users;

import com.backend.demoHabr.User_roles.User_RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin()
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/all")
    public List<Users> getClients() {
        return usersService.getClients();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public String createUser(@RequestBody Users users) {
        usersService.createUser(users);
        return "Success";
    }

    @PostMapping(path = "/byemail{login}")
    public Users findByLogin(@RequestParam("login") String login){
        return usersService.getByLogin(login);
    }
}