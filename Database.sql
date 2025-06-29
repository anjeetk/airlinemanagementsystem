CREATE DATABASE airlinemanagementsystem;
USE airlinemanagementsystem;

CREATE TABLE login(username VARCHAR(20), password varchar(20));
CREATE TABLE customer(name VARCHAR(20), nationality VARCHAR(20), phone VARCHAR(15), address VARCHAR(30),adhar VARCHAR(12),gender VARCHAR(8));
CREATE TABLE flightInfo(flight_code VARCHAR(8),flight_name VARCHAR(15),source VARCHAR(15),destination VARCHAR(15));
CREATE TABLE reservation(PNR VARCHAR(10), ticket VARCHAR(10), adhar VARCHAR(12), name VARCHAR(30),nationality VARCHAR(20),flight_code VARCHAR(12),flight_name VARCHAR(15),source VARCHAR(15),destination VARCHAR(15),travel_date VARCHAR(15));
CREATE TABLE CANCEL(cancelNo VARCHAR(12),PNR VARCHAR(12),NAME VARCHAR(30),cancelDate VARCHAR(15));
 
INSERT INTO login values('admin','admin');
show tables;