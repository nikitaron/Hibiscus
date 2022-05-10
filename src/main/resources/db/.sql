DROP TABLE IF EXISTS users, cards, card_accounts, holdings, credits, passports, sns, transactions;

CREATE TABLE if not exists sns
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    surname    VARCHAR(255) NOT NULL,
    succession VARCHAR(255) NOT NULL
);
CREATE TABLE if not exists passports
(
    id            BIGSERIAL PRIMARY KEY,
    dob           TIMESTAMP                  NOT NULL,
    identity_code VARCHAR(14)                NOT NULL,
    sns_id        BIGINT REFERENCES sns (id) NOT NULL
);

CREATE DOMAIN email_varchar AS VARCHAR(50) CHECK (value ~ '/^\\S+@\\S+\\.\\S+$/') NOT NULL UNIQUE;

CREATE TABLE if not exists users
(
    id          BIGSERIAL PRIMARY KEY,
    email       email_varchar                    NOT NULL,
    password    VARCHAR(255)                     NOT NULL,
    passport_id BIGINT REFERENCES passports (id) NOT NULL
);

CREATE TYPE currency AS ENUM (
    'EUR', 'USD', 'BYN', 'RUB'
);

CREATE TABLE if not exists card_accounts
(
    id            BIGSERIAL PRIMARY KEY,
    money         DECIMAL                      NOT NULL,
    iban          VARCHAR(28)                  NOT NULL,
    number        VARCHAR(15)                  NOT NULL,
    currency_type currency                     NOT NULL,
    user_id       BIGINT REFERENCES users (id) NOT NULL
);
CREATE TABLE if not exists cards
(
    id              BIGSERIAL PRIMARY KEY,
    pin             VARCHAR(4)                           NOT NULL,
    number          VARCHAR(16)                          NOT NULL,
    cvv             VARCHAR(3)                           NOT NULL,
    expiration_time TIMESTAMP                            NOT NULL,
    user_id         BIGINT REFERENCES users (id)         NOT NULL,
    account_id      BIGINT REFERENCES card_accounts (id) NOT NULL
);

CREATE TABLE if not exists holdings
(
    id            BIGSERIAL PRIMARY KEY,
    issuance_date TIMESTAMP  NOT NULL,
    amount        DECIMAL    NOT NULL,
    percentage    DECIMAL    NOT NULL,
    currency_type currency   NOT NULL,
    passport_id   BIGINT REFERENCES passports (id)
);
CREATE TABLE if not exists credits
(
    id            BIGSERIAL PRIMARY KEY,
    issuance_date TIMESTAMP  NOT NULL,
    amount        DECIMAL    NOT NULL,
    currency_type currency   NOT NULL,
    passport_id   BIGINT REFERENCES passports (id)
);
CREATE TABLE if not exists transactions
(
    id               BIGSERIAL PRIMARY KEY,
    transaction_time TIMESTAMP   DEFAULT (current_timestamp),
    to_account       VARCHAR(15) NOT NULL,
    amount           DECIMAL     NOT NULL,
    currency_type    VARCHAR(4)  NOT NULL
);