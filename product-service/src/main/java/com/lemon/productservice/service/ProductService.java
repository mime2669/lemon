package com.lemon.productservice.service;

import java.util.List;

import com.lemon.productservice.service.model.AddProduct;
import com.lemon.productservice.service.model.GetProduct;

public interface ProductService {
	
	public List<GetProduct> getAll();
	public GetProduct get(int id);
	
	public GetProduct add(AddProduct entry);
	
	public GetProduct update(AddProduct entry);
	
	void deleteById(int entryId);
	void deleteAll();

}
