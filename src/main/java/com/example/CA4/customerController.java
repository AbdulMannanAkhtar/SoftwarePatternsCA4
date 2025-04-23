package com.example.CA4;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/users")
public class customerController {
	
	private customerService cService;
	private customerFactory cFactory;
	
	public customerController(customerService cService, customerFactory cFactory)
	{
		super();
		this.cService = cService;
		this.cFactory = cFactory;
	}
	
	@GetMapping("/index")
	public String landingPage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String registerPage()
	{
		return "Register";
	}
	
	
	@PostMapping("/register") 
	public String registerCustomer(customer newCust)
	{
		customer c = cFactory.newCustomer(newCust.getUsername(), newCust.getPassword(), newCust.getEmail(), newCust.getPhoneNumber(),
				newCust.getStreet(), newCust.getCity(), newCust.getCounty());
		
		cService.registerCustomer(c);
		
		
		return "Login";
		
	}
	
	@GetMapping("/login")
	public String LoginPage()
	{
		return "Login";
	}
	
	@PostMapping("/login")
	public String getCustomer(@RequestParam("Username") String username, @RequestParam("Password") String password)
	{
		customer c = cService.loginCustomer(username, password);
		
		if (c != null)
		{
			return "Home";
		}
		
		else
		{
			return "Login";
		}
	}
	

}
