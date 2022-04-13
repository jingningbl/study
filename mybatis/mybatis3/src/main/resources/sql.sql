use spring;
show tables ;
select * from student ;
insert into student(id,name, address) values (2,'lisi','156');
desc student;
alter table student add birthday datetime;
alter table student change birthday my_birthday datetime;
insert into student(id, name, address) values (3,'lisi','beijing');
update student set name=?,address=? where id=?;
delete from student where id=?;
select last_insert_id();

select * from student where id=1;
select * from course where course_id=1;