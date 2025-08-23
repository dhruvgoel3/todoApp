package com.todoApp.todoApp.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    @NonNull
    @Indexed(unique = true)
    public String userName;
    @NonNull
    private String password;

//    @DBRef // creating reference of todo's in user
    private List<String> todos = new ArrayList<>();

}
//  So here we are creating the refernce of todos in User.