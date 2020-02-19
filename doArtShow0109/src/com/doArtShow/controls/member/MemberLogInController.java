package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;

//회원 로그인 컨트롤러
public class MemberLogInController implements Controller{
MemberDao memberDao;
	
	public MemberLogInController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		//로그인 화면을 요청할 때

			String referer = (String)model.get("Referer");
			
			MemberDto loginInfo = (MemberDto)model.get("loginInfo");
			
			MemberDto member = memberDao.checkMember(
					loginInfo.getEmail(), loginInfo.getPw());
						
			//로그인 정보에 맞는 회원이 db에 있다면 세션을 생성하고
			if (member.getEmail() != null) {
		        HttpSession session = (HttpSession)model.get("session");
		        session.setAttribute("member", member);
		        
		        //회원가입을 하고 난 후에는 이전페이지가 아닌 메인화면을 출력해준다.
		        if(referer.startsWith("http://rladudrl286.cafe24.com/doArtShow/client/auth/memberAdd.do?")) {
		        	return "redirect:/doArtShow/";
		        }
		        if(referer.startsWith("http://rladudrl286.cafe24.com/doArtShow/client/auth/memberLogIn.do")) {
		        	return "redirect:/doArtShow/";

		        }
		        
		        return "redirect:"+referer;
		        
		     } else {
		    	 
		        return "/client/auth/memberLogInFail.jsp";
		     }

	}
}
