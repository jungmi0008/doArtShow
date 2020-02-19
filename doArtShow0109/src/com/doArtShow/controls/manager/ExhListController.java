package com.doArtShow.controls.manager;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;
import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.TagDto;

public class ExhListController implements Controller {
	ManagerDao managerDao;
	
	public ExhListController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### ExhListController ###");
		
		String listType = (String) model.get("listType");
		
		HttpSession session = (HttpSession)model.get("session");
		
		if (listType.equals("ALL")) {
			List<ExhibitionDto> allExhList = null;
			allExhList = managerDao.getAllExhLists();
			
			model.put("allExhList", allExhList);
			
			session.setAttribute("listType", "ALL");
			
			return "manager/exh/allExhList.jsp";
		} else if (listType.equals("NEW")) {
			List<ExhibitionDto> newExhList = null;
			newExhList = managerDao.getNewExhLists();
			
			model.put("newExhList", newExhList);
			
			session.setAttribute("listType", "NEW");
			
			return "manager/exh/newExhList.jsp";
		} else if (listType.equals("END")) {
			List<ExhibitionDto> endExhList = null;
			endExhList = managerDao.getEndExhLists();
			
			model.put("endExhList", endExhList);
			
			session.setAttribute("listType", "END");
			
			return "manager/exh/endExhList.jsp";
		}
		
		return null;
		
	}

}
