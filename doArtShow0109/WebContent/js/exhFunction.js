/**
 * 
 */
//----------------------------------------------------------
// 아이디 중복체크
//----------------------------------------------------------
function confirmId()
{
	if(document.memInsForm.id.value == ""){
		alert("아이디를 입력하십시오")
		return;
	}
	
	url="confirmId.jsp?id=" + document.memInsForm.id.value;
	
	window.open(url, "confirm", "toolbar=no, location=no, \
					status=no, menubar=no, scrollbar=no, \
					resizable=no, width=500, height=200");
} //End - function confirmId()

//----------------------------------------------------------
// 숫자 검사
//----------------------------------------------------------
function isNumberCheck(inputVal)
{
	var var_normalize = /[^0-9]/gi; 	//정규식
	if(var_normalize.test(inputVal) == true) return false;
	else return true;
}

//----------------------------------------------------------
// 최상위 체크 로직(chars로 넘긴 값이 있다면 false)
//----------------------------------------------------------
function containsCharsOnly(input, chars)  //containsCharsOnly(13579, "0123456789")
{
	for(var inx=0; inx<input.length; inx++) {
		if(chars.indexOf(input.charAt(inx) != -1))
			return true;
	}
	return false;
}

//----------------------------------------------------------
// 숫자 체크 
//----------------------------------------------------------
function isNum(input) { //넘어오는 숫자는 문자타입임
	var chars = "0123456789"; 	
	return containsCharsOnly(input, chars);	//
}

//----------------------------------------------------------
// 영숫자 체크 
//----------------------------------------------------------
function isAlphaNumCheck(input) { //넘어오는 숫자는 문자타입임
	var chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 	
	return containsCharsOnly(input, chars);	//
}

//----------------------------------------------------------
// 이름 체크
//----------------------------------------------------------
function isNameCheck(input) { //넘어오는 숫자는 문자타입임
	var chars = "0123456789~!@#$%^&*()_-+=|{}[],./?"; 	
	return containsCharsOnly(input, chars);	//
}

