package com.example.CA4;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private bookService bService;
	private bookFactory bFactory;
	
	public customerController(customerService cService, customerFactory cFactory, bookService bService, bookFactory bFactory)
	{
		super();
		this.cService = cService;
		this.cFactory = cFactory;
		this.bService = bService;
		this.bFactory = bFactory;
		
		
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
	
	@GetMapping("/home")
	public String getBooks(Model m)
	{
		
		List<Book> books = bService.allBooks();
		
		m.addAttribute("books", books);
		
		return "Home";
	}
	
	@GetMapping("/search/title")
	public String searchByTitle(@RequestParam String search, Model m)
	{
		List<Book> b = bService.search("byTitle", search);
		
		m.addAttribute("books", b);
		
		return "searchResults";
	}
	
	@GetMapping("/search/author")
	public String searchByAutor(@RequestParam String search, Model m)
	{
		List<Book> b = bService.search("byAuthor", search);
		
		m.addAttribute("books", b);
		
		return "searchResults";
	}
	
	@GetMapping("/search/publisher")
	public String searchByPublisher(@RequestParam String search, Model m)
	{
		List<Book> b = bService.search("byPublisher", search);
		
		m.addAttribute("books", b);
		
		return "searchResults";
	}
	
	@GetMapping("/search/category")
	public String searchByCategory(@RequestParam String search, Model m)
	{
		List<Book> b = bService.search("byCategory", search);
		
		m.addAttribute("books", b);
		
		return "searchResults";
	}

	

}
