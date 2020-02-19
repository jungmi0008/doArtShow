package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;

//이메일  찾기 컨트롤러
public class FindEmailController implements Controller{
	MemberDao memberDao;
	
	public FindEmailController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("findEmailInfo") != null) {
			MemberDto member = (MemberDto)model.get("findEmailInfo");
			String email = memberDao.findEmail(member.getName(), member.getBirth());
						
			HttpSession session = (HttpSession)model.get("session");
	        session.setAttribute("email", email);
	        
			return "/client/auth/findEmailResult.jsp";
			
		} else {
			return "/client/auth/findEmailForm.jsp";
		}
	}
}
