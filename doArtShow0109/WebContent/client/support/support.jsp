<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="page" value="${sessionScope.member}" var="member" />

<jsp:include page="/module/1doctype_head.jsp"></jsp:include>

<style>
/*  선택된 버튼 효과  */
.btn-checked{
	border-bottom: 2px solid #23AD21 !important;
	transition: all 0.3s;
	background-color: white;
}

/*  */

.faq-choose1{
	text-align: center;
	margin: 15px 10px;
}

.faq > button:focus{
	outline-color : #fff;
	outline-style: solid;
	outline-width : 0px;
}
.faq-choose1 > button:focus{
	outline-color : #fff;
	outline-style: solid;
	outline-width : 0px;
}
.faq-choose1 > button{
	border: 0;
    font-size: 20pt;
    transition: all 0.3s;
    background-color: white;
}
.faq > button{
	border: 0;
	margin-bottom: 20px;
    font-size: 20pt;
    transition: all 0.3s;
    background-color: white;
}

.faq{
	min-width: 900px;
	max-height: 320px;
	overflow: scroll;
	margin: 0 auto;
}


/* 아코디언 */
.accordion {
    color: #444;
    cursor: pointer;
    border-top: 3px solid black;
    border-left: 0;
    border-bottom: 0;
    border-right: 0;
    margin: 0px;
    padding: 12px 18px;
    width: 100%;
    /* border: none; */
    text-align: left;
    outline: none;
    font-size: 19px;
    transition: 0.4s;
    font-weight: bold;
}
.cateDetail button {
    color: #444;
    background-color: white;
    cursor: pointer;
    border-top: 3px solid black;
    border-left: 0;
    border-bottom: 0;
    border-right: 0;
    margin: 0px;
    padding: 12px 18px;
    width: 100%;
    /* border: none; */
    text-align: left;
    outline: none;
    font-size: 19px;
    transition: 0.4s;
    font-weight: bold;
}

.active, .accordion:hover {
  background-color: #ccc;
}
.active{
  border-bottom: 0;
}

.accordion:after {
  content: '\002B';
  color: #777;
  font-weight: bold;
  float: right;
  margin-left: 5px;
}

.active:after {
  content: "\2212";
}

.panel1 {
  padding: 0 18px;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.2s ease-out;
}
.panel1 p{
  font-size: 1.3em;
  padding-left: 20px;
  font-family: "Noto Sans KR", sans-serif;
  color: #444;
}

/*  */

.support-section{
	min-height: 510px;
}


</style>


<body>    
<jsp:include page="/module/2body_first.jsp"></jsp:include>




    <section id="contact" class="dark-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="section-title">
                        <h2>공 지 사 항</h2>
                        <p>정책 변경 및 기타 전달사항입니다<br></p>
                    </div>
                </div>
            </div>
            <div class="row">
            
            			<div id="" class="noticeDetail">
	
<button class="accordion">전시:해의 정식 서비스가 시작됩니다.</button>
<div class="panel1">
  <p>전시:해 사이트 서비스를 정식으로 실시합니다. 전체 서비스 이용을 위해서는 <a target="_blank" href="<%=request.getContextPath()%>/client/auth/memberAdd.do">이메일로 회원가입</a>하거나,<br>
    <a href="#" onclick="addFormLogin()" id="myBtn">SNS로 회원가입</a>을 해주시기 바랍니다. <br>감사합니다.
  </p>
</div>

<button class="accordion">서버 점검으로 인한 서비스 이용 불가 기간 안내</button>
<div class="panel1">
  <p>보다 나은 서비스를 제공하기 위해 아래와 같이 시스템 점검을 시행합니다.<br>
점검 시간동안 서비스 사용이 일시 중단되오니 서비스 이용에 참고 부탁드립니다.<br>
감사합니다.
<br><br>
점검 일시 : 2020년 1월 26일 00:00 ~ 05:00</p>
</div>

<!-- <button class="accordion">Section 3</button>
<div class="panel1">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
</div>

<button class="accordion">Section 4</button>
<div class="panel1">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
</div>

<button class="accordion">Section 5</button>
<div class="panel1">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
</div> -->

			</div>
            
            
            
            </div>
        </div>
    </section>




