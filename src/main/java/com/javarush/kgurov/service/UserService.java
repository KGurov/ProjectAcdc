package com.javarush.kgurov.service;

import com.javarush.kgurov.repository.Repository;
import com.javarush.kgurov.users.User;
import com.javarush.kgurov.repository.UserRepository;

import java.util.Optional;

public class UserService implements Service {
    private final Repository userRepository;
    private static Service userService;

    public UserService() {
        userRepository = new UserRepository();
    }

    public static Service getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public Optional<User> get(long id) {
        return userRepository.get(id);
    }
}