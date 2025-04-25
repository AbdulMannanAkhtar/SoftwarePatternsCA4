package com.example.CA4;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component("byCategory")
public class categorySearch implements BookTemplate{
	

	private bookRepo bRepo;
	
	public categorySearch(bookRepo bRepo)
	{
		this.bRepo = bRepo;
	}
	
	
	@Override
	public List<Book> searchBy(String search) {
		// TODO Auto-generated method stub
		
		return bRepo.findAll().stream().filter(b -> b.getCategory().equalsIgnoreCase(search)).collect(Collectors.toList());
	} 

}


