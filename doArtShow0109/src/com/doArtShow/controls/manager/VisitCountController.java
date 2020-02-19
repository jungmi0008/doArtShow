package com.doArtShow.controls.manager;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;

public class VisitCountController implements Controller {
	ManagerDao managerDao;

	public VisitCountController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### VisitCountController ###");
		
		String value = (String) model.get("value");
		
		if (value.equals("total")) {
			return "manager/chart/charts.jsp";
		} else if (value.equals("week")) {
			String weekValue = (String) model.get("weekValue");
			
			int weekVisitCnt = managerDao.getWeekVisitCnt(weekValue);
			
			return "" + weekVisitCnt;
		} else if (value.equals("month")) {
			String year = (String) model.get("year");
			String monthValue = (String) model.get("monthValue");

			int monthVisitCnt = managerDao.getMonthVisitCnt(year, monthValue);
			
			return "" + monthVisitCnt;
		} else {
			
			return null;
		}
		
	}

}
