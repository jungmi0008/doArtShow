package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;

//회원 정보 수정 컨트롤러
public class MemberUpdateController implements Controller{
	MemberDao memberDao;
	HttpSession session;
	
	public MemberUpdateController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
			MemberDto member = (MemberDto)model.get("member");
			
			memberDao.updateMember(
					member.getBirth(), 
					member.getGender(),
					member.getPw(),
					(String)model.get("email"));
			
			member = memberDao.selectInfo((String)model.get("email"));
			session = (HttpSession)model.get("session");
			session.removeAttribute("member");
			
			session.setAttribute("member",member);
			
			return "redirect:memberDetail.do";
	}
	
}
