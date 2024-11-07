package edu.jsp.product.dao;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.product.dto.Product;
import edu.jsp.product.repository.ProductRepo;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepo repo;
	
	public Product saveProduct(Product p) {
		
		return repo.save(p);
	}
	
	public Product fetchProductById(int id) {
		
		Optional<Product> o=repo.findById(id);
		
		return o.get();
	}
	
	public List<Product> fetchAll(){
		
		return repo.findAll();
	}
	
	public String deleteById(int id) {
		
		repo.deleteById(id);
		
		return "Deleted";
	}
	
	public Product findByName(String name) {
		
		Optional<Product> o= repo.findByName(name);
		
		return o.get();
	}
	
	public Product updateProduct(Product p) {
		
		return repo.save(p);
	}
}