//----------------------------------------------------------
// 회원등록검사
//----------------------------------------------------------
function memberInsertCheckForm(memInsForm) 
{
	//어떤것을 검사해야 할까?
	if(!memInsForm.id.value){
		alert("고객 id를 입력하십시오.");
		document.memInsForm.id.focus();
		return;
	}
	if(isAlphaNumCheck(memInsForm.id.value) == false){
		alert("고객 id는 숫자와 영문자만 사용 가능합니다.");
		document.memInsForm.id.focus();
		return;
	}
	if((memInsForm.id.value.length < 8) || (memInsForm.id.value.length > 10)){
		alert("\n고객 id는 8자리에서 10자리 사이를 입력하셔야 합니다.");
		document.memInsForm.id.focus();
		return false;
	}
	//어떤것을 검사해야 할까?
	if(!memInsForm.passwd.value){
		alert("비밀번호를 입력하십시오.");
		document.memInsForm.passwd.focus();
		return;
	}
	if(isAlphaNumCheck(memInsForm.passwd.value) == false){
		alert("비밀번호는 숫자와 영문자만 사용 가능합니다.");
		document.memInsForm.passwd.focus();
		return;
	}
	if((memInsForm.repasswd.value.length < 8) || (memInsForm.passwd.value.length > 10)){
		alert("\n비밀번호확인는 8자리에서 10자리 사이를 입력하셔야 합니다.");
		document.memInsForm.passwd.focus();
		return false;
	}
	if(!memInsForm.repasswd.value){
		alert("비밀번호확인를 입력하십시오.");
		document.memInsForm.repasswd.focus();
		return;
	}
	if(isAlphaNumCheck(memInsForm.repasswd.value) == false){
		alert("비밀번호확인는 숫자와 영문자만 사용 가능합니다.");
		document.memInsForm.repasswd.focus();
		return;
	}
	if((memInsForm.repasswd.value.length < 8) || (memInsForm.repasswd.value.length > 10)){
		alert("\n비밀번호확인는 8자리에서 10자리 사이를 입력하셔야 합니다.");
		document.memInsForm.repasswd.focus();
		return false;
	}
	if(memInsForm.passwd.value != memInsForm.repasswd.value){
		alert("비밀번호가 일치하지 않습니다. \n다시 입력하십시오");
		document.memInsForm.passwd.focus();
		return false;
	}
	
	if(!memInsForm.name.value){
		alert("이름을 입력하십시오.");
		memInsForm.name.focus();
		return false;
	}
	
	if(isNameCheck(memInsForm.name.value)==false){
		alert("이름에는 숫자나 특수문자를 입력할수없습니다.");
		document.memInsForm.name.focus();
		return false;
	}

	if(!memInsForm.address.value){
		alert("주소를 입력하십시오.");
		memInsForm.address.focus();
		return false;
	}
	
	if(!memInsForm.tel1.value){
		alert("전화번호를 입력하십시오.");
		memInsForm.tel1.focus();
		return false;
	}
	
	if(!memInsForm.tel2.value){
		alert("전화번호를 입력하십시오.");
		memInsForm.tel2.focus();
		return false;
	}
	
	if(!memInsForm.tel3.value){
		alert("전화번호를 입력하십시오.");
		memInsForm.tel3.focus();
		return false;
	}
	
	if(!isNumberCheck(memInsForm.tel2.value)){
		alert("전화번호 2번째 자리는 숫자만 입력이 가능합니다.");
		document.memInsForm.tel2.focus();
		return false;
	}
	
	if((memInsForm.tel2.value.length < 3) || (memInsForm.tel2.value.length > 4)){
		alert("전화번호 2번째 자리는 최소 3자를 입력하셔야 합니다.");
		document.memInsForm.tel2.focus();
		return false;
	}
	
	if(memInsForm.registerYn[0].checked == false){
		alert("회원가입을 하시려면 회원가입에 동의해주셔야 합니다.");
		memInsForm.registerYn.focus();
		return false;
	}
	
	if(memInsForm.is_subscribed.checked == false){	//
		alert("개인정보수집 및 이용에 동의해주셔야 회원가입을 할 수 있습니다.");
		memInsForm.is_subscribed.focus();
		return false;
	}
	//memInsForm.action="memberInsertPro.jsp";
	memInsForm.submit();
} //End - function memberInsertCheckForm(memInsForm) 



