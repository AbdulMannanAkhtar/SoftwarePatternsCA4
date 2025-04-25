package com.example.CA4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class orderBuilder {
	
	 private customer customer;
	 private Map<Book,Integer> books;
	 
	 
	 public orderBuilder customerOrder(customer c) 
	 {
	        this.customer = c;
	        return this;
	 }
	 
	 public orderBuilder withBooks(Map<Book,Integer> Books) {
	        this.books = books;
	        return this;
	    }
	    public Order build() {
	        Order o = new Order();
	        o.setCustomer(customer);
	        
	      	double sub = 0;
	        int totalBooks = 0;
	        List<Book> bookList = new ArrayList<>();
	        
	        for (Map.Entry<Book,Integer> entry : books.entrySet()) {
	            Book b = entry.getKey();
	            int quantity = entry.getValue();
	            bookList.add(b);
	            
	            sub += b.getPrice() * quantity;
	            totalBooks += quantity;
	        }
	        o.setBooks(bookList);
	        o.setQuantity(totalBooks);
	        o.setSubTotal(sub);
	        o.setTotal(sub); 

	        return o;
	    }

}
