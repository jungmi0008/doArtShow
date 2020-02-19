<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="/doArtShow/resourcesImages/Jeon_invisible.ico" type="image/x-icon" />
  <title>전시:해 - 종료된 목록</title>

  <jsp:include page="/module/manager_ExhList_Header.html"></jsp:include>

</head>

<body id="page-top">

  <jsp:include page="/module/manager_TopNav.jsp"></jsp:include>

  <div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="/module/manager_Sidebar.html"></jsp:include>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="manager.do">Home</a>
          </li>
          <li class="breadcrumb-item active">종료된 전시회 목록</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
			<i class="fas fa-table"></i>
            	종료된 전시회 목록
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered table-hover nowrap" id="dataTable" cellspacing="0" style="width: 100%">
                <thead>
                  <tr>
                    <th>전시회ID</th><!-- 0 -->
                    <th>회원ID</th><!-- 1 -->
                    <th>분류</th>
                    <th>장르</th>
                    <th>위치</th>
                    <th>전시명(상세보기)</th>
                    <th>작가명</th><!-- 6 -->
                    <th>작가정보</th><!-- 7 -->
                    <th>전시내용</th><!-- 8 -->
                    <th>전시장</th><!-- 9 -->
                    <th>짚코드</th><!-- 10 -->
                    <th>주소 1</th><!-- 11 -->
                    <th>주소 2</th><!-- 12 -->
                    <th>홈페이지</th><!-- 13 -->
                    <th>시작일</th>
                    <th>종료일</th>
                    <th>운영시간</th><!-- 16 -->
                    <th>전화번호</th><!-- 17 -->
                    <th>입장료</th><!-- 18 -->
                    <th>포스터</th><!-- 19 -->
                    <th>작품/전시전경 1</th><!-- 20 -->
                    <th>작품/전시전경 2</th><!-- 21 -->
                    <th>작품/전시전경 3</th><!-- 22 -->
                    <th>조회수</th>
                    <th>등록일</th><!-- 24 -->
                    <th>ActiveFlag</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="list" items="${endExhList}">
                  	<tr>
                  		<td>${list.exhID}</td>
                  		<td>${list.memberID}</td>
                  		<td>${list.exhGubun1}</td>
                  		<td>${list.exhGubun2}</td>
                  		<td>${list.exhGubun4}</td>
                  		<td>${list.exhName}</td>     		
                  		<td>${list.artistName}</td>
                  		<td>${list.artistInfo}</td>
                  		<td>${list.exhContent}</td>
                  		<td>${list.exhPlace}</td>
                  		<td>${list.exhPlaceZip}</td>
                  		<td>${list.exhPlaceAddr1}</td>
                  		<td>${list.exhPlaceAddr2}</td>
                  		<td><a href="${list.exhUrl}">${list.exhUrl}</a></td>
                  		<td>${list.exhStartDate}</td>
                  		<td>${list.exhEndDate}</td>
                  		<td>${list.opTime}</td>
                  		<td>${list.tel}</td>
                  		<td>${list.admFee}</td>
                  		<td><img src="/doArtShow/exhibitionImages/${list.imageFile1}" width="200px" height="330px" /></td>
                  		<td><img src="/doArtShow/exhibitionImages/${list.imageFile2}" width="250px" height="330px" /></td>
                  		<td><img src="/doArtShow/exhibitionImages/${list.imageFile3}" width="250px" height="330px" /></td>
                  		<td><img src="/doArtShow/exhibitionImages/${list.imageFile4}" width="250px" height="330px" /></td>
                  		<td>${list.exhReadCount}</td>
                  		<td>${list.registerDate}</td>
                  		<td>
                  			<c:choose>
                  				<c:when test="${list.activeFlag ne 'E'}">
                  					<label class="switch">
									  <input type="checkbox" checked="checked">
									  <span class="slider round"></span>
									</label>
                  				</c:when>
                  				<c:otherwise>
                  					<label class="switch">
									  <input type="checkbox" disabled="disabled">
									  <span class="slider round"></span>
									</label>
                  				</c:otherwise>
                  			</c:choose>
                  		</td>
                  	</tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          <div class="card-footer small text-muted">Updated today at <span id="nowTime"></span></div>
        </div>

      </div>
      <!-- /.container-fluid -->



      <!-- The Modal -->
      <div class="modal" id="myModal">
        <div class="modal-dialog modal-xl modal-dialog-scrollable">
          <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title">상세 정보</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">전시회ID</span>
                </div>
                <div class="form-control" id="exhID"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">회원ID</span>
                  </div>
                  <div class="form-control" id="memberID"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">분류</span>
                  </div>
                  <div class="form-control" id="exhGubun1"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">장르</span>
                  </div>
                  <div class="form-control" id="exhGubun2"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">태그</span>
                  </div>
                  <div class="form-control" id="exhGubun3"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">전시명</span>
                  </div>
                  <div class="form-control" id="exhName"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">작가명</span>
                  </div>
                  <div class="form-control" id="artistName"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">작가정보</span>
                  </div>
                  <div class="form-control" id="artistInfo" style="height: auto;"></div>
              </div>

              <div class="input-group mb-3">
				<div class="input-group-prepend">
                	<span class="input-group-text">전시내용</span>
                </div>
                <div class="form-control" id="exhContent" style="height: auto;"></div>
              </div>

              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">전시장</span>
                  </div>
                  <div class="form-control" id="exhPlace"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">짚코드</span>
                  </div>
                  <div class="form-control" id="exhPlaceZip"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">위치</span>
                  </div>
                  <div class="form-control" id="exhGubun4"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">주소 1</span>
                  </div>
                  <div class="form-control" id="exhPlaceAddr1"></div>
              </div>
              
              <div class="input-group mb-3">
                  <div class="input-group-prepend">
                      <span class="input-group-text">주소 2</span>
                  </div>
                  <div class="form-control" id="exhPlaceAddr2"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">홈페이지</span>
                </div>
                <div class="form-control" id="exhUrl"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">시작일</span>
                </div>
                <div class="form-control" id="exhStartDate"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">종료일</span>
                </div>
                <div class="form-control" id="exhEndDate"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">운영시간</span>
                </div>
                <div class="form-control" id="opTime"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">전화번호</span>
                </div>
                <div class="form-control" id="tel"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">입장료</span>
                </div>
                <div class="form-control" id="admFee"></div>
              </div>
              
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">포스터<br>/<br>작품<br>/<br>전시전경</span>
                </div>
                <div class="form-control" id="imageFile" style="height: auto;"></div>
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">조회수</span>
                </div>
                <div class="form-control" id="exhReadCount"></div>
                
              </div>

              <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">등록일</span>
                </div>
                <div class="form-control" id="registerDate"></div>
              </div>

            </div><!-- Modal Body End -->

            <!-- Modal footer -->
            <div class="modal-footer">
              <button type="button" class="btn btn-danger" id="deleteBtn">Delete</button>
              <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div>

          </div>
        </div>
      </div><!-- Modal End -->



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
  <script src="js/demo/datatables-demo_endExhList.js"></script>

</body>

</html>