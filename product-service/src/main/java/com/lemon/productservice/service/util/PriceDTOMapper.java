package com.lemon.productservice.service.util;

import com.lemon.productservice.model.Price;
import com.lemon.productservice.service.model.AddPrice;
import com.lemon.productservice.service.model.GetPrice;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class PriceDTOMapper {
	
	private PriceDTOMapper() {
		throw new IllegalAccessError("Utility class");
	}

	private static MapperFactory buildMapperFactoryGetDTO() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Price.class, GetPrice.class).constructorB()
		.byDefault().register();
		return mapperFactory;
	}

	private static MapperFactory buildMapperFactoryAddDTO() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Price.class, AddPrice.class).constructorB()
		.byDefault().register();
		return mapperFactory;
	}

	public static GetPrice fromEntityToGetDTO(Price price) {
		MapperFactory mapperFactory = buildMapperFactoryGetDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(price, GetPrice.class);
	}

	public static AddPrice fromEntityToAddDTO(Price price) {
		MapperFactory mapperFactory = buildMapperFactoryAddDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(price, AddPrice.class);
	}

	public static Price toEntity(GetPrice entry) {
		MapperFactory mapperFactory = buildMapperFactoryGetDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(entry, Price.class);
	}

	public static Price toEntity(AddPrice entry) {
		MapperFactory mapperFactory = buildMapperFactoryAddDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(entry, Price.class);
	}

}
