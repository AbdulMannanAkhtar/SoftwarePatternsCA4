package com.example.CA4;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long BookId;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Author")
	private String author;
	
	@Column(name = "Publisher")
	private String publisher;
	
	@Column(name = "Price")
	private Double price;
	
	@Column(name = "Category")
	private String category;
	
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "Image")
	private String imageUri;
	
	@ManyToMany
	//@JoinColumn(name = "orderId")
	private List<Order> order = new ArrayList<>();
	
	
	public Long getBookId()
	{
		return this.BookId;
	}
	
	public void setBookId(Long BookId)
	{
		this.BookId = BookId;
	}
	
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public Double getPrice()
	{
		return this.price;
	}
	
	public void setPrice(Double price) 
	{
		this.price = price;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public void setCategory(String category) 
	{
		this.category = category;
		
	}
	
	public String getIsbn()
	{
		return this.isbn;
	}
	
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public String getImageUri()
	{
		return this.imageUri;
	}
	
	public void setImageUri(String imageUri)
	{
		this.imageUri = imageUri;
	}
	
	public List<Order> getOrder()
	{
		return this.order;
	}
	
	public void setOrder(List<Order> setOrder)
	{
		this.order = order;
	}


}
