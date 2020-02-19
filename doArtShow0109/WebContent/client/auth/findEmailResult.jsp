<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>

<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>

    <!-- 가입되어있는 이메일이 없는 경우 -->
    <c:if test="${empty sessionScope.email}">
        <div class="container" id="mainContainer">
            <div style="padding: 20vh; height: 63vh;">
                <div style="margin-bottom:50px; font-size:2em;">
                    <center>가입되어 있는 이메일이 없습니다</center>
                </div>
                <div align="center">
                    <a class="btn" href="javascript:addFormLogin()" style="color: white; margin-right: 20px;"">다시 로그인 하기</a>
                    <a class="btn" href="<%=request.getContextPath()%>/client/auth/findEmail.do"
                        style="color: white;">이메일 찾기</a>
                </div>
            </div>
        </div>
    </c:if>

    <!-- 가입되어있는 이메일이 있는 경우 -->
    <c:if test="${!empty sessionScope.email}">
        <div class="container border" id="mainContainer">
            <div style="padding: 20vh; height: 63vh;">
                <div style="margin-bottom:50px; font-size:2em;">
                    <center>회원님의 이메일은 <b>${email }</b>입니다.</center>
                </div>
                <div align="center">
                    <a class="btn" href="javascript:addFormLogin()" 
                    style="color: white; margin-right: 20px;">다시 로그인 하기</a>
                    <a class="btn" href="<%=request.getContextPath()%>/client/auth/findPw.do" 
                    style="color: white;">비밀번호 찾기</a>
                </div>
            </div>
        </div>
    </c:if>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    
</body>

</html>