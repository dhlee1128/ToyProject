package com.project.scheduler.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.scheduler.dto.UserDto;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException 
    {
        ObjectMapper mapper = new ObjectMapper();	//JSON 변경용
    	
    	UserDto userDto = new UserDto();
    	userDto.setCode("200");
    	userDto.setStatus("200");
    	
    	String prevPage = request.getSession().getAttribute("prevPage").toString();	//이전 페이지 가져오기
    	 
    	Map<String, String> items = new HashMap<String,String>();	
    	items.put("url", prevPage);	// 이전 페이지 저장
    	userDto.setItem(items);
    	
    	response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(mapper.writeValueAsString(userDto));
        response.getWriter().flush();
        
    }
     
}
