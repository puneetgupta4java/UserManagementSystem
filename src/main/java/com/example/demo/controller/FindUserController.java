package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.request.dto.RequestDto;
import com.example.demo.response.dto.UserResponseDto;
import com.example.demo.service.UserService;

/**
 * Copyright (c) 2020 UserManagement. All Rights Reserved.<br>
 * <br>
 * Theme - UserManagement <br>
 * Feature - UserServices<br>
 * Description - This is a controller class for User Search 
 * 
 * @author Ashi Bindal
 * @version 1.0.0
 * @since Feb 21, 2021
 */

@ApplicationScope
@RestController
@RequestMapping("/search")
public class FindUserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserAssembler userAssembler;
	
	@Autowired
	UserResponseDto userResponseDto;
	
	@Autowired
	RequestDto requestDto;
	
	Logger logger = LoggerFactory.getLogger(FindUserController.class);
	
	
	@GetMapping("allUsers")
	public ResponseEntity<UserResponseDto> SearchUsers(
			) throws InterruptedException
	{
		
		logger.info("Getting Started with getAllUsers");
		
		List<User> users= userService.findUsers(requestDto.getId(),requestDto.getName(), requestDto.getEmail(),requestDto.getAccountState(),requestDto.getStart()
				,requestDto.getPageSize(),requestDto.getOrderBy(),requestDto.getSortBy());
		UserResponseDto response = userAssembler.toModel(users);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
}
