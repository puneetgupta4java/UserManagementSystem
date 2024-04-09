package com.example.demo.service.impl;

import java.util.Comparator;

import org.springframework.util.ObjectUtils;

import com.example.demo.model.Address;
import com.example.demo.model.User;

/**
 * Copyright (c) 2020 UserManagement. All Rights Reserved.<br>
 * <br>
 * Theme - UserManagement <br>
 * Feature - UserServices<br>
 * Description - This is a Comparator Used for sorting User fields 
 * 
 * @author Ashi Bindal
 * @version 1.0.0
 * @since Feb 21, 2021
 */


public class UserNameComparator implements Comparator<User> {

	String sortBy;
	
	public UserNameComparator(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public int compare(User user1, User user2) {
		int response =0;
		switch (sortBy.toLowerCase()) {
		case "id":
			response= user1.getId()-user2.getId();
			break;
		case "name":
			response= user1.getName().compareTo(user2.getName());
			break;
		case "email":
			response= user1.getEmail().compareToIgnoreCase(user2.getEmail());
			break;
		case "accountState":
			response= user1.getAccountState().compareToIgnoreCase(user2.getAccountState());
			break;
		case "addressid":
			Address add1 = user1.getAddress().orElse(null);
			Address add2 = user2.getAddress().orElse(null);
			
			if(ObjectUtils.isEmpty(add1) && ObjectUtils.isEmpty(add2))
			{
				response =0;
			}
			else if(ObjectUtils.isEmpty(add1))
			{
				response = -1;
			}
			else if(ObjectUtils.isEmpty(add2))
			{
				response = 1;
			}
			else
			{
				response = add1.getAddressId() ==0 ? (add2.getAddressId() ==0? 0:-1 ) : (add2.getAddressId() == 0 ? 1: add1.getAddressId()-add2.getAddressId());
			}
			break;
		case "city":
			Address add11 = user1.getAddress().orElse(null);
			Address add22 = user2.getAddress().orElse(null);
			
			if(ObjectUtils.isEmpty(add11) && ObjectUtils.isEmpty(add22))
			{
				response =0;
			}
			else if(ObjectUtils.isEmpty(add11))
			{
				response = -1;
			}
			else if(ObjectUtils.isEmpty(add22))
			{
				response = 1;
			}
			else
			{
				response = add11.getCity() == null ? (add22.getCity() ==null? 0:-1 ) : (add22.getCity() ==null ? 1: add11.getCity().compareToIgnoreCase(add22.getCity()));
			}
			break;
		case "state":
			
			Address add111 = user1.getAddress().orElse(null);
			Address add221 = user2.getAddress().orElse(null);
			
			if(ObjectUtils.isEmpty(add111) && ObjectUtils.isEmpty(add221))
			{
				response =0;
			}
			else if(ObjectUtils.isEmpty(add111))
			{
				response = -1;
			}
			else if(ObjectUtils.isEmpty(add221))
			{
				response = 1;
			}
			else
			{
				response = add111.getState() == null ? (add221.getState() ==null? 0:-1 ) : (add221.getState() ==null ? 1: add111.getState().compareToIgnoreCase(add221.getState()));
			}
			break;
		case "pincode":
			Address add1111 = user1.getAddress().orElse(null);
			Address add21 = user2.getAddress().orElse(null);
			
			if(ObjectUtils.isEmpty(add1111) && ObjectUtils.isEmpty(add21))
			{
				response =0;
			}
			else if(ObjectUtils.isEmpty(add1111))
			{
				response = -1;
			}
			else if(ObjectUtils.isEmpty(add21))
			{
				response = 1;
			}
			else
			{
				response = add1111.getPincode() ==0 ? (add21.getPincode() ==0? 0:-1 ) : (add21.getPincode() == 0 ? 1: add1111.getPincode()-add21.getPincode());
			}
			break;
		default:
				break;
		}
		return response;
	
	}

	
}
