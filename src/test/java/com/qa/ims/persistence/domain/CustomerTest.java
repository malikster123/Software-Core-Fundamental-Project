package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	

	@Test
	public void toStringTest() {
		Customer customer = new Customer(1L, "Jimmy", "John");
		String expected = "id:1 first name:Jimmy surname:John";
		assertEquals(expected, customer.toString());
	}

	@Test
	public void firstConstructorTest() {
		Customer customer = new Customer("Gandalf", "TheGrey");
		assertEquals("Gandalf", customer.getFirstName());
		assertEquals("TheGrey", customer.getSurname());

	}

	@Test
	public void secondConstructorTest() {
		Customer customer = new Customer(1L, "Travis", "Touchdown");
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("Travis", customer.getFirstName());
		assertEquals("Touchdown", customer.getSurname());

	}

}
