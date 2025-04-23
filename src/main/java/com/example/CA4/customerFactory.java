package com.example.CA4;

import org.springframework.stereotype.Component;

@Component
public class customerFactory {
	
	public customer newCustomer(String username, String password, String email, String phoneNumber, String street, String city, String county)
	{
		
		customer c  = new customer();
		c.setUsername(username);
		c.setPassword(password);
		c.setEmail(email);
		c.setPhoneNumber(phoneNumber);
		c.setStreet(street);
		c.setCity(city);
		c.setCounty(county);
		
		
		return c;
		
	}

}
