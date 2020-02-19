package com.doArtShow.controls.member;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;


// 전시회 등록 컨트롤러
public class NaverMemberController implements Controller{
	MemberDao memberDao;
	
	public NaverMemberController setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String referer = (String)model.get("Referer");
  		String result= null;
		MemberDto member = new MemberDto();
		MemberDto loginInfo = new MemberDto();
		 loginInfo = (MemberDto)model.get("member");
		JSONObject jsonObj = (JSONObject)model.get("jsonObj");
		//로그인하면 되는지, 회원가입을 시켜야 하는지, 회원가입 해야하는데(naverId가 없는데) 이메일이 중복인지 체크함.
		//1. 로그인 하거나, profileImg의 값으로 분기한 뒤 처리. naverId가 일치하면 최하단의 else문으로 간다.
		member = memberDao.naverCheckMember( loginInfo.getEmail(), loginInfo.getNaverId(), loginInfo.getName(),loginInfo.getBirth(),loginInfo.getGender());		
        
		//2. 회원가입 후 바로 로그인 처리 해주기 위해 다시 보냄. 이후 세션 줌.
		if(member.getProfileImg().equals("회원가입했어요!로그인해줘요")){
        member = memberDao.kakaoCheckMember(loginInfo.getEmail(), loginInfo.getNaverId(),null,null,null);
		HttpSession session = (HttpSession)model.get("session");
        session.setAttribute("member", member);
        jsonObj.put("res", 1);
    	result = jsonObj.toJSONString();
    	return "json:"+result;
        /*return "redirect:/doArtShow";*/
        
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
        
        // 프로필이미지에 일치하는 분기 메시지 없을시 바로 세션 부여 로그인처리하고 if else문 밖에서 return res=1을함
        }else{
			HttpSession session = (HttpSession)model.get("session");
	        session.setAttribute("member", member);
	        
	        if(referer.startsWith("http://localhost:8888/doArtShow/client/auth/memberAdd.do?")) {return "redirect:"+referer;}
        }
		
		
		
    	jsonObj.put("res", 1);
    	result = jsonObj.toJSONString();
    	return "json:"+result;
        
	}
	
	
	
	
	
	
	
	
}
