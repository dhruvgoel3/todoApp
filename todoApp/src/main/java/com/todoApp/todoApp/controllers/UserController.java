package com.todoApp.todoApp.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.todoApp.entity.User;
import com.todoApp.todoApp.services.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/get-allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-oneuser")
    public User getOneUser(@RequestParam String username) {
        return userService.getOnUser(username);
    }

    @PutMapping
    public User updateUser(@RequestParam String userName, @RequestBody User body) {
        User userInDb = userService.findByUserName( userName);
        if (userInDb != null) {
            userInDb.setUserName(body.getUserName());
            userInDb.setPassword(body.getPassword());
            User updatedUser = userService.getOnUser(userName);
            return updatedUser;
        } else {
            return userInDb;
        }

    }

    @DeleteMapping("/delete-allusers")
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    public void deleteUserById(String id) {
        userService.deleteUserById(id);

    }
}
//user controller