package com.lemon.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lemon.productservice.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	Product findByName(String name);
}
