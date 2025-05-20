package com.example.springDocsSwagger.controller;

import org.springframework.web.bind.annotation.*;

import com.example.springDocsSwagger.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    // GET endpoint - Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    // GET endpoint - Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        Optional<Product> product = products.stream().filter(p -> p.getId().equals(id)).findFirst();
        return product.orElse(null); // If product not found, return null
    }

    // POST endpoint - Create a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setId((long) (products.size() + 1)); // Simple ID generation logic
        products.add(product);
        return product;
    }

    // PUT endpoint - Update an existing product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.get(i).setName(updatedProduct.getName());
                products.get(i).setPrice(updatedProduct.getPrice());
                return products.get(i);
            }
        }
        return null; // If not found
    }

    // DELETE endpoint - Delete a product by ID
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        products.removeIf(product -> product.getId().equals(id));
        return "Product with ID " + id + " deleted successfully.";
    }
}
