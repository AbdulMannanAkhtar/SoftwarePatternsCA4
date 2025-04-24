package com.example.CA4;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/admin")
public class bookController {
	
	private bookService bService;
	private bookFactory bFactory;
	
	public bookController(bookService bService, bookFactory bFactory) 
	{
		super();
		this.bService = bService;
		this.bFactory = bFactory;
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
	
	

}
