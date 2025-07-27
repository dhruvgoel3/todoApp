package com.todoApp.todoApp.services;

import java.util.List;
import com.todoApp.todoApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.todoApp.entity.Todo;
import com.todoApp.todoApp.repositories.TodoRepository;

@Service // ✅ Use @Service, not @Component for service class
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void savetodo(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo createTodo(Todo body) {
        return todoRepository.save(body);
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

}
