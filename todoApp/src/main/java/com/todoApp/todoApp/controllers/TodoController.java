package com.todoApp.todoApp.controllers;

import java.util.List;

import com.todoApp.todoApp.entity.Todo;
import com.todoApp.todoApp.entity.User;
import com.todoApp.todoApp.services.TodoService;
import com.todoApp.todoApp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;

    // Create a new Todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo body) {
        return todoService.createTodo(body);
    }

    // Get all Todos
    @GetMapping("/get-alltodos")
    public ResponseEntity<?> getAllToDos(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<Todo> all = user.getTodos();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // Get a Todo by title
    @GetMapping("/get-todobytitle")
    public Todo getTodoByTitle(@RequestParam String todoTitle) {
        return todoService.getTodoByTitle(todoTitle);
    }

    // Update a Todo
    @PutMapping
    public Todo updateTodo(@RequestParam String title, @RequestBody Todo body) {
        Todo todoInDB = todoService.findByTitle(title);
        if (todoInDB != null) {
            todoInDB.setTitle(body.getTitle());
            todoInDB.setDescription(body.getDescription());
            Todo updatedTodo = todoService.savetodo(todoInDB);
            return updatedTodo;
        } else {
            return todoInDB;
        }
    }

    // Delete all Todos
    @DeleteMapping("/delete-alltodos")
    public ResponseEntity<?> deleteAllTodos() {
        todoService.deleteAllTodos();
        return new ResponseEntity<>("All todos deleted", HttpStatus.OK);
    }

    // Delete a single Todo by title
    @DeleteMapping("/delete-onetodo")
    public ResponseEntity<?> deleteTodoByTitle(@RequestParam String todo) {
        todoService.deleteTodoByTitle(todo);
        return new ResponseEntity<>("Todo deleted", HttpStatus.OK);
    }
}
