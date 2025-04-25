package com.example.CA4;

import java.awt.Component;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class bookService {
	
	private bookRepo bRepo;
	private final Map<String, BookTemplate> searchMap;
	
	public bookService(bookRepo bRepo, Map<String, BookTemplate> searchMap)
	{
		super();
		this.bRepo = bRepo;
		this.searchMap = searchMap;
		
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
	
	public List<Book> search(String filterKey, String search)
	{
        BookTemplate sm = searchMap.getOrDefault(filterKey, searchMap.get("byTitle"));
        
        return sm.searchBy(search);
    }
	
	
	

}
