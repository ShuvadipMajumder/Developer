package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;

	public List<Product> getProduct(){
		return repo.findAll();
	}
	
	public Optional<Product> getProductById(int prodId) {
		return repo.findById(prodId);
	}
		
	public void addProduct(Product prod) {
		repo.save(prod);
	}
	
	public void updateProduct(Product prod) {
	        repo.save(prod);
	}
	
	public void deleteProduct(int prodId) {
		repo.deleteById(prodId);
	}
}
