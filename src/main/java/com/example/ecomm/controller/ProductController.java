package com.example.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Product;
import com.example.ecomm.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productsService;
	
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size) {
		Page<Product> products = this.productsService.getAllProducts(page, size);
		for(Product p : products) {
			System.out.println(p);
		}
		return new ResponseEntity<Page<Product>>(products,HttpStatus.OK); 
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Optional<Product> product = this.productsService.getProductById(id);
		return new ResponseEntity<Optional<Product>>(product,HttpStatus.OK); 
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<Page<Product>> getProductBySearchKey(@RequestParam String key,@RequestParam int page, @RequestParam int size) {
		Page<Product> product = this.productsService.findProductsBySearchKey(key, page, size);
		return new ResponseEntity<Page<Product>>(product,HttpStatus.OK); 
	}
	
	@GetMapping("/products/category")
	public ResponseEntity<Page<Product>> getProductByCategoryId(@RequestParam Long id,@RequestParam int page, @RequestParam int size) {
		Page<Product> product = this.productsService.findProductsByCategoryId(id, page, size);
		return new ResponseEntity<Page<Product>>(product,HttpStatus.OK); 
	}
	
}
