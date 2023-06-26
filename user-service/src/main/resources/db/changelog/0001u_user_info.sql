--liquibase formatted sql
--changeset vishnu:change_user_info_0001

CREATE SEQUENCE IF NOT EXISTS user_info_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE user_info
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    CONSTRAINT pk_userinfo PRIMARY KEY (id)
);