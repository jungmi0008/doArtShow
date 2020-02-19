//회원가입 유효성 검사
function validateSignUp(signUpForm){
	console.log(signUpForm.email.value);
	
	//이메일 입력여부 검사
	if(!signUpForm.email.value){
		$("#email_check").text("이메일을 입력하세요");
		$("#email_check").css('color','red');
		signUpForm.email.focus();
		return false;  
	}

	//이름 입력여부 검사
	if(!signUpForm.name.value){
		$("#name_check").text("이름을 입력하세요");
		$("#name_check").css('color','red');
		signUpForm.name.focus();
		return false;
	}
	
	//생년월일 입력여부 검사
	var year 	= $("#year").val();
	var month 	= $("#month").val();
	var day 	= $("#day").val();
	var birth 	= year+"-"+month+"-"+day;
	signUpForm.birth.value=birth;
	
	//비밀번호 입력여부 검사
	if(!signUpForm.pw.value){
		$("#pw_check").text("비밀번호를 입력하세요");
		$("#pw_check").css('color','red');
		signUpForm.pw.focus();
		return false;
	}
	
	//비밀번호확인 입력여부 검사
	if(!signUpForm.pw2.value){
		$("#pw2_check").text("비밀번호를 다시 입력하세요");
		$("#pw2_check").css('color','red');
		signUpForm.pw2.focus();
		return false;
	}
	
	//체크박스 체크여부 검사
	if($("input:checkbox[name='agree']").is(":checked") == false){
		$("#checkbox_check").text("이용약관에 동의해주세요");
		$("#checkbox_check").css('color','red');
		return false;
	} else {
		$("#checkbox_check").text("");
	}
	signUpForm.action = "memberAdd.do?email="+signUpForm.email.value;
	signUpForm.submit();
}

//회원 정보수정(생년월일 수정)
function checkUpdateForm(updateForm){
	if(!updateForm.pw.value){
		$("#pw_check").text("본인인증을 위해 비밀번호를 입력하세요");
		$("#pw_check").css('color','red');
		updateForm.pw.focus();
		return false;
	}
	//생년월일 입력여부 검사
	var year 	= $("#year").val();
	var month 	= $("#month").val();
	var day 	= $("#day").val();
	var birth 	= year+"-"+month+"-"+day;
	updateForm.birth.value=birth;
	
	confirm("회원정보를 수정하시겠습니까?")
	updateForm.action="memberUpdate.do"
	updateForm.submit();
}

//이메일 찾기 폼 유효성 검사
function chkFindEmailForm(findEmailForm){
	if(!findEmailForm.name.value){
		$("#chkName").text("이름을 입력하세요");
		$("#chkName").css('color','red');
		findEmailForm.name.focus();
		return false;
	}
	if(!findEmailForm.birth.value){
        $("#chkBirth").text("생년월일을 입력하세요");
        $("#chkBirth").css('color','red');
        findEmailForm.birth.focus();
        return false;
    }
	
	
	findEmailForm.action="findEmail.do"
	findEmailForm.submit();
}	

//비밀번호 찾기 폼 유효성 검사
function chkFindPwForm(findPwForm){
	if(!findPwForm.email.value){
		 $("#chkEmail").text("이메일을 입력하세요");
	     $("#chkEmail").css('color','red');
	     findPwForm.email.focus();
		 return false;
	}
	if(!findPwForm.birth.value){
		 $("#chkBirth").text("생년월일을 입력하세요");
	     $("#chkBirth").css('color','red');
	     findPwForm.birth.focus();
	     return false;
	}
	findPwForm.action = "findPw.do";
	findPwForm.submit();
}