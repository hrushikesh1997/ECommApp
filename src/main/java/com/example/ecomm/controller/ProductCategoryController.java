package com.example.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.Product;
import com.example.ecomm.entity.ProductCategory;
import com.example.ecomm.service.ProductCategoryService;
import com.example.ecomm.service.ProductService;

@RestController
@CrossOrigin
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<ProductCategory>> getProducts() {
		List<ProductCategory> productCategories = this.productCategoryService.getAllProducts();
		for(ProductCategory p : productCategories) {
			System.out.println(p);
		}
		return new ResponseEntity<List<ProductCategory>>(productCategories,HttpStatus.OK); 
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		Optional<ProductCategory> productCategory = this.productCategoryService.getProductById(id);
		return new ResponseEntity<Optional<ProductCategory>>(productCategory,HttpStatus.OK); 
	}
}
