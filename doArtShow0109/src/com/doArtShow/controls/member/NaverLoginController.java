package com.doArtShow.controls.member;

import java.util.ArrayList;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.ExhibitionDto;

public class NaverLoginController implements Controller {
/*	ExhibitionDao exhibitionDao;

	public NaverLoginController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}
*/
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("네아로 컨트롤러얌");
		return "/client/OAuth/NaverCallback.jsp";
	}

}
