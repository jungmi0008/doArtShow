package com.doArtShow.dto;

// 관리자 정보
public class ManagerDto {
	private String managerId;
	private String managerPwd;
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
}
