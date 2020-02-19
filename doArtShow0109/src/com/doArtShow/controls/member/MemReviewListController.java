package com.doArtShow.controls.member;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;
import com.doArtShow.dto.MyReviewDto;

//회원 리뷰 전체보기 컨트롤러
public class MemReviewListController implements Controller{
	MemberDao	memberDao;
	
	public MemReviewListController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		
		if(session.getAttribute("member") != null) {
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			String email = member.getEmail();
			
			//전시회 리뷰 목록
			ArrayList<MyReviewDto> reviewList = memberDao.selectReviewList(email);
			if(reviewList != null) {
				model.put("reviewList", reviewList);
			}
			
			//리뷰개수
			int reviewCount = memberDao.countReview(email);
			if(reviewCount != 0) {
				model.put("reviewCount", reviewCount);
			}
		}
		
		return "/client/auth/myReviewList.jsp";
	}

}
