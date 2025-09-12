//package com.todoApp.todoApp.controllers;
//
//import java.util.List;
//
//import com.todoApp.todoApp.entity.Todo;
//import com.todoApp.todoApp.entity.User;
//import com.todoApp.todoApp.services.TodoService;
//import com.todoApp.todoApp.services.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/todo")
//public class TodoController {
//
//    @Autowired
//    private TodoService todoService;
//    @Autowired
//    private UserService userService;
//
//    // Create a new Todo
//    @PostMapping
//    public User createTodo(@RequestBody Todo body) {
//        return todoService.createTodo(body);
//    }
//
//    // Get all Todos
//    // Get all Todos by username
//    @GetMapping("/getAllTodos")
//    public List<Todo> getAllToDos() {
//        return todoService.getAllTodo();
//    }
//
//
//    // Get a Todo by title
//    @GetMapping("/get-todobytitle")
//    public Todo getTodoByTitle(@RequestParam String todoTitle) {
//        return todoService.getTodoByTitle(todoTitle);
//    }
//
//    // Update a Todo
//    @PutMapping
//    public Todo updateTodo(@RequestParam String title, @RequestBody Todo body) {
//        Todo todoInDB = todoService.findByTitle(title);
//        if (todoInDB != null) {
//            todoInDB.setTitle(body.getTitle());
//            todoInDB.setDescription(body.getDescription());
//            Todo updatedTodo = todoService.savetodo(todoInDB);
//            return updatedTodo;
//        } else {
//            return todoInDB;
//        }
//    }
//
//    // Delete all Todos
//    @DeleteMapping("/delete-alltodos")
//    public ResponseEntity<?> deleteAllTodos() {
//        todoService.deleteAllTodos();
//        return new ResponseEntity<>("All todos deleted", HttpStatus.OK);
//    }
//
//    // Delete a single Todo by title
//
//    @DeleteMapping("/todo/{id}")
//    public ResponseEntity<String> deleteTodo(@PathVariable String id) {
//        todoService.deleteTodoById(id);
//        return ResponseEntity.ok("Todo deleted successfully");
//    }
//
//
//}
package com.todoApp.todoApp.controllers;

import java.util.List;

import com.todoApp.todoApp.entity.Todo;
import com.todoApp.todoApp.entity.User;
import com.todoApp.todoApp.services.TodoService;
import com.todoApp.todoApp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// ✅ Allow CORS requests from your Flutter dev server
@CrossOrigin(
        origins = {
                "http://localhost:62883",   // Flutter web dev server
                "http://127.0.0.1:62883"    // fallback if dev server uses 127.0.0.1
        },
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;

    // Create a new Todo
    @PostMapping
    public User createTodo(@RequestBody Todo body) {
        return todoService.createTodo(body);
    }

    // Get all Todos
    @GetMapping("/getAllTodos")
    public List<Todo> getAllToDos() {
        return todoService.getAllTodo();
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
            return todoService.savetodo(todoInDB);
        } else {
            return null;
        }
    }

    // Delete all Todos
    @DeleteMapping("/delete-alltodos")
    public ResponseEntity<?> deleteAllTodos() {
        todoService.deleteAllTodos();
        return new ResponseEntity<>("All todos deleted", HttpStatus.OK);
    }

    // Delete a single Todo by id
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable String id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }
}
