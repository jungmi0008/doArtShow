<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="/doArtShow/resourcesImages/Jeon_invisible.ico" type="image/x-icon" />
  <title>전시:해 - 수정</title>

  <jsp:include page="/module/manager_ModifyExh_Header.html"></jsp:include>

</head>

<body id="page-top">

  <jsp:include page="/module/manager_TopNav.jsp"></jsp:include>

  <div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="/module/manager_Sidebar.html"></jsp:include>

    <div id="content-wrapper">

      <div class="container-fluid">


      <div><!-- Modal Start -->
        <div>
          <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header breadcrumb">
              <h5 class="modal-title breadcrumb-item">
              	<a href="manager.do">Home</a>
              	&nbsp;&nbsp;/&nbsp;&nbsp;
              	<span class="breadcrumb-item active">수정 페이지</span>
              </h5>

            </div>

            <!-- Modal body -->
            <div class="modal-body">

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">전시회ID</span>
                </div>
                <div class="form-control" id="exhID">${exhDto.exhID}</div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">회원ID</span>
                  </div>
                  <div class="form-control" id="memberID">${exhDto.memberID}</div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">분류</span>
                  </div>
                  <div class="form-control">
                  
                  	<input type="hidden" id="exhGubun1" value="${exhDto.exhGubun1}" />
                  	<input type="radio" name="exhGubun1Radio" value="개인전">&nbsp;개인전
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun1Radio" value="단체전">&nbsp;단체전
						
                  </div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">장르</span>
                  </div>
                  <div class="form-control">
                  	
                  	<input type="hidden" id="exhGubun2" value="${exhDto.exhGubun2}" />
                  	<input type="radio" name="exhGubun2Radio" value="서양화">&nbsp;서양화
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="동양화">&nbsp;동양화
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="유화">&nbsp;유화
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="조각">&nbsp;조각
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="설치미술">&nbsp;설치미술
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="미디어아트">&nbsp;미디어아트
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="사진">&nbsp;사진
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="디자인">&nbsp;디자인
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun2Radio" value="공예">&nbsp;공예
                  
                  </div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">태그</span>
                  </div>
                  <div class="form-control">
                  
                  	<input type="hidden" id="exhGubun3" value="${exhGubun3}" />
                  	<input type="checkbox" name="exhGubun3Check" value="데이트">&nbsp;데이트
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="exhGubun3Check" value="인생샷">&nbsp;인생샷
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="exhGubun3Check" value="친구와함께">&nbsp;친구와함께
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="exhGubun3Check" value="나혼자문화생활">&nbsp;나혼자문화생활
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="exhGubun3Check" value="부모님과함께">&nbsp;부모님과함께
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="exhGubun3Check" value="아이와함께">&nbsp;아이와함께
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="checkbox" name="exhGubun3Check" value="교육전시">&nbsp;교육전시
                  	
                  </div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">전시명</span>
                  </div>
                  <input type="text" class="form-control" id="exhName" value="${exhDto.exhName}">
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">작가명</span>
                  </div>
                  <input type="text" class="form-control" id="artistName" value="${exhDto.artistName}">
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">작가정보</span>
                  </div>
                  <textarea id="artistInfo" class="form-control" rows="15" cols="40" style="width: 90%; height: 250px;">${exhDto.artistInfo}</textarea>
              </div>

              <div class="input-group mb-3">
				<div class="input-group-prepend">
                	<span class="input-group-text">전시내용</span>
                </div>
                <textarea id="exhContent" class="form-control" rows="15" cols="40" style="width: 90%; height: 250px;">${exhDto.exhContent}</textarea>
              </div>

              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">전시장</span>
                  </div>
                  <input type="text" class="form-control" id="exhPlace" value="${exhDto.exhPlace}">
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">짚코드</span>
                  </div>
                  <div class="form-control" id="exhPlaceZip">${exhDto.exhPlaceZip}</div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">위치</span>
                  </div>
                  <div class="form-control">
                  
                  	<input type="hidden" id="exhGubun4" value="${exhDto.exhGubun4}" />
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_1" value="서울">&nbsp;서울
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_2" value="인천/경기">&nbsp;인천/경기
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_3" value="대전/충청">&nbsp;대전/충청
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_4" value="광주/전라">&nbsp;광주/전라
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_5" value="부산/경상">&nbsp;부산/경상
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_6" value="강원">&nbsp;강원
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="exhGubun4Radio" id="exhGubun4_7" value="제주">&nbsp;제주
                  	
                  </div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">주소 1</span>
                  </div>
                  <div class="form-control" style="height: auto;">
                  	<span id="exhPlaceAddr1">${exhDto.exhPlaceAddr1}</span>
                  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="button" class="btn btn-info" onclick="sample6_execDaumPostcode_1()" value="주소 검색">
                  </div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">주소 2</span>
                  </div>
                  <input type="text" class="form-control" id="exhPlaceAddr2" value="${exhDto.exhPlaceAddr2}">
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">홈페이지</span>
                </div>
                <input type="text" class="form-control" id="exhUrl" value="${exhDto.exhUrl}">
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">시작일</span>
                </div>
                <input type="date" id="exhStartDate" class="form-control" value="${exhDto.exhStartDate}">
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">종료일</span>
                </div>
                <input type="date" id="exhEndDate" class="form-control" value="${exhDto.exhEndDate}">
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">운영시간</span>
                </div>
                <input type="text" class="form-control" id="opTime" value="${exhDto.opTime}">
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">전화번호</span>
                </div>
                <c:set var="phone" value="${fn:split(exhDto.tel, '-')}" />
                <input type="tel" class="form-control" id="tel1" value="${phone[0]}" required="required">
                <input type="tel" class="form-control" id="tel2" value="${phone[1]}" required="required">
                <input type="tel" class="form-control" id="tel3" value="${phone[2]}" required="required">
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">입장료</span>
                </div>
                <div class="form-control">
                
                	<input type="hidden" id="admFee" value="${exhDto.admFee}" />
                	<input type="radio" name="admFeeRadio" value="유료">&nbsp;유료
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  	<input type="radio" name="admFeeRadio" value="무료">&nbsp;무료
                
                </div>
              </div>
              
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">포스터<br>/<br>작품<br>/<br>전시전경</span>
                </div>
                <div class="form-control" id="imageFile" style="height: auto;">
                
                	<div style="float: left; margin: 10px;">
	                	<p>[포스터]</p>
	           
	                	<c:choose>
	                		<c:when test="${exhDto.imageFile1 == null || exhDto.imageFile1 eq ''}">
	                			<div class="content"></div>
	                		</c:when>
	                		<c:otherwise>
	                			<div id="imageFile1" class="content" style="outline: none;">
									<img src="/doArtShow/exhibitionImages/${exhDto.imageFile1}" width="100%" height="100%">
								</div>
	                		</c:otherwise>
	                	</c:choose>
	                	
                	</div>
                	<div style="float: left; margin: 10px;">
	                	<p>[작품/전시전경 1]</p>
						
						<c:choose>
	                		<c:when test="${exhDto.imageFile2 == null || exhDto.imageFile2 eq ''}">
	                			<div class="content"></div>
	                		</c:when>
	                		<c:otherwise>
	                			<div id="imageFile2" class="content" style="outline: none;">
									<img src="/doArtShow/exhibitionImages/${exhDto.imageFile2}" width="100%" height="100%">
								</div>
	                		</c:otherwise>
	                	</c:choose>
						
                	</div>
                	<div style="float: left; margin: 10px;">
	                	<p>[작품/전시전경 2]</p>
						
						<c:choose>
	                		<c:when test="${exhDto.imageFile3 == null || exhDto.imageFile3 eq ''}">
	                			<div class="content"></div>
	                		</c:when>
	                		<c:otherwise>
	                			<div id="imageFile3" class="content" style="outline: none;">
									<img src="/doArtShow/exhibitionImages/${exhDto.imageFile3}" width="100%" height="100%">
								</div>
	                		</c:otherwise>
	                	</c:choose>
						
                	</div>
                	<div style="float: left; margin: 10px;">
	                	<p>[작품/전시전경 3]</p>
						
						<c:choose>
	                		<c:when test="${exhDto.imageFile4 == null || exhDto.imageFile4 eq ''}">
	                			<div class="content"></div>
	                		</c:when>
	                		<c:otherwise>
	                			<div id="imageFile4" class="content" style="outline: none;">
									<img src="/doArtShow/exhibitionImages/${exhDto.imageFile4}" width="100%" height="100%">
								</div>
	                		</c:otherwise>
	                	</c:choose>
						
                	</div>
                	
                </div>
              </div>
            </div><!-- Modal Body End -->

            <!-- Modal footer -->
            <div class="modal-footer">
              <button type="button" class="btn btn-success" onclick="sendModifyExhData()">Modify</button>
              <button type="button" class="btn btn-danger" onclick="cancelModify()">Cancel</button>
            </div>

          </div>
        </div>
      </div><!-- Modal End -->





      </div>
      <!-- /.container-fluid -->



      


      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright © 전시:해 2020</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <!-- <script src="js/demo/datatables-demo_ExhList.js"></script> -->
  <script src="js/modifyExh.js"></script>

</body>

</html>