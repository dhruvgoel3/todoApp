package com.todoApp.todoApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HealthCheck {
    public String ToDoAppStarter(@RequestParam String param) {
        return new String();

    }

    @GetMapping("/HealthCheck")
    public String healthcheck() {
        return "ok";
    }

}
