package com.doArtShow.controls.member;

import java.util.Map;

import org.json.simple.JSONObject;

import com.doArtShow.controls.Controller;
import com.doArtShow.dao.MemberDao;
import com.doArtShow.dto.MemberDto;

//회원가입시 이메일 중복을 확인 컨트롤러
public class MemberEmailChkController implements Controller{
   
   MemberDao memberDao;
   
   public MemberEmailChkController setMemberDao(MemberDao memberDao){
      this.memberDao = memberDao;
      return this;
   }
   
   @Override
   public String execute(Map<String, Object> model) throws Exception {
	   String result = null;
	   if(model.get("checkEmailInfo") != null) {
         JSONObject jsonObj = (JSONObject)model.get("jsonObj");

         String email = (String)model.get("checkEmailInfo");
         
         int res = 0;

         try {
            res = memberDao.checkEmail(email);
         } catch (Exception e) {
            e.printStackTrace();
         }
         
         jsonObj.put("res",res);
         result = jsonObj.toJSONString();
      }
      
      return "json:"+result;
   }

}