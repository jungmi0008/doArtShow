<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="isLogin" value="${sessionScope.member}"/>

    <!-- 메인로고나 top 버튼 클릭시 최상단 좌표 역할 #page-top -->
    <!-- <span id="page-top">&nbsp;</span> -->
    <div id="page-top-div"></div>
    <!--최상단 Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top my-nav-top">
        <div id="top-container">
            <!-- 모바일에서 출력 -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <%-- top-mainlogo-img --%>
                <a class="navbar-brand page-scroll" id="top-mainlogo-a" href="/doArtShow"><div class="navbar" style="width:100px;height:30px;"></div>
                <!-- <img src="/doArtShow/resourcesImages/mainlogo2.png"> -->
                </a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav navbar-right">
                	
                	<li style="margin-top: 10px;">
                		<form name="searchForm" action="<%=request.getContextPath()%>/search.do" onsubmit="return chkSearch(this.form)" method="get">
						<div class="cntr" style="display:contents;">
							<div class="cntr-innr" style="display: inline-block;">
								<label class="search navbar" for="inpt_search">
                    				<input type="text" id="inpt_search" name="search" style="font-family: 'Noto Sans KR', sans-serif;" />
                    				<input type="submit" class="hidden" value="검색">
                    			</label>
                    		</div>
                    	</div>
                    	</form>
                	</li>
                    
                    <li>
                        <a class="page-scroll acss" href="<%=request.getContextPath()%>/client/exhibition/ExListView.do" id="top-list">
                    	  	 전시목록
                        </a>
                    </li>
                    <li>
                        <a class="page-scroll acss" href="<%=request.getContextPath()%>/searchMap.do" id="top-list">
                        	지도
                        </a>
                    </li>
                    <li>
                        <a class="page-scroll acss" href="<%=request.getContextPath() %>/client/exhibition/addForm.do" id="top-list">
                        	전시등록
                        </a>
                    </li>
                    <li>
                        <a class="page-scroll acss" href="<%=request.getContextPath() %>/support.do" onclick="" id="">
                        	고객지원
                        </a>
                    </li>
                    <c:choose>
						<c:when test="${!empty sessionScope.member}">
							<li>
								<a class="page-scroll acss" href="<%=request.getContextPath()%>/client/auth/memberPage.do">
									마이페이지
								</a>
							</li>						
						</c:when>                    
                    </c:choose>
                    
                    <li>
                        <c:choose>
                        <c:when test="${empty sessionScope.member}">
                        
                        <a class="page-scroll acss" href="" onclick="return false" id="myBtn">
                        	로그인
                        </a>
						</c:when>
              			<c:when test="${!empty sessionScope.member}">
                        <a class="page-scroll acss" href="<%=request.getContextPath()%>/client/auth/memberLogOut.do">
                        	로그아웃
                        </a>
                        </c:when>
                        </c:choose>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <!--/ 최상단 Navigation -->


    <!-- 로그인 Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content" id="login-content">
                <div class="modal-header">
                    <h4 class="modal-title"> </h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">

                    <div id="login-wrap">
                    
                         <form onsubmit="validateLogin(this);" method="post" name="loginForm" action="<%=request.getContextPath()%>/client/auth/memberLogIn.do">
                            <div class="login-input"><!-- action="<%=request.getContextPath()%>/client/auth/memberLogIn.do" -->
                                <input class="form-control" type="email" placeholder="이메일" name="email" id="login_email">
                                <div style="margin-top:5px; height:20px; overflow:hidden;" id="chkLoginEmail"></div>
                            </div>
                            
                            <div class="login-input">
                            	<input class="form-control" type="password" placeholder="비밀번호" name="pw" id="login_pw">
                            	<div style="margin-top:5px; height:20px; overflow:hidden;" id="chkLoginPw"></div>
                            </div><!-- onclick="validateLogin(this.form)" -->
                                <input type="submit" class="btn btn-info" value="로그인" style="margin-bottom: 10px;">
   						 </form>
                         
                            <div class="login-input">
                                <a href="<%=request.getContextPath()%>/client/auth/findEmail.do">이메일</a> 
                                / <a href="<%=request.getContextPath()%>/client/auth/findPw.do">비밀번호 찾기</a><br>
                            </div>
                            <hr>
                            	<h5 style="display: inline;font-family: 'Noto Sans KR', sans-serif;font-size: 17px;font-weight: bold;">SNS로 간편 회원가입/로그인</h5>
                            <div id="login-btngroup">
                                
                                 <a id="kakao-login-btn"></a>
                                 <div id="naverIdLogin"></div>
                             <a class="btn btn-danger" href="<%=request.getContextPath()%>/client/auth/memberAdd.do">이메일로 회원가입</a>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<div class="float-button-container">
  <div class="open-button" id="backtop">
  </div>
  <a href="#" alt="Settings" title="Settings"><div class="item01"></div></a>
  <a href="#" alt="Notifications" title="Notifications"><div class="item02"></div></a>
  <a href="<%=request.getContextPath() %>/client/exhibition/addForm.do" alt="전시등록" title="전시등록"><div class="item03"></div></a>
  <a href="#" id="myBtn" alt="My profile" title="마이 페이지"><div class="item04"></div></a>
</div>