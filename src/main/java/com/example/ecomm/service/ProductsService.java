package com.example.ecomm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Product;
import com.example.ecomm.repository.ProductRepository;

@Service
public class ProductsService {

	
	@Autowired
	private ProductRepository productsRepository;
	
	public List<Product> getAllProducts(){
		return this.productsRepository.findAll();
	}
	
	public Optional<Product> getProductById(Long id){
		return this.productsRepository.findById(id);
	}
}
