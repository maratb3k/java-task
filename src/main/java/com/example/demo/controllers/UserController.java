package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/user/{id}")
    public User findUserByID(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PutMapping(path = "/{id}/")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

}