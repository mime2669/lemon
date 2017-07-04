package com.lemon.productservice.service.model;

import java.util.List;

public class GetProduct extends BaseModel {

	private static final long serialVersionUID = 8958286763043472798L;
	
	private String name;
	private String description;
	private List<GetShop> shops;
	private List<GetPrice> prices;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<GetShop> getShops() {
		return shops;
	}
	
	public void setShops(List<GetShop> shops) {
		this.shops = shops;
	}
	
	public List<GetPrice> getPrices() {
		return prices;
	}
	
	public void setPrices(List<GetPrice> prices) {
		this.prices = prices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prices == null) ? 0 : prices.hashCode());
		result = prime * result + ((shops == null) ? 0 : shops.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof GetProduct))
			return false;
		GetProduct other = (GetProduct) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prices == null) {
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		if (shops == null) {
			if (other.shops != null)
				return false;
		} else if (!shops.equals(other.shops))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GetProduct [name=" + name + ", description=" + description + ", shops=" + shops + ", prices=" + prices
				+ "]";
	}
	
	

}
