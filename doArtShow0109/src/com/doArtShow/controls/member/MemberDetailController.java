package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;

//회원정보 수정 페이지 컨트롤러
public class MemberDetailController implements Controller{
	MemberDao memberDao;
	HttpSession session;
	
	public MemberDetailController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String email = (String)model.get("email");
		MemberDto member = memberDao.selectInfo(email);
		
		return "/client/auth/memberDetail.jsp";			
	}

}
