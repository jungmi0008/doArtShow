package com.doArtShow.controls.member;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.MemberDto;
import com.doArtShow.dto.MyReviewDto;

//회원이 다녀온 전시 전체보기 컨트롤러
public class MemVisitListController implements Controller{
	MemberDao	memberDao;
	
	public MemVisitListController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		
		if(session.getAttribute("member") != null) {
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			String email = member.getEmail();
						
			//갔다온 전시회 목록
			ArrayList<ExhibitionDto> visitList = memberDao.selectVisitList(email);
			if(visitList != null) {
				model.put("visitList", visitList);
			}
			
			//갔다온 전시 개수
			int visitCount = memberDao.countVisitExh(email);
			if(visitCount != 0) {
				model.put("visitCount", visitCount);
			}
		}
		
		return "/client/auth/myVisitList.jsp";
	}

}
