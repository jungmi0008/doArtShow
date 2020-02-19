package com.doArtShow.controls.manager;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;

public class UpdateActiveFlagController implements Controller {
	ManagerDao managerDao;
	
	public UpdateActiveFlagController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### UpdateActiveFlagController ###");
		
		String exhID = (String) model.get("exhID");
		String checked = (String) model.get("checked");
		
		if (checked.equals("true")) {
			managerDao.updateActiveFlagTrue(exhID);			
		} else if (checked.equals("end")) {
			managerDao.updateActiveFlagEnd(exhID);
		} else {
			managerDao.updateActiveFlagFalse(exhID);
		}
		
		HttpSession session = (HttpSession)model.get("session");
		//System.out.println("listType >>> " + session.getAttribute("listType"));
		String listType = (String) session.getAttribute("listType");
		
		if (listType.equals("ALL")) {
			return "manager/exh/allExhList.jsp";
			//return "good";
		} else if (listType.equals("NEW")) {
			return "manager/exh/newExhList.jsp";
		} else if (listType.equals("END")) {
			return "manager/exh/endExhList.jsp";
		}
		
		return null;
	}

}