<!-- FAQ -->
   <section id="contact" class="support-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="section-title">
                        <h2>F  A  Q <span style="font-size: 0.5em;">s</span></h2>
                        <p style="margin: 0;">자주 여쭤보시는 질문에 대한 답변입니다</p>
                    </div>
                    

<div class="container-faq"><!-- Test begin -->

	<div class="faq-choose1">
	  <button class="btnCheck1 btn-checked" onclick="changeFaq(event, 'category')">분류별로 보기</button>
	  <button class="btnCheck1 " onclick="changeFaq(event, 'keyword')">키워드로 검색</button>
	</div>
	
	
		<div id="category" class="faq" >
		
		  <button class="btnCheck2 btn-checked" onclick="changeCate(event, 'category1')">회원</button>
		  <button class="btnCheck2 " onclick="changeCate(event, 'category2')">전시</button>
		  <button class="btnCheck2 " onclick="changeCate(event, 'category3')">등록</button>
		  <button class="btnCheck2 " onclick="changeCate(event, 'category4')">기타</button>
		
			<div id="category1" class="cateDetail">
	<!-- 회원 -->
<button class="accordion">Q. 회원가입은 어떻게 하나요? </button>
<div class="panel1">
  <p> <a target="_blank" href="<%=request.getContextPath()%>/client/auth/memberAdd.do">이메일로 회원가입</a>하거나,
   <a href="#" onclick="addFormLogin()" id="myBtn">SNS로 회원가입</a>하시면 모든 서비스를 이용할 수 있습니다. <br>
   </p>
</div>

<button class="accordion">Q. 계정을 등록하면 무엇이 좋은가요?</button>
<div class="panel1">
  <p> 회원가입 후 이용하시면 리뷰 작성, 가고싶어요 등의 커뮤니케이션 기능을 이용하실 수 있으며 이를 통해 회원님의 <br>
  전시 기록을 관리할 수 있습니다. 또한 데이터를 바탕으로 취향에 맞는 전시를 추천해 드립니다.</p></div>

<button class="accordion">Q. SNS로 회원가입하면 이메일로 로그인과 어떤 점이 다른가요?</button>
<div class="panel1">
  <p> 고객님의 카카오톡, 네이버 아이디로 로그인/회원가입 시에는 각 계정에 등록된 정보를 기반으로 회원가입이 됩니다. <br>
  이후 전시:해의 계정으로 이용하시려면 <a class="page-scroll " href="<%=request.getContextPath()%>/client/auth/memberPage.do">마이페이지</a> - 내 정보수정 에서 추가적인 정보를 등록해 주세요.</p>
</div>

<button class="accordion">Q. 전시:해를 탈퇴하고 싶습니다.</button>
<div class="panel1">
  <p> 회원탈퇴를 원하시면 <a class="page-scroll " href="<%=request.getContextPath()%>/client/auth/memberPage.do">마이페이지</a> - 내 정보수정 - 회원탈퇴 에서 진행해주세요.
  <br>또한, 전시:해 이용에 건의사항 및 불만사항은 1:1 문의하기를 통해서 등록해주시면 신속히 해결하겠습니다. <br>
  더욱 유용하고 사랑스러운 전시:해가 되겠습니다. </p>
</div>

<!-- <button class="accordion">Section 5</button>
<div class="panel1">
  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
</div> -->

			</div>
			<div id="category2" class="cateDetail" style="display:none">
			
	<!-- 전시 -->
<button class="accordion">Q. 전시:해에는 어떤 전시가 있나요? </button>
<div class="panel1">
  <p> 현재 전시:해에서는 크게 서양화, 동양화, 유화, 조각, 설치미술,<br> 미디어아트, 사진, 디자인, 공예에 대한 분류로 전시를 소개해 드리고 있습니다.<br>
  또한, '지도' 기능을 이용하여 원하는 지역의 등록된 전시를 쉽게 찾아볼 수 있고,<br> '태그로 찾을래요' 에서 원하시는 분위기의 전시를 둘러보실 수 있습니다.<br>
  추후 전시 이외에도 콘서트, 일반 공연 등의 기능을 추가하여 더욱 알찬 서비스를 제공해드릴 예정입니다.  </p>
