--CREATE TABLE CUSTOMER (
--    id INT AUTO_INCREMENT  PRIMARY KEY,
--    first_name VARCHAR(250) NOT NULL,
--    last_name VARCHAR(250) NOT NULL,
--    email VARCHAR(250) DEFAULT NULL,
--    created_time TIMESTAMP NOT NULL
--);

CREATE TABLE STOCK (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    code VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    quantity INT NOT NULL,
    start_price DOUBLE NOT NULL,
    latest_price DOUBLE NOT NULL,
    expected_return DOUBLE NOT NULL,
    annual_sd DOUBLE NOT NULL,
    created_time TIMESTAMP NOT NULL
);


CREATE TABLE OPTIONS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    code VARCHAR(250) NOT NULL REFERENCES STOCK(code),
    type INT NOT NULL,
    option_price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    maturity_year DOUBLE NOT NULL,
    strike_price DOUBLE NOT NULL,
    created_time TIMESTAMP NOT NULL
);


--CREATE TABLE TRANSACTION (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    product_code VARCHAR(250) REFERENCES STOCK(code),
--    customer_id VARCHAR(250) REFERENCES CUSTOMER(id),
--    product_type VARCHAR(250) NOT NULL,
--    price DOUBLE NOT NULL,
--    quantity INT NOT NULL
--);
