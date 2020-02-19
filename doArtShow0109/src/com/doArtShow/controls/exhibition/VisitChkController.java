package com.doArtShow.controls.exhibition;

import java.util.Map;

import org.json.simple.JSONObject;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.VisitListDao;
import com.doArtShow.dto.VisitListDto;

public class VisitChkController implements Controller{
	VisitListDao visitListDao;
		
	public VisitChkController setVisitListDao(VisitListDao visitListDao) {
		this.visitListDao = visitListDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String result = null;
		
		if(model.get("checkVisitInfo") != null){
			System.out.println("##3번 VisitChkController(페이지컨트롤러)실행");
			
			JSONObject jsonObj = (JSONObject)model.get("jsonObj");
			
			VisitListDto visitDto = (VisitListDto)model.get("checkVisitInfo");
			String email = visitDto.getEmail();
			int exhID = visitDto.getExhID();
			
			/*
			  	경우의 수
			  	1. 다녀오지 않음 (checkVisit=0, checkRev=0)
			  	2. 다녀왔고, 리뷰 작성 안함 (checkVisit=1, checkRev=0)
			  	3. 다녀왔고, 리뷰 작성 함 (checkVisit=1, checkRev=1)
			*/
			
			int checkVisit = visitListDao.visitCheck(email, exhID); //해당 전시에 회원이 다녀왔어요 기록이 있는지 확인하여 0(안다녀왔음)또는 1(다녀왔음)로 리턴받음			
			int checkRev = visitListDao.reviewCheck(email, exhID); //해당 전시에 회원이 리뷰를 쓴 기록이 있는지 확인하여 0(리뷰 안씀)또는 1(리뷰 씀)을 리턴받음
			
			if(checkVisit == 0){ //경우의 수 1
				visitListDao.insertVisit(visitDto); //다녀온 전시 등록
				visitListDao.updateVisitCheck(email, exhID); //다녀온 전시를 등록하면 visitCheck를 1로 바꿔준다
				
				jsonObj.put("checkVisit", checkVisit);
				jsonObj.put("checkRev", checkRev);
				result = jsonObj.toJSONString();
			}else if(checkVisit == 1 && checkRev == 0){ //경우의 수 2
				jsonObj.put("checkVisit", checkVisit);
				jsonObj.put("checkRev", checkRev);
				result = jsonObj.toJSONString();
			}else if(checkVisit == 1 && checkRev == 1){ //경우의 수 3
				jsonObj.put("checkRev", checkRev);
				result = jsonObj.toJSONString();
			}
			
		}
		
		return "json:" + result;

	}
	
}