</div>

<button class="accordion">Q. '인기 전시'와 '곧 종료하는 전시'는 무엇인가요?</button>
<div class="panel1">
  <p> '인기전시' 에서는 현재 진행중인 전시중에서 가장 많이 조회된 전시들을 보여드립니다. <br>
  '곧 종료하는 전시' 는 2주 이내로 종료되는 전시를 보여드립니다. </p>
</div>

<button class="accordion">Q. 제가 찾고있는 전시가 없는것 같아요.</button>
<div class="panel1">
  <p> 전시:해는 직접 '전시등록'을 한 전시와 운영진에 의해 등록된 전시를 바탕으로 서비스를 제공해 드리고 있습니다. <br>
  따라서 일부 전시에 대해서는 아직 등록이 되어 있지 않은 경우가 있습니다. <br>추후 API를 활용하여 더욱 다양한 전시를 
  빠르게 등록하고, 이용에 불편이 없도록 발전하겠습니다. </p>
</div>


<button class="accordion">Q. 마음에 드는 전시를 공유하거나 저장하고 싶어요.</button>
<div class="panel1">
  <p> 마음에 들거나 공유하고 싶은 전시가 있으면, 해당 게시물의 상세 페이지에서 <br>'가고싶어요' 를 눌러서 마이페이지에서 한 번에 보실 수 있습니다.<br>
  또는, 공유 - SNS 공유하기를 통해서 해당 게시물의 바로가기 링크를 공유할 수 있습니다. </p>
</div>

			</div>
			<div id="category3" class="cateDetail" style="display:none">
	<!-- 등록 -->

<button class="accordion">Q. 내 전시를 등록하고 싶어요.</button>
<div class="panel1">
  <p> <a class="page-scroll" href="<%=request.getContextPath() %>/client/exhibition/addForm.do" >전시등록</a> 을 원하시면 로그인이 필요합니다.<br>
   로그인 후 전시를 등록해주시면 내가 등록한 전시를 한 눈에 모아보실 수 있으며, 수정 및 삭제에 대한 요청권한이 부여됩니다.<br>
    수정 및 삭제 기능은 관리자가 게시물 승인을 하기 전까지 바로 적용되며, <strong>이후에는 관리자의 확인을 거친 후에 수정/삭제 내용이 적용</strong>되니 <br>이 점 유의해 주시기 바랍니다.</p>
</div>


<button class="accordion">Q. 이미 종료된 전시를 등록해도 되나요?</button>
<div class="panel1">
  <p> 네, 이미 종료된 전시는 관리자에 의하여 확인이 완료되면 바로 등록이 완료됩니다. <br>종료된 전시에 대해서도 전시목록 - 종료된 전시 에서 조회가 가능하며, <br>
  리뷰 , 가고싶어요 기능을 바탕으로 회원님의 취향을 분석하고 추천하는 자료로 활용됩니다. </p>
</div>


<button class="accordion">Q. 등록을 하려면 어떤 정보들이 필요한가요?</button>
<div class="panel1">
  <p> 등록시에는 " 분류, 신청자, 장르, 태그(최대3개), 전시명, 작가명, 전시관, 전시관 주소, 전시관 지역, 전시 일정, <br>
  전시 운영시간, 전화번호, 입장료, 포스터 1장 및 작품사진 (최대 3장) "을 필수적으로 등록하셔야 합니다. <br><br>
  그 외 " 홈페이지 주소, 작가 정보, 전시 내용 " 을 기입해주시면 상세페이지에서 조회하는데에 활용됩니다.<br>
  전시 내용은 게시물의 상세페이지에서 활용되므로 가독성이 좋게 작성해 주시는것이 좋습니다. </p>
</div>


<button class="accordion">Q. 사진을 더 등록하고 싶어요.</button>
<div class="panel1">
  <p> 전시등록 과정에서 등록한 최대 4장의 사진을 제외하고 추가로 등록을 원하신다면,<br> <strong> artshowsupport@doartshow.com</strong> 으로 보내주시기 바랍니다. </p>
</div>


			</div>
			<div id="category4" class="cateDetail" style="display:none">

	<!-- 기타 -->
