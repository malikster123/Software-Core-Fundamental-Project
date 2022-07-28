package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long id;
	private String customer_id;
	

	public Order(String customer_id) {
		super();
		this.customer_id = customer_id;
	}
	
	
	public Order(Long id, String customer_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_id=" + customer_id + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(customer_id, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer_id, other.customer_id) && Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
