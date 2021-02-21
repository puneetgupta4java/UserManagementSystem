package com.example.demo.assembler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;

/**
 * Copyright (c) 2020 UserManagement. All Rights Reserved.<br>
 * <br>
 * Theme - UserManagement <br>
 * Feature - UserServices<br>
 * Description - This is an Assembler 
 * 
 * @author Ashi Bindal
 * @version 1.0.0
 * @since Feb 21, 2021
 */

@Component
public class UserAssembler {
	
	@Autowired
	UserDto userDto;
	
	public UserDto toModel(Optional<User> user)
	{
		User usr = user.get();
	
		userDto.setName(usr.getName());
		userDto.setEmail(usr.getEmail());
		userDto.setAddress(usr.getAddress());
		
	return userDto;
		
	}
}
