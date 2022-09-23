package com.project.scheduler.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scheduler.dto.TodoDto;
import com.project.scheduler.service.TodoService;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    @GetMapping("/main")
    public String getHome() {
        return "hello spring";
    }

    @GetMapping("/todoList")
    // public ResponseEntity<HashMap<String, Object>> getAllTodoList() {
    public String getAllTodoList() {
        TodoDto todoList = todoService.getAllTodoList();
        return todoList.getTitle();
        // return new ResponseEntity<HashMap<String, Object>>(todoList, HttpStatus.OK);
    }
    
}
