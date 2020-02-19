create user 'artmaster'@'localhost'
identified  by '1111';

create user 'artmaster'@'%'
identified  by '1111';

create database artshowdb
default character set utf8
collate utf8_general_ci;



grant all privileges on artshowdb.* 
to 'artmaster'@'localhost'
with grant option;

grant all privileges on artshowdb.* 
to 'artmaster'@'%'
with grant option;

use artshowdb;


create table artshowdb.member (
email   varchar(45)  not null primary key, -- 이메일
name    varchar(10)  not null, -- 이름
birth    varchar(45)  not null, -- 생년월일
gender   varchar(10)  not null, -- 성별
pw      varchar(45)  null, -- 비밀번호
profileImg varchar(45) null,
kakaoId varchar(30) null,
naverId varchar(30) null
) default character set utf8 collate utf8_general_ci;

insert into artshowdb.member(email, name, birth, gender, pw) values('jungmi0008@naver.com','길정미','1993-08-16','여성','Qp2ql134!');
select * from artshowdb.member;

