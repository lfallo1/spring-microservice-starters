package com.lancefallon.microservices.demo.users.repository;

import com.lancefallon.microservices.demo.users.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findUser(String value);

}
