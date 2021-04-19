CREATE database if not exists studentDataBase;
use studentDataBase;
# create database IF NOT EXISTS studentDataBase;
# use studentDataBase;
# create table if not exists student (id int(20),name varchar(20),marks int(10));
# insert into student values(1,'anvesh',98);
# insert into student values(2,'ganesh',98);
# insert into student values(3,'chandu',98);
# insert into student values(4,'vamshi',98);
alter table studentDataBase.student add sid int(10) not null auto_increment primary key ;
# select * from student;

