<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>
    <div class="container" id="mainContainer">
        <form class="container" method="post" name="signUpForm" id="signUpForm" style="padding:10px;">
            <table align="center">
                <tr>
                    <td id="formTitle" colspan="3">회원가입</td>
                </tr>
                <tr>
                    <td class="check_tr" colspan="3"></td>
                </tr>
                <tr>
                    <th><label class="tableLabel">이메일</label></th>
                    <td><input class="form-control" type="text" name="email" id="input_email" placeholder="이메일"></td>
                    <td><input class="btn btn-light" type="button" id="emailChkButton" value="중복확인"
                            style="margin-left:2vw; color: white;" onclick="emailChkModal(document.signUpForm.email.value)"></td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2">
                        <div id="email_check"></div>
                    </td>
                </tr>
                <tr>
                    <th><label class="tableLabel">이름</label></th>
                    <td>
                        <input class="form-control" type="text" name="name" id="input_name" placeholder="이름">
                    </td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2">
                        <div id="name_check"></div>
                    </td>
                </tr>
                <tr>
                    <th><label class="tableLabel">생년월일</label></th>
                    <td>
                    <select id="year" style="width: 100px;">
                    	<c:set var="today" value="<%=new java.util.Date()%>" />
                    	<fmt:formatDate value="${today}" pattern="yyyy" var="start"/>
          					<c:forEach begin="0" end="80" var="idx" step="1">
	          					<option value="<c:out value="${start - idx}" />">
	          					<c:out value="${start - idx}" />
	          					</option>
         					</c:forEach>

					</select>
					<label>년&nbsp;&nbsp;</label>
                    <select id="month" style="width: 100px;">
          					<c:forEach begin="1" end="12" var="idx" step="1">
	          					<option value="<c:out value="${idx}" />">
	          					<c:out value="${idx}" />
	          					</option>
         					</c:forEach>

					</select>
					<label>월&nbsp;&nbsp;</label>
                    <select id="day" style="width: 100px;">
          					<c:forEach begin="1" end="31" var="idx" step="1">
	          					<option value="<c:out value="${idx}" />">
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
                    <th><label class="tableLabel">성별</label></th>
                    <td>
                        <input class="form-check-input" type="radio" name="gender" id="male" value="남성"><label>남</label>
                        <input class="form-check-input" type="radio" name="gender" id="female" checked="checked"
                            value="여성"><label>여</label>
                    </td>
                </tr>
                <tr class="check_tr">
                    <td colspan="2">
                        <div></div>
                    </td>
                </tr>
                <tr>
                    <th><label class="tableLabel">비밀번호</label></th>
                    <td><input class="form-control" type="password" name="pw" id="input_pw" placeholder="비밀번호"></td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2">
                        <div id="pw_check"></div>
                    </td>
                </tr>
                <tr>
                    <th><label class="tableLabel">비밀번호 확인</label></th>
                    <td><input class="form-control" type="password" name="pw2" id="input_pw2" placeholder="비밀번호확인"></td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2">
                        <div id="pw2_check"></div>
                    </td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td colspan="2"><label style="width:40vw;">개인정보 수집 / 이용 동의(필수)</label></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <iframe width="" src="../etc/constraint1.html"></iframe>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input style="width:20px" class="checkbox" type="checkbox" name="agree">
                        <label>위의 이용 약관에 동의합니다.</label>
                    </td>
                </tr>
                <tr class="check_tr">
                    <td></td>
                    <td colspan="2"></td>
                </tr>     
                <tr class="check_tr">
                    <td colspan="3">
                        <div id="checkbox_check"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input class="btn" type="button" value="회원가입" id="submitBtn"
                            onclick="javascript:validateSignUp(this.form)"
                            style="width: 100%; color: white; font-size: 1.2em;">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
<script>
	function emailChkModal() {
	    if ($("#input_email").val() == "") {
	        $("#email_check").text("아이디를 입력하세요");
	        $("#email_check").css('color', 'red');
	        $("#emailChkButton").attr("disabled", true);
	        return;
	    } else {
	        url = "chkEmail.jsp?email=" + document.signUpForm.email.value;
	
	        window.open(url, "confirm",
	            "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, left=200, right=200, width=500, height=200"
	            );
	        $("#input_email").attr("disabled", true);
	        $("#emailChkButton").attr("disabled", true);
	    }
	}
	$(document).ready(function () {
	    $("#input_email").keyup(function () {
	        if ($("#input_email").val() != "") {
	            $("#chkEmail").text("")
	        }
	    });
	    $("#input_pw").keyup(function () {
	        if ($("#input_pw").val() != "") {
	            $("#chkPw").text("")
	        }
	    });
	});
</script>
</body>

</html>