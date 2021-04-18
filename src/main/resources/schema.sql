DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS savings_account;
DROP TABLE IF EXISTS customer_grouploan;
DROP TABLE IF EXISTS wallet_account;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS group_loan;

CREATE TABLE customer (
    id	BIGSERIAL NOT NULL PRIMARY KEY,
    first_name	VARCHAR(255) NULL,
    last_name	VARCHAR(255) NOT NULL,
    civil_status	VARCHAR(1) NOT NULL
);

CREATE TABLE address (
    customer_id	BIGINT PRIMARY KEY REFERENCES customer(id),
    city	VARCHAR(255) NULL,
    state	VARCHAR(255) NULL,
    country	VARCHAR(255) NOT NULL
);

CREATE TABLE savings_account (
    id	BIGSERIAL NOT NULL PRIMARY KEY,
    account_number	VARCHAR(255) NOT NULL,
    balance	NUMERIC,
    customer_id BIGINT NOT NULL
);

CREATE TABLE group_loan (
    id	BIGSERIAL NOT NULL PRIMARY KEY,
    account_number	VARCHAR(255) NOT NULL,
    principal	NUMERIC,
    charges	NUMERIC,
    interest	NUMERIC
);

CREATE TABLE customer_grouploan (
    customer_id	BIGINT,
    group_loan_id	BIGINT,
    PRIMARY KEY(customer_id, group_loan_id)
);

CREATE TABLE wallet_account (
    id	BIGSERIAL NOT NULL PRIMARY KEY,
	wallet_type	VARCHAR(50) NOT NULL,
    account_number	VARCHAR(255) NOT NULL,
    balance	NUMERIC,
    customer_id BIGINT NOT NULL
);