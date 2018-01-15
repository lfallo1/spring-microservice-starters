package com.lancefallon.microservices.demo.users.repository.impl;

import com.lancefallon.microservices.demo.users.model.User;
import com.lancefallon.microservices.demo.users.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepositoryDummyImpl implements UserRepository {

    private final List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("lfallo1", "fallon.lance@gmail.com"));
        users.add(new User("kara1", "kara23@gmail.com"));
        users.add(new User("jdoe123", "jdoe123@yahoo.com"));
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User findUser(String value) {
        List<User> results = this.users
                .stream()
                .filter(u -> value.toLowerCase().equals(u.getUsername().toLowerCase()))
                .collect(Collectors.toList());

        return results.size() > 0 ? results.get(0) : null;
    }
}