<button class="accordion">Q. 탈퇴하면 이용기록이 삭제되나요?</button>
<div class="panel1">
  <p> 회원탈퇴를 하신 경우에도 등록하신 전시, 리뷰, 가고싶어요 기록은 삭제되지 않습니다. <br>
   기록을 전부 삭제하고 싶으시면 마이페이지에서 전체 조회를 하신 후 삭제를 원하는 게시물을 삭제해 주시기 바랍니다. <br>
 만약 조회 및 삭제가 안되거나 일괄적으로 처리를 원하시면 하단의 1:1 문의를 통해 말씀해 주시기 바랍니다.</p>
</div>


<button class="accordion">Q. 추가하고 싶은 기능이나 건의사항이 있어요.</button>
<div class="panel1">
  <p> 전시:해 서비스를 이용중에 불편하시거나 추가하고 싶으신 기능이 있으시면 1:1 문의를 통해 말씀해 주세요. <br>
  운영진이 검토후 최대한 빠르게 조치하고 답변을 드리겠습니다. <br> 더욱 발전하는 전시:해가 되겠습니다! </p>
</div>


<button class="accordion">Q. 사이트가 이상하게 보여요.</button>
<div class="panel1">
  <p> 전시:해는 현재 PC 및 노트북에서 구글 크롬을 사용하는 환경에 최적화 되어 있습니다. <br>
  원활한 서비스를 이용하기 위해서 크롬을 사용해 주세요. <a href="https://www.google.com/intl/ko/chrome/" target="_blank">크롬 설치하기 (새 창으로 이동)</a> <br>
  추후 스마트폰 및 태블릿 PC에서도 이용이 편리하도록 사이트 최적화 및 앱 개발 작업중입니다. <br> 더욱 발전하는 전시:해가 되겠습니다!</p>
</div>


			</div>
		
		</div>
		
		
		
<!-- 검색해서 찾기 -->		
		<div id="keyword" class="faq" style="display:none">
			<input id="myInput" type="text" placeholder="검색어를 입력해주세요" style="font-family: 'Noto Sans KR', sans-serif; margin-bottom:20px;">
			<!-- 질문이 담겨있는 영역 -->
			<div id="myDIV">

	<!-- 회원 -->
<button class="accordion">Q. 회원가입은 어떻게 하나요?<span hidden>이메일로 회원가입 SNS로 회원가입 서비스 이용 네이버 카카오톡 카톡</span></button>
<div class="panel1">
  <p> <a target="_blank" href="<%=request.getContextPath()%>/client/auth/memberAdd.do">이메일로 회원가입</a>하거나,
   <a href="#" onclick="addFormLogin()" id="myBtn">SNS로 회원가입</a>하시면 모든 서비스를 이용할 수 있습니다. <br>
   </p>
</div>

<button class="accordion">Q. 계정을 등록하면 무엇이 좋은가요? <span hidden>회원가입 리뷰 가고싶어요 전시기록 기록 관리 데이터 취향 추천</span> </button>
<div class="panel1">
  <p> 회원가입 후 이용하시면 리뷰 작성, 가고싶어요 등 커뮤니케이션 기능을 이용하실 수 있으며 이를 통해 회원님의 <br>
  전시 기록을 관리할 수 있습니다. 또한 데이터를 바탕으로 취향에 맞는 전시를 추천해 드립니다.</p></div>

<button class="accordion">Q. SNS로 회원가입하면 이메일로 로그인과 어떤 점이 다른가요?<span hidden>회원가입 이메일 로그인 카톡 카카오톡 네이버 전환 </span></button>
<div class="panel1">
  <p> 고객님의 카카오톡, 네이버 아이디로 로그인/회원가입 시에는 각 계정에 등록된 정보를 기반으로 회원가입이 됩니다. <br>
  이후 전시:해의 계정으로 이용하시려면 <a class="page-scroll " href="<%=request.getContextPath()%>/client/auth/memberPage.do">마이페이지</a> - 내 정보수정 에서 추가적인 정보를 등록해 주세요.</p>
</div>

