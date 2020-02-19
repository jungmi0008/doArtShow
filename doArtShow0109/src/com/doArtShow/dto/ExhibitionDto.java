package com.doArtShow.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

//전시정보
public class ExhibitionDto {
	private int 			exhID; //전시회 등록 ID
	private String			memberID; //신청자
	private String			exhGubun1; //분류
	private String			exhGubun2; //장르
	private String			exhGubun4; //전시관위치
	private String 			exhName; //전시회명
	private String			artistName; //작가명
	private String			artistInfo; //작가정보
	private String 			exhContent; //전시내용
	private String 			exhPlace; //전시관명
	private String 			exhPlaceZip; //전시관우편번호
	private String 			exhPlaceAddr1; //전시관주소1
	private String			exhPlaceAddr2; //전시관주소2
	private String 			exhUrl; //전시관홈페이지주소
	private String			exhStartDate; //전시시작일
	private String			exhEndDate; //전시종료일
	private String			opTime; //운영시간
	private String 			tel; //전시관전화번호
	private String 			admFee; //입장료
	private String			imageFile1; //전시회 포스터
	private String 			imageName1; //이미지명, 작품명 			//newly added by Hojeong @200120
	private String			imageType1; //작품유형, 이미지유형		//newly added by Hojeong @200120
	private String 			imageFile2; //작품, 전시전경1
	private String 			imageName2; //이미지명, 작품명 			//newly added by Hojeong @200120
	private String			imageType2; //작품유형, 이미지유형		//newly added by Hojeong @200120
	private String 			imageFile3; //작품, 전시전경2 *NULL가능
	private String 			imageName3; //이미지명, 작품명 			//newly added by Hojeong @200120
	private String			imageType3; //작품유형, 이미지유형 		//newly added by Hojeong @200120
	private String 			imageFile4; //작품, 전시전경3 *NULL가능
	private String 			imageName4; //이미지명, 작품명 			//newly added by Hojeong @200120
	private String			imageType4; //작품유형, 이미지유형		//newly added by Hojeong @200120
	private int				exhReadCount; //전시조회수
	private Timestamp		registerDate; //전시등록일
	private String			activeFlag; //관리자컨펌여부
	private String 			exhGubun3[]; //태그
	
	
	
	
	public ExhibitionDto() {}// ManagerDao 전용 생성자
	
	public ExhibitionDto(int exhID, String memberID, String exhGubun1, String exhGubun2, String exhGubun4, 
			String exhName, String artistName, String artistInfo, String exhContent, String exhPlace, 
			String exhPlaceZip, String exhPlaceAddr1, String exhPlaceAddr2, String exhUrl, 
			String exhStartDate, String exhEndDate, String opTime, String tel, String admFee, 
			String imageFile1, String imageFile2, String imageFile3, String imageFile4,
			//String imageName1, String imageName2, String imageName3, String imageName4,
			//String imageType1, String imageType2, String imageType3, String imageType4,
			int exhReadCount, Timestamp registerDate, String activeFlag) {
		this.exhID = exhID;
		this.memberID = memberID;
		this.exhGubun1 = exhGubun1;
		this.exhGubun2 = exhGubun2;
		this.exhGubun4 = exhGubun4;
		this.exhName = exhName;
		this.artistName = artistName;
		this.artistInfo = artistInfo;
		this.exhContent = exhContent;
		this.exhPlace = exhPlace;
		this.exhPlaceZip = exhPlaceZip;
		this.exhPlaceAddr1 = exhPlaceAddr1;
		this.exhPlaceAddr2 = exhPlaceAddr2;
		this.exhUrl = exhUrl;
		this.exhStartDate = exhStartDate;
		this.exhEndDate = exhEndDate;
		this.opTime = opTime;
		this.tel = tel;
		this.admFee = admFee;
		this.imageFile1 = imageFile1;
		this.imageFile2 = imageFile2;
		this.imageFile3 = imageFile3;
		this.imageFile4 = imageFile4;
		/*
		this.imageName1 = imageName1;	//newly added by Hojeong @20/01/20
		this.imageName2 = imageName2;	//newly added by Hojeong @20/01/20
		this.imageName3 = imageName3;	//newly added by Hojeong @20/01/20
		this.imageName4 = imageName4;	//newly added by Hojeong @20/01/20
		this.imageType1 = imageType1;	//newly added by Hojeong @20/01/20
		this.imageType2 = imageType2;	//newly added by Hojeong @20/01/20
		this.imageType3 = imageType3;	//newly added by Hojeong @20/01/20
		this.imageType4 = imageType4;	//newly added by Hojeong @20/01/20
		*/
		this.exhReadCount = exhReadCount;
		this.registerDate = registerDate;
		this.activeFlag = activeFlag;
	}// ManagerDao 전용 생성자2
	
