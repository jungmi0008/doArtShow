package com.doArtShow.controls.manager;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;

public class ManagerMainController implements Controller {
	ManagerDao managerDao;

	public ManagerMainController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
		
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### ManagerMainController ###");
		
		HttpSession session = (HttpSession)model.get("session");
		
		if (session.getAttribute("managerId") == null) {
			return "manager/logon/managerLogin.jsp";
		} else {
			int memberCnt = managerDao.getMemberCnt();
			
			model.put("memberCnt", memberCnt);
			
			int newExhListCnt = managerDao.getNewExhListCnt();
			
			model.put("newExhListCnt", newExhListCnt);
			
			int todayVisitCnt = managerDao.getTodayVisitCnt();
			
			model.put("todayVisitCnt", todayVisitCnt);
			
			return "managerMain.jsp";
		}
	}

}