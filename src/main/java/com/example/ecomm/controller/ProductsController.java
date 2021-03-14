package com.example.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Product;
import com.example.ecomm.service.ProductsService;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = this.productsService.getAllProducts();
		for(Product p : products) {
			System.out.println(p);
		}
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK); 
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Optional<Product> product = this.productsService.getProductById(id);
		return new ResponseEntity<Optional<Product>>(product,HttpStatus.OK); 
	}
	
}
