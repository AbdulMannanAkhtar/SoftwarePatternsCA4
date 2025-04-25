package com.example.CA4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface BookTemplate {
	
	
	
	 List<Book> searchBy(String search);
	
}
