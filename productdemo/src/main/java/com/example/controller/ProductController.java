package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return service.getProduct();
	}
	
	@GetMapping("/products/{prodId}")
	public Optional<Product> getProductById(@PathVariable int prodId) {
		return service.getProductById(prodId);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		service.addProduct(prod);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product prod) {
		service.updateProduct(prod);
	}
	
	@DeleteMapping("/products/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		service.deleteProduct(prodId);
	}

}
