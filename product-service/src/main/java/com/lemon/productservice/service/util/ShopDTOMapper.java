package com.lemon.productservice.service.util;

import com.lemon.productservice.model.Shop;
import com.lemon.productservice.service.model.AddShop;
import com.lemon.productservice.service.model.GetShop;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ShopDTOMapper {
	
	private ShopDTOMapper() {
		throw new IllegalAccessError("Utility class");
	}

	private static MapperFactory buildMapperFactoryGetDTO() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Shop.class, GetShop.class).constructorB()
		.byDefault().register();
		return mapperFactory;
	}

	private static MapperFactory buildMapperFactoryAddDTO() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Shop.class, AddShop.class).constructorB()
		.byDefault().register();
		return mapperFactory;
	}

	public static GetShop fromEntityToGetDTO(Shop shop) {
		MapperFactory mapperFactory = buildMapperFactoryGetDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(shop, GetShop.class);
	}

	public static AddShop fromEntityToAddDTO(Shop shop) {
		MapperFactory mapperFactory = buildMapperFactoryAddDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(shop, AddShop.class);
	}

	public static Shop toEntity(GetShop entry) {
		MapperFactory mapperFactory = buildMapperFactoryGetDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(entry, Shop.class);
	}

	public static Shop toEntity(AddShop entry) {
		MapperFactory mapperFactory = buildMapperFactoryAddDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(entry, Shop.class);
	}

}
