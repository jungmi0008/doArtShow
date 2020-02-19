<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<style>
	td{
		font-size: 1.2em;
		
	}
</style>

<body>

    <jsp:include page="../../module/2body_first.jsp"></jsp:include>

    <c:if test="${!empty sessionScope.member}">
        <div class="container" id="mainContainer">
            <form method="post" name="updateForm" id="updateForm">
                <table align="center">
                    <tr>
                        <td id="formTitle" colspan="3">회원정보수정</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/client/auth/memberDelete.jsp"
                                style="color:gray; font-size:0.8em">탈퇴하기</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="check_tr" colspan="3"></td>
                    </tr>
                    <tr>
                        <th><label class="tableLabel">이메일</label></th>
                        <td>${member.email}</td>
                    </tr>
                    <tr>
                        <td class="check_tr" colspan="3">
                            <div></div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="tableLabel">이름</label></th>
                        <td>${member.name}</td>
                    </tr>

                    <tr>
                        <td class="check_tr" colspan="3">
                            <div></div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="tableLabel">비밀번호</label></th>
                        <td><input class="form-control" type="password" name="pw" id="input_pw">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="check_tr" colspan="2">
                            <div id="pw_check"></div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="tableLabel">비밀번호 확인</label></th>
                        <td><input class="form-control" type="password" name="pw2" id="input_pw2">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="check_tr" colspan="2">
                            <div id="pw2_check"></div>
                        </td>
                    </tr>
                    <tr>
                    <th><label class="tableLabel">생년월일</label></th>
                    <td>
                    <c:set var="birthString" value="${member.birth}"/>
                    <c:set var="year" value="${fn:split(birthString, '-')[0]}"/>
                    <c:set var="month" value="${fn:split(birthString, '-')[1]}"/>
                    <c:set var="day" value="${fn:split(birthString, '-')[2]}"/>
                    
                    <select id="year" style="width: 100px;">
                    		<c:set var="today" value="<%=new java.util.Date()%>" ></c:set>
          					<fmt:formatDate value="${today}" pattern="yyyy" var="start"></fmt:formatDate>
          					<c:forEach begin="0" end="80" var="idx" step="1">
	          					<option value="<c:out value="${start - idx}" />" <c:if test="${(start - idx) eq year}">selected</c:if>>
	          					<c:out value="${start - idx}" />
	          					</option>
         					</c:forEach>

					</select>
					<label>년&nbsp;&nbsp;</label>
                    <select id="month" style="width: 100px;">
          					<c:forEach begin="1" end="12" var="idx" step="1">
	          					<option value="<c:out value="${idx}" />" <c:if test="${idx eq month}">selected</c:if>>
	          						<c:out value="${idx}"/>
	          					</option>
         					</c:forEach>

					</select>
					<label>월&nbsp;&nbsp;</label>
                    <select id="day" style="width: 100px;">
          					<c:forEach begin="1" end="31" var="idx" step="1">
	          					<option value="<c:out value="${idx}" />" <c:if test="${idx eq day}">selected</c:if>>
	          					<c:out value="${idx}" />
	          					</option>
         					</c:forEach>

					</select>
					<label>일&nbsp;&nbsp;</label>
                        <input type="hidden" name="birth">
                    </td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2">
                        <div></div>
                    </td>
                </tr>
                    <tr>
                        <td></td>
                        <td class="check_tr" colspan="2">
                            <div id="birth_check"></div>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="tableLabel">성별</label></th>
                        <td>
                            <input class="form-check-input" type="radio" name="gender" id="male" value="남성" <c:if
                                test="${member.gender eq '남성'}">checked="checked"
    </c:if>>남성
    <input class="form-check-input" type="radio" name="gender" id="female" value="여성" <c:if
        test="${member.gender eq '여성'}">checked="checked"</c:if>>여성
    </td>
    </tr>
    <tr>
        <td class="check_tr" colspan="3">
            <div></div>
        </td>
    </tr>
    <tr>
        <th><label class="tableLabel">프로필 사진</label></th>
        <td>
            <a href="javascript:profileImgUpdate();">
                <img src="../../memberProfileImages/${member.profileImg}" alt="${member.profileImg}" width="120px" height="120px">
            </a>
        </td>
    </tr>
    <tr>
        <td class="check_tr" colspan="3">
            <div></div>
        </td>
    </tr>
    <tr>
        <td class="check_tr" colspan="3">
            <div></div>
        </td>
    </tr>
    <tr>
        <td class="check_tr" colspan="2">
            <input class="btn" type="button" onclick="checkUpdateForm(this.form)" value="수정" style="color: white; width: 40%; margin-left: 9%;margin-right: 10%;">
            <input class="btn" type="button" onclick="javascript:history.go(-1)" value="취소" style="color: white; width: 40%;">
        </td>
    </tr>
    </table>
    </form>
    </div>
    </c:if>
    <c:if test="${empty sessionScope.member}">
        <jsp:include page="askLogIn.jsp"></jsp:include>
    </c:if>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    <script>

//--------------------------------------------------------------------------------
//	memberDetail.jsp	회원정보 수정 유효성 검사
//--------------------------------------------------------------------------------
$(document).ready(function(){
	//비밀번호 입력을하고 나면 알림 부분을 비워준다.	
	$("#input_pw").keyup(function(){
		if($("#input_pw").val() != null){
			$("#pw_check").text("")
		}
	});

	//비밀번호 유효검사
	$("#input_pw").blur(function(){
		var pw = $("#input_pw").val();
		var filter = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
		if(filter.test(pw)){
			$("#pw_check").text("");
			$("#pwSubmitBtn").attr("disabled", false);
		} else {
			$("#pw_check").text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
			$("#pw_check").css('color','red');
			$("#pwSubmitBtn").attr("disabled", true);
		}			
	});
	
	//비밀번호 확인이 이전 비밀번호와 일치하는지 검사
	$("#input_pw2").blur(function(){
		var pw = $("#input_pw").val();
		var pw2 = $("#input_pw2").val();
		if(pw2 != pw){
			$("#pw2_check").text("비밀번호가 일치하지 않습니다.");
			$("#pw2_check").css('color','red');
			$("#submitBtn").attr("disabled", true);
		} else {
			$("#pw2_check").text("");
			$("#submitBtn").attr("disabled", false);
		}
	});
});

//--------------------------------------------------------------------------------
//	memberDetail.jsp	프로필 사진 수정을 위한 jsp페이지를 여는 기능
//--------------------------------------------------------------------------------
function profileImgUpdate() {
    url = "profileImgUpdate.jsp";

    window.open(url, "confirm",
        "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, left=200, right=200, width=500, height=500"
        );
}
</script>
</body>

</html>