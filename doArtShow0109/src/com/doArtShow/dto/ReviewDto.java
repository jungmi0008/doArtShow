package com.doArtShow.dto;

import java.sql.Date;
import java.sql.Timestamp;

// 리뷰 정보
public class ReviewDto {
	private String 		email;
	private int 		exhID;
	private String 		revContent;
	private Date	 	revDate;
	
	public String getEmail() {
		return email;
	}
	public ReviewDto setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getExhID() {
		return exhID;
	}
	public ReviewDto setExhID(int exhID) {
		this.exhID = exhID;
		return this;
	}
	public String getRevContent() {
		return revContent;
	}
	public ReviewDto setRevContent(String revContent) {
		this.revContent = revContent;
		return this;
	}
	public Date getRevDate() {
		return revDate;
	}
	public ReviewDto setRevDate(Date revDate) {
		this.revDate = revDate;
		return this;
	}
	
	
}
