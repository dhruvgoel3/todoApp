package com.todoApp.todoApp.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todoApp.todoApp.entity.Todo;
import com.todoApp.todoApp.entity.User;
import com.todoApp.todoApp.repositories.UserRepository;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User savetodo(User user) {
        return userRepository.save(user);
    }

    public User createUser(User user) { // Creates a user
        return userRepository.save(user);

    }

    public List<User> getAllUsers() { // Get all the users
        return userRepository.findAll();
    }

    public User getOnUser(String userName) { // Get only one user
        return userRepository.findByUserName(userName);
    }

    public void deleteAllUsers() { // Delete all the users
        userRepository.deleteAll();
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);

    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}
