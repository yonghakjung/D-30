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
  constraint role_check check(role='master' or role='general' or role='company')
);

insert into khj_authentication_test(id, role)
values('seltise@naver.com','master')

select * from khj_authentication_test;
select * from khj_member_test;

commit

drop table khj_authentication_test

CREATE TABLE intro (
    post_no INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(100) NOT NULL,
    title VARCHAR(100) NOT NULL,
    content LONGTEXT NOT NULL,
    id VARCHAR(100) NOT NULL,
    post_date DATE NOT NULL,
    update_date DATE,
    constraint intro_fk foreign key(id) references khj_member_test(id)
)

INSERT INTO intro (category, title, content, id, post_date, update_date)
VALUES ('회원사', '제목', '내용', 'seltise@naver.com', CURRENT_DATE(), NULL);

DELETE FROM intro WHERE post_no = 2;


select * from intro;

commit;

drop table intro;
