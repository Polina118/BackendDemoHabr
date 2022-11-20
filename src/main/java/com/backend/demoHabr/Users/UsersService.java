package com.backend.demoHabr.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Users createUser(Users users) {
        Optional<Users> clientOptional = usersRepository.findUserByLogin(users.getLogin());
        if (clientOptional.isPresent())
            throw new IllegalStateException("login is taken");
        usersRepository.save(users);
        return users;
    }

    public Users getByLogin(String login) {
        return usersRepository.findUserByLogin(login).
                orElseThrow(() -> new IllegalStateException(("incorrect login")));
    }

    @Transactional
    public Users updateUser(int userId, String login, String firstname, String lastname) {
        Users user = usersRepository.findById(userId).orElseThrow(()->
                new IllegalStateException("not found"));
        if (login != null && login.length() != 0)
            user.setLogin(login);
        if (firstname != null && firstname.length() != 0)
            user.setFirstname(firstname);
        if (lastname != null && lastname.length() != 0)
            user.setLastname(lastname);
        return user;

    }
}