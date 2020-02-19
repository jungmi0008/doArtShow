package com.doArtShow.dto;

public class TagDto {
	private int		exhID;
	private String	exhTagName;
	
	
	
	
	public TagDto() {}// ManagerDao 전용 생성자

	public TagDto(int exhID, String exhTagName) {
		this.exhID = exhID;
		this.exhTagName = exhTagName;
	}// ManagerDao 전용 생성자2
	
	
	
	
	
	public int getExhID() {
		return exhID;
	}
	public void setExhID(int exhID) {
		this.exhID = exhID;
	}
	public String getExhTagName() {
		return exhTagName;
	}
	public void setExhTagName(String exhTagName) {
		this.exhTagName = exhTagName;
	}
	
	@Override
	public String toString() {
		return "TagInfo [exhID=" + exhID + ", exhTagName=" + exhTagName + "]";
	}
	
	
}
