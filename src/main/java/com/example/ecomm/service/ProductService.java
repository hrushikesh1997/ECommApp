package com.example.ecomm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Product;
import com.example.ecomm.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productsRepository;
	
	public Page<Product> getAllProducts(int pageNum, int pageSize){
		Pageable page = PageRequest.of(pageNum, pageSize);
		return this.productsRepository.findAll(page);
	}
	
	public Optional<Product> getProductById(Long id){
		return this.productsRepository.findById(id);
	}
	
	public Page<Product> findProductsByCategoryId(Long id, int pageNum, int pageSize){
		Pageable page = PageRequest.of(pageNum, pageSize);
		return this.productsRepository.findByCategoryId(id, page);
	}
	
	public Page<Product> findProductsBySearchKey(String key, int pageNum, int pageSize){
		Pageable page = PageRequest.of(pageNum, pageSize);
		return this.productsRepository.findByNameContaining(key, page);
	}
}
