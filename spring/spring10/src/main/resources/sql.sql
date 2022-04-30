create database spring_jdbc;
use spring_jdbc;
create table student(
    id integer primary key auto_increment,
    name varchar(20),
    age integer,
    address varchar(20)
);