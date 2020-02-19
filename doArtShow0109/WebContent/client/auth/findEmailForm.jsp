<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>

<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>
    <div class="container" id="mainContainer">
        <form style="height: 63vh; padding:10vh;" name="findEmailForm" method="post">
            <table align="center">
                <tr>
                    <td id="formTitle" colspan="2">이메일 찾기</td>
                </tr>
                <tr>
                    <td class="check_tr" colspan="2"></td>
                </tr>
                <tr>
                    <th><label class="tableLabel">이름</label></th>
                    <td><input class="form-control" type="text" name="name" id="input_name" placeholder="이름"></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="check_tr">
                        <div id="chkName"></div>
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
                <tr>
                    <td></td>
                    <td class="check_tr" colspan="2">
                        <div id="chkBirth"></div>
                    </td>
                </tr>
                <tr>
                	<td></td>
                    <td><input class="btn" type="button" value="다음" onclick="chkFindEmailForm(this.form)" style="color:white; width: 100%;"></td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#input_birth").keyup(function () {
                if ($("#input_birth").val() != "") {
                    $("#chkBirth").text("")
                }
            });
            $("#input_name").keyup(function () {
                if ($("#input_name").val() != "") {
                    $("#chkName").text("")
                }
            });
        });
    </script>
</body>

</html>