	public ExhibitionDto(int exhID, String memberID, String exhGubun1, String exhGubun2, String exhGubun4,
			String exhName, String artistName, String artistInfo, String exhContent, String exhPlace, 
			String exhPlaceZip, String exhPlaceAddr1, String exhPlaceAddr2, String exhUrl, 
			String exhStartDate, String exhEndDate, String opTime, String tel, String admFee, 
			String imageFile1, String imageFile2, String imageFile3, String imageFile4, 
			//String imageName1, String imageName2, String imageName3, String imageName4,
			//String imageType1, String imageType2, String imageType3, String imageType4,
			int exhReadCount, Timestamp registerDate, String activeFlag, String[] exhGubun3) {
		this.exhID = exhID;
		this.memberID = memberID;
		this.exhGubun1 = exhGubun1;
		this.exhGubun2 = exhGubun2;
		this.exhGubun4 = exhGubun4;
		this.exhName = exhName;
		this.artistName = artistName;
		this.artistInfo = artistInfo;
		this.exhContent = exhContent;
		this.exhPlace = exhPlace;
		this.exhPlaceZip = exhPlaceZip;
		this.exhPlaceAddr1 = exhPlaceAddr1;
		this.exhPlaceAddr2 = exhPlaceAddr2;
		this.exhUrl = exhUrl;
		this.exhStartDate = exhStartDate;
		this.exhEndDate = exhEndDate;
		this.opTime = opTime;
		this.tel = tel;
		this.admFee = admFee;
		this.imageFile1 = imageFile1;
		this.imageFile2 = imageFile2;
		this.imageFile3 = imageFile3;
		this.imageFile4 = imageFile4;
		/*
		this.imageName1 = imageName1;	//newly added by Hojeong @20/01/20
		this.imageName2 = imageName2;	//newly added by Hojeong @20/01/20
		this.imageName3 = imageName3;	//newly added by Hojeong @20/01/20
		this.imageName4 = imageName4;	//newly added by Hojeong @20/01/20
		this.imageType1 = imageType1;	//newly added by Hojeong @20/01/20
		this.imageType2 = imageType2;	//newly added by Hojeong @20/01/20
		this.imageType3 = imageType3;	//newly added by Hojeong @20/01/20
		this.imageType4 = imageType4;	//newly added by Hojeong @20/01/20
		*/
		this.exhReadCount = exhReadCount;
		this.registerDate = registerDate;
		this.activeFlag = activeFlag;
		this.exhGubun3 = exhGubun3;
	}// ManagerDao 전용 생성자3
	
	
	
	
	
