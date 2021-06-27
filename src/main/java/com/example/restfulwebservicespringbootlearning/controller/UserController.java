package com.example.restfulwebservicespringbootlearning.controller;

import java.net.URI;
import java.util.List;

import com.example.restfulwebservicespringbootlearning.entity.User;
import com.example.restfulwebservicespringbootlearning.exception.UserNotFoundException;
import com.example.restfulwebservicespringbootlearning.repository.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping(path = "/user")
    public List<User> retrieveAllUsers() {
        return userDAO.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDAO.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userDAO.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

        // return 201-Created
        // return location: api to get this savedUser in header response
    }
}
