package com.doArtShow.controls.exhibition;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.ExhibitionDto;
import com.doArtShow.dto.TagDto;

// 전시회 수정 컨트롤러
public class ExhibitionUpdateController implements Controller {
	ExhibitionDao exhibitionDao;

	// 전시회 수정을 위한 컨트롤러이므로 ExhibitionDao를 받습니다.
	// 예를들어 전시 등록을 위한 컨트롤러 라면 Exhibition을 받는 식으로 수정해주세요!
	public ExhibitionUpdateController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		PrintWriter out = (PrintWriter) model.get("out");
		// get과 post방식을 모두 처리하기 때문에 request를 담은 model에 정보가 들어있는지에 따라서 처리 방식이
		// 달라집니다.

		// 전시회 수정폼을 요청할 때
		//if (model.get("id") == null) {

		//	return "/auth/memberLoginForm.jsp";

			//
		//} else {

			ExhibitionDto exhibition = (ExhibitionDto) model.get("exhibition");
			//전시회 수정 폼을 요청할 때
			if (model.get("exhibition") == null) {
				System.out.println("jsp페이지를 열어요$$$$");
				int exhID = Integer.parseInt(String.valueOf(model.get("exhID")));
				ExhibitionDto detailInfo = exhibitionDao.selectExhibition(exhID);
				ArrayList<TagDto> tagList = exhibitionDao.getTagList(exhID);
				//System.out.println("detailInfo:" + detailInfo.getExhName());
				System.out.println("tags-Controller" + tagList.toString());
				for (int i = 0; i < tagList.size(); i++)
					if ("데이트".equals(tagList.get(i).getExhTagName())) {
						System.out.println("데이트");
					}
				model.put("exhibition", detailInfo);
				model.put("tagList", tagList);	
				return "/client/exhibition/updateForm.jsp";
			//전시회 수정을 요청할 때	
			} else {
				//ExhibitionDto exhibition = (ExhibitionDto)model.get("exhibition");
				int rsCnt = exhibitionDao.updateExhibition(exhibition);
				System.out.println("DispatcherServlet_update.do_rsCnt: " + rsCnt);
				// return "redirect:list.do";
				/*
				if (rsCnt == 1) {
					 out.println("<html><body>");
					 out.println("<script>alert('전시회 수정이 완료되었습니다.');</script>");
					 out.println("</body></html>");
					 System.out.println("DispatcherServlet_update.do_sql update succeded!");
				} else {
					 out.println("<html><body>");
					 out.println("<script>alert('전시회 수정에 실패했습니다. 잠시 후 다시 시도하거나 관리자에게 문의하세요.');</script>");
					 out.println("</body></html>");
					 System.out.println("DispatcherServlet_update.do_sql update failed!");
				}*/	
				//return "../../index.jsp";
				return "redirect:myList.do?uRsCnt="+rsCnt;
				//return "/client/exhibition/myList.jsp?check="+rsCnt;
			}
		//}
	}
}
