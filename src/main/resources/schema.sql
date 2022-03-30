
CREATE TABLE STOCK (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    code VARCHAR(250) NOT NULL,
    name VARCHAR(250) NOT NULL,
    quantity INT NOT NULL,
    start_price DOUBLE NOT NULL,
    latest_price DOUBLE NOT NULL,
    expected_return DOUBLE NOT NULL,
    annual_sd DOUBLE NOT NULL,
    position INT NOT NULL,
    created_time TIMESTAMP NOT NULL
);


CREATE TABLE OPTIONS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    code VARCHAR(250) NOT NULL REFERENCES STOCK(code),
    type INT NOT NULL,
    option_price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    position INT NOT NULL,
    maturity_year DOUBLE NOT NULL,
    strike_price DOUBLE NOT NULL,
    created_time TIMESTAMP NOT NULL
);
