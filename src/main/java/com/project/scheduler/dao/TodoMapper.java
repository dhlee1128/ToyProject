package com.project.scheduler.dao;

import com.project.scheduler.dto.*;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    public TodoDto getAllTodoList();
    
}