//----------------------------------------------------------
//회원등록검사
//----------------------------------------------------------
function memberUpDelCheckForm(memUpDelForm, selectVal) 
{
	//어떤것을 검사해야 할까?
	if(!memUpDelForm.passwd.value){
		alert("비밀번호를 입력하십시오.");
		document.memUpDelForm.passwd.focus();
		return;
	}
	if(isAlphaNumCheck(memUpDelForm.passwd.value) == false){
		alert("비밀번호는 숫자와 영문자만 사용 가능합니다.");
		document.memberUpDelForm.passwd.focus();
		return;
	}
	if((memUpDelForm.repasswd.value.length < 8) || (memUpDelForm.passwd.value.length > 10)){
		alert("\n비밀번호확인는 8자리에서 10자리 사이를 입력하셔야 합니다.");
		document.memUpDelForm.passwd.focus();
		return false;
	}
	if(!memUpDelForm.repasswd.value){
		alert("비밀번호확인를 입력하십시오.");
		document.memUpDelForm.repasswd.focus();
		return;
	}
	if(isAlphaNumCheck(memUpDelForm.repasswd.value) == false){
		alert("비밀번호확인는 숫자와 영문자만 사용 가능합니다.");
		document.memUpDelForm.repasswd.focus();
		return;
	}
	if((memUpDelForm.repasswd.value.length < 8) || (memUpDelForm.repasswd.value.length > 10)){
		alert("\n비밀번호확인는 8자리에서 10자리 사이를 입력하셔야 합니다.");
		document.memberUpDelForm.repasswd.focus();
		return false;
	}
	if(memUpDelForm.passwd.value != memUpDelForm.repasswd.value){
		alert("비밀번호가 일치하지 않습니다. \n다시 입력하십시오");
		document.memberUpDelForm.passwd.focus();
		return false;
	}
	
	
	alert("selectVal : " + selectVal);
	//수정일 경우만 검사한다.
	if(selectVal == "UP") {
	if(!memUpDelForm.name.value){
		alert("이름을 입력하십시오.");
		memUpDelForm.name.focus();
		return false;
	}
	
	if(isNameCheck(memUpDelForm.name.value)==false){
		alert("이름에는 숫자나 특수문자를 입력할수없습니다.");
		document.memUpDelForm.name.focus();
		return false;
	}

	if(!memUpDelForm.address.value){
		alert("주소를 입력하십시오.");
		memUpDelForm.address.focus();
		return false;
	}
	
	if(!memUpDelForm.tel1.value){
		alert("전화번호를 입력하십시오.");
		memUpDelForm.tel1.focus();
		return false;
	}
	
	if(!memUpDelForm.tel2.value){
		alert("전화번호를 입력하십시오.");
		memUpDelForm.tel2.focus();
		return false;
	}
	
	if(!memUpDelForm.tel3.value){
		alert("전화번호를 입력하십시오.");
		memUpDelForm.tel3.focus();
		return false;
	}
	
	if(!isNumberCheck(memUpDelForm.tel2.value)){
		alert("전화번호 2번째 자리는 숫자만 입력이 가능합니다.");
		document.memUpDelForm.tel2.focus();
		return false;
	}
	
	if((memUpDelForm.tel2.value.length < 3) || (memUpDelForm.tel2.value.length > 4)){
		alert("전화번호 2번째 자리는 최소 3자를 입력하셔야 합니다.");
		document.memberUpDelForm.tel2.focus();
		return false;
	}
	}
	memUpDelForm.action = "memberUpDelModalForm.jsp?mode=" + selectVal;
	memUpDelForm.submit();
} //End - function 

