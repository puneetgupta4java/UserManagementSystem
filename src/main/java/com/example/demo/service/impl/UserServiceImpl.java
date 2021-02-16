package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Override
	public List<User> findUsers(List<User> users, Optional<Integer> id, Optional<String> name, String accountState,
			int start, int pageSize, String orderBy, String sortBy) {
		
		List<User> searchedUserList = new ArrayList<User>();
		
		users.stream().forEach((usr) ->
		{
			//Incase is ID and Name both are Present
			if(name.isPresent() && id.isPresent())
			{
				if(id.get().equals(usr.getId()) && name.get().equalsIgnoreCase(usr.getName()) && accountState.equalsIgnoreCase(usr.getAccountState()))
				{
					searchedUserList.add(usr);
				}
			}
			
			//Incase Only Name is Present
			else if(name.isPresent())
			{
				if(name.get().equalsIgnoreCase(usr.getName()) && accountState.equalsIgnoreCase(usr.getAccountState()))
				{
					searchedUserList.add(usr);	
				}
			}
			else if(id.isPresent())
			{
				if(id.get().equals(usr.getId()))
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
		
		if(sortBy.equalsIgnoreCase("Name"))
		{
			Collections.sort(searchedUserList, new UserNameComparator());
		}
		
		//int totalpages = searchedUserList.size() / pageSize;
		int max =pageSize;
		int min =start;
		if(min >= 0 && max >0)
		{
			max= start+pageSize >= searchedUserList.size() ? searchedUserList.size(): start+pageSize ;
			min = start> searchedUserList.size()? 0: start;
		}
		
		//int max = start>=totalpages? searchedUserList.size():pageSize*(start+1);
        //int min = start >totalpages? max:pageSize*start;

		
			Pageable pageable = PageRequest.of(0, pageSize, Direction.fromString(orderBy), sortBy);
			Page<User> pageList = new PageImpl<>(searchedUserList.subList(min, max), pageable, searchedUserList.size()) ; 	
			
			return pageList.getContent();
	}
	
}
