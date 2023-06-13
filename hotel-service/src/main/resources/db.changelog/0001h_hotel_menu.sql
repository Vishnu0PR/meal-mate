-- liquibase formatted sql
--changeset vishnu:change_0002

CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence START WITH 1001 INCREMENT BY 15;

CREATE TABLE hotel_menu (
  item_id BIGINT NOT NULL,
   item_name VARCHAR(255) NOT NULL,
   category VARCHAR(255),
   type VARCHAR(255),
   price DECIMAL NOT NULL,
   is_avail BOOLEAN,
   CONSTRAINT pk_hotel_menu PRIMARY KEY (item_id)
);
