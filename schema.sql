create database hibernate_db;
use hibernate_db;

create table entities(
id int not null auto_increment,
property_one varchar(10) not null,
property_two int(5),
property_three bool not null,
primary key (id)
);
