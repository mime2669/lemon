package com.lemon.productservice.service;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lemon.productservice.model.Shop;
import com.lemon.productservice.repository.ShopRepository;
import com.lemon.productservice.service.model.AddShop;
import com.lemon.productservice.service.model.GetShop;
import com.lemon.productservice.service.util.ShopDTOMapper;

@Service
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {
	
	private ShopRepository shopRepository;
	
	protected Logger logger = Logger.getLogger(ShopServiceImpl.class.getName());
	
	@Inject
	public ShopServiceImpl(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}

	@Override
	public List<GetShop> getAll() {
		Iterable<Shop> shops = shopRepository.findAll();
		List<GetShop> entries = new LinkedList<>();
		if (shops != null) {
			shops.forEach(e -> entries.add(ShopDTOMapper.fromEntityToGetDTO(e)));
		}
		return entries;
	}

	@Override
	public GetShop get(int id) {
		Shop shop = shopRepository.findOne(id);
		if (shop == null) {
			throw new ShopServiceException("Unable to find entry in repository for id " + id);
		}
		return ShopDTOMapper.fromEntityToGetDTO(shop);
	}

	@Override
	@Transactional(readOnly = false)
	public GetShop add(AddShop entry) {
		if (entry == null) {
			throw new ShopServiceException("Unable to add entry. Entry is null");
		}
		if (entry.getName() == null || entry.getName().isEmpty()) {
			throw new ShopServiceException("Unable to add entry. Name is null or empty");
		}
		if (shopRepository.findByName(entry.getName()) != null) {
			throw new ShopServiceException("Unable to add entry. Entry with same name already exists " + entry);
		}
		Shop shop = ShopDTOMapper.toEntity(entry);
		Shop createdShop = shopRepository.save(shop);
		return ShopDTOMapper.fromEntityToGetDTO(createdShop);
	}

	@Override
	@Transactional(readOnly = false)
	public GetShop update(AddShop entry) {
		if (entry == null)
			throw new ShopServiceException("Unable to update entry. Entry is null");
		if (entry.getName() == null || entry.getName().isEmpty())
			throw new ShopServiceException("Unable to update entry. Name is null or empty");
		if (shopRepository.findOne(entry.getId()) == null) {
			throw new ShopServiceException("Unable to update entry. Cannot find entry for id " + entry.getId());
		}
		
		Shop shop = ShopDTOMapper.toEntity(entry);
		Shop updatedShop =shopRepository.save(shop);
		return ShopDTOMapper.fromEntityToGetDTO(updatedShop);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(int id) {
		if (shopRepository.findOne(id) == null) {
			throw new ShopServiceException("Unable to delete entry. Cannot find entry for id " + id);
		}
		shopRepository.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAll() {
		shopRepository.deleteAll();
	}

}
