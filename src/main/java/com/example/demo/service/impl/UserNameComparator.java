package com.example.demo.service.impl;

import java.util.Comparator;

import com.example.demo.model.User;

public class UserNameComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		int name = o1.getName().compareToIgnoreCase(o2.getName());
		return name ==0? o1.getId()-o2.getId() : name;
	}

	
}
