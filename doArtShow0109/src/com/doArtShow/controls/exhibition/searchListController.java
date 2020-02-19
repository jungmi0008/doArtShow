package com.doArtShow.controls.exhibition;

import java.util.ArrayList;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.ExhibitionDto;

public class searchListController implements Controller {
	ExhibitionDao exhibitionDao;

	public searchListController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		if (model.get("search") != null) {
			ArrayList<ExhibitionDto> searchResult = exhibitionDao.searchExhibition((String)model.get("search"));
			model.put("searchResult", searchResult);
			return "/client/search/searchList.jsp";
		}
		return "redirect:/doArtShow";
	}
}
