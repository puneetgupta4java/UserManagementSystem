package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	HttpStatus httpStatus;
	
	public UserException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + ", httpStatus=" + httpStatus + "]";
	}
	
	
}
