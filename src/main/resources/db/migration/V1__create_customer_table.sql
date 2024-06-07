create schema if not exists users;
create extension if not exists pgcrypto;
create table if not exists users.customer(
    id_customers int primary key ,
    bank_account_id numeric(20,0) not null unique ,
    phone_number character(11) not null unique ,
    password text not null unique
);