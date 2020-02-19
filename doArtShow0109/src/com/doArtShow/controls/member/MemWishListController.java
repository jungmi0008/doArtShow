package com.doArtShow.controls.member;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.MemberDto;
import com.doArtShow.dto.MyReviewDto;

//회원이 가고 싶은 전시 전체보기 컨트롤러
public class MemWishListController implements Controller{
	MemberDao	memberDao;
	
	public MemWishListController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		
		if(session.getAttribute("member") != null) {
			MemberDto member = (MemberDto)session.getAttribute("member");
			
			String email = member.getEmail();
			
			//가고싶은 전시회 목록
			ArrayList<ExhibitionDto> wishList = memberDao.selectWishList(email);
			if(wishList != null) {
				model.put("wishList", wishList);
			}
			
			//가고싶은 전시 개수
			int wishCount = memberDao.countWishExh(email);
			if(wishCount != 0) {
				model.put("wishCount", wishCount);
			}
		}
		
		return "/client/auth/myWishList.jsp";
	}

	
}
