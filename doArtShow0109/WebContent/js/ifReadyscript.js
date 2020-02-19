$(document).ready(function() {
	
	// 페이지를 최상단으로 부드럽게 이동
	$('#backtop').click(function(){
		$('html, body').animate({scrollTop:0}, 'slow');
	    return false;
	  });
		  
	
	// 로그인 모달 활성화	
	$("#myBtn").click(function() {
		$("#myModal").modal({
			backdrop : true
		});
	});
	

	//검색어를 입력하지 않고 검색창에서 엔터를 입력할 시 alert
	function chkSearch(searchForm){
		var _search = $('#inpt_search');
		if(!_search.val()){
			alert('검색어를 입력해주세요.');
			_search.focus();
			return false;
		}else {
			return true;
		}
	}

	// 로그인 되지 않은 상태에서 '전시등록'을 누르면 로그인 화면 모달 활성화
	function addFormLogin() {
		$("#myModal").modal({
			backdrop : true
		});
	}

	
}); /* end of ready script */

