package com.sujan.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujan.app.entity.Product;
import com.sujan.app.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}	
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public Product findById(Long id) {
		return repository.findById(id).get();		
	}
	
	public void deleteById(Long id) {
		
		repository.deleteById(id);
	}

}
