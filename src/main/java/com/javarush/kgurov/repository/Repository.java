package com.javarush.kgurov.repository;


import com.javarush.kgurov.users.User;

import java.util.Collection;
import java.util.Optional;

public interface Repository {
    void create(User user);

    void update(User user);

    Optional<User> get(long id);

}
