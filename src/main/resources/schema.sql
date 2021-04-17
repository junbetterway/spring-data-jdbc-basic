DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS savings_account;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id	BIGSERIAL NOT NULL PRIMARY KEY,
    first_name	VARCHAR(255) NULL,
    last_name	VARCHAR(255) NOT NULL
);

CREATE TABLE address (
    customer	BIGSERIAL PRIMARY KEY REFERENCES customer(id),
    city	VARCHAR(255) NULL,
    state	VARCHAR(255) NULL,
    country	VARCHAR(255) NOT NULL
);

CREATE TABLE savings_account (
    id	BIGSERIAL NOT NULL PRIMARY KEY,
    account_number	VARCHAR(255) NOT NULL,
    balance	NUMERIC,
    customer BIGINT NOT NULL
);