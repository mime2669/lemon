package com.lemon.productservice.service;

import java.util.List;

import com.lemon.productservice.service.model.AddShop;
import com.lemon.productservice.service.model.GetShop;

public interface ShopService {
	
	public List<GetShop> getAll();
	public GetShop get(int id);
	
	public GetShop add(AddShop entry);
	
	public GetShop update(AddShop entry);
	
	void deleteById(int id);
	void deleteAll();

}
