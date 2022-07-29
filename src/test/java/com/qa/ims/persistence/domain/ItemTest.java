package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

    @Test
    public void toStringTEST() {
        Item item = new Item(1L, "PLAYSTATION 5", 400.99);
        String expected = "Item [id=1, itemName=PS5,  price=400.99]";
        assertEquals(expected, item.toString());
    }

    @Test
    public void firstConstructorTEST() {
        Item item = new Item("PS5", 400.99);
        assertEquals("PS5", item.getItem_name());
        assertEquals(400.99, item.getPrice(), 0.02);
    }

    @Test
    public void secondConstructorTEST() {
        Item item = new Item(1L, "PS5", 500.00);
        assertEquals(Long.valueOf("1"), item.getId());
        assertEquals("XBOX", item.getItem_name());
        assertEquals(500.00, item.getPrice(), 0.02);

    }


    @Test
    public void setIdTEST() {
        Item item = new Item(1L, "PS5", 400.99);
        item.setId(2L);
        assertEquals(Long.valueOf("2"), item.getId());

    }

    @Test
    public void setItemNameTEST() {
        Item item = new Item(1L, "PS5", 400.99);
        item.setItem_name("NINTENDO SWITCH");
        assertEquals("NINTENDO SWITCH", item.getItem_name());
    }

    @Test
    public void setItemCategoryTEST() {
        Item item = new Item(1L, "PS5", 400.99);

    }

    @Test
    public void setPriceTEST() {
        Item item = new Item(1L, "XBOX", 400.99);
        item.setPrice(5000);
        assertEquals(5000, item.getPrice(), 0.02);

    }

}
