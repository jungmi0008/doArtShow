<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카카오 추가정보 입력</title>
</head>
	
	<script src="/doArtShow/js/jquery-3.4.1.js"></script>
	<script>
	function inputAddInfo1(){
		var email = $('#kakao_email').val();
		var name = $('#kakao_name').val();		
		var gender = $(":input:radio[name=kakao_info]:checked").val();
		var birthday = $("#kakao_birth").val();
		
		window.opener.inputAddInfo(email,name,gender,birthday);
		self.close();
	}	
	</script>
<style>
div{
  text-align:center;
  
}
</style>
<body>

	<div class="contaier">
	<h3>최초 회원가입시 성별과 생일이 필요합니다.</h3>
	<br>
			<h4>이메일을 입력해주세요.</h4>
			<input type="email" placeholder="EMAIL" id="kakao_email" width="200px;"/>	
			<br>
			<h4>이름을 입력해주세요.</h4>
			<input type="text" placeholder="이름" id="kakao_name" width="200px;"/>	
			<br>
			<h4>성별을 알려주세요.</h4>
			<label><input type="radio" name="kakao_info" value="남성" checked="checked">남성</label>
			<label><input type="radio" name="kakao_info" value="여성">여성</label>
			<br>
			<h4>생일을 알려주세요</h4>
			<input type="date" id="kakao_birth" value="2000-01-01" min="1910-01-01" max="2020-12-30"/>
			<p><input type="button" value="확인" onclick="inputAddInfo1()" style="font-weight:bold; font-size:1.1em; border:0px; background-color: #ffe500;width: 350px;height: 50px;"></p>
			<br><br><hr>
			<img src="/doArtShow/resourcesImages/mainNameBlack.png">
			<hr>
	</div>

</body>
</html>