//package com.backend.demoHabr.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/api/users")
//@CrossOrigin()
//public class UsersController {
//
//    private final UsersService usersService;
//
//    @Autowired
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//    @GetMapping(path = "/all")
//    public List<Users> getClients() {
//        return usersService.getClients();
//    }
//
//    @PostMapping(path = "/create")
//    @ResponseBody
//    public Users createUser(@RequestBody Users users) {
//        return usersService.createUser(users);
//    }
//
//    @PostMapping(path = "/byemail{login}")
//    public Users findByLogin(@RequestParam("login") String login){
//        return usersService.getByLogin(login);
//    }
//
//    @PutMapping("/update{id}")
//    public Users updateUser(@PathVariable("id") int userId, @RequestBody Users user){
//        return usersService.updateUser(
//                userId,
//                user.getLogin(),
//                user.getFirstname(),
//                user.getLastname());
//    }
//}