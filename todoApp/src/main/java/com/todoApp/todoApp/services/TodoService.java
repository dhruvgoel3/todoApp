package com.todoApp.todoApp.services;

import java.util.List;
import java.util.Optional;

import com.todoApp.todoApp.entity.User;
import com.todoApp.todoApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.todoApp.entity.Todo;
import com.todoApp.todoApp.repositories.TodoRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service // ✅ Use @Service, not @Component for service class
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public Todo savetodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public User createTodo(Todo body) {
        Todo savedTodo = todoRepository.save(body);
        String id = savedTodo.getId();
        User user = userRepository.findByUserName("Dhruv Goel");
        user.getTodos().add(id);
        userRepository.save(user);
        System.out.print("After saving" + user);
        return user;
    }

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo getTodoByTitle(String todoTitle) {
        return todoRepository.findByTitle(todoTitle);
    }

    public Todo findByTitle(String todo) {
        return todoRepository.findByTitle(todo);

    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    public void deleteTodoById(String id) {
        // 1. Find the todo
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isEmpty()) {
            throw new RuntimeException("Todo not found with Id" + id);
        }
        Todo todo = todoOptional.get();

        // 2. Delete todo from collection
        todoRepository.deleteById(id);

        // 3. Remove from user's todo list

        User user = userRepository.findByUserName("Dhruv Goel");

        if (user != null) {
            user.getTodos().remove(id);
        }
        userRepository.save(user);

    }

}
//done