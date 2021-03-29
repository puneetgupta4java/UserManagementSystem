package com.example.demo.response.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResponseDto implements Serializable{
	
	@Autowired
	private List<UserResponse> userResponse;
	
	public UserResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public UserResponseDto(List<UserResponse> userResponse) {
		super();
		this.userResponse = userResponse;
	}

	public List<UserResponse> getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(List<UserResponse> userResponse) {
		this.userResponse = userResponse;
	}

	
}
