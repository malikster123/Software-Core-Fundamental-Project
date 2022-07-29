package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {

	@Test
	public void toStringTest() {
		Order order = new Order(1l, 2l);
		String expected = "id:1 customer_id:2";
		assertEquals(expected, order.toString());
	}

	@Test
	public void firstConstructorTest() {
		Order order = new Order(1l, 2l);
		assertEquals(Long.valueOf(3),  order.getId());
		assertEquals(1, order.getCustomer_id(), 0.02);

	}

	@Test
	public void secondConstructorTest() {
		Customer customer = new Customer(1L, "Travis", "Touchdown");
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("Travis", customer.getFirstName());
		assertEquals("Touchdown", customer.getSurname());

	}
	
}
