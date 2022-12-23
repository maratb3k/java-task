package com.example.demo.services.user;

import com.example.demo.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(long id);
    List<User> getUsers();
    User updateUser(User user);
    String deleteUser(long id);
}
