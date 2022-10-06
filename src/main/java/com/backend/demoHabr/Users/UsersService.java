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

    public List<Users> getClients() {
        return usersRepository.findAll();
    }

    public void createUser(Users users) {
        Optional<Users> clientOptional = usersRepository.findUserByLogin(users.getLogin());
        if (clientOptional.isPresent())
            throw new IllegalStateException("login is taken");
        usersRepository.save(users);
    }

    public Users getByLogin(String login) {
        return usersRepository.findUserByLogin(login).
                orElseThrow(() -> new IllegalStateException((" --!incorrect login!-- ")));
    }
}