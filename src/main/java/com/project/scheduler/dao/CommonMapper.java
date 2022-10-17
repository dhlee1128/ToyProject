package com.project.scheduler.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project.scheduler.dto.*;

@Mapper
public interface CommonMapper {

    String getPassword(UserDto userDto);
    UserDto getUserInfo(String id);
    
}
