package com.project.scheduler.dao;

import java.util.HashMap;
import java.util.List;

import com.project.scheduler.dto.*;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

    public HashMap<String, Object> getAllTodoList();
    
}
