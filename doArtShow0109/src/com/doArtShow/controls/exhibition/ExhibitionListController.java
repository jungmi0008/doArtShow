package com.doArtShow.controls.exhibition;

import java.util.Map;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;

public class ExhibitionListController implements Controller {
	ExhibitionDao exhibitionDao;
	
	//MemberDao를 주입받기 위한 인스턴수 변수와 셋터 메서드를 추가
	public ExhibitionListController setExhibitionDao(ExhibitionDao exhibitionDao){
		this.exhibitionDao = exhibitionDao;
		return this;
	}
	//이렇게 써줌으로써 외부에서 MemberDao객체를 주입해줄것이기 때문에 밑에 execute()에서 Map객체에서 MemberDao를 꺼낼 필요가 없다
	
	@Override
	public String execute(Map<String, Object> model) throws Exception{
		System.out.println("##3번 ExhibitionListController(페이지컨트롤러)실행");
//		MemberDao memberDao = (MemberDao)model.get("memberDao"); 제거
		
		int listCnt = exhibitionDao.getListCount(); //전시갯수
		model.put("listCnt", listCnt);
		model.put("lists", exhibitionDao.selectList()); //exhibitionDao에게 ExList목록 데이터 요청(selectList()메서드에서 쿼리문으로 데이터 처리)
		//exhibitionDao.selectList()에서 가져온 데이터를 lists라는 이름으로 model(Map객체)에 담는다
		
		return "/client/exhibition/ExListView.jsp"; //DispatcherRedirect에게 뷰URL을 반환
	}
	
}
