<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="error" value="${sessionScope.error}" />
<c:choose>
	<c:when test="${sessionScope.error eq 'idError'}">
		<% session.removeAttribute("error"); %>
		<script type="text/javascript">
			alert("아이디를 확인하세요.");
			location.href = "../../manager.do";
		</script>
	</c:when>
	<c:when test="${sessionScope.error eq 'pwdError'}">
		<% session.removeAttribute("error"); %>
		<script type="text/javascript">
			alert("비밀번호를 확인하세요.");
			location.href = "../../manager.do";
		</script>
	</c:when>
	<c:otherwise>
		<% session.removeAttribute("error"); %>
		<!DOCTYPE html>
		<html lang="en">
		
		<head>
		
		  <meta charset="utf-8">
		  <meta http-equiv="X-UA-Compatible" content="IE=edge">
		  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		  <meta name="description" content="">
		  <meta name="author" content="">
		  <link rel="shortcut icon" href="/doArtShow/resourcesImages/Jeon_invisible.ico" type="image/x-icon" />
		  <title>전시:해 - 관리자 로그인</title>
		
		  <!-- Custom fonts for this template-->
		  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		
		  <!-- Custom styles for this template-->
		  <link href="css/sb-admin.css" rel="stylesheet">
		
		</head>
		
		<body class="bg-dark">
		
		  <div class="container">
		    <div class="card card-login mx-auto mt-5">
		      <div class="card-header">Login</div>
		      <div class="card-body">
		        <form action="managerLogin.do" method="POST">
		          <div class="form-group">
		            <div class="form-label-group">
		              <input type="id" name="managerId" id="inputEmail" class="form-control" placeholder="관리자 ID를 입력하세요." required="required" autofocus="autofocus">
		              <label for="inputEmail">ID</label>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="form-label-group">
		              <input type="password" name="managerPwd" id="inputPassword" class="form-control" placeholder="관리자 비밀번호를 입력하세요." required="required">
		              <label for="inputPassword">Password</label>
		            </div>
		          </div>
		          <input type="submit" value="Login" class="btn btn-primary btn-block">
		        </form>
		      </div>
		    </div>
		  </div>
		
		  <!-- Bootstrap core JavaScript-->
		  <script src="vendor/jquery/jquery.min.js"></script>
		  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		
		  <!-- Core plugin JavaScript-->
		  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
		
		</body>
		</html>		
	</c:otherwise>
</c:choose>