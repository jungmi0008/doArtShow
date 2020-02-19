<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="/doArtShow/resourcesImages/Jeon_invisible.ico" type="image/x-icon" />
  <title>전시:해 - 통계</title>

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
          <li class="breadcrumb-item active">통계</li>
        </ol>

        <!-- Area Chart Example-->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-chart-area"></i>
            <span id="title_week"></span>
          </div>
          <div class="card-body">
            <canvas id="myAreaChart" width="100%" height="30"></canvas>
          </div>
          <div class="card-footer small text-muted">Updated today at <span class="nowTime"></span></div>
        </div>

        <div class="row">
          <div class="col-lg-8">
            <div class="card mb-3">
              <div class="card-header">
                <i class="fas fa-chart-bar"></i>
                	월별 방문자 통계
              </div>
              <div class="card-body">
	              <div class="row">
	              	<div class="col-sm-8 my-auto">
		                <canvas id="myBarChart" width="100%" height="50"></canvas>
	              	</div>
	                <div class="col-sm-4 text-center my-auto">
	                 <div class="h4 mb-0 text-primary" id="average"></div>
	                 <div class="small text-muted">평균 방문자 수</div>
	                 <hr>
	                 <div class="h4 mb-0 text-warning" id="min"></div>
	                 <div class="small text-muted">최소 방문자 수</div>
	                 <hr>
	                 <div class="h4 mb-0 text-success" id="max"></div>
	                 <div class="small text-muted">최대 방문자 수</div>
	               </div>
	              </div>
              </div>
              <div class="card-footer small text-muted">Updated today at <span class="nowTime"></span></div>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="card mb-3">
              <div class="card-header">
                <i class="fas fa-chart-pie"></i>
                	연령대별 비율	
              </div>
              <div class="card-body">
                <canvas id="myPieChart" width="100%" height="71"></canvas>
              </div>
              <div class="card-footer small text-muted">Updated today at <span class="nowTime"></span></div>
            </div>
          </div>
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
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-bar-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
