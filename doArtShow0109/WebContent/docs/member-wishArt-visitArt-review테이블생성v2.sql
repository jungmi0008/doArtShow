use artshowdb;

-- member 테이블
create table artshowdb.member (
email   varchar(45)  not null primary key, -- 이메일
name    varchar(10)  not null, -- 이름
birth    varchar(45)  not null, -- 생년월일
gender   varchar(10)  not null, -- 성별
pw      varchar(45) not null,  -- 비밀번호
profileImg varchar(45) default 'default.jpg'
) default character set utf8 collate utf8_general_ci;

insert into artshowdb.member(email, name, birth, gender, pw) values('jungmi0008@naver.com','홍길동','1993-08-16','여성','Class11!!');

select * from artshowdb.member;

-- wishArt 테이블
CREATE TABLE wishArt(
	email varchar(45) not null,
    exhID int not null,
    wishCheck int default 0 null,
    FOREIGN KEY(email) REFERENCES member(email),
    FOREIGN KEY(exhID) REFERENCES artshow(exhID)
) default character set utf8 collate utf8_general_ci;

-- visitArt 테이블
CREATE TABLE visitArt(
	email varchar(45) not null,
    exhID int not null,
    revCheck int default 0 null,
    visitCheck int default 0 null,
    FOREIGN KEY(email) REFERENCES member(email),
    FOREIGN KEY(exhID) REFERENCES artshow(exhID)
) default character set utf8 collate utf8_general_ci;

-- review 테이블
CREATE TABLE review(
	email varchar(45) not null,
    exhID int not null,
    revContent	varchar(100) not null, -- 리뷰내용은 글자수 제한할것임
    revDate date not null,
    FOREIGN KEY(email) REFERENCES member(email),
    FOREIGN KEY(exhID) REFERENCES artshow(exhID)
) default character set utf8 collate utf8_general_ci;























