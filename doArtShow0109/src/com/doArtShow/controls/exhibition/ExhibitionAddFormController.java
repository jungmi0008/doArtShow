package com.doArtShow.controls.exhibition;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.MemberDto;

public class ExhibitionAddFormController implements Controller {
	ExhibitionDao exhibitionDao;

	// 전시회 등록을 위한 컨트롤러이므로 ExhibitionDao를 받습니다.
	// 예를들어 전시 등록을 위한 컨트롤러 라면 Exhibition을 받는 식으로 수정해주세요!
	public ExhibitionAddFormController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// get과 post방식을 모두 처리하기 때문에 request를 담은 model에 정보가 들어있는지에 따라서 처리 방식이
		// 달라집니다.

		// 전시회 등록폼을 요청할때
		HttpSession session = (HttpSession)model.get("session");
		MemberDto member = (MemberDto) session.getAttribute("member");
		if(member != null) {
			String email = member.getEmail();
			System.out.println("controller id:" + email);
			model.put("memberID", email);
		} 
		return "/client/exhibition/registerForm.jsp";
	}
}
