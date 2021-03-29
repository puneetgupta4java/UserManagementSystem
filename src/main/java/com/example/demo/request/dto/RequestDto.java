package com.example.demo.request.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*@RequestParam(value= "pageSize", defaultValue="2")  int pageSize,
	 		@RequestParam(value= "start", defaultValue="0")  int start,
			@RequestParam(value="orderBy",defaultValue ="ASC") String orderBy,
  			@RequestParam(value="sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value="id", required= false) Integer id,
			@RequestParam(value="name",  required= false) String name,
			@RequestParam(value="email",  required= false) String email,
			@RequestParam(value="accountOption",defaultValue ="Active") String accountState*/

@Getter
@Setter
@ApplicationScope
@Component
public class RequestDto {
	
	@Builder.Default
	int pageSize =2;
	
	@Builder.Default
	int start =0;
	
	@Builder.Default
	String orderBy ="ASC";
	
	@Builder.Default
	String sortBy = "id";
	Integer id;
	String name;
	String email;
	String accountState;
	
	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDto(int pageSize, int start, String orderBy, String sortBy, Integer id, String name, String email,
			String accountState) {
		super();
		this.pageSize = pageSize;
		this.start = start;
		this.orderBy = orderBy;
		this.sortBy = sortBy;
		this.id = id;
		this.name = name;
		this.email = email;
		this.accountState = accountState;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
