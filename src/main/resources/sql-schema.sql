drop database if exists IMS; 
CREATE DATABASE IF NOT EXISTS IMS;
USE IMS;

CREATE TABLE customers (
    id int AUTO_INCREMENT,
    first_name varchar(40),
    surname varchar(40),
    PRIMARY KEY (id)
    );

CREATE TABLE items (
    id INT AUTO_INCREMENT,
    item_name varchar(40),
    price decimal(9,3),
    PRIMARY KEY (id)
    );


CREATE TABLE orders (
    id int AUTO_INCREMENT,
    customer_id INT,
   
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) 
        REFERENCES customers(id)
    );

CREATE TABLE order_items (
    id INT AUTO_INCREMENT,
    item_id INT,
    order_id INT,
    quantity INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id)
        REFERENCES orders(id),
    FOREIGN KEY (item_id)
        REFERENCES items(id)
);