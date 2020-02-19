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

	memInsForm.action="memberInsertPro.jsp";
	memInsForm.submit();
} //End - function memberInsertCheckForm(memInsForm) 
