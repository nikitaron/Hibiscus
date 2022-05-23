DROP TABLE IF EXISTS users, cards, card_accounts, holdings, credits, passports, sns, transactions, users;

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

CREATE TABLE if not exists users
(
    id          BIGSERIAL PRIMARY KEY,
    email       varchar(50) CHECK (users.email ~ '/^\\S+@\\S+\\.\\S+$/')
                                                 NOT NULL UNIQUE,
    password    VARCHAR(255)                     NOT NULL,
    passport_id BIGINT REFERENCES passports (id) NOT NULL
);

CREATE TABLE if not exists card_accounts
(
    id            BIGSERIAL PRIMARY KEY,
    money         DECIMAL     NOT NULL,
    iban          VARCHAR(28) NOT NULL,
    number        VARCHAR(15) NOT NULL,
    currency_type VARCHAR(10)    NOT NULL
);

CREATE TABLE if not exists cards
(
    id              BIGSERIAL PRIMARY KEY,
    pin             VARCHAR(4)                           NOT NULL,
    number          VARCHAR(16)                          NOT NULL,
    cvv             VARCHAR(3)                           NOT NULL,
    expiration_time TIMESTAMP CHECK (EXTRACT(YEAR FROM expiration_time)::int >
                                     EXTRACT(YEAR FROM current_timestamp)::int),
    user_id         BIGINT REFERENCES users (id)         NOT NULL,
    account_id      BIGINT REFERENCES card_accounts (id) NOT NULL
);

CREATE TABLE if not exists holdings
(
    id            BIGSERIAL PRIMARY KEY,
    issuance_date TIMESTAMP  NOT NULL,
    amount        DECIMAL    NOT NULL,
    percentage    DECIMAL    NOT NULL,
    currency_type VARCHAR(4) NOT NULL,
    passport_id   BIGINT REFERENCES passports (id)
);

CREATE TABLE if not exists credits
(
    id            smallint PRIMARY KEY,
    issuance_date TIMESTAMP  NOT NULL,
    amount        DECIMAL    NOT NULL,
    currency_type VARCHAR(4) NOT NULL,
    passport_id   BIGINT     NOT NULL UNIQUE,
    FOREIGN KEY (passport_id) REFERENCES passports (id)
);
CREATE TABLE if not exists transactions
(
    id               BIGSERIAL PRIMARY KEY,
    transaction_time TIMESTAMP DEFAULT (current_timestamp),
    to_account       VARCHAR(15) NOT NULL,
    amount           DECIMAL     NOT NULL,
    currency_type    VARCHAR(4)  NOT NULL
);