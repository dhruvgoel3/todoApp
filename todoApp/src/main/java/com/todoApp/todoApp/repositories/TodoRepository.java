package com.todoApp.todoApp.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.todoApp.todoApp.entity.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
    Todo findByTitle(String title);
}
