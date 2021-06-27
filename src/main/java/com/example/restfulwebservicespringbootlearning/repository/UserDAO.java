package com.example.restfulwebservicespringbootlearning.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.restfulwebservicespringbootlearning.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private static int userCount = 3;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
