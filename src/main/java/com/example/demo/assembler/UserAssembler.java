package com.example.demo.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.model.User;
import com.example.demo.response.dto.UserResponse;
import com.example.demo.response.dto.UserResponseDto;

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
	
	/*
	 * @Autowired UserResponse userResponse;
	 */
	
	@Autowired
	UserResponseDto userResponseDto;
	
	@Autowired
	AddressAssembler addressAssembler;
	
	public UserResponseDto toModel(List<User> user)
	{
		List<UserResponse> userResponseList = user.stream().map(		
		(usr) ->
		{	
			  UserResponse userResponse = new UserResponse();
			  userResponse.setName(usr.getName()); 
			  userResponse.setEmail(usr.getEmail());
			  
			  //AddressDto address = new AddressDto();
		
			  
			/*  if(usr.getAddress().isPresent())
			  {
				  		Address add = usr.getAddress().get();
				  		
						  String city = add.getCity();
						  String state= add.getState();
						  int pincode = add.getPincode();
				  
				userResponse.setAddress(new AddressDto(city,state,pincode));
			  }
			 */
			 
			  if(usr.getAddress().isPresent())
			  {
				  userResponse.setAddress(addressAssembler.toModelAddress(usr));
			  }
			  
			  userResponse.setAccountState(usr.getAccountState());
			  userResponse.setRoles(usr.getRoles());
			  return userResponse;
		}).collect(Collectors.toList());
		
		userResponseDto.setUserResponse(userResponseList);
		
	return userResponseDto;
		
	}
}
