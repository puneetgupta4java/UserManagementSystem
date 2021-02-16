package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/find")
public class FindUserController {
	
	@Autowired
	UserRepository userRepositry;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserAssembler userAssembler;
	
	Logger logger = LoggerFactory.getLogger(FindUserController.class);
	
	
	@GetMapping("allUsers")
	@Cacheable(value="allUsersCache" )
	public ResponseEntity<List<User>> SearchUsers(
			@RequestParam(value= "pageSize", defaultValue="2")  int pageSize,
			@RequestParam(value= "start", defaultValue="0")  int start,
			@RequestParam(value="orderBy",defaultValue ="ASC") String orderBy,
			@RequestParam(value="sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value="id") Optional<Integer> id,
			@RequestParam(value="name") Optional<String> name,
			@RequestParam(value="accountOption",defaultValue ="Active") String accountState
			) throws InterruptedException
	{
		Thread.sleep(1000);
		
		logger.debug("Getting Started with getAllUsers");
		
		List<User> users =userRepositry.findAll();
		List<User> finalUser = new LinkedList<User>();
		
		finalUser= userService.findUsers(users, id, name, accountState,start,pageSize,orderBy,sortBy);
		return new ResponseEntity<>(finalUser,HttpStatus.OK);
		
	//Collections.sort(list);	
		//return new ResponseEntity<>(finalUser, HttpStatus.OK);
		
	}
}
