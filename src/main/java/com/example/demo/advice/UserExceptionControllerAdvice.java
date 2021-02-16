package com.example.demo.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.UserException;

	@ControllerAdvice
	public class UserExceptionControllerAdvice {
		
		@ExceptionHandler(UserException.class)
		public ResponseEntity<String> handleUserException(UserException userException)
		{	
			   return new ResponseEntity<String>(userException.toString(),userException.getHttpStatus()); 
		}
}

