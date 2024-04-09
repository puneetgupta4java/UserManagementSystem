package com.example.demo.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.UserException;

/**
 * Copyright (c) 2020 UserManagement. All Rights Reserved.<br>
 * <br>
 * Theme - UserManagement <br>
 * Feature - UserServices<br>
 * Description - Base exception class for all service Layers
 * 
 * @author Ashi Bindal
 * @version 1.0.0
 * @since Feb 21, 2021
 */

@ControllerAdvice
public class UserExceptionControllerAdvice {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handleUserException(UserException userException) {
		return new ResponseEntity<String>(userException.toString(), userException.getHttpStatus());
	}
}
