package com.doArtShow.controls.member;

import java.util.ArrayList;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.ExhibitionDto;

public class IndexController implements Controller {
	ExhibitionDao exhibitionDao;

	public IndexController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("여기 인덱스 컨트롤러얌");
		
		ArrayList<ExhibitionDto> indexExhibition = exhibitionDao.indexExhibition();
		model.put("lists", indexExhibition);
		return "/index.jsp";
	}

}
