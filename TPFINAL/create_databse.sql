CREATE DATABASE inventario;
USE inventario;

CREATE TABLE salesman(
	salesman_id int auto_increment,
	name varchar(30),
	city varchar(15),
	commission decimal(5,2),
	PRIMARY KEY(salesman_id)
);

CREATE TABLE customer(
	customer_id int auto_increment,
	cust_name varchar(30),
	city varchar(15),
	grade numeric(3),
	PRIMARY KEY(customer_id)
);

CREATE TABLE orders(
	ord_no int auto_increment,
	purch_amt decimal(8,2),
	ord_date date,
	customer_id int,
	salesman_id int,
	PRIMARY KEY (ord_no),
	FOREIGN KEY (customer_id) references customer(customer_id),
	FOREIGN KEY (salesman_id) references salesman(salesman_id)
);

show tables;