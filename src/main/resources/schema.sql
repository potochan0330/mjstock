CREATE TABLE USER (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) DEFAULT NULL,
    created_time TIMESTAMP NOT NULL
);

CREATE TABLE PROFOLIO (
    id INT AUTO_INCREMENT,
    product_id VARCHAR(250) NOT NULL,
    product_type VARCHAR(250) NOT NULL,
    quantity INT DEFAULT NULL,
    PRIMARY KEY (id, product_id, product_type)
);

CREATE TABLE STOCK (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    code VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    start_price DOUBLE NOT NULL,
    latest_price DOUBLE NOT NULL,
    expected_return DOUBLE NOT NULL,
    annual_sd DOUBLE NOT NULL,
    created_time TIMESTAMP NOT NULL,
    last_updated_time TIMESTAMP NOT NULL
);


CREATE TABLE OPTIONS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    stock_id INT,
    code VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    start_price DOUBLE NOT NULL,
    latest_price DOUBLE NOT NULL,
    expected_return DOUBLE NOT NULL,
    annual_sd DOUBLE NOT NULL,
    created_time TIMESTAMP NOT NULL,
    last_updated_time TIMESTAMP
);
