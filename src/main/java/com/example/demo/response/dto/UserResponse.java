package com.example.demo.response.dto;

import java.io.Serializable;
import java.util.List;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@SuppressWarnings("serial")
public class UserResponse implements Serializable{
	
	private String name;
	
	@JsonIgnoreProperties("user")
	private AddressDto address;
	private String email;
	private String accountState;
	private List<String> roles;
	
	public UserResponse() {
		// TODO Auto-generated constructor stub
	}

	public UserResponse(String name, AddressDto address, String email, String accountState, List<String> roles) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.accountState = accountState;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserResponse [name=" + name + ", address=" + address + ", email=" + email + ", accountState="
				+ accountState + ", roles=" + roles + "]";
	}
	

}
