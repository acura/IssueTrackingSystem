


create table its_master
(
oid int(10) not null,
issue_date Date not null,
developer_name varchar(50) not null,
project varchar(50) not null,
issue_no varchar(20)not null ,
hours double(13,2) not null,
comment  varchar(1000) ,
activity varchar(50) not null,
created_date date null default null,
last_updated_date date null default null,
primary key (oid)
)