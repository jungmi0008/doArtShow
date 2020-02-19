package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;

//탈퇴하기 페이지 컨트롤러
public class MemberDeleteController implements Controller{
	MemberDao memberDao;
	
	public MemberDeleteController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		
		if(session.getAttribute("member")!=null) {
			MemberDto member = (MemberDto)session.getAttribute("member");
			memberDao.deleteMember(member.getEmail());
			
			//탈퇴함과 동시에 로그인 정보를 없앤다.
			session.invalidate();
			
			return "redirect:/doArtShow/";
		} else {
			return "redirect:/client/auth/memberLogIn.do";
		}
	}
}
