CREATE TABLE khj_member_test (
  id VARCHAR(100) NOT NULL PRIMARY KEY,
  password VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL
);

insert into khj_member_test(id, password, name)
values('seltise@naver.com','kosta250','김훈진');

select * from khj_member_test;

commit

drop table khj_member_test

CREATE TABLE khj_authentication_test (
  id varchar(100) primary key,
  role varchar(100) not null,
  constraint role_fk foreign key(id) references khj_member_test(id),
  constraint role_check check(role='Master' or role='general' or role='company')
);

insert into khj_authentication_test(id, role)
values('seltise@naver.com','Master')

select * from khj_authentication_test;
select * from khj_member_test;

commit

drop table khj_authentication_test
