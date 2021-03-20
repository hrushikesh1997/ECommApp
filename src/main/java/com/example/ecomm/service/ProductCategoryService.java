package com.example.ecomm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Product;
import com.example.ecomm.entity.ProductCategory;
import com.example.ecomm.repository.ProductCategoryRepository;
import com.example.ecomm.repository.ProductRepository;

@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	public List<ProductCategory> getAllProducts(){
		return this.productCategoryRepository.findAll();
	}
	
	public Optional<ProductCategory> getProductById(Long id){
		return this.productCategoryRepository.findById(id);
	}
}
