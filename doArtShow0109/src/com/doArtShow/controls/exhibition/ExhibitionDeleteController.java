package com.doArtShow.controls.exhibition;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.util.DeleteFileUtil;

public class ExhibitionDeleteController implements Controller {
	ExhibitionDao exhibitionDao;

	// 전시회 수정을 위한 컨트롤러이므로 ExhibitionDao를 받습니다.
	// 예를들어 전시 등록을 위한 컨트롤러 라면 Exhibition을 받는 식으로 수정해주세요!
	public ExhibitionDeleteController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String saveFolder = "/exhibitionImages";
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		int exhID = Integer.parseInt(String.valueOf(model.get("exhID")));
		String[] imageFile = exhibitionDao.getImageFile(exhID);
		int rsCnt = exhibitionDao.deleteExhibition(exhID);
		if(rsCnt == 1) {
			for (int i=0; i<imageFile.length; i++) {
				if(imageFile[i]!=null) {
					if(!imageFile[i].equals("Nothing.png"))
						DeleteFileUtil.deleteFile(saveFolder, imageFile[i], request);
				}	
			}	
		}
		
		System.out.println("DispatcherServlet_delete.do_rsCnt: " + rsCnt);
		return "redirect:myList.do?dRsCnt="+rsCnt;   //modified by Hojeong @200120
	}

}
