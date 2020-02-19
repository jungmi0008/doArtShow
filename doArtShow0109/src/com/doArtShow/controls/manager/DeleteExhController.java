package com.doArtShow.controls.manager;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ManagerDao;
import com.doArtShow.util.DeleteFileUtil;

public class DeleteExhController implements Controller {
	ManagerDao managerDao;

	public DeleteExhController setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("### ModifyExhController ###");
		
		int exhID = Integer.parseInt((String) model.get("exhID"));
		String[] imageFile = managerDao.getImageFile(exhID);
		
		int resultDeleteExhContent = managerDao.deleteExhContent(exhID);
		
		if (resultDeleteExhContent > 0) {
			for (int i=0; i<imageFile.length; i++) {
				if(imageFile[i]!=null) {
					if(!imageFile[i].equals("Nothing.png"))
						DeleteFileUtil.deleteFile("/exhibitionImages", imageFile[i], (HttpServletRequest) model.get("request"));
				}	
			}

			return "success";
		} else {
			return "fail";
		}
	}


}
