<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>
    <c:if test="${!empty sessionScope.member}">
        <div class="container" id="mainContainer">
            <!-- === 프로필 부분 (profileDiv) =================================================================== -->
            <jsp:include page="profile.jsp"></jsp:include>

            <div class="container col-lg-9" id="mainDiv">


                <!-- === 다녀 온 전시 =================================================================== -->
                <label style="font-size:15pt;">다녀왔어요&nbsp;
                    <span style="color: skyblue;">
                        <c:if test="${empty requestScope.visitCount}">0</c:if>
                        <c:if test="${!empty requestScope.visitCount}">${visitCount}</c:if>
                    </span>
                </label>
                <c:choose>
                    <c:when test="${empty requestScope.visitList}">
                        <div class="box2">
                            <a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do">
                            <p>+ 내가 다녀온 전시를 등롭 해보세요</p></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="boxFull">
                            <c:forEach var="exhibition" items="${visitList}">
                                <div class="oneExhDiv">
                                    <div class="exhImgDiv">
                                        <a class="exhImgDivA"
                                            href="<%=request.getContextPath()%>/client/exhibition/ExContentView.do?exhID=${exhibition.exhID}">
                                            <img src="/doArtShow/exhibitionImages/${exhibition.imageFile1}">
                                        </a>
                                    </div>
                                    <div class="exhNameDiv">
                                        <b>${exhibition.exhName}</b>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>


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