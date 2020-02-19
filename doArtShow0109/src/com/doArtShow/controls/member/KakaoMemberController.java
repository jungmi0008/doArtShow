package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;


// 전시회 등록 컨트롤러
public class KakaoMemberController implements Controller{
	MemberDao memberDao;
	
	public KakaoMemberController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String referer = (String)model.get("Referer");
  		String result= null;
		MemberDto member = new MemberDto();
		MemberDto loginInfo = (MemberDto)model.get("member");
		JSONObject jsonObj = (JSONObject)model.get("jsonObj");
		//로그인하면 되는지, 회원가입을 시켜야 하는지, 회원가입 해야하는데(kakaoId가 없는데) 이메일이 중복인지 체크함.
		//1. 로그인 하거나, profileImg의 값으로 분기한 뒤 처리.
		member = memberDao.kakaoCheckMember( loginInfo.getEmail(), loginInfo.getKakaoId(), loginInfo.getName(),loginInfo.getBirth(),loginInfo.getGender());		
        
		//2. 회원가입 후 바로 로그인 처리 해주기 위해 다시 보냄. 이후 세션 줌.
		if(member.getProfileImg().equals("회원가입했어요!로그인해줘요")){
        member = memberDao.kakaoCheckMember(loginInfo.getEmail(), loginInfo.getKakaoId(),null,null,null);
		HttpSession session = (HttpSession)model.get("session");
        session.setAttribute("member", member);
        //가입 페이지에서 로그인/회원가입시 돌려보냄. 이후 접근 못하게 함.
        if(referer.startsWith("http://localhost:8888/doArtShow/client/auth/memberAdd.do?")) {
        	return "redirect:/doArtShow";
        	}
        
        return "redirect:/doArtShow";
        
        //3. 이메일이 이미 사용중이므로 가입 및 로그인 처리 하지 않음. ajax 콜백함수에서 알림
        }else if(member.getProfileImg().equals("이메일중복")){
        	//json 콜백함수에게 alert 처리하라고 응답
        	jsonObj.put("res", 2);
        	result = jsonObj.toJSONString();
        	return "json:"+result;
        	
        //4. SQL Exception으로 인한 에러. Ajax 콜백함수에서 알림.
        }else if(member.getProfileImg().equals("에러발생")){
        	//json 콜백함수에게 alert 처리하라고 응답
        	jsonObj.put("res", 3);
        	result = jsonObj.toJSONString();
        	return "json:"+result;
        	
        //1-1. 바로 로그인처리
        }else if(member.getProfileImg().equals("회원가입필요함")){
        	System.out.println("회원가입필요함에 걸림 ㅎㅎ");
        	//ajax로 돌아가서 다음 단계 진행하도록 응답
        	jsonObj.put("res", 4);
        	result = jsonObj.toJSONString();
        	return "json:"+result;
        }else{
			HttpSession session = (HttpSession)model.get("session");
	        session.setAttribute("member", member);
	        
	        if(referer.startsWith("http://localhost:8888/doArtShow/client/auth/memberAdd.do?")) {return "redirect:"+referer;}
        }
    	jsonObj.put("res", 1);//다시 ajax로 돌아가는 처리
    	result = jsonObj.toJSONString();
    	return "json:"+result;
		
        /*return "redirect:"+referer;*/
        
	}
	
	
	
	
	
	
	
	
}
