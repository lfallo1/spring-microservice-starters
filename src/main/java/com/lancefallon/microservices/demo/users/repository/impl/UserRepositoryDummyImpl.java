package com.lancefallon.microservices.demo.users.repository.impl;

import com.lancefallon.microservices.demo.users.model.Address;
import com.lancefallon.microservices.demo.users.model.Role;
import com.lancefallon.microservices.demo.users.model.User;
import com.lancefallon.microservices.demo.users.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepositoryDummyImpl implements UserRepository {

    private final List<User> users;

    {

        Calendar cal = Calendar.getInstance();
        users = new ArrayList<>();

        //user #1
        cal.set(1986, 9, 12);
        users.add(new User("lfallo1", "fallon.lance@gmail.com", cal.getTime(),
                Arrays.asList(new Address("7919 westmoreland avenue", "baltimore", "md", "21234")),
                "snoopy",
                Arrays.asList(new Role(1, "ROLE_USER"), new Role(2, "ROLE_ADMIN"))));

        //user #2
        cal.set(1989, 2, 10);
        users.add(new User("kara1", "kara123@gmail.com", cal.getTime(),
                Arrays.asList(new Address("123 west street", "hilton", "wa", "21889")),
                "secret",
                Arrays.asList(new Role(1, "ROLE_USER"))));
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
