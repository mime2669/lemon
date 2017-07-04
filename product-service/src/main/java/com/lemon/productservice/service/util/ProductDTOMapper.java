package com.lemon.productservice.service.util;

import com.lemon.productservice.model.Product;
import com.lemon.productservice.service.model.AddProduct;
import com.lemon.productservice.service.model.GetProduct;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ProductDTOMapper {
	
	private ProductDTOMapper() {
		throw new IllegalAccessError("Utility class");
	}

	private static MapperFactory buildMapperFactoryGetDTO() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Product.class, GetProduct.class).constructorB()
		.byDefault().register();
		return mapperFactory;
	}

	private static MapperFactory buildMapperFactoryAddDTO() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
		mapperFactory.classMap(Product.class, AddProduct.class).constructorB()
		.byDefault().register();
		return mapperFactory;
	}

	public static GetProduct fromEntityToGetDTO(Product product) {
		MapperFactory mapperFactory = buildMapperFactoryGetDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(product, GetProduct.class);
	}

	public static AddProduct fromEntityToAddDTO(Product product) {
		MapperFactory mapperFactory = buildMapperFactoryAddDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(product, AddProduct.class);
	}

	public static Product toEntity(GetProduct entry) {
		MapperFactory mapperFactory = buildMapperFactoryGetDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(entry, Product.class);
	}

	public static Product toEntity(AddProduct entry) {
		MapperFactory mapperFactory = buildMapperFactoryAddDTO();
		MapperFacade mapper = mapperFactory.getMapperFacade();
		return mapper.map(entry, Product.class);
	}

}
