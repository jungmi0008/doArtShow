package com.doArtShow.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ReviewListDto {
	private String revContent;
	private Date revDate;
	private String name;
	private String profileImg;
	
	public String getRevContent() {
		return revContent;
	}
	public ReviewListDto setRevContent(String revContent) {
		this.revContent = revContent;
		return this;
	}
	public Date getRevDate() {
		return revDate;
	}
	public ReviewListDto setRevDate(Date revDate) {
		this.revDate = revDate;
		return this;
	}
	public String getName() {
		return name;
	}
	public ReviewListDto setName(String name) {
		this.name = name;
		return this;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public ReviewListDto setProfileImg(String profileImg) {
		this.profileImg = profileImg;
		return this;
	}
	
	@Override
	public String toString() {
		return "ReviewListDto [revContent=" + revContent + ", revDate=" + revDate + ", name=" + name + ", profileImg="
				+ profileImg + "]";
	}
	
	
}
