package com.doArtShow.controls.manager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;

public class GetArtShowTagController implements Controller {
	ManagerDao managerDao;
	
	public GetArtShowTagController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### ArtShowTagController ###");
		
		int exhID = Integer.parseInt((String) model.get("exhID"));
		
		List<String> list = null;
		list = managerDao.getExhListTags(exhID);
		
		String[] tagList = list.toArray(new String[list.size()]);
		
		String tags = "";
		
		for (String s : tagList) {
			tags += ",";
			tags += s;
		}
		
		//System.out.println("tags >>>" + tags);
		
		return tags;
	}

}
