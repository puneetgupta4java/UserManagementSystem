package com.example.demo.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	List<User> findByNameIgnoreCase(String emp_name);
	
	List<User> findByAccountStateIgnoreCase(String emp_name);
	
	List<User> findByNameOrderByName(String name);

	List<User> findByNameOrderByNameDesc(String name);

	/*
	 * @Query("select u from User u where u.email =:email") Page<User>
	 * findAllSorted(PageRequest of);
	 */
}
