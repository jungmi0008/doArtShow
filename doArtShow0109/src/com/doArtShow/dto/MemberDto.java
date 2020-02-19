package com.doArtShow.dto;

// 회원 정보
public class MemberDto {
	private String 	email;
	private String 	name;
	private String 	birth;
	private String 	gender;
	private String 	pw;
	private String 	profileImg;
	private String  kakaoId;
	private String  naverId;
	
	
	
	public MemberDto() {}// ManagerDao 전용 생성자

	public MemberDto(String email, String name, String birth, String gender, String pw, String profileImg) {
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.pw = pw;
		this.profileImg = profileImg;
	}// ManagerDao 전용 생성자2
	
	public MemberDto(String email, String name, String birth, String gender, String pw, String profileImg, String kakaoId, String naverId) {
		super();
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.pw = pw;
		this.profileImg = profileImg;
		this.kakaoId = kakaoId;
		this.naverId = naverId;
	}// ManagerDao 전용 생성자3
	
	
	
	

	public String getEmail() {
		return email;
	}

	public MemberDto setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getName() {
		return name;
	}

	public MemberDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getBirth() {
		return birth;
	}

	public MemberDto setBirth(String birth) {
		this.birth = birth;
		return this;
	}

	public String getGender() {
		return gender;
	}
	
	public MemberDto setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public String getPw() {
		return pw;
	}

	public MemberDto setPw(String pw) {
		this.pw = pw;
		return this;
	}
	
	public String getProfileImg() {
		return profileImg;
	}

	public MemberDto setProfileImg(String profileImg) {
		this.profileImg = profileImg;
		return this;
	}
	
	public String getKakaoId() {
		return kakaoId;
	}
	
	public MemberDto setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
		return this;
	}
	
	public String getNaverId() {
		return naverId;
	}
	
	public MemberDto setNaverId(String naverId) {
		this.naverId = naverId;
		return this;
	}

	@Override
	public String toString() {
		return "MemberDto [email=" + email + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", pw=" + pw
				+ ", profileImg=" + profileImg + ", kakaoId=" + kakaoId + ", naverId=" + naverId + "]";
	}

	
	
}
