
drop table users;

create sequence seq_users;
create sequence seq_addrs;

create table users (id number(5) primary key,u_name varchar2(10),age number(2));
create table addrs (id number(5) primary key,addr_name varchar2(10),u_id number(5));


select * from addrs;
select * from users;