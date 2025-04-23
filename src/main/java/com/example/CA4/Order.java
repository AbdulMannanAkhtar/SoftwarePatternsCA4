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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name = "Subtotal")
	private Double subTotal;
	
	@Column(name = "Total")
	private Double total;
	
	@Column(name = "Quantity")
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_user_id")
	private customer customer;
	
	@ManyToMany
	//@JoinColumn(name = "BookId")
	private List<Book> books = new ArrayList<>();
	
	
	@Column(name = "Discount")
	private String discount;
	
	
	public Double getSubTotal()
	{
		return this.subTotal;
	}
	
	public void setSubTotal(Double subTotal)
	{
		this.subTotal = subTotal;
	}
	
	
	public Double getTotal()
	{
		return this.total;
	}
	
	public void setTotal(Double total)
	{
		this.total = total;
	}
	
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public customer getCustomer()
	{
		return this.customer;
	}
	
	public void setCustomer(customer customer)
	{
		this.customer = customer;
	}
	
	public List<Book> getBooks()
	{
		return this.books;
	}
	
	public void setBooks(List<Book> setBooks)
	{
		this.books = books;
	}
	
	public String getDiscount()
	{
		return this.discount;
	}

	public void setDiscount(String discount)
	{
		this.discount = discount;
	}

}
