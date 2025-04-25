package com.example.CA4;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class customerService {
	
	private customerRepo cRepo;
	private bookRepo bRepo;
	private orderFactory oFactory;
	private orderRepo oRepo;
	//private customerFactory cFactory;
	
	public customerService(customerRepo cRepo, orderFactory oFactory, bookRepo bRepo, orderRepo oRepo)
	{
		super();
		this.cRepo = cRepo;
		this.oFactory = oFactory;
		this.bRepo = bRepo;
		this.oRepo = oRepo;
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
	
	
	@Transactional
    public Order order(cart cart, customer cust) 
	{
        Order order = oFactory.cart(cart, cust);
        Order saved = oRepo.save(order);

        
        for (var entry : cart.getBooks().entrySet()) 
        {
            Book b = entry.getKey();
            int quantity = entry.getValue();
            b.setQuantity(b.getQuantity() - quantity);
            
            bRepo.save(b);
        }

        return saved;
    }
	

}
