package com.lemon.productservice.service.model;

import java.math.BigDecimal;
import java.util.Date;

public class GetPrice extends BaseModel {
	
	private static final long serialVersionUID = 83059814582294242L;
	
	private BigDecimal amount;
	private Date date;
	private GetProduct product;
	private GetShop shop;
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public GetProduct getProduct() {
		return product;
	}
	
	public void setProduct(GetProduct product) {
		this.product = product;
	}
	
	public GetShop getShop() {
		return shop;
	}
	
	public void setShop(GetShop shop) {
		this.shop = shop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GetPrice))
			return false;
		GetPrice other = (GetPrice) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GetPrice [amount=" + amount + ", date=" + date + ", product=" + product + ", shop=" + shop + "]";
	}
	
}
