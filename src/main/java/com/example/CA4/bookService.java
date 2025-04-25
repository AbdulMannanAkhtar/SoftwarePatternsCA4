package com.example.CA4;

import java.util.List;
import java.util.Optional;

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
	
	public void handle(bookCommand bCommand)
	{
		Book b = bRepo.findById(bCommand.getId()).orElseThrow();
		
		if(bCommand.getTitle() != null && !bCommand.getTitle().isBlank())
		{
			b.setTitle(bCommand.getTitle());
		}
		if(bCommand.getAuthor() != null && !bCommand.getAuthor().isBlank())
		{
			b.setAuthor(bCommand.getAuthor());
		}
		if(bCommand.getPublisher() != null && !bCommand.getPublisher().isBlank())
		{
			b.setPublisher(bCommand.getPublisher());
		}
		if(bCommand.getPrice() != null)
		{
			b.setPrice(bCommand.getPrice());
		}
		if(bCommand.getCategory() != null && !bCommand.getCategory().isBlank())
		{
			b.setCategory(bCommand.getCategory());
		}
		if(bCommand.getIsbn() != null && !bCommand.getIsbn().isBlank())
		{
			b.setIsbn(bCommand.getIsbn());
		}
		if(bCommand.getImageUri() != null && !bCommand.getImageUri().isBlank())
		{
			b.setImageUri(bCommand.getImageUri());
		}
		if(bCommand.getQuantity() != null)
		{
			b.setQuantity(bCommand.getQuantity());
		}
		
		bRepo.save(b);
	}

}
