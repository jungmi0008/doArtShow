package com.doArtShow.controls.member;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.ExhibitionDto;

//회원이 작성한 리뷰 삭제하는 컨트롤러
public class MemRevDeleteController implements Controller{
	MemberDao	memberDao;
	
	public MemRevDeleteController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String referer = (String)model.get("Referer");
		
		if(model.get("exhName")!=null) {
			ExhibitionDto exhibition = (ExhibitionDto)model.get("exhName");
			int exhID = memberDao.getExhID(exhibition.getExhName().trim());
			
			String email = (String)model.get("logInInfo");
			memberDao.deleteReveiw(email, exhID);
			
		}
		return "redirect:"+referer;
	}

}
