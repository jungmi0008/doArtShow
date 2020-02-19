/**
 * 도서관련 스크립트
 */
//-------------------------------------------------
// 도서 등록시 점검 항목 
//-------------------------------------------------
function checkForm(writeForm){
	if(!writeForm.book_kind.value){ //북종류의 값이 없으면
		alert("책의 분류를 선택하십시오.");
		writeForm.book_kind.focus();
		return;
	}
	if(!writeForm.book_title.value){
		alert("책의 제목을 입력하십시오.");
		writeForm.book_title.focus();
		return;
	}
	if(!writeForm.book_price.value){
		alert("책의 가격을 입력하십시오.");
		writeForm.book_price.focus();
		return false;
	}
	if(!writeForm.book_count.value){
		alert("책의 수량을 입력하십시오.");
		writeForm.book_count.focus();
		return false;
	}
	if(!writeForm.author.value){
		alert("책의 저자을 입력하십시오.");
		writeForm.author.focus();
		return false;
	}
	if(!writeForm.publishing_com.value){
		alert("출판사를 입력하십시오.");
		writeForm.publishing_com.focus();
		return false;
	}
	if(!writeForm.book_content.value){
		alert("책내용을 입력하십시오.");
		writeForm.book_content.focus();
		return false;
	}
	if(!writeForm.discount_rate.value){
		alert("할인율을 입력하십시오.");
		writeForm.discount_rate.focus();
		return false;
	}
	writeForm.action="bookRegisterPro.jsp";
	writeForm.submit();
}//End-function checkForm(writeForm)
//-------------------------------------------------
// 도서 수정시 점검 항목 
//-------------------------------------------------
function updateCheckForm(writeForm){
	if(!writeForm.book_kind.value){ //북종류의 값이 없으면
		alert("책의 분류를 선택하십시오.");
		writeForm.book_kind.focus();
		return;
	}
	if(!writeForm.book_title.value){
		alert("책의 제목을 입력하십시오.");
		writeForm.book_title.focus();
		return;
	}
	if(!writeForm.book_price.value){
		alert("책의 가격을 입력하십시오.");
		writeForm.book_price.focus();
		return false;
	}
	if(!writeForm.book_count.value){
		alert("책의 수량을 입력하십시오.");
		writeForm.book_count.focus();
		return false;
	}
	if(!writeForm.author.value){
		alert("책의 저자을 입력하십시오.");
		writeForm.author.focus();
		return false;
	}
	if(!writeForm.publishing_com.value){
		alert("출판사를 입력하십시오.");
		writeForm.publishing_com.focus();
		return false;
	}
	if(!writeForm.book_content.value){
		alert("책내용을 입력하십시오.");
		writeForm.book_content.focus();
		return false;
	}
	if(!writeForm.discount_rate.value){
		alert("할인율을 입력하십시오.");
		writeForm.discount_rate.focus();
		return false;
	}
	writeForm.action="bookUpdatePro.jsp";
	writeForm.submit();
}//End-function updateCheckForm(writeForm)