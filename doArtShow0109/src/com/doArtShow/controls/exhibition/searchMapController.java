package com.doArtShow.controls.exhibition;

import java.util.ArrayList;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.ExhibitionDto;

public class searchMapController implements Controller {
	ExhibitionDao exhibitionDao;

	public searchMapController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

			
			model.put("mapLists", exhibitionDao.searchMapExhibition());
			
			return "/client/mappage/ExMap.jsp";
	}
}
