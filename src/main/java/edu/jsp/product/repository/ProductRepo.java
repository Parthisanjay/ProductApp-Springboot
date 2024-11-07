package edu.jsp.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.product.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	public Optional<Product> findByName(String name);
}
