package com.doArtShow.controls.exhibition;

import java.util.Map;

import org.json.simple.JSONObject;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.WishListDao;
import com.doArtShow.dto.WishListDto;

public class WishChkController implements Controller{
	WishListDao wishListDao;
	
	public WishChkController setWishListDao(WishListDao wishListDao) {
		this.wishListDao = wishListDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String result = null;
		
		if(model.get("checkWishInfo") != null){
			System.out.println("##3번 WishChkController(페이지컨트롤러)실행");
			
			JSONObject jsonObj = (JSONObject)model.get("jsonObj");
			
			WishListDto wishDto = (WishListDto)model.get("checkWishInfo");
			String email = wishDto.getEmail();
			int exhID = wishDto.getExhID();
			
			/*
			  	경우의 수
			  	1. 가고싶어요 한번도 체크하지 않아서 row 자체가 없음 (wishCheck=0, checkWishRow=0)
			  	2. 가고싶어요 체크 했다가 취소해서 row가 남아있음 (wishCheck=0, checkWishRow=1)
			  	3. 가고싶어요 체크 되있음 (wishCheck=1, checkWishRow=1)
			*/
			
			int checkWish = wishListDao.wishCheck(email, exhID); //해당 전시에 회원이 가고싶어요 기록이 있는지 확인하여 0(가고싶어요 누른적 없음)또는 1(가고싶어요 누른적 있음)로 리턴받음
			int checkWishRow = wishListDao.WishRowCheck(email, exhID); //wishArt테이블에 row가 중복 삽입되지 않게 하기 위해, 해당아이디가 해당전시의 가고싶어요 클릭했던 기록이 있는지 확인
			
			if(checkWish == 0 && checkWishRow == 0){ 
				wishListDao.insertWish(wishDto); //가고싶어요 전시 등록
				wishListDao.updateWishCheck(email, exhID); //가고싶은 전시를 등록하면 wishCheck를 1로 바꿔준다
				
				jsonObj.put("checkWish", checkWish);
				result = jsonObj.toJSONString();
			}else if(checkWish == 0 && checkWishRow == 1){ 
				wishListDao.updateWishCheck(email, exhID); //row가 이미 있으므로 wishCheck만 1로 바꿔준다
				
				jsonObj.put("checkWish", checkWish);
				result = jsonObj.toJSONString();
			}else if(checkWish == 1){
				wishListDao.deleteWishCheck(email, exhID); //가고싶어요 취소를 하면  wishCheck를 0으로 바꿔준다
				
				jsonObj.put("checkWish", checkWish);
				result = jsonObj.toJSONString();
			}

		}
		
		return "json:" + result;
	}

}
