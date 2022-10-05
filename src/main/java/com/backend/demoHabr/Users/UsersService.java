package com.backend.demoHabr.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void createUser(Users user) {
        Optional<Users> userOptional = usersRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent())
            throw new IllegalStateException("email is taken");
        usersRepository.save(user);
    }

    public Users getByLogin(String login) {
        return usersRepository.findUserByEmail(login).
                orElseThrow(() -> new IllegalStateException((" --!incorrect email!-- ")));
    }

    public void deleteClient(int id) {
        if (!usersRepository.existsById(id))
            throw new IllegalStateException("user with id " + id + " does not exists");
        usersRepository.deleteById(id);

    }
}