
INSERT INTO STOCK (code ,name ,start_price ,latest_price ,expected_return ,annual_sd ,created_time, quantity, position)
VALUES ('AAA', 'AAA company', 3.45, 3.53, 0.14, 0.25, now(), 204, 1);
INSERT INTO STOCK (code ,name ,start_price ,latest_price ,expected_return ,annual_sd ,created_time, quantity, position)
VALUES ('BBB', 'BBB company', 204.51, 405.00, 0.72, 0.17, now(), 41, 1);
INSERT INTO STOCK (code ,name ,start_price ,latest_price ,expected_return ,annual_sd ,created_time, quantity, position)
VALUES ('CCC', 'CCC company', 16.55, 3.15, 0.64, 0.47, now(), 89, -1);

INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity, position)
VALUES ('AAA', 1, 36.05, now(), 1.8, 0, 134, 1);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity, position)
VALUES ('AAA', 2, 0.45, now(), 0.35, 0, 34, -1);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity, position)
VALUES ('BBB', 1, 505.55, now(), 0.6, 0, 32, 1);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity, position)
VALUES ('BBB', 2, 250.45, now(), 2.5, 0, 25, 1);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity, position)
VALUES ('CCC', 1, 36.05, now(), 1.6, 0, 149, -1);
INSERT INTO OPTIONS(code, type, strike_price, created_time, maturity_year, option_price, quantity, position)
VALUES ('CCC', 2, 1.45, now(), 0.5, 0, 85, -1);

