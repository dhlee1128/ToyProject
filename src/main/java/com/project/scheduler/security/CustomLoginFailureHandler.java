package com.project.scheduler.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.scheduler.dto.UserDto;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException 
    {
        ObjectMapper mapper = new ObjectMapper();	//JSON 변경용
    	
    	UserDto userDto = new UserDto();
    	userDto.setCode("999");
    	userDto.setStatus("999");
    	userDto.setMessage("아이디 혹은 비밀번호가 일치하지 않습니다.");
    	
    	response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(mapper.writeValueAsString(userDto));
        response.getWriter().flush();
        
    }
    
}
