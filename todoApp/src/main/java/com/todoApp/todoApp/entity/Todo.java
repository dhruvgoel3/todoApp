package com.todoApp.todoApp.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Document(collection = "Todo")
@Data
public class Todo {

    @Id
    private String id;
    @NonNull
    @Indexed(unique = true)
    private String title;
    private String description;

}