<button class="accordion">Q. 전시:해를 탈퇴하고 싶습니다.<span hidden>삭제 계정탈퇴 불만 건의 변경 </span></button>
<div class="panel1">
  <p> 회원탈퇴를 원하시면 <a class="page-scroll " href="<%=request.getContextPath()%>/client/auth/memberPage.do">마이페이지</a> - 내 정보수정 - 회원탈퇴 에서 진행해주세요.
 <br> 또한, 전시:해 이용에 건의사항 및 불만사항은 1:1 문의하기를 통해서 등록해주시면 신속히 해결하겠습니다. <br>
  더욱 유용하고 사랑스러운 전시:해가 되겠습니다. </p>
</div>


	<!-- 전시 -->
<button class="accordion">Q. 전시:해에는 어떤 전시가 있나요? <span hidden>장르 종류 추천 기능 서양화, 동양화, 유화, 조각, 설치미술, 미디어아트, 사진, 디자인, 공예 
지도 태그 분위기 추천 콘서트 일반 공연 다른 </span></button>
<div class="panel1">
  <p> 현재 전시:해에서는 크게 서양화, 동양화, 유화, 조각, 설치미술,<br> 미디어아트, 사진, 디자인, 공예에 대한 분류로 전시를 소개해 드리고 있습니다.<br>
  또한, '지도' 기능을 이용하여 원하는 지역의 등록된 전시를 쉽게 찾아볼 수 있고, <br>'태그로 찾을래요' 에서 원하시는 분위기의 전시를 둘러보실 수 있습니다.<br>
  추후 전시 이외에도 콘서트, 일반 공연 등의 기능을 추가하여 더욱 알찬 서비스를 제공해드릴 예정입니다.  </p>
</div>

<button class="accordion">Q. '인기 전시'와 '곧 종료하는 전시'는 무엇인가요? <span hidden> 인기 추천 종료 마감 곧 끝나는 끝 조회 조회순 2주 모아보기 정렬 </span></button>
<div class="panel1">
  <p> '인기전시' 에서는 현재 진행중인 전시중에서 가장 많이 조회된 전시들을 보여드립니다. <br>
  '곧 종료하는 전시' 는 2주 이내로 종료되는 전시를 보여드립니다. </p>
</div>

<button class="accordion">Q. 제가 찾고있는 전시가 없는것 같아요. <span hidden>없 API 등록 찾는 아직 검색 </span></button>
<div class="panel1">
  <p> 전시:해는 직접 '전시등록'을 한 전시와 운영진에 의해 등록된 전시를 바탕으로 서비스를 제공해 드리고 있습니다. <br>
  따라서 일부 전시에 대해서는 아직 등록이 되어 있지 않은 경우가 있습니다. <br>추후 API를 활용하여 더욱 다양한 전시를
  빠르게 등록하고, 이용에 불편이 없도록 발전하겠습니다. </p>
</div>


<button class="accordion">Q. 마음에 드는 전시를 공유하거나 저장하고 싶어요. <span hidden>공유 저장 SNS 링크 카톡 카카오톡 네이버 페이스북 트위터 </span></button>
<div class="panel1">
  <p> 마음에 들거나 공유하고 싶은 전시가 있으면, 해당 게시물의 상세 페이지에서 <br>'가고싶어요' 를 눌러서 마이페이지에서 한 번에 보실 수 있습니다.<br>
  또는, 공유 - SNS 공유하기를 통해서 해당 게시물의 바로가기 링크를 공유할 수 있습니다. </p>
</div>

	<!-- 등록 -->

<button class="accordion">Q. 내 전시를 등록하고 싶어요.<span hidden> 전시 게시 작성 수정 삭제 게시물 승인 관리 관리자 조회 조회수 요청 변경  </span></button>
<div class="panel1">
  <p> <a class="page-scroll" href="<%=request.getContextPath() %>/client/exhibition/addForm.do" >전시등록</a> 을 원하시면 로그인이 필요합니다.<br>
   로그인 후 전시를 등록해주시면 내가 등록한 전시를 한 눈에 모아보실 수 있으며, 수정 및 삭제에 대한 요청권한이 부여됩니다.<br>
    수정 및 삭제 기능은 관리자가 게시물 승인을 하기 전까지 바로 적용되며, <strong>이후에는 관리자의 확인을 거친 후에 수정/삭제 내용이 적용</strong>되니 <br>이 점 유의해 주시기 바랍니다.</p>
