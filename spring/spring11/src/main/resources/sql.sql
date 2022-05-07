use spring;
create table account
(
    id    INTEGER primary key auto_increment,
    aname varchar(20),
    money DOUBLE
);
insert into account(aname, money)
values ('张三', 5000);
insert into account(aname, money)
values ('李四', 2000);
drop table account;
select *
from account;
update account
set money=money + ?
where id = ?;
select money from account where id=?;
