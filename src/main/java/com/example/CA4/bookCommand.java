package com.example.CA4;

import jakarta.persistence.Column;

public class bookCommand {
	
	private Long Id;
	private String title;
	private String author;
	private String publisher;
	private Double price;
	private String category;
	private String isbn;
	private String imageUri;
	private Integer quantity;
	
	
	public Long getId() 
	{
		return Id;
	}
	
	public void setId(Long Id)
	{
		this.Id = Id;
	}
	
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getAuthor() 
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getPublisher() 
	{
		return publisher;
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public Double getPrice() 
	{
		return price;
	}
	
	public void setPrice(Double price) 
	{
		this.price = price;
	}
	
	public String getCategory() 
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public String getIsbn() 
	{
		return isbn;
	}
	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}
	public String getImageUri() 
	{
		return imageUri;
	}
	public void setImageUri(String imageUri) 
	{
		this.imageUri = imageUri;
	}
	public Integer getQuantity() 
	{
		return quantity;
	}
	
	public void setQuantity(Integer quantity) 
	{
		this.quantity = quantity;
	}
	
	

	
	

}
