package com.example.CA4;

import java.util.HashMap;
import java.util.Map;

public class cart {
	
	private Map<Book, Integer> books = new HashMap<>();
	
	public void addBook(Book b)
	{
		books.put(b, books.getOrDefault(b, 0) + 1);
		
		
	}
	
	public void updateBookQuantity(Book b, int quantity)
	{
		if(quantity <= 0)
		{
			books.remove(b);
		}
		
	}
	
	public Map<Book, Integer> getBooks()
	{
		return books;
	}
	
	
	
	

}
