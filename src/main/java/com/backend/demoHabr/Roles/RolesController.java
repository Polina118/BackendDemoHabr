package com.backend.demoHabr.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/role")
@CrossOrigin
public class RolesController {

    RolesRepository rolesRepository;

    @Autowired
    public RolesController(RolesRepository rolesRepository){
        this.rolesRepository = rolesRepository;
    }

    @GetMapping(path = "/all")
    public List<Roles> getAllRoles(){
        return rolesRepository.findAll();
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles role) // value, description
    {
        rolesRepository.save(role);
        return role;
    }

    @GetMapping(path = "/{value}")
    public Roles findByValue(@RequestParam("value") String value){
        Optional<Roles> optionalRoles = rolesRepository.findRoleByValue(value);
        if(optionalRoles.isEmpty())
            throw new IllegalStateException(value +" doesn't exists");
        return optionalRoles.get();
    }
}
