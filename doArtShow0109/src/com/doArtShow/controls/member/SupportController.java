package com.doArtShow.controls.member;

import java.util.ArrayList;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.ExhibitionDto;

public class SupportController implements Controller {
/*	ExhibitionDao exhibitionDao;

	public SupportController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}*/

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("여기 서포트 컨트롤러얌");
		
		return "/client/support/support.jsp";
	}

}
