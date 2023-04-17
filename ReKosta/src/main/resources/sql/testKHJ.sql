CREATE TABLE member (
  id VARCHAR(100) NOT NULL PRIMARY KEY,
  password VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL
);

insert into member(id, password, name)
values('seltise@naver.com','kosta250','김훈진');

select * from member;

commit

drop table member

CREATE TABLE authority (
  id varchar(100) primary key,
  role varchar(100) not null,
  constraint role_fk foreign key(id) references member(id),
  constraint role_check check(role='master' or role='general' or role='company')
);

insert into authority(id, role)
values('seltise@naver.com','master')

select * from authority;
select * from member;

commit

drop table authority

CREATE TABLE intro (
    post_no INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(100) NOT NULL,
    title VARCHAR(100) NOT NULL,
    content longtext,
    id VARCHAR(100) NOT NULL,
    constraint intro_fk foreign key(id) references member(id)
)

INSERT INTO intro (category, title, content, id)
VALUES ('회원사', 'Test', null, 'seltise@naver.com');

DELETE FROM intro WHERE post_no = 2;


select * from intro;

commit;

drop table intro;


SELECT i.title, i.post_date, i.category, m.name FROM (SELECT post_no, title, postDate, category, id, ROW_NUMBER() OVER(ORDER BY post_no DESC) AS rnum FROM intro) i INNER JOIN member m ON i.id = m.id WHERE rnum BETWEEN 1 AND 5

