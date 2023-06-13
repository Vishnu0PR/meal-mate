--liquibase formatted sql
--changeset vishnu:change_0001

CREATE TABLE test (id BIGINT NOT NULL,
                  name VARCHAR(50),
                   PRIMARY KEY(id));