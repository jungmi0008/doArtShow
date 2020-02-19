package com.doArtShow.controls.manager;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;
import com.doArtShow.dto.ManagerDto;

public class ManagerLoginController implements Controller {
	ManagerDao managerDao;

	public ManagerLoginController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### ManagerLoginController ###");
		
		if(model.get("managerLoginInfo") == null){
			System.out.println("managerLoginInfo is NULL....");
			
			return "redirect:managerMain.jsp";
			
		} else {
			System.out.println("managerLoginInfo is not NULL....");
			ManagerDto managerDto = (ManagerDto)model.get("managerLoginInfo");
			System.out.println("managerDto.getManagerId() >>> " + managerDto.getManagerId());
			System.out.println("managerDto.getManagerPwd() >>> " + managerDto.getManagerPwd());
			
			int result = managerDao.checkManager(managerDto.getManagerId(), managerDto.getManagerPwd());
			//System.out.println("result >>> " + result);
			
			HttpSession session = (HttpSession)model.get("session");
			
			if (result == 1) {
				session.setAttribute("managerId", managerDto.getManagerId());
				
				//return "redirect:managerMain.jsp";
				return "redirect:manager.do";
			} else if (result == 0) {
				session.setAttribute("error", "pwdError");
				
				return "redirect:manager/logon/managerLogin.jsp";
			} else {
				session.setAttribute("error", "idError");
				
				return "redirect:manager/logon/managerLogin.jsp";
			}
		}
	}

}
