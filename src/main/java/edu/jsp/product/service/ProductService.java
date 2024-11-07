package edu.jsp.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import edu.jsp.product.dao.ProductDao;
import edu.jsp.product.dto.Product;
import edu.jsp.product.util.ResponseStructure;
 
@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	
	public ResponseStructure<Product> saveProduct(Product p) {
		
		ResponseStructure<Product> rs= new ResponseStructure();
		rs.setStatus(HttpStatus.CREATED.value());
		rs.setMessage("Data Saved");
		rs.setData(dao.saveProduct(p));
		return rs;
	}
	
	public ResponseStructure<Product> fetchProductById(int id) {
		
		ResponseStructure<Product> rs = new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("Data Received");
		rs.setData(dao.fetchProductById(id));
		
		return rs;
	}
	
	public ResponseStructure<List<Product>> fetchAll(){
		
		ResponseStructure<List<Product>> rs= new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("Data ReceivedAll");
		rs.setData(dao.fetchAll());
		return rs;
	}
	
	public ResponseStructure<String> deleteById(int id) {
		
		ResponseStructure<String> rs= new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("Data deleted Successfully");
		rs.setData(dao.deleteById(id));
		return rs;
	}
	
	public ResponseStructure<Product> findByName(String name) {
		
		ResponseStructure<Product> rs= new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMessage("Data fetched Successfully");
		rs.setData(dao.findByName(name));
		return rs;
	}
	
	public ResponseStructure<Product> updateProduct(int id,Product p) {
		
		Product p1=dao.fetchProductById(id);
		
		if(p1!=null) {
			p.setId(id);
			
			ResponseStructure<Product> rs = new ResponseStructure();
			rs.setStatus(HttpStatus.CREATED.value());
			rs.setMessage("Data Updated Successfully");
			rs.setData(dao.updateProduct(p));
			return rs;
		}
		else {
			return null;
		}
	}
}