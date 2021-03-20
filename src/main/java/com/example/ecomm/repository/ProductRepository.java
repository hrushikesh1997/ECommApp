package com.example.ecomm.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecomm.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findByCategoryId(Long id, Pageable pageable);
	Page<Product> findByNameContaining(String name, Pageable pageable);
}
