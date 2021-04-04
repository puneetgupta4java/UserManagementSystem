package com.example.demo.assembler;


import org.springframework.stereotype.Component;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.response.dto.AddressDto;

@Component
public class AddressAssembler {
	
	
	public AddressDto toModelAddress(User usr)
	{
		if(usr.getAddress().isPresent())
		  {
			  		Address add = usr.getAddress().get();
			  		
					  String city = add.getCity();
					  String state= add.getState();
					  int pincode = add.getPincode();
					  
					  return new AddressDto(city,state,pincode);
		  }
		return null;
	}
	
	
}
