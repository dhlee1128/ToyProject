package com.project.scheduler.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scheduler.dao.TodoMapper;
import com.project.scheduler.dto.TodoDto;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    public TodoDto getAllTodoList() {
        return todoMapper.getAllTodoList();
    }
    
}
