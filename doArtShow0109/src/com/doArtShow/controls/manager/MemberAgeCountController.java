package com.doArtShow.controls.manager;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;

public class MemberAgeCountController implements Controller {
	ManagerDao managerDao;

	public MemberAgeCountController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### VisitCountController ###");
		
		int startYear = Integer.parseInt((String) model.get("startYear"));
		int lastYear = Integer.parseInt((String) model.get("lastYear"));

		int memberAgeCnt = managerDao.getAgeCnt(startYear, lastYear);

		return "" + memberAgeCnt;
	}

}
