package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


/**
 * Copyright (c) 2020 UserManagement. All Rights Reserved.<br>
 * <br>
 * Theme - UserManagement <br>
 * Feature - UserServices<br>
 * Description - This is UserServiceImpl Layer
 * 
 * @author Ashi Bindal
 * @version 1.0.0
 * @since Feb 21, 2021
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepositry;
	
	
	@Override
	@Cacheable(value="allUsersCache" )
	public List<User> findUsers(Integer id, String name, String email, String accountState, int start, int pageSize, String orderBy,
			String sortBy){
		
		List<User> users =userRepositry.findAll();
		List<User> searchedUserList = new ArrayList<User>();
		
		users.stream().forEach((usr) ->
		{
			//Incase is ID and Name both are Present
			if(name != null && id != null && email != null)
			{
				if(id.equals(usr.getId()) && name.equalsIgnoreCase(usr.getName()) && accountState.equalsIgnoreCase(usr.getAccountState()))
				{
					searchedUserList.add(usr);
				}
			}
			
			//Incase Only Name is Present
			else if(name != null )
			{
				if(name.equalsIgnoreCase(usr.getName()) && accountState.equalsIgnoreCase(usr.getAccountState()))
				{
					searchedUserList.add(usr);	
				}
			}
			else if(id != null)
			{
				if(id.equals(usr.getId()))
				{
					searchedUserList.add(usr);
				}
			}
			
			else if(email != null)
			{
				if(email.equals(usr.getEmail()))
				{
					searchedUserList.add(usr);
				}
			}
			
			else
			{
				searchedUserList.add(usr);
			}
		}		
	);
		
		
		Collections.sort(searchedUserList, new UserNameComparator(sortBy));
		
		if(orderBy.equalsIgnoreCase("DESC"))
		{
			Collections.reverse(searchedUserList);
		}
	
		int max =pageSize;
		int min =start;
		if(min >= 0 && max >0)
		{
			max= start+pageSize >= searchedUserList.size() ? searchedUserList.size(): start+pageSize ;
			min = start> searchedUserList.size()? 0: start;
		}

			Pageable pageable = PageRequest.of(0, pageSize);
			Page<User> pageList = new PageImpl<>(searchedUserList.subList(min, max), pageable, searchedUserList.size()) ; 	
			
			return pageList.getContent();
	}
	
}
