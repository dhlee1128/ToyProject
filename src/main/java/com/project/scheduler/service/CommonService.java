package com.project.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scheduler.dao.CommonMapper;
import com.project.scheduler.dto.*;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommonService {

    @Autowired
    private CommonMapper commonMapper;

    public String getPassword(UserDto userDto) {
        return commonMapper.getPassword(userDto);
    }
    
}
