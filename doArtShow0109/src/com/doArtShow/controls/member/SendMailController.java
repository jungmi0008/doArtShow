package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.util.FindUtil;

public class SendMailController implements Controller{
	HttpSession session;
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String keyCode = FindUtil.createKey();
		session = (HttpSession)model.get("session");
		session.setAttribute("keyCode", keyCode);
		
		String subject = "[전시해] 임시 비밀번호";
		
		String msg = "<div align ='center'>";
		
		return null;
	}

}
