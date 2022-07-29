Coverage: 59.8%

# Jira Link
[subhaanmalik](https://subhaanmalik.atlassian.net/jira/software/projects/IP/boards/2/roadmap)

# Fundamental Project: Inventory Management System

This is my project for the Inventory Management System. This showcases the skills I have gained over the last 5 weeks with QA Academy.
This program was written in Java, and the database was created and stored in MySQL, which was then connected and transported into Java. The IMS allows users to perform basic CRUD functionality. After an order is placed, the system provides an Items ID, Quantity, and Total Cost.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
- Java 8 JDK
- Maven
- MySQL Version 8 or higher
- Git
- JUnit

```

### Installing

1. Clone this repository

```
 git clone https://github.com/malikster123/Software-Core-Fundamental-Project.git
```
2. inside your terminal run: 
```cd ims mvn java -jar```
This will result in an executable .jar file that can be run by the JVM.
Open the project in your IDE of choice (the project was developed in Eclipse).

Once built and opened, the application can be used to manipulate the database. First, select a table to perform operations on. Then, select the operation. The application will ask for information and manipulate the database accordingly.

## Running the tests


In Eclipse, unit tests and integration tests can be run manually (by right-clicking on them and choosing Run As -> JUnit Test or by pressing Ctrl+F11) or automatically, for example, by deploying the project to a Jenkins server that builds it periodically using Maven. 

### Unit Tests 

Unit tests isolate written code to test and determine if it works as intended. here i am passing unit tests for my items class 

```
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
```

### Integration Tests 

INTEGRATION TESTING is defined as a type of testing where software modules are integrated logically and tested as a group. A typical software project consists of multiple software modules, coded by different programmers. The purpose of this level of testing is to expose defects in the interaction between these software modules when they are integrated

here below is an example of my integration tests for my item controller
```

	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;

	@Test
	public void testCreate() {
		final String item_name = "barry";
		final Double price = 20.20;
		final Item created = new Item(item_name, price);

		Mockito.when(utils.getString()).thenReturn(item_name);
		Mockito.when(utils.getDouble()).thenReturn(price);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> item = new ArrayList<>();
		item.add(new Item( "jordan", 35.60));

		Mockito.when(dao.readAll()).thenReturn(item);

		assertEquals(item, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item("bar", 20.21);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItem_name());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
```
```

## Deployment

mvn deploy
Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Subhaan Malik**

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
