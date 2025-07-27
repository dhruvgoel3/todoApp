package com.todoApp.todoApp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.todoApp.todoApp.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
}
