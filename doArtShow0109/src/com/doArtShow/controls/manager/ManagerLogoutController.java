package com.doArtShow.controls.manager;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;

public class ManagerLogoutController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### ManagerLogoutController ###");
		
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		
		return "redirect:managerMain.jsp";
	}

}
