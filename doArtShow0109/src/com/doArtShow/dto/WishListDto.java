package com.doArtShow.dto;

// 가고 싶은 전시 정보
public class WishListDto {
	private String 	email;
	private int 	exhID;
	private int 	wishCheck;
	
	public String getEmail() {
		return email;
	}
	public WishListDto setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getExhID() {
		return exhID;
	}
	public WishListDto setExhID(int exhID) {
		this.exhID = exhID;
		return this;
	}
	public int getWishCheck() {
		return wishCheck;
	}
	public WishListDto setWishCheck(int wishCheck) {
		this.wishCheck = wishCheck;
		return this;
	}
	
}
