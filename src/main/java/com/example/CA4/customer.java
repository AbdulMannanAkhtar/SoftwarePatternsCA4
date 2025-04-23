package com.example.CA4;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Phone_Number")
	private String phoneNumber;
	
	@Column(name = "Street")
	private String street;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "County")
	private String county;
	
	
	@OneToMany(mappedBy = "customer")
	//@JoinColumn(name = "customer")
	private List<Order> order = new ArrayList<>();
	
	public Long getUserId()
	{
		return this.userId;
	}
	
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getStreet()
	{
		return this.street;	
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getCounty()
	{
		return this.county;
	}
	
	public void setCounty(String county)
	{
		this.county = county;
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
