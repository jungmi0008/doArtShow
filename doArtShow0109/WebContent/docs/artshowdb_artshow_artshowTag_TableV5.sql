-- artshowdb를 오픈한다.
use artshowdb;
-- artshow 테이블 생성 
CREATE TABLE artshow (
    ExhID 		int			NOT NULL PRIMARY KEY,	-- 전시회ID  			(1)		
    MemberID	varchar(45)		NOT NULL,				-- 회원ID  			(2)
    EXhGubun1	varchar(30)		NOT NULL,				-- 전시분류1 개인전/단체전		(3)
    ExhGubun2	varchar(30)		NOT NULL, 				-- 전시분류2 장르			(4)
    ExhGubun4	varchar(30)		NOT NULL,				-- 전시분류3 전시관위치		(5)
    ExhName	varchar(100)		NOT NULL,				-- 전시명 				(6)
    ArtistName	varchar(100) 		NOT NULL,				-- 작가명				(7)
    ArtistInfo	text,								-- 작가정보			(8)
    ExhContent	text,								-- 전시내용			(9)
    ExhPlace	varchar(100)  		NOT NULL,				-- 전시장				(10)
    ExhPlaceZip	varchar(7)	 		NOT NULL,				-- 전시장짚코드			(11)
    ExhPlaceAddr1	varchar(100)		NOT NULL,				-- 전시장주소1			(12)
    ExhPlaceAddr2	varchar(100)		NOT NULL,				-- 전시장주소2			(13)
    ExhUrl		varchar(100),							-- 전시홈페이지 주소 		(14)
    exhstartdate	DATE			NOT NULL,				-- 전시시작일			(15)
    exhenddate	DATE			NOT NULL,				-- 전시종료일			(16)
    OpTime	VARCHAR(100)		NOT NULL,				-- 전시운영시간			(17)
    Tel		VARCHAR(30)		NOT NULL,				-- 전화번호			(18)
    AdmFee	VARCHAR(10)		NOT NULL,				-- 입장료 유료/무료			(19)
    ImageFile1	VARCHAR(100),							-- 포스터				(20)
    imageName1	VARCHAR(100),							-- 이미지명, 작품명			(21)
    imageType1	VARCHAR(100),							-- 이미지유형?, 작품유형		(22)	
    ImageFile2	VARCHAR(100),							-- 작품/전시전경1			(21)
    imageName2	VARCHAR(100),							-- 이미지명, 작품명			(21)
    imageType2	VARCHAR(100),							-- 이미지유형?, 작품유형		(22)
    imagefile3	VARCHAR(100),							-- 작품/전시전경2			(23)
    imageName3	VARCHAR(100),							-- 이미지명, 작품명			(24)
    imageType3	VARCHAR(100),							-- 이미지유형?, 작품유형		(25)
    imagefile4	VARCHAR(100),							-- 작품/전시전경3			(26)
    imageName4	VARCHAR(100),							-- 이미지명, 작품명			(27)
    imageType4	VARCHAR(100),							-- 이미지유형?, 작품유형		(28)
    ExhReadCount	INT,								-- 전시조회수			(29)
    RegisterDate	DATETIME			NOT NULL,				-- 전시등록일			(30)
    ActiveFlag	VARCHAR(1)		NOT NULL				-- 관리자Confirm for 전시등록 Y/N	(31)		
)default character set utf8 collate utf8_general_ci;

-- artshowTag 테이블 생성 
CREATE TABLE artshowtag (
    exhid 		int			NOT NULL,				-- 전시회ID	(1)			
    tagname	varchar(100)		NOT NULL				-- 태그명		(2)
)default character set utf8 collate utf8_general_ci;	    

-- 테이블 생성 되었는지 확인
show tables;

-- 테이블 레이아웃 확인 
desc artshow;
desc artshowtag; 


    

    
   