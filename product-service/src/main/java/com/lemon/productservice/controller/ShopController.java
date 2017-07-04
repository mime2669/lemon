package com.lemon.productservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lemon.productservice.service.ShopService;
import com.lemon.productservice.service.model.AddShop;
import com.lemon.productservice.service.model.GetShop;

@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	private Logger logger = Logger.getLogger(ShopController.class.getName());
	
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ResponseEntity<List<GetShop>> listAll() {
		List<GetShop> entries = shopService.getAll();
		if (entries.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(entries, HttpStatus.OK);
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetShop> get(@PathVariable("id") int id) {
		GetShop entry = shopService.get(id);
		if (entry == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(entry, HttpStatus.OK);
	}

	@RequestMapping(value = "/shop/", method = RequestMethod.POST)
	public ResponseEntity<GetShop> add(@RequestBody AddShop shop,
			UriComponentsBuilder ucBuilder) {
		GetShop createdShop = shopService.add(shop);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/shop/{id}").buildAndExpand(createdShop.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GetShop> update(@PathVariable("id") int id,
			@RequestBody AddShop shop) {
		shop.setId(id);
		GetShop updatedShop = shopService.update(shop);
		return new ResponseEntity<>(updatedShop, HttpStatus.OK);
	}

	@RequestMapping(value = "/shop/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AddShop> delete(@PathVariable("id") int id) {
		logger.debug("Fetching & Deleting production system with id " + id);
		shopService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shop", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAll() {
		logger.debug("Fetching & Deleting all production systems");
		shopService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
