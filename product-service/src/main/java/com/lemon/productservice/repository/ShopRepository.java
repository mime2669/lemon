package com.lemon.productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lemon.productservice.model.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
	
	Shop findByName(String name);

}
