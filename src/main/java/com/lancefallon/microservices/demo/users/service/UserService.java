package com.lancefallon.microservices.demo.users.service;

import com.lancefallon.microservices.demo.users.model.User;
import com.lancefallon.microservices.demo.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public User find(String emailOrUsername){
        User user = this.userRepository.findUser(emailOrUsername);
        if(user == null){
            user = new User();
        }
        return user;
    }

}
