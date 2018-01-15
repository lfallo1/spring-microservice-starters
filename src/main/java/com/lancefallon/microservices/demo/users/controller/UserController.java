package com.lancefallon.microservices.demo.users.controller;

import com.lancefallon.microservices.demo.users.model.User;
import com.lancefallon.microservices.demo.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping(value = "/{emailOrUsername}", produces = "application/json")
    public Resource<User> findUser(@PathVariable("emailOrUsername") String value) {
        Resource<User> resource = new Resource<>(this.userService.find(value));
        ControllerLinkBuilder allUsersLink = linkTo(methodOn(this.getClass()).getUsers());
        resource.add(allUsersLink.withRel("all-users"));
        return resource;
    }

}
