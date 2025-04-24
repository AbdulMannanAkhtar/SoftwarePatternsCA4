package com.example.CA4;

import org.springframework.stereotype.Component;

@Component
public class bookFactory {
	
	public Book newBook(String title, String author, String publisher, Double price, String category, String isbn, String imageUri, int quantity)
	{
		
		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setPublisher(publisher);
		b.setPrice(price);
		b.setCategory(category);
		b.setIsbn(isbn);
		b.setImageUri(imageUri);
		b.setQuantity(quantity);
		
		return b;
		
	}
	
	

}
