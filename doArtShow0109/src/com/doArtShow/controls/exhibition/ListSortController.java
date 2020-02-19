package com.doArtShow.controls.exhibition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.ExhibitionDao;
import com.doArtShow.dto.ExhListDto;

public class ListSortController implements Controller{
	ExhibitionDao exhibitionDao;
	
	public ListSortController setExhibitionDao(ExhibitionDao exhibitionDao){
		this.exhibitionDao = exhibitionDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("##3번 ListSortController(페이지컨트롤러)실행");
		
		String result = "";
		String res = "";
		JSONArray jsonArray = new JSONArray();
		
		int inputSort = Integer.valueOf((String)model.get("inputSort"));
		int inputTag = Integer.valueOf((String)model.get("inputTag"));
		int inputLoc = Integer.valueOf((String)model.get("inputLoc"));
		int inputGen = Integer.valueOf((String)model.get("inputGen"));
		int inputPage = Integer.valueOf((String)model.get("inputPage"));
		
		/*확인*/
		System.out.println("inputSort : " + inputSort);
		System.out.println("inputTag : " + inputTag);
		System.out.println("inputLoc : " + inputLoc);
		System.out.println("inputGen : " + inputGen);
		System.out.println("inputPage : " + inputPage);
		
		List<ExhListDto> lists = null;
		lists = exhibitionDao.selectSortList(inputSort, inputTag, inputLoc, inputGen, inputPage);
		
		ArrayList<Map> list = new ArrayList<Map>();
		JSONObject jsonObj = null;
			
		if(lists.size() > 0) {
			for(int i=0;i<lists.size();i++) {
				jsonObj = new JSONObject();
				jsonObj.put("exhID", lists.get(i).getExhID());
				jsonObj.put("imageFile1", lists.get(i).getImageFile1());
				jsonObj.put("exhName", lists.get(i).getExhName());
				jsonObj.put("exhPlace", lists.get(i).getExhPlace());
				jsonObj.put("exhStartDate", lists.get(i).getExhStartDate());
				jsonObj.put("exhEndDate", lists.get(i).getExhEndDate());
					
				list.add(jsonObj);
			}
		}
			
		int listCnt = lists.size(); //정렬로 찾을 경우의 전시갯수
		System.out.println(listCnt);
		jsonObj = new JSONObject();
		jsonObj.put("listCnt", listCnt);
		list.add(jsonObj);
			
		jsonArray.add(list);
		result = jsonArray.toJSONString();
		int idx = result.indexOf("]");
		res = result.substring(1,idx+1);
				
		return "json:" + res;
	}
	
	
}
