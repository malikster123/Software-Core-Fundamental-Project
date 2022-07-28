package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long id;
	private String item_name;
	private double price;
	
	
    public Item(String item_name,Double price) {
        this.setItem_name (item_name);
        this.setPrice (price);
    }

    public Item(Long id, String itemName, Double price) {
        this.id = id;
        this.setItem_name (itemName);
        this.setPrice (price);
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
//	public String getItem_category() {
//		return item_category;
//	}
//
//	public void setItem_category(String item_category) {
//		this.item_category = item_category;
//	}
	
	
	@Override
	public String toString() {
		return "id:" + id + " item name:" + item_name + "price: " + price;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, item_name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id 
				&& Objects.equals(item_name, other.item_name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}


	
}
