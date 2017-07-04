package com.lemon.productservice.service.model;

import java.math.BigDecimal;
import java.util.Date;

public class AddPrice extends BaseModel {
	
	private static final long serialVersionUID = 4563055131183722305L;
	
	private BigDecimal amount;
	private Date date;
	private AddProduct product;
	private AddShop shop;
	
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
	
	public AddProduct getProduct() {
		return product;
	}
	
	public void setProduct(AddProduct product) {
		this.product = product;
	}
	
	public AddShop getShop() {
		return shop;
	}
	
	public void setShop(AddShop shop) {
		this.shop = shop;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AddPrice))
			return false;
		AddPrice other = (AddPrice) obj;
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
		return "AddPrice [amount=" + amount + ", date=" + date + ", product=" + product + ", shop=" + shop + "]";
	}

}
