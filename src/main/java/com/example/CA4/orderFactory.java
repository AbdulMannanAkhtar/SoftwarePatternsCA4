package com.example.CA4;

public class orderFactory {
	
	public Order cart(cart c, customer cust)
	{
		return new orderBuilder().customerOrder(cust).withBooks(c.getBooks()).build();
	}
	
	

}
