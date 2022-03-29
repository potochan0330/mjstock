
--INSERT INTO CUSTOMER (first_name, last_name, email, created_time) VALUES ('Wong', 'Alice', 'alicewong@gmail.com', now());
--INSERT INTO CUSTOMER (first_name, last_name, email, created_time) VALUES ('Li', 'Bob', 'bobli@gmail.com', now());


INSERT INTO STOCK (code ,name ,start_price ,latest_price ,expected_return ,annual_sd ,created_time, quantity)
VALUES ('AAA', 'AAA company', 3.45, 3.53, 0.14, 0.25, now(), 204);
INSERT INTO STOCK (code ,name ,start_price ,latest_price ,expected_return ,annual_sd ,created_time, quantity)
VALUES ('BBB', 'BBB company', 204.51, 405.00, 0.72, 0.17, now(), 41);
INSERT INTO STOCK (code ,name ,start_price ,latest_price ,expected_return ,annual_sd ,created_time, quantity)
VALUES ('CCC', 'CCC company', 16.55, 3.15, 0.64, 0.47, now(), 89);

INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity)
VALUES ('AAA', 1, 36.05, now(), 1.8, 0, 134);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity)
VALUES ('AAA', 2, 0.45, now(), 0.35, 0, 34);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity)
VALUES ('BBB', 1, 505.55, now(), 0.6, 0, 32);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity)
VALUES ('BBB', 2, 250.45, now(), 2.5, 0, 25);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity)
VALUES ('CCC', 1, 36.05, now(), 1.6, 0, 149);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity)
VALUES ('CCC', 2, 1.45, now(), 0.5, 0, 85);

--INSERT INTO TRANSACTION (product_code, customer_id, product_type, price, quantity)
--VALUES ('AAA', 1, 1, 3.5, 100);
--INSERT INTO TRANSACTION (product_code, customer_id, product_type, price, quantity)
--VALUES ('AAA', 1, 1, 1.5, 10);
--INSERT INTO TRANSACTION (product_code, customer_id, product_type, price, quantity)
--VALUES ('BBB', 1, 1, 265.63, 500);
--INSERT INTO TRANSACTION (product_code, customer_id, product_type, price, quantity)
--VALUES ('BBB', 1, 1, 198.53, 1000);
--INSERT INTO TRANSACTION (product_code, customer_id, product_type, price, quantity)
--VALUES ('AAA', 2, 1, 2, 423);
--INSERT INTO TRANSACTION (product_code, customer_id, product_type, price, quantity)
--VALUES ('CCC', 2, 1, 20, 500);

