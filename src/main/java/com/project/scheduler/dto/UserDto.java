package com.project.scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    
    private String id;
    private String password;
    private String name;
    private String code;
	private String status;
	private String message;
	private Object item;
}
