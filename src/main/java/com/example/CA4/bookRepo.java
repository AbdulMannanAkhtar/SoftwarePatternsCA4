package com.example.CA4;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepo extends JpaRepository<Book, Long>{
	
	List<Book> findByCategory(String category);
	

}
