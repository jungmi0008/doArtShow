<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>NaverLoginSDK</title>
</head>

<body>
   <script src="/doArtShow/js/jquery-3.4.1.js" type="text/javascript"></script>
   <script src="/doArtShow/js/naveridlogin_js_sdk_2.0.0.js" type="text/javascript"></script>
   <script type="text/javascript"  type="text/javascript" charset="utf-8">

   var email,name,profileImage,birthday,uniqId,age,gender;
   var naverLogin = new naver.LoginWithNaverId(
         {
            clientId: "QvLk55msCCyAfv2p50Yg",
            callbackUrl: "http://localhost:8888/doArtShow/NaverCallback",
            isPopup: false,
            callbackHandle: true
         }
      );
      naverLogin.init();

      window.addEventListener('load', function () {
         naverLogin.getLoginStatus(function (status) {

            if (status) {
                 email = naverLogin.user.getEmail();
                 name = naverLogin.user.getNickName();
   				 profileImage = naverLogin.user.getProfileImage();
   				 birthday = naverLogin.user.getBirthday();			
   				 uniqId = naverLogin.user.getId();
   				 age = naverLogin.user.getAge();
   				 gender = naverLogin.user.getGender();
   				
               if( email == undefined || email == null) {
                  alert('이메일은 필수 항목입니다. 정보 제공에 동의해주세요.');
                  naverLogin.reprompt();
                  return;
               }
               if( name == undefined || name == null) {
                  alert("성명은 필수 항목입니다. 정보 제공에 동의해주세요.");
                  naverLogin.reprompt();
                  return;
               }
               if( birthday == undefined || birthday == null) {
                  alert("생일은 필수 항목입니다. 정보 제공에 동의해주세요.");
                  naverLogin.reprompt();
                  return;
               }
               if( gender == undefined || gender == null) {
                  alert("성별은 필수 항목입니다. 정보 제공에 동의해주세요.");
                  naverLogin.reprompt();
                  return;
               }
               birthday = '0000-'+birthday;
              /*  if(gender=='M'){
            	   gender='남성';
               }else if(gender=='F'){
            	   gender='여성';
               } */
               //alert( email +'\n'+name+'\n'+profileImage+'\n'+birthday+'\n'+uniqId+'\n'+age+'\n'+gender); // 로그인 한 이메일 ***@naver.com 이 출력된다.
               //////////////////////////////////////////

               	  $.ajax({
		        		type: "POST",
		        		url: "/doArtShow/naverLogin.do",
		        		async: false,
		        		data: {'nid':uniqId, 'email':email, 'name':name,'birth':birthday,'gender':gender},
		        		success: function(data){
		        																	console.log("성공");
		        					  if(data.res==1){
		        																	console.log("로그인처리됨");
		        					location.reload(true);
		        				}else if(data.res==2){
		        					alert("네이버 계정에서 설정한 이메일이 이미 사용중입니다.\n이메일로 로그인 해주세요.");
		           				}else if(data.res==3){
		           					alert('로그인/회원가입 처리중 오류가 발생하였습니다.\n다시 시도하시거나 관리자에게 문의해주세요.');
		           				}
		        		},
		        		error: function(e){
		        			alert('네이버 로그인에 실패했습니다.\n다시 시도하시거나 관리자에게 문의해주세요.');
		        		}
		        	});
               
               //////////////////////////////////////////
               window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/doArtShow");
            } else {
               console.log("callback 처리에 실패하였습니다.");
            }
         });
      });
   </script>
</body>

</html>