</div>


<button class="accordion">Q. 이미 종료된 전시를 등록해도 되나요?<span hidden> 종료 끝난 이미 지나간 지난 예전 옛날 추천 자료 데이터 조회 검색 </span></button>
<div class="panel1">
  <p> 네, 이미 종료된 전시는 관리자에 의하여 확인이 완료되면 바로 등록이 완료됩니다. <br>종료된 전시에 대해서도 전시목록 - 종료된 전시 에서 조회가 가능하며, <br>
  리뷰 , 가고싶어요 기능을 바탕으로 회원님의 취향을 분석하고 추천하는 자료로 활용됩니다. </p>
</div>


<button class="accordion">Q. 등록을 하려면 어떤 정보들이 필요한가요?<span hidden>  등록하기 전시등록 내 전시 개인 단체 전시관  등록시에는 " 분류, 신청자, 장르, 태그(최대3개), 전시명, 작가명, 전시관, 전시관 주소, 전시관 지역, 전시 일정,
   전시 운영시간, 전화번호, 입장료, 포스터 1장 및 작품사진 (최대 3장) "을 필수적으로 등록하셔야 합니다. <br>
  그 외 " 홈페이지 주소, 작가 정보, 전시 내용 " 을 기입해주시면 상세페이지에서 조회하는데에 활용됩니다.<br>
  전시 내용은 게시물의 상세페이지에서 활용되므로 가독성이 좋게 작성해 주시는것이 좋습니다. </span></button>
<div class="panel1">
  <p> 등록시에는 " 분류, 신청자, 장르, 태그(최대3개), 전시명, 작가명, 전시관, 전시관 주소, 전시관 지역, 전시 일정, <br>
  전시 운영시간, 전화번호, 입장료, 포스터 1장 및 작품사진 (최대 3장) "을 필수적으로 등록하셔야 합니다. <br><br>
  그 외 " 홈페이지 주소, 작가 정보, 전시 내용 " 을 기입해주시면 상세페이지에서 조회하는데에 활용됩니다.<br>
  전시 내용은 게시물의 상세페이지에서 활용되므로 가독성이 좋게 작성해 주시는것이 좋습니다. </p>
</div>

<button class="accordion">Q. 사진을 더 등록하고 싶어요.<span hidden> 4장 사진 추가 등록 게시물 게시 전시 문의 전경 </span></button>
<div class="panel1">
  <p> 전시등록 과정에서 등록한 최대 4장의 사진을 제외하고 추가로 등록을 원하신다면,<br> <strong> artshowsupport@doartshow.com</strong> 으로 보내주시기 바랍니다. </p>
</div>


	<!-- 기타 -->
<button class="accordion">Q. 탈퇴하면 이용기록이 삭제되나요?<span hidden> 탈퇴 삭제 계정 일괄 제거 기록 리뷰 가고싶어요 전시 등록 전부 마이 페이지 한 번에 </span></button>
<div class="panel1">
  <p> 회원탈퇴를 하신 경우에도 등록하신 전시, 리뷰, 가고싶어요 기록은 삭제되지 않습니다. <br>
   기록을 전부 삭제하고 싶으시면 마이페이지에서 전체 조회를 하신 후 삭제를 원하는 게시물을 삭제해 주시기 바랍니다. <br>
 만약 조회 및 삭제가 안되거나 일괄적으로 처리를 원하시면 하단의 1:1 문의를 통해 말씀해 주시기 바랍니다.</p>
</div>


<button class="accordion">Q. 추가하고 싶은 기능이나 건의사항이 있어요.<span hidden>발전 기능 요구 더 불편 서비스 </span></button>
<div class="panel1">
  <p> 전시:해 서비스를 이용중에 불편하시거나 추가하고 싶으신 기능이 있으시면 1:1 문의를 통해 말씀해 주세요. <br>
  운영진이 검토후 최대한 빠르게 조치하고 답변을 드리겠습니다. <br> 더욱 발전하는 전시:해가 되겠습니다! </p>
</div>


