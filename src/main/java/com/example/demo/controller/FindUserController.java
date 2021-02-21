package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * Copyright (c) 2020 UserManagement. All Rights Reserved.<br>
 * <br>
 * Theme - UserManagement <br>
 * Feature - UserServices<br>
 * Description - This is a controler class for User Search 
 * 
 * @author Ashi Bindal
 * @version 1.0.0
 * @since Feb 21, 2021
 */


@RestController
@RequestMapping("/search")
public class FindUserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserAssembler userAssembler;
	
	Logger logger = LoggerFactory.getLogger(FindUserController.class);
	
	
	@GetMapping("allUsers")
	public ResponseEntity<List<User>> SearchUsers(
			@RequestParam(value= "pageSize", defaultValue="2")  int pageSize,
			@RequestParam(value= "start", defaultValue="0")  int start,
			@RequestParam(value="orderBy",defaultValue ="ASC") String orderBy,
			@RequestParam(value="sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value="id", required= false) Integer id,
			@RequestParam(value="name",  required= false) String name,
			@RequestParam(value="email",  required= false) String email,
			@RequestParam(value="accountOption",defaultValue ="Active") String accountState
			) throws InterruptedException
	{
		
		logger.info("Getting Started with getAllUsers");
		
		List<User> users= userService.findUsers(id,name, email,accountState,start,pageSize,orderBy,sortBy);
		return new ResponseEntity<>(users,HttpStatus.OK);
		
	}
}
