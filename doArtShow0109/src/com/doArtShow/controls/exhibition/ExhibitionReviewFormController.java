package com.doArtShow.controls.exhibition;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ReviewDao;
import com.doArtShow.dao.VisitListDao;
import com.doArtShow.dto.ReviewDto;

public class ExhibitionReviewFormController implements Controller{
	ReviewDao reviewDao;
	
	public ExhibitionReviewFormController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("##3번 ExhibitionReviewFormController(페이지컨트롤러)실행");
		
		ReviewDto exhreview = (ReviewDto)model.get("exhreview");		
		
		reviewDao.insertReview(exhreview); //리뷰등록하는 Dao
		
		String email = exhreview.getEmail();
		int exhID = exhreview.getExhID();
		
		reviewDao.updateRevCheck(email, exhID); //리뷰 등록하면 revcheck를 1로 바꿔줌
		
		return "redirect:ExContentView.do?exhID="+exhID;
	}
	
}
