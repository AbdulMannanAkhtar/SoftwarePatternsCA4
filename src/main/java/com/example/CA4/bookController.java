package com.example.CA4;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/admin")
public class bookController {
	
	private bookService bService;
	private bookFactory bFactory;
	private customerService cService;
	private customerFactory cFactory;
	
	
	public bookController(bookService bService, bookFactory bFactory, customerService cService, customerFactory cFactory) 
	{
		super();
		this.bService = bService;
		this.bFactory = bFactory;
		this.cService = cService;
		this.cFactory = cFactory;
	}
	
	@GetMapping("/adminDash")
	public String getBooks(Model m)
	{
		
		List<Book> books = bService.allBooks();
		
		m.addAttribute("books", books);
		
		return "adminDash";
	}
	
	@GetMapping("/addBook")
	public String addBookPage()
	{
		return "addBook";
	}
	
	@PostMapping("/addBook")
	public String addBook(Book newBook)
	{
		Book b = bFactory.newBook(newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), newBook.getPrice(),
				newBook.getCategory(), newBook.getIsbn(), newBook.getImageUri(), newBook.getQuantity());
		
		bService.addBook(b);
		
		return "addedBook";
	}
	
	@GetMapping("/allCustomers")
	public String customers(Model m)
	{
		List<customer> customers =  cService.allCustomers();
		
		m.addAttribute("customers", customers);
		
		return "allCustomers";
	}
	
	@GetMapping("/updateBook")
	public String updateBook()
	{
		return "updateBook";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(bookCommand bCommand)
	{
		bService.handle(bCommand);
		
		return ("updatedBook");
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
