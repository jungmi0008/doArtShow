<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>
    
    <div class="container border" id="mainContainer">
        <div style="padding: 20vh; height: 63vh;">
            <div style="margin-bottom:50px; font-size:2em;">
                <center>임시 비밀번호를 이메일로 보냈습니다.<br>임시비밀번호로 로그인 후 비밀번호를 수정해주세요.</center>
            </div>
            <div align="center">
                <a class="btn" href="javascript:addFormLogin()" style="color: white; margin-right: 20px;">로그인 바로 하기</a>
                <a class="btn" href="<%=request.getContextPath()%>/index.jsp" style="color: white;">메인화면 바로가기</a>
            </div>
        </div>
        </div>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    
</body>

</html>