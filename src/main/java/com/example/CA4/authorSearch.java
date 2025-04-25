package com.example.CA4;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component("byAuthor")
public class authorSearch implements BookTemplate{
	

private bookRepo bRepo;
	
	public authorSearch(bookRepo bRepo)
	{
		this.bRepo = bRepo;
	}

	@Override
	public List<Book> searchBy(String search) {
		// TODO Auto-generated method stub
		return  bRepo.findAll().stream().filter(b -> b.getAuthor().equalsIgnoreCase(search)).collect(Collectors.toList());
	} 
	

}


