var kid,email,name,raw_birth,birth,gender;
// 카카오 로그인 버튼을 생성합니다.
Kakao.Auth.createLoginButton({
	container : '#kakao-login-btn',
	success : function(authObj) {
		// 로그인 성공시, API를 호출합니다.
		Kakao.API.request({
			url : '/v2/user/me',
			success : function(res) {
				//console.log('\n res>>'+JSON.stringify(res));
				 //console.log('\n authObj>>'+ JSON.stringify(authObj)); //Kakao.Auth.createLoginButton에서 불러온 결과값 json형태로 출력
	             //console.log('\n access_token>>'+ authObj.access_token);
	             kid = res.id;
	             $.ajax({//이미 kakaoId가 있는 유저를 login만 처리하기 위해서
		        		type: "POST",
		        		url: "/doArtShow/kakaoLogin.do",
		        		async: false,
		        		data: {'kid':kid, 'email':'nothing'},
		        		success: function(data){
		        			if(data.res==1){//바로 로그인 처리 완료. session 생성함. 새로고침
		        					location.reload(true);
		        				}else{// kakaoId가 DB에 없음. 회원가입 처리로 넘김
		        					kakaoSignUp();
		        				}
		        		},
		        		error: function(e){
		        			alert('카카오 로그인에 실패했습니다.\n다시 시도하시거나 관리자에게 문의해주세요.');
		        		}
		        	});
	             
	             function kakaoSignUp(){//해당 kakao 계정으로 회원가입 처리
	            	 
					 var haz_gender = true;
					 var haz_name  = true;
					 var haz_birth  = true;
					 var haz_email = true;
					 
					 if(typeof res.kakao_account.gender=='undefined')haz_gender=false;
					 if(typeof res.properties['nickname']=='undefined')haz_name=false; 
					 if(typeof res.kakao_account.birthday=='undefined')haz_birth=false; 
					 if(typeof res.kakao_account['email']=='undefined')haz_email=false;
					 
					 if(haz_gender== true && haz_name== true && haz_birth == true && haz_email ==true ){
						 // 1-1) kakaoAPI로부터 모든 필요 값을 받음.
		              email = res.kakao_account['email'];
		              name = res.properties['nickname'];
		              raw_birth = res.kakao_account.birthday;
		              birth = '0000-'+raw_birth.substring(0,2)+'-'+raw_birth.substring(2,4);
		              gender = res.kakao_account.gender;
								
		             if (gender == 'male') {
											gender = '남성';
										} else {
											gender = '여성';
										}
		            		 kakaoSignUpAjax(email, name, gender, birth);
					 }else{// 1-2) kakaoAPI로부터 받지 못하여서 창 오픈.
		            	 function popupAddInfo(){
			                 var popUrl = "/doArtShow/client/OAuth/KakaoAddInfo.jsp";
			                 var popOption = " status=no, menubar=no, toolbar=no, resizable=no";//top=140, left=740, width=450, height=660,
			                 window.open(popUrl,"", popOption);//"_blank" 
		            	 }
		            	 popupAddInfo();
		            	 
		                 
					 }
					 
	             }// end - kakaoSignUp()
	             
			},
			fail : function(error) {
				alert(JSON.stringify(error)+'Kakao API 회원정보 접근 실패');
			}
		});
	},
	fail : function(err) {
		alert(JSON.stringify(err)+'Kakao API 호출 실패');
	}
});

function inputAddInfo(add_email, add_name, add_gender, add_birth){
	 if(add_gender==null || add_birth==null || add_name==null){
		 alert('잘못 입력하셨습니다.\n다시 입력해주세요.');
		 popupAddInfo();
	 }
	 email=add_email;
	 name = add_name;
	 gender= add_gender;
	 birth=add_birth;
	 console.log(email,name,gender,birth);
	 kakaoSignUpAjax(email,name,gender,birth);
	}
function kakaoSignUpAjax(email,name,gender,birth){
	 $.ajax({
   		type: "POST",
   		url: "/doArtShow/kakaoLogin.do",
   		/*data: data,*/
   		data: {'kid':kid, 'email':email,'name':name,'birth':birth,'gender':gender},
   		success: function(data){
   			location.reload(true);
   			if(data.res==2){alert("카카오 계정에서 사용중인 이메일이 이미 사용중입니다.\n이메일로 로그인 해주세요.");
   				}else if(data.res==3){
   					alert('로그인/회원가입 처리중 오류가 발생하였습니다.\n다시 시도하시거나 관리자에게 문의해주세요.');
   				}
   		},
   		error: function(e){
   			alert('카카오 로그인에 실패했습니다.\n다시 시도하시거나 관리자에게 문의해주세요.');
   		}
   	});
    }