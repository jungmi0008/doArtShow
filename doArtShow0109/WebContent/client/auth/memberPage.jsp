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
                <!-- === 나의리뷰 =================================================================== -->
                <label style="font-size:15pt;">나의 리뷰&nbsp;
                    <span style="color: skyblue;">
                        <c:if test="${empty requestScope.reviewCount}">0</c:if>
                        <c:if test="${!empty requestScope.reviewCount}">${reviewCount}</c:if>
                    </span>
                </label>
                <a href="<%=request.getContextPath()%>/client/auth/reviewList.do" class="seeAll">전체보기</a>
                <c:choose>
                    <c:when test="${empty requestScope.reviewList}">
                        <div class="box">
                            <a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do">
                                <p>+ 내가 가본 전시 리뷰를 작성해보세요</p></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="boxFull">
                            <c:forEach var="review" items="${reviewList}" varStatus="vs"  begin="0" end="3">
                                <div class="oneRev">
                                    <div class="revImg">
                                        <a class="revImgA"
                                            href="<%=request.getContextPath()%>/client/exhibition/ExContentView.do?exhID=${review.exhID}">
                                            <img src="/doArtShow/exhibitionImages/${review.imageFile1}">
                                        </a>
                                    </div>
                                    <div class="revBody">
                                            <div class="navbar" id="revExhName<c:out value='${vs.index}'/>">
                                                <span class="revExhNameSpan">
                                                    ${review.exhName}
                                                </span>
                                                <div class="navbar-item dropdown">

                                                    <a class="nav-link" href="#" data-toggle="dropdown">
                                                        <span style="float: right; font-size: 1.2em;"><i
                                                                class="fa fa-ellipsis-v"></i>
                                                        </span>
                                                    </a>
                                                    <div class="dropdown-menu  dropdown-menu-right" id="dropdown-menu">
                                                        <a class="dropdown-item"
                                                            href="javascript:openRevModal(<c:out value='${vs.index}'/>)">수정하기</a><br>
                                                        <a class="dropdown-item"
                                                            href="javascript:confirmDeleteRev(<c:out value='${vs.index}'/>)">삭제하기</a>
                                                    </div>
                                                </div>
                                            </div>
                                        <div class="revContent">
                                            ${review.revContent}
                                        </div>
                                    </div>
                                </div>
                                <div class="modal fade" id="revUpdateModal<c:out value='${vs.index}'/>" role="dialog">
                                    <div class="modal-dialog">
                                        <form method="post" name="reviewUpdateForm" id="revForm">
                                            <!-- Modal 전체 -->
                                            <div class="modal-content" id="revWriteModal-content">
                                                <!-- Modal header -->
                                                <div class="modal-header">
                                                    <button type="button" class="close"
                                                        data-dismiss="modal">&times;</button>
                                                </div>

                                                <!-- Modal body -->
                                                <div class="modal-body">
                                                    <h4 class="modal-title"><b>리뷰 수정하기</b></h4><br><br>
                                                    <table class="table nanum">
                                                        <tr>
                                                            <td width="20%">전시명</td>
                                                            <td width="80%">
                                                                ${review.exhName}
                                                                <input type="hidden" name="exhID" readonly="readonly"
                                                                    value="${review.exhID}">
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td width="20%">리뷰 작성일</td>
                                                            <td width="80%">${review.revDate}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>리뷰 내용</td>
                                                            <td>
                                                                <textarea cols="60" rows="15" name="revContent" id="revContent"
                                                                    placeholder="리뷰는 50자 이내로 작성 가능합니다.">${review.revContent}</textarea>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>

                                                <!-- Modal footer -->
                                                <div id="shareModal-footer<c:out value='${vs.index}'/>">
                                                    <button type="button" class="btn btn-light"
                                                        onclick="javascript:chkreviewUpdateForm(this.form)">등록하기</button>
                                                    <button type="button" class="btn btn-danger"
                                                        data-dismiss="modal">닫기</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>

                <!-- === 가고 싶은 전시 =================================================================== -->
                <label style="font-size: 15pt;">가고 싶어요&nbsp;
                    <span style="color: skyblue;">
                        <c:if test="${empty requestScope.wishCount}">0</c:if>
                        <c:if test="${!empty requestScope.wishCount}">${wishCount}</c:if>
                    </span>
                </label>
                <a href="<%=request.getContextPath()%>/client/auth/wishList.do" class="seeAll">전체보기</a>
                <c:choose>
                    <c:when test="${empty requestScope.wishList}">
                        <div class="  box">
                            <a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do">
                                <p>+ 내가 가고 싶은 전시를 찾아보세요</p></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="boxFull">
                            <c:forEach var="exhibition" items="${wishList}"  begin="0" end="2">
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

                <!-- === 다녀 온 전시 =================================================================== -->
                <label style="font-size:15pt;">다녀왔어요&nbsp;
                    <span style="color: skyblue;">
                        <c:if test="${empty requestScope.visitCount}">0</c:if>
                        <c:if test="${!empty requestScope.visitCount}">${visitCount}</c:if>
                    </span>
                </label>
                <a href="<%=request.getContextPath()%>/client/auth/visitList.do" class="seeAll">전체보기</a>
                <c:choose>
                    <c:when test="${empty requestScope.visitList}">
                        <div class="box">
                            <a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do"><p>+ 내가 다녀온 전시를 등록
                                해보세요</p></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="boxFull">
                            <c:forEach var="exhibition" items="${visitList}" begin="0" end="2">
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

                <!-- === 내가 등록한 전시 =================================================================== -->
                <label style="font-size: 15pt;" id="mypageBottom">등록한 전시&nbsp;
                    <span style="color: skyblue;">
                        <c:if test="${empty requestScope.myExhCount}">0</c:if>
                        <c:if test="${!empty requestScope.myExhCount}">${myExhCount}</c:if>
                    </span>
                </label>
                <a href="<%=request.getContextPath()%>/client/exhibition/myList.do" class="seeAll">전체보기</a>

                <c:choose>
                    <c:when test="${empty requestScope.myExhList}">
                        <div class="box">
                            <a href="<%=request.getContextPath()%>/client/exhibition/addForm.do"><p>+ 전시를 직접 등록해보세요</p></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="boxFull">
                            <c:forEach var="exhibition" items="${myExhList}"  begin="0" end="2">
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
    <script>
		function openRevModal(num) {
		    $("#revUpdateModal" + num).modal({
		        backdrop: true
		    });
		}
		
		function confirmDeleteRev(num) {
		    confirm("삭제하시겠습니까?");
		    var exhN = $("#revExhName" + num).find("span").text().trim();
 		    location.href = "revDelete.do?exhName=" + exhN;
		}
		
		function chkreviewUpdateForm(reviewUpdateForm) {
		    if (!reviewUpdateForm.revContent.value) {
		        alert("내용을 작성해주세요");
		        revForm.revConter.focus();
		        return false;
		    }
		
		    reviewUpdateForm.action = "revUpdate.do";
		    reviewUpdateForm.submit();
		}

	</script>
</body>

</html>