<button class="accordion">Q. 사이트가 이상하게 보여요.<span hidden>핸드폰 모바일 스마트폰 폰 태블릿 아이패드 크롬 구글 인터넷 익스 플로러 파이어 폭스 사파리 PC 노트북 최적화 이상 깨져 깨 안 안보여 보여 앱 어플 App 개발 최적화 </span></button>
<div class="panel1">
  <p> 전시:해는 현재 PC 및 노트북에서 구글 크롬을 사용하는 환경에 최적화 되어 있습니다. <br>
  원활한 서비스를 이용하기 위해서 크롬을 사용해 주세요. <a href="https://www.google.com/intl/ko/chrome/" target="_blank">크롬 설치하기 (새 창으로 이동)</a> <br>
  추후 스마트폰 및 태블릿 PC에서도 이용이 편리하도록 사이트 최적화 및 앱 개발 작업중입니다. <br> 더욱 발전하는 전시:해가 되겠습니다!</p>
</div>


			</div>		
		</div>
	<!-- 검색해서 찾기 종료-->	
	


</div><!-- Test end -->
                    
                </div>
            </div>
            <div class="row">
            </div>
        </div>
    </section>
    
    
<!-- 문의사항 -->
    <section id="contact" class="dark-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="section-title">
                        <h2>1:1 문의하기</h2>
                        <p>질문을 등록해주시면 최대한 빠르게 답변드리겠습니다<br></p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="section-text">
                        <h4>Our Business Office</h4>
                        <p>서울 강남구 테헤란로 123, 15층</p>
                        <p><i class="fa fa-phone"></i> +82 10 - 2979 - 0710</p>
                        <p><i class="fa fa-envelope"></i> artshowsupport@doartshow.com</p>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="section-text">
                        <h4>Business Hours</h4>
                        <p><i class="fa fa-clock-o"></i> <span class="day">Weekdays&nbsp;:&nbsp;</span><span>9am to 8pm</span></p>
                        <p><i class="fa fa-clock-o"></i> <span class="day">Saturday&nbsp;:&nbsp;</span><span>9am to 2pm</span></p>
                        <p><i class="fa fa-clock-o"></i> <span class="day">Sunday&nbsp;:&nbsp;</span><span>Closed</span></p>
                    </div>
                </div>
                <div class="col-md-6">
                    <form action="" method="post" name="sentMessage" id="contactForm">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name *" id="name" required="" data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Your Email *" id="email" required="" data-validation-required-message="Please enter your email address.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Your Message *" id="message" required="" data-validation-required-message="Please enter a message."></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <button type="submit" class="btn">Send Message</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>


<jsp:include page="/module/3body_last.html" />
	
	<script>
	// 검색-카테고리 선택
	function changeFaq(evt, selected) {
		  var i, x, btnchk;
		  x = document.getElementsByClassName("faq");
		  for (i = 0; i < x.length; i++) {
		    x[i].style.display = "none";
		  }
		  btnchk = document.getElementsByClassName("btnCheck1");
		  for (i = 0; i < x.length; i++) {
			  btnchk[i].className = btnchk[i].className.replace(" btn-checked", "");
			}
		  document.getElementById(selected).style.display = "block";
		  evt.currentTarget.className += " btn-checked";
		}
	// 카테고리 - 상세 선택
	function changeCate(evt, selected) {
		  var i, x, btnchk;
		  x = document.getElementsByClassName("cateDetail");
		  for (i = 0; i < x.length; i++) {
		    x[i].style.display = "none";
		  }
		  btnchk = document.getElementsByClassName("btnCheck2");
		  for (i = 0; i < x.length; i++) {
			  btnchk[i].className = btnchk[i].className.replace(" btn-checked", "");
			}
		  document.getElementById(selected).style.display = "block";
		  evt.currentTarget.className += " btn-checked";
		}
	// 카테고리 - 상세 선택
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
	  acc[i].addEventListener("click", function() {
	    this.classList.toggle("active");
	    var panel = this.nextElementSibling;
	    if (panel.style.maxHeight) {
	      panel.style.maxHeight = null;
	    } else {
	      panel.style.maxHeight = panel.scrollHeight + "px";
	    } 
	  });
	}
	
	/* FAQs 검색으로 찾기 기능 필터 */
$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myDIV button").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
</script>


</body>
</html>