	public int getExhID() {
		return exhID;
	}
	public void setExhID(int exhID) {
		this.exhID = exhID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getExhGubun1() {
		return exhGubun1;
	}
	public void setExhGubun1(String exhGubun1) {
		this.exhGubun1 = exhGubun1;
	}
	public String getExhGubun2() {
		return exhGubun2;
	}
	public void setExhGubun2(String exhGubun2) {
		this.exhGubun2 = exhGubun2;
	}
	public String getExhGubun4() {
		return exhGubun4;
	}
	public void setExhGubun4(String exhGubun4) {
		this.exhGubun4 = exhGubun4;
	}
	public String getExhName() {
		return exhName;
	}
	public void setExhName(String exhName) {
		this.exhName = exhName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistInfo() {
		return artistInfo;
	}
	public void setArtistInfo(String artistInfo) {
		this.artistInfo = artistInfo;
	}
	public String getExhContent() {
		return exhContent;
	}
	public void setExhContent(String exhContent) {
		this.exhContent = exhContent;
	}
	public String getExhPlace() {
		return exhPlace;
	}
	public void setExhPlace(String exhPlace) {
		this.exhPlace = exhPlace;
	}
	public String getExhPlaceZip() {
		return exhPlaceZip;
	}
	public void setExhPlaceZip(String exhPlaceZip) {
		this.exhPlaceZip = exhPlaceZip;
	}
	public String getExhPlaceAddr1() {
		return exhPlaceAddr1;
	}
	public void setExhPlaceAddr1(String exhPlaceAddr1) {
		this.exhPlaceAddr1 = exhPlaceAddr1;
	}
	public String getExhPlaceAddr2() {
		return exhPlaceAddr2;
	}
	public void setExhPlaceAddr2(String exhPlaceAddr2) {
		this.exhPlaceAddr2 = exhPlaceAddr2;
	}
	public String getExhUrl() {
		return exhUrl;
	}
	public void setExhUrl(String exhUrl) {
		this.exhUrl = exhUrl;
	}
	public String getExhStartDate() {
		return exhStartDate;
	}
	public void setExhStartDate(String exhStartDate) {
		this.exhStartDate = exhStartDate;
	}
	public String getExhEndDate() {
		return exhEndDate;
	}
	public void setExhEndDate(String exhEndDate) {
		this.exhEndDate = exhEndDate;
	}
	public String getOpTime() {
		return opTime;
	}
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdmFee() {
		return admFee;
	}
	public void setAdmFee(String admFee) {
		this.admFee = admFee;
	}
	public String getImageFile1() {
		return imageFile1;
	}
	public void setImageFile1(String imageFile1) {
		this.imageFile1 = imageFile1;
	}
	
	public String getImageName1() {
		return imageName1;
	}

	public void setImageName1(String imageName1) {
		this.imageName1 = imageName1;
	}

	public String getImageType1() {
		return imageType1;
	}

	public void setImageType1(String imageType1) {
		this.imageType1 = imageType1;
	}

	public String getImageFile2() {
		return imageFile2;
	}
	public void setImageFile2(String imageFile2) {
		this.imageFile2 = imageFile2;
	}
	public String getImageName2() {
		return imageName2;
	}

	public void setImageName2(String imageName2) {
		this.imageName2 = imageName2;
	}

	public String getImageType2() {
		return imageType2;
	}

	public void setImageType2(String imageType2) {
		this.imageType2 = imageType2;
	}

	public String getImageFile3() {
		return imageFile3;
	}
	public void setImageFile3(String imageFile3) {
		this.imageFile3 = imageFile3;
	}
	public String getImageName3() {
		return imageName3;
	}

	public void setImageName3(String imageName3) {
		this.imageName3 = imageName3;
	}

	public String getImageType3() {
		return imageType3;
	}

	public void setImageType3(String imageType3) {
		this.imageType3 = imageType3;
	}

	public String getImageFile4() {
		return imageFile4;
	}
	public void setImageFile4(String imageFile4) {
		this.imageFile4 = imageFile4;
	}
	public String getImageName4() {
		return imageName4;
	}

	public void setImageName4(String imageName4) {
		this.imageName4 = imageName4;
	}

	public String getImageType4() {
		return imageType4;
	}

	public void setImageType4(String imageType4) {
		this.imageType4 = imageType4;
	}

	public int getExhReadCount() {
		return exhReadCount;
	}
	public void setExhReadCount(int exhReadCount) {
		this.exhReadCount = exhReadCount;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	public String[] getExhGubun3() {
		return exhGubun3;
	}
	public void setExhGubun3(String exhGubun3[]) {
		this.exhGubun3 = exhGubun3;
	}

	@Override
	public String toString() {
		return "ExhibitionDto [exhID=" + exhID + ", memberID=" + memberID + ", exhGubun1=" + exhGubun1 + ", exhGubun2="
				+ exhGubun2 + ", exhGubun4=" + exhGubun4 + ", exhName=" + exhName + ", artistName=" + artistName
				+ ", artistInfo=" + artistInfo + ", exhContent=" + exhContent + ", exhPlace=" + exhPlace
				+ ", exhPlaceZip=" + exhPlaceZip + ", exhPlaceAddr1=" + exhPlaceAddr1 + ", exhPlaceAddr2="
				+ exhPlaceAddr2 + ", exhUrl=" + exhUrl + ", exhStartDate=" + exhStartDate + ", exhEndDate=" + exhEndDate
				+ ", opTime=" + opTime + ", tel=" + tel + ", admFee=" + admFee + ", imageFile1=" + imageFile1
				+ ", imageName1=" + imageName1 + ", imageType1=" + imageType1 + ", imageFile2=" + imageFile2
				+ ", imageName2=" + imageName2 + ", imageType2=" + imageType2 + ", imageFile3=" + imageFile3
				+ ", imageName3=" + imageName3 + ", imageType3=" + imageType3 + ", imageFile4=" + imageFile4
				+ ", imageName4=" + imageName4 + ", imageType4=" + imageType4 + ", exhReadCount=" + exhReadCount
				+ ", registerDate=" + registerDate + ", activeFlag=" + activeFlag + ", exhGubun3="
				+ Arrays.toString(exhGubun3) + "]";
	}

	
}

