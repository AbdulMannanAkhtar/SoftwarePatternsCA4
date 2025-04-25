package com.example.CA4;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component("byTitle")
public class titleSearch implements BookTemplate{
	
	
	private bookRepo bRepo;
	
	public titleSearch(bookRepo bRepo)
	{
		this.bRepo = bRepo;
	}
	
	@Override
	public List<Book> searchBy(String search) {
		
		String lower = search.toLowerCase();
		
		
		return bRepo.findAll().stream().filter(b -> b.getTitle().toLowerCase().contains(lower)).collect(Collectors.toList());
	} 
	
	

}
