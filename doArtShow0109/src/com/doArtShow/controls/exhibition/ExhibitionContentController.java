package com.doArtShow.controls.exhibition;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.TagDto;

public class ExhibitionContentController implements Controller{
	ExhibitionDao exhibitionDao;
	HttpSession session;
	
	public ExhibitionContentController setExhibitionDao(ExhibitionDao exhibitionDao) {
		this.exhibitionDao = exhibitionDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("##3번 ExhibitionContentController(페이지컨트롤러)실행");
		
		int exhID = (int)model.get("exhID");
		int wishChk = 0;
		
		if(model.get("email") != null){
			String email = (String)model.get("email");
			
			wishChk = exhibitionDao.wishCheck(email, exhID); //가고싶어요 여부 확인
		}
		model.put("wishChk", wishChk);
		
		exhibitionDao.updateReadCount(exhID); //조회수 1 증가
		model.put("listOne", exhibitionDao.selectOne(exhID)); //상세페이지에 뿌릴 전시 정보를 가져옴
		ArrayList<TagDto> taglist = exhibitionDao.getTagList(exhID); //해당전시의 지정된 태그 가져옴
		model.put("listOneTag", taglist); 
		
		int revCnt = exhibitionDao.getRevCount(exhID); //해당 전시의 리뷰 총 갯수를 가져옴
		model.put("revCnt", revCnt);
		model.put("revLists", exhibitionDao.revContent(exhID)); //해당 전시의 리뷰목록을 가져옴
		
		return "/client/exhibition/ExContentView.jsp";
	}

}
