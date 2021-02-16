package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException{

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

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "UserException [message=" + message + ", httpStatus=" + httpStatus + "]";
	}
	
	
}
