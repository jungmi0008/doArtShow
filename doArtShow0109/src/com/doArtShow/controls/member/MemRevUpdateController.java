package com.doArtShow.controls.member;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.ReviewDto;

//회원 리뷰 수정 컨트롤러
public class MemRevUpdateController implements Controller{
	MemberDao	memberDao;
	
	public MemRevUpdateController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String referer = (String)model.get("Referer");
		
		if(model.get("revUpdateInfo")!=null) {
			ReviewDto revUpdateInfo = (ReviewDto)model.get("revUpdateInfo");
			String 	email 		= revUpdateInfo.getEmail();
			int 	exhID 		= revUpdateInfo.getExhID();
			String 	revContent 	= revUpdateInfo.getRevContent();
			
			memberDao.updateReveiw(email, exhID, revContent);
			
		}
		return "redirect:"+referer;
	}

}
