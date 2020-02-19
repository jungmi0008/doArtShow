package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;
import com.doArtShow.util.EmailUtil;
import com.doArtShow.util.FindUtil;

//비밀번호 찾기 컨트롤러
public class FindPwController implements Controller{
	MemberDao memberDao;
	HttpSession session;
	
	public FindPwController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		//임시비밀번호를 가입된 이메일 주소로 발급 받는다.
		if(model.get("findPwInfo") != null) {
			MemberDto member = (MemberDto)model.get("findPwInfo");
			
			String newPw = FindUtil.createKey();

			memberDao.changePw(newPw, member.getEmail(), member.getBirth());
			
			String subject = "[전시해] 임시 비밀번호 발급";
			
			String msg = "";
			
			msg += "<div align='center' style='border: 1px solid black; font-family:verdana; padding: 50px;'>";
			msg += "<h3><strong>" + member.getEmail() + "님</strong>의 임시 비밀번호 입니다.</h3>";
			msg += "<h3>로그인 후 비밀번호를 변경하세요.</h3>";
			msg += "<p style='color:blue';>임시 비밀번호 : <strong>"+ newPw +"</strong></p>";
			msg += "<a href=\"http://rladudrl286.cafe24.com/doArtShow/\">전시해 홈페이지 바로가기</a>";
			msg += "</div>";
			
			EmailUtil.sendMail(member.getEmail(), subject, msg);
			
			return "/client/auth//findPwResult.jsp";
			
		} else {
			
			return "/client/auth/findPwForm.jsp";
		}
	}

}
