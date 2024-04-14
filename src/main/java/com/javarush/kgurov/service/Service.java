package com.javarush.kgurov.service;

import com.javarush.kgurov.users.User;

import java.util.Optional;

public interface Service {
    void create(User user);

    Optional<User> get(long id);
}
