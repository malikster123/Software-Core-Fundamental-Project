package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	
	private Long id;
	private Customer fkcustomer_id;
	private Long customer_id;
	

	public Order(Long customer_id) {
		super();
		this.customer_id = customer_id;
	}
	
	
	public Order(Long id, Long customer_id) {
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
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", fkcustomer_id=" + fkcustomer_id + ", customer_id=" + customer_id + "]";
	}


	public Customer getFkcustomer_id() {
		return fkcustomer_id;
	}


	public void setFkcustomer_id(Customer fkcustomer_id) {
		this.fkcustomer_id = fkcustomer_id;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		return result;
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
