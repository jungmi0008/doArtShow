<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
</head>
<jsp:include page="../../module/2body_first.jsp"></jsp:include>

<body>
    <c:if test="${!empty sessionScope.member}">
        <div class="container" id="mainContainer">
        <div style="margin-bottom: 8vh; padding: 8vh;">
            <div id="formTitle" style="margin-bottom:2vh;">회원탈퇴신청</div>
            <div>
                <p>회원 탈퇴 신청에 앞서 아래 내용을 반드시 확인해 주세요.</p>
            </div>
            <div>
                <p><b><span><i class="fa fa-check"></i></span>탈퇴시 해당 아이디에 대한 정보(리뷰 등)는 복구가 불가능 합니다.
                        탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</b></p>
                <ul id="deleteList">
                    <li>
                        <p>리뷰</p>
                    </li>
                    <li>
                        <p>가고 싶은 전시 목록</p>
                    </li>
                    <li>
                        <p>갔다 온 전시 목록</p>
                    </li>
                </ul>
            </div>
            <div>
                <p><b><span><i class="fa fa-check" id="checkIcon"></i></span>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로
                        남아있습니다.</b><br>
                    등록되어 있는 전시는 탈퇴 시 자동으로 삭제되지 않고 그대로 남아있습니다.<br>
                    삭제를 원하는 전시가 있다면 <span style="color:orange">반드시 탈퇴 전 삭제하시기바랍니다.</span><br>
                    탈퇴 후에는 회원정보가 삭제되어 보인 여부를 확인할 방법이 없어, 전시 게시물을 임의로 삭제해드릴 수 없습니다.</p>
            </div>
            <br><br>
                    <div><a class="btn" href="<%=request.getContextPath()%>/client/auth/memberDelete.do" style="color: white;">탈퇴하기</a></div>
            
        </div>
        </div>
    </c:if>
    <c:if test="${empty sessionScope.member}">
        <jsp:include page="askLogIn.jsp"></jsp:include>
    </c:if>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    
</body>

</html>