drop table users;
drop sequence seq_users;
create sequence seq_users;
create table users (id number(5) primary key,uname varchar2(10),age number(2),psd varchar2(10));

select * from users;