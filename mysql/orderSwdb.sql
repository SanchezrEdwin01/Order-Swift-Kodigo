CREATE DATABASE orderSwift;

USE orderSwift;

CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(30) NULL,
	first_name VARCHAR(30),
    last_name VARCHAR(30),
	user_password VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
    phone_num VARCHAR(9) NULL,
    user_email VARCHAR(30) NULL,
    user_rol VARCHAR(8)
);

CREATE TABLE orders(
    order_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER,
    order_date DATETIME NUll,
    order_status VARCHAR(12) NULL,
    total_amount DECIMAL(10, 2) NULL,
    foreign key (user_id) REFERENCES users (user_id) 
);

CREATE TABLE products(
    product_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) NULL,
    product_descrip VARCHAR(250) NULL,
    price DECIMAL(10, 2) NULL
);

CREATE TABLE ordersDetails(
    order_detail_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    order_id INTEGER,
    product_id INTEGER,
    quantity INTEGER NULL,
    unit_price DECIMAL(10, 2) NULL,
    foreign key (order_id) REFERENCES orders(order_id),
    foreign key (product_id) REFERENCES products(product_id)
);

CREATE TABLE categories(
	category_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NULL
);

CREATE TABLE transactions(
	transaction_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER,
    order_id INTEGER,
    transactions_date DATETIME NULL,
    amount DECIMAL(10, 2) NULL,
    payment_method VARCHAR(15),
    foreign key (user_id) REFERENCES users (user_id),
    foreign key (order_id) REFERENCES orders(order_id)
);

CREATE TABLE products_categories(
	category_id INTEGER,
    product_id INTEGER,
    foreign key (category_id) REFERENCES categories(category_id),
    foreign key (product_id) REFERENCES products(product_id)
); 
