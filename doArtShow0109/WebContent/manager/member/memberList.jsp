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
  <title>전시:해 - 회원 목록</title>

  <jsp:include page="/module/manager_MemberList_Header.html"></jsp:include>

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
          <li class="breadcrumb-item active">회원 목록</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            	회원 목록
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>이메일</th>
                    <th>이름</th>
                    <th>생년월일</th>
                    <th>성별</th>
                    <th>비밀번호</th>
                    <th>카카오 아이디</th>
                    <th>네이버 아이디</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="list" items="${memberList}">
                  	<tr>
                  		<td>${list.email}</td>
                  		<td>${list.name}</td>
                  		<td>${list.birth}</td>
                  		<td>${list.gender}</td>
                  		<td>${list.pw}</td>
                  		<c:choose>
                  			<c:when test="${list.kakaoId eq '' || empty list.kakaoId}">
                  				<td>없음</td>
                  			</c:when>
                  			<c:otherwise>
                  				<td>${list.kakaoId}</td>
                  			</c:otherwise>
                  		</c:choose>
                  		<c:choose>
                  			<c:when test="${list.naverId eq '' || empty list.naverId}">
                  				<td>없음</td>
                  			</c:when>
                  			<c:otherwise>
                  				<td>${list.naverId}</td>
                  			</c:otherwise>
                  		</c:choose>
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
  <script src="js/demo/datatables-demo_MemberList.js"></script>

</body>

</html>
