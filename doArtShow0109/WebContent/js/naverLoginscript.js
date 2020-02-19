// 네이버 로그인 API 초기화
$(function(){
	var naverLogin = new naver.LoginWithNaverId({
		clientId : "QvLk55msCCyAfv2p50Yg",
		callbackUrl : "http://localhost:8888/doArtShow/NaverCallback",
		isPopup : false, /* 팝업을 통한 연동처리 여부 */
		callbackHandle: true,
		loginButton : {
			color : "green",
			type : 3,
			height : 48
		}
	/* 로그인 버튼의 타입을 지정 */
	});

	/* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();

	});

//--------------------------------------------------------------------------------
//	로그인 모달을 띄우는 function
//--------------------------------------------------------------------------------
function addFormLogin() {
	$("#myModal").modal({
		backdrop : true
	});
	
}