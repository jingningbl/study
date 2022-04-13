use spring;
#案例3.3
create table stu_class
(
    cid   int primary key auto_increment,
    cname varchar(20),
    sum   int
);
create table stu_info
(
    sid     int primary key auto_increment,
    sname   varchar(20),
    age     varchar(20),
    course  varchar(20),
    classId int,
    foreign key (classId) references stu_class (cid)
);
insert into stu_class(cname, sum)
VALUES ('Java1801', 50);
insert into stu_class(cname, sum)
VALUES ('Java1802', 46);
insert into stu_info(sname, age, course, classId)
VALUES ('zhangsan', '20', 'Java', 1);
insert into stu_info(sname, age, course, classId)
VALUES ('lisi', '21', 'Java', 2);
insert into stu_info(sname, age, course, classId)
VALUES ('wangWu', '20', 'Java', 1);
insert into stu_info(sname, age, course, classId)
VALUES ('zhouLiu', '19', 'Java', 1);
#案例3.4
create table class_info
(
    cid   int primary key auto_increment,
    cname varchar(20),
    sum   int
);
create table teach_info
(
    tid    int primary key auto_increment,
    tname  varchar(20),
    age    varchar(20),
    course varchar(20)
);
create table class_teach
(
    id       int primary key auto_increment,
    class_id int,
    teach_id int,
    foreign key (class_id) references class_info (cid),
    foreign key (teach_id) references teach_info (tid)
);
insert into class_info(cname, sum)
VALUES ('Java1801', 50);
insert into class_info(cname, sum)
VALUES ('Java1802', 46);
insert into teach_info(tname, age, course)
VALUES ('zhangsan', '31', 'JavaSE');
insert into teach_info(tname, age, course)
VALUES ('lisi', '33', 'JavaWeb');
insert into class_teach(class_id, teach_id)
VALUES (1, 1);
insert into class_teach(class_id, teach_id)
VALUES (2, 1);
insert into class_teach(class_id, teach_id)
VALUES (1, 2);