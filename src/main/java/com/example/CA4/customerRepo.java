package com.example.CA4;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepo extends JpaRepository<customer, Long>{
	
	customer findByUsernameAndPassword(String username, String password);

}