//----------------------------------------------------------
//파일 미리보기1 - 시작
//----------------------------------------------------------
function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
//----------------------------------------------------------
//파일 미리보기1 - 끝
//----------------------------------------------------------
//----------------------------------------------------------
//파일 미리보기2 - 시작
//----------------------------------------------------------
function previewImage2(targetObj, View_area2) {
	var preview = document.getElementById(View_area2); //div id
	var ua = window.navigator.userAgent;

//ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area2);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area2); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area2)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area2;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
//ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area2); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area2;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
//----------------------------------------------------------
//파일 미리보기2 - 끝
//----------------------------------------------------------
//----------------------------------------------------------
//파일 미리보기3 - 시작
//----------------------------------------------------------
function previewImage3(targetObj, View_area3) {
	var preview = document.getElementById(View_area3); //div id
	var ua = window.navigator.userAgent;

//ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area2);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area3); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area3)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area3;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
//ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area3); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area3;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
//----------------------------------------------------------
//파일 미리보기3 - 끝
//----------------------------------------------------------
//----------------------------------------------------------
//파일 미리보기4 - 시작
//----------------------------------------------------------
function previewImage4(targetObj, View_area4) {
	var preview = document.getElementById(View_area4); //div id
	var ua = window.navigator.userAgent;

//ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area4);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area4); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area4)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area4;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
//ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area4); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area4;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '100px'; 
			img.style.height = '100px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}
//----------------------------------------------------------
//파일 미리보기4 - 끝
//----------------------------------------------------------
//----------------------------------------------------------
//파일업로드-이미지미리보기 - begin
//----------------------------------------------------------
function LoadImg(value) {
  		if(value.files && value.files[0]) {
 			var reader = new FileReader();
 			reader.onload = function(e) {
 				$('#LoadImg').attr('src', e.target.result);
 			}
 			reader.readAsDataURL(value.files[0]);
 		}
 	}
//----------------------------------------------------------
//파일업로드-이미지미리보기 - end
//----------------------------------------------------------
//----------------------------------------------------------
//전시회등록유효성체크 - 시작
//----------------------------------------------------------
function exhRegisterCheckForm(exhRegisterForm) {
	/*
	var chk = false
	for(var i =0; document.exhRegisterForm.exhGubun3.length ; i++){
	    if(document.exhRegisterForm.exhGubun3[i].checked){  
	        chk = true; 
	    }
	}
	if(!chk ){
	    alert('태그를 선택하세요')
	}*/
	
	/*if($("input[name='exhGubun3']").is(":checked")){
		alert("cheked")
		console.log('체크박스에 체크가 됨###');
		//return true;
		exhRegisterForm.action = "add.do";
		exhRegisterForm.submit();
		return;
	} else {
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('태그를 선택하세요')

		$("input[name='exhGubun3']").eq(0).focus();

		return false;
	}*/
	
	var exhGubun1 = $("#exhGubun1").val();
	var exhGubun2 = $("#exhGubun2").val();
	var exhName = $("#exhName").val();
	var artistName = $("#artistName").val();
	var exhPlace = $("#exhPlace").val();
	var exhAddr1 = $("#exhAddr1").val();
	var exhGubun4 = $("#exhGubun4").val();
	var exhStartDate = $("#exhStartDate").val();
	var exhEndDate = $("#exhEndDate").val();
	var opTime = $("#opTime").val();
	var tel1 = $("#tel1").val();
	var tel2 = $("#tel2").val();
	var tel3 = $("#tel3").val();
	var admFee = $("#admFee").val();
	var file1 = $("#profile_pt1").val();
	var file2 = $("#profile_pt2").val();
	
	if(exhGubun1 == "") {
		alert("전시회 분류 선택하십시오.");
		$("#exhGubun1").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhGubun2 == "") {
		alert("장르를 선택하십시오.");
		$("#exhGubun2").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(!($("input[name='exhGubun3']").is(":checked"))){
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('태그를 선택하세요')
		$("input[name='exhGubun3']").eq(0).focus();
		return false;
	} /*else {
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('태그를 선택하세요')

		$("input[name='exhGubun3']").eq(0).focus();

		return false;
	}*/
	if(exhName == "") {
		alert("전시회명을 입력하십시오.");
		$("#exhName").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(artistName == "") {
		alert("작가명을 입력하십시오.");
		$("#artistName").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhPlace == "") {
		alert("전시관을 입력하십시오.");
		$("#exhPlace").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhAddr1 == "") {
		alert("전시관 주소를 입력하십시오.");
		$("#exhAddr1").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhGubun4 == "") {
		alert("전시관 지역을 선택하십시오.");
		$("#exhGubun4").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(!exhStartDate){
		alert("전시 시작일을 선택하십시오");
		$("#exhStartDate").focus();	//입력 포커스 이동
		return false;
	}
	if(!exhEndDate){
		alert("전시 종료일을 선택하십시오.");
		$("#exhEndDate").focus();	//입력 포커스 이동
		return false;
	}
	if(!opTime){
		alert("전시 운영 시간을 입력하십시오.");
		$("#exhStartDate").focus();	//입력 포커스 이동
		return false;
	}
	if(!tel1){
		alert("전시회 1번째 자리를 선택하십시오.");
		$("#tel1").focus();	//입력 포커스 이동
		return false;
	}
	if(!tel2){
		alert("전시회 2번째 자리를 선택하십시오.");
		$("#tel2").focus();	//입력 포커스 이동
		return false;
	}
	if(!isNumberCheck(tel2)){
		alert("전화번호 2번째 자리는 숫자만 입력이 가능합니다.");
		$("#tel2").focus();	//입력 포커스 이동
		return false;
	}
	if(!tel3){
		alert("전시회 3번째 자리를 선택하십시오.");
		$("#tel3").focus();	//입력 포커스 이동
		return false;
	}
	if(!isNumberCheck(tel3)){
		alert("전화번호 3번째 자리는 숫자만 입력이 가능합니다.");
		$("#tel3").focus();	//입력 포커스 이동
		return false;
	}
	/*if(!admFee){
		alert("입장료를 선택하십시오.");
		$("#admFee").focus();	//입력 포커스 이동
		return false;
	}*/
	if(!($("input[name='admFee']").is(":checked"))){
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('입장료를 선택하세요')
		$("input[name='admFee']").eq(0).focus();
		return false;
	} 
	if(!file1) {
		alert("포스터 이미지 파일을 첨부하십시오.");
		$("#profile_pt1").focus();	//입력 포커스 이동
		return false;
	}
	if(!file2) {
		alert("작품사진1을 첨부하십시오.");
		$("#profile_pt1").focus();	//입력 포커스 이동
		return false;
	}
	
	//영기
	var form = exhRegisterForm;
	var data = new FormData(form);
	console.log(form+'///form입니다');
	console.log(data+'///data입니다');
	
	$.ajax({
		type: "POST",
		enctype: 'multipart/form-data',
		url: "add.do",
		data: data,
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function(data){
			if(data.res==1){alert("전시 등록 신청이 완료됐습니다.");
				location.replace('/doArtShow/client/auth/memberPage.do');}
		},
		error: function(e){
			alert('전시 등록에 실패했습니다.');
		}
	});
	

	/*exhRegisterForm.action = "add.do";
	exhRegisterForm.submit();*/
}
//----------------------------------------------------------
//전시회등록유효성체크 -끝
//----------------------------------------------------------
//----------------------------------------------------------
//전시회수정유효성체크 - 시작
//----------------------------------------------------------
function exhUpdateCheckForm(exhUpdateForm) {
	/*
	var chk = false
	for(var i =0; document.exhRegisterForm.exhGubun3.length ; i++){
	    if(document.exhRegisterForm.exhGubun3[i].checked){  
	        chk = true; 
	    }
	}
	if(!chk ){
	    alert('태그를 선택하세요')
	}*/

	var exhGubun1 = $("#exhGubun1").val();
	var exhGubun2 = $("#exhGubun2").val();
	var exhName = $("#exhName").val();
	var artistName = $("#artistName").val();
	var exhPlace = $("#exhPlace").val();
	var exhPlaceAddr1 = $("#exhAddr1").val();
	var exhGubun4 = $("#exhGubun4").val();
	var exhStartDate = $("#exhStartDate").val();
	var exhEndDate = $("#exhEndDate").val();
	var opTime = $("#opTime").val();
	var tel1 = $("#tel1").val();
	var tel2 = $("#tel2").val();
	var tel3 = $("#tel3").val();
	var admFee = $("#admFee").val();
	var file1 = $("#profile_pt1").val();
	var file2 = $("#profile_pt2").val();
	
	if(exhGubun1 == "") {
		alert("전시회 분류 선택하십시오.");
		$("#exhGubun1").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhGubun2 == "") {
		alert("장르를 선택하십시오.");
		$("#exhGubun2").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(!($("input[name='exhGubun3']").is(":checked"))){
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('태그를 선택하세요')
		$("input[name='exhGubun3']").eq(0).focus();
		return false;
	} /*else {
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('태그를 선택하세요')

		$("input[name='exhGubun3']").eq(0).focus();

		return false;
	}*/
	if(exhName == "") {
		alert("전시회명을 입력하십시오.");
		$("#exhName").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(artistName == "") {
		alert("작가명을 입력하십시오.");
		$("#artistName").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhPlace == "") {
		alert("전시관을 입력하십시오.");
		$("#exhPlace").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhPlaceAddr1 == "") {
		alert("전시관 주소를 입력하십시오.");
		$("#exhAddr1").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(exhGubun4 == "") {
		alert("전시관 지역을 선택하십시오.");
		$("#exhGubun4").focus();	//입력 포커스 이동
		return; //함수 종료
	}
	if(!exhStartDate){
		alert("전시 시작일을 선택하십시오");
		$("#exhStartDate").focus();	//입력 포커스 이동
		return false;
	}
	if(!exhEndDate){
		alert("전시 종료일을 선택하십시오.");
		$("#exhEndDate").focus();	//입력 포커스 이동
		return false;
	}
	if(!opTime){
		alert("전시 운영 시간을 입력하십시오.");
		$("#exhStartDate").focus();	//입력 포커스 이동
		return false;
	}
	if(!tel1){
		alert("전시회 1번째 자리를 선택하십시오.");
		$("#tel1").focus();	//입력 포커스 이동
		return false;
	}
	if(!tel2){
		alert("전시회 2번째 자리를 선택하십시오.");
		$("#tel2").focus();	//입력 포커스 이동
		return false;
	}
	if(!isNumberCheck(tel2)){
		alert("전화번호 2번째 자리는 숫자만 입력이 가능합니다.");
		$("#tel2").focus();	//입력 포커스 이동
		return false;
	}
	if(!tel3){
		alert("전시회 3번째 자리를 선택하십시오.");
		$("#tel3").focus();	//입력 포커스 이동
		return false;
	}
	if(!isNumberCheck(tel3)){
		alert("전화번호 3번째 자리는 숫자만 입력이 가능합니다.");
		$("#tel3").focus();	//입력 포커스 이동
		return false;
	}
	/*if(!admFee){
		alert("입장료를 선택하십시오.");
		$("#admFee").focus();	//입력 포커스 이동
		return false;
	}*/
	if(!($("input[name='admFee']").is(":checked"))){
		console.log('체크박스에 체크가 되어있지 않습니다.###');
		alert('입장료를 선택하세요')
		$("input[name='admFee']").eq(0).focus();
		return false;
	}
	if(!file1) {
		alert("포스터 이미지 파일을 첨부하십시오.");
		$("#profile_pt1").focus();	//입력 포커스 이동
		return false;
	}
	if(!file2) {
		alert("작품사진을 첨부하십시오.");
		$("#profile_pt2").focus();	//입력 포커스 이동
		return false;
	}

	exhUpdateForm.action = "update.do";
	exhUpdateForm.submit();
}
//----------------------------------------------------------
//전시회등록유효성체크 - checkBox 유효성체크 -끝
//----------------------------------------------------------
//----------------------------------------------------------
//kakao 주소 검색 API 불러오기(1) - begin
//----------------------------------------------------------
/*var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = {
	center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
	level : 5
//지도의 확대 레벨
};*/
/*
//지도를 미리 생성
var map = new daum.maps.Map(mapContainer, mapOption);
//주소-좌표 변환 객체를 생성
var geocoder = new daum.maps.services.Geocoder();
//마커를 미리 생성
var marker = new daum.maps.Marker({
	position : new daum.maps.LatLng(37.537187, 127.005476),
	map : map
});*/
function sample5_execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 각 주소의 노출 규칙에 따라 주소를 조합한다. 
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
			var fullAddr = data.address; // 최종 주소 변수 
			var extraAddr = ''; // 조합형 주소 변수

			// 기본 주소가 도로명 타입일때 조합한다. 
			if (data.addressType === 'R') {
				//법정동명이 있을 경우 추가한다. 
				if (data.bname !== '') {
					extraAddr += data.bname;
				} // 건물명이 있을 경우 추가한다. 
				if (data.buildingName !== '') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다. 
				fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
			}
			// 주소 정보를 해당 필드에 넣는다. 
			document.getElementById("exhPlaceAddr1").value = fullAddr;
			// 주소로 상세 정보를 검색 
			document.getElementById('exhGubun4').focus();
			window.close();
			geocoder.addressSearch(data.address, function(results, status) {
				// 정상적으로 검색이 완료됐으면 
				if (status === daum.maps.services.Status.OK) {

					var result = results[0]; //첫번째 결과의 값을 활용

					// 해당 주소에 대한 좌표를 받아서 
					var coords = new daum.maps.LatLng(result.y, result.x);
					// 지도를 보여준다. 
					mapContainer.style.display = "block";
					map.relayout();
					// 지도 중심을 변경한다. 
					map.setCenter(coords);
					// 마커를 결과값으로 받은 위치로 옮긴다. 
					marker.setPosition(coords)
				}
			});
		}
	
	}).open();
	
	
}
//----------------------------------------------------------
//kakao 주소 검색 API 불러오기(1) - end
//----------------------------------------------------------
//----------------------------------------------------------
//kakao 주소 검색 API 불러오기(2) - begin
//----------------------------------------------------------
var element_wrap = document.getElementById('conDiv');

function execDaumPostcode() {

    new daum.Postcode({

        oncomplete: function(data) {

            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.



            // 각 주소의 노출 규칙에 따라 주소를 조합한다.

            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.

            var fullAddr = ''; // 최종 주소 변수

            var extraAddr = ''; // 조합형 주소 변수



            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.

            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우

                fullAddr = data.roadAddress;



            } else { // 사용자가 지번 주소를 선택했을 경우(J)

                fullAddr = data.roadAddress;

				//fullAddr = data.jibunAddress;

            }



            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.

            if(data.userSelectedType === 'R'){

                //법정동명이 있을 경우 추가한다.

                if(data.bname !== ''){

                    extraAddr += data.bname;

                }

                // 건물명이 있을 경우 추가한다.

                if(data.buildingName !== ''){

                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);

                }

                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.

                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');

            }



            // 우편번호와 주소 정보를 해당 필드에 넣는다.

			var obj = opener.infoform;

            //document.getElementById('POST_NO1').value = Left(data.zonecode,3); //5자리 새우편번호 사용

			//document.getElementById('POST_NO2').value = Right(data.zonecode,2); //5자리 새우편번호 사용

            //document.getElementById('ADDR1').value = fullAddr;

			//obj.POST_NO1.value = Left(data.zonecode,3); //5자리 새우편번호 사용

			//obj.POST_NO2.value = Right(data.zonecode,2); //5자리 새우편번호 사용

			//obj.ADDR1.value = fullAddr;
			obj.exhPlaceAddr1.value = fullAddr;



			window.close();



            // 커서를 상세주소 필드로 이동한다.

            //document.getElementById('ADDR2').focus();

        },

        onresize : function(size) {

            //element_wrap.style.height = size.height+'px';

        },

        width : '100%',

        height : '100%'

    }).embed(element_wrap);

	//element_wrap.style.display = 'block';

}
	function Left(str, n) {

		if (n <= 0) {

			return "";

		} else if (n > String(str).length) {

			return str;

		} else {

			return String(str).substring(0, n);

		}

	}
	function Right(str, n) {

		if (n <= 0) {

			return "";

		} else if (n > String(str).length) {

			return str;

		} else {

			var iLen = String(str).length;

			return String(str).substring(iLen, iLen - n);

		}

}
//----------------------------------------------------------
//kakao 주소 검색 API 불러오기(2) - end
//----------------------------------------------------------	
//----------------------------------------------------------
//kakao 주소 검색 API 불러오기(3) - begin
//----------------------------------------------------------	
function sample6_execDaumPostcode_2() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                //document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                //document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            //document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("exhPlaceAddr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            //document.getElementById("exhGubun4").focus();
        }
    }).open();
}
//----------------------------------------------------------
//kakao 주소 검색 API 불러오기(3) - end
//----------------------------------------------------------	

