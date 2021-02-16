package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	
	public List<User> findUsers(List<User> users, Optional<Integer> id, Optional<String> name, String accountState,
			int start, int pageSize, String orderBy, String sortBy);
}
