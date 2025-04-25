package com.example.CA4;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class customerService {
	
	private customerRepo cRepo;
	//private customerFactory cFactory;
	
	public customerService(customerRepo cRepo)
	{
		super();
		this.cRepo = cRepo;
	}
	
	public customer registerCustomer(customer c)
	{
		return cRepo.save(c);
	}
	
	public customer loginCustomer(String username, String password)
	{
		return cRepo.findByUsernameAndPassword(username, password);
	}
	
	public List<customer> allCustomers()
	{
		return cRepo.findAll();
	}
	
	

}
