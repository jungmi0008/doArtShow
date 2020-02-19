package com.doArtShow.dto;

public class ExhListDto {
	private int exhID;
	private String imageFile1;
	private String exhName;
	private String exhPlace;
	private String exhStartDate;
	private String exhEndDate;
	
	public int getExhID() {
		return exhID;
	}
	public void setExhID(int exhID) {
		this.exhID = exhID;
	}
	public String getImageFile1() {
		return imageFile1;
	}
	public void setImageFile1(String imageFile1) {
		this.imageFile1 = imageFile1;
	}
	public String getExhName() {
		return exhName;
	}
	public void setExhName(String exhName) {
		this.exhName = exhName;
	}
	public String getExhPlace() {
		return exhPlace;
	}
	public void setExhPlace(String exhPlace) {
		this.exhPlace = exhPlace;
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
	
	@Override
	public String toString() {
		return "ExhListDto [exhID=" + exhID + ", imageFile1=" + imageFile1 + ", exhName=" + exhName + ", exhPlace="
				+ exhPlace + ", exhStartDate=" + exhStartDate + ", exhEndDate=" + exhEndDate + "]";
	}
	
}
