<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>
    <div class="container border" id="mainContainer">
        <div style="padding: 20vh; height: 63vh;">
            <div style="margin-bottom:50px; font-size:2em;">
                <center>가입하지 않은 이메일이거나, 잘못된 비밀번호입니다.</center>
            </div>
            <div align="center">
                <a class="btn" href="<%=request.getContextPath()%>/client/auth/findEmail.do"
                    style="color: white; margin-right: 20px;">이메일 찾기</a>
                <a class="btn" href="<%=request.getContextPath()%>/client/auth/findPw.do"
                    style="color: white; margin-right: 20px;">비밀번호 찾기</a>
                <a class="btn" href="<%=request.getContextPath()%>/client/auth/memberAdd.do"
                    style="color: white;">회원가입</a>
            </div>
        </div>
    </div>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    
</body>

</html>