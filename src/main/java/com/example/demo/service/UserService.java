package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	public List<User> findUsers(Integer id, String name, String email, String accountState, int start, int pageSize, String orderBy,
			String sortBy);
}
