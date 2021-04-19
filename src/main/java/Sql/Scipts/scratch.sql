use studentDataBase;
create database IF NOT EXISTS studentDataBase;
use studentDataBase;
create table if not exists student
(
    Name  varchar(20),
    Grade varchar(2),
    regNo int(10)
);
select *
from student;
