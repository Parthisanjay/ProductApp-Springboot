package edu.jsp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 

import edu.jsp.product.dto.Product;
import edu.jsp.product.service.ProductService;
import edu.jsp.product.util.ResponseStructure;

@RestController //Combination of Controller and RequestBody
public class ProductController {
	
	@Autowired
	private ProductService service;
	
//	@RequestMapping(method=RequestMethod.POST,value="saveproduct")
	@PostMapping("saveproduct")
	public ResponseStructure<Product> saveProduct(@RequestBody Product p) {//RequestBody=Convert JSON to JavaObject
														//ResponseBody=Convert JavaObject to JSON
		return service.saveProduct(p);
	}
	
	@GetMapping("getproduct")
	public ResponseStructure<Product> fetchProductById(@RequestParam int id) {
		
		return service.fetchProductById(id);
	}
	
	@GetMapping("fetchall")
	public ResponseStructure<List<Product>> fetchAll(){
		
		return service.fetchAll();
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseStructure<String> deleteById(@PathVariable int id) {
		
		return service.deleteById(id);
	}
	
	@GetMapping("fetchbyname")
	public ResponseStructure<Product> findByName(@RequestParam String name) {
		
		return service.findByName(name);
	}
	
	@PutMapping("update")
	public ResponseStructure<Product> updateProduct(@RequestParam int id,@RequestBody Product p) {
		
		return service.updateProduct(id, p);
	}
}
