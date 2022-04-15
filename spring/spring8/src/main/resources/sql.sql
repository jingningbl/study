use mybatis;
create table student(
    id integer primary key ,
    name varchar(20),
    address varchar(20)
);
insert into student(id, name, address) values (1,'张三','北京');
insert into student(id, name, address) values (2,'李四','上海');