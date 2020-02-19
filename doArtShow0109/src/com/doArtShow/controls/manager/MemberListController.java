package com.doArtShow.controls.manager;

import java.util.List;
import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;
import com.doArtShow.dto.MemberDto;

public class MemberListController implements Controller {
	ManagerDao managerDao;
	
	public MemberListController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### MemberListController ###");
		
		List<MemberDto> memberList = null;
		memberList = managerDao.getMembers();
		
		model.put("memberList", memberList);
		
		return "manager/member/memberList.jsp";
	}

}
