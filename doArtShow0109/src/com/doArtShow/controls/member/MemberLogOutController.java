package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;

//로그아웃 컨트롤러
public class MemberLogOutController implements Controller{
	MemberDao memberDao;
	
	public MemberLogOutController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		return "redirect:/doArtShow/";
	}
	
}
