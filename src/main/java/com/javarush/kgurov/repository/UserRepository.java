package com.javarush.kgurov.repository;

import com.javarush.kgurov.users.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository {
    private final Map<Long, User> userMap = new HashMap<>();
    private final AtomicLong id = new AtomicLong(0L);

    public UserRepository() {
    }

    @Override
    public void create(User user) {
        user.setId(id.incrementAndGet());
        update(user);
    }

    @Override
    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(userMap.get(id));
    }
}