$(document).ready(function(){
	//아이디 중복확인
	$("#emailChkModalBtn").click(function(){
		var email = $("#email_value").val();
		console.log(email);

		$.ajax({
			url : 'checkEmail.do?email='+email,
			type : 'GET',
			datatype : 'JSON',
			success : function(data){
				if(data.res == 1){
					//이메일이 중복 되는 경우
					$("#email_result").text("이미 해당 이메일로 가입 되어있습니다.");
					$("#email_result").css('color','red');
					$("#emailUseBtn").attr("disabled", true);
				} else {
					//이메일이 중복 되지 않는 경우
					//이메일 형식 검사
					var filter =  /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
					if(filter.test(email)){
						$("#email_result").text("사용가능한 이메일입니다.");
						$("#email_result").css('color','green');
						$("#emailUseBtn").attr("disabled", false);
						$('#email_value').attr('readonly', true);
					} else {
						$("#email_result").text("이메일 형식에 맞게 작성해주세요. 예시)123@art.com");
						$("#email_result").css('color','red');
						$("#emailUseBtn").attr("disabled", true);
					}
				}
			},
			error: function(request, status, error){
				var msg = "ERROR : <br>"
					msg += reqeust.status +"<br>"+ request.responseText +"<br>"+ error;
			}
		});
	});
});
