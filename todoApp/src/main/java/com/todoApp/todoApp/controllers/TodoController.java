package com.todoApp.todoApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.todoApp.todoApp.entity.Todo;
import com.todoApp.todoApp.repositories.UserRepository;
import com.todoApp.todoApp.services.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final UserRepository userRepository;

    @Autowired // Inject the service properly
    private TodoService todoService;

    TodoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo body) {
        return todoService.createTodo(body);
    }

    @GetMapping("/get-alltodos") // Added "/" for consistency
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @GetMapping("/get-todobytitle") // Return Todo object, not String
    public Todo getTodoByTitle(@RequestParam String todoTitle) {
        return todoService.getTodoByTitle(todoTitle);
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo) {
        Todo todoInDB = todoService.findByTitle(todo.getTitle());
        System.out.println(todoInDB);
        if(todoInDB != null) {
            todoInDB.setTitle(todo.getTitle());
            todoInDB.setDescription(todo.getDescription());
            todoService.savetodo(todoInDB);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
