package com.example.CA4;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class bookService {
	
	private bookRepo bRepo;
	
	public bookService(bookRepo bRepo)
	{
		super();
		this.bRepo = bRepo;
		
	}
	
	public Book addBook(Book b)
	{
		return bRepo.save(b);
	}
	
	public List<Book> allBooks()
	{
		return bRepo.findAll();
	}

}
