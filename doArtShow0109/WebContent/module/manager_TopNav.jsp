<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		
	<a class="navbar-brand mr-1" href="manager.do" id="logo">전시:해</a>

	<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
		<i class="fas fa-bars"></i>
	</button>

	<!-- Navbar -->
	<ul class="navbar-nav ml-auto">
		<li class="nav-item dropdown no-arrow">
			<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<c:if test="${newExhListCnt > 0}">
					<span class="badge badge-danger">${newExhListCnt}</span>
				</c:if>
				<i class="fas fa-user-circle fa-fw"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
				<c:if test="${newExhListCnt > 0}">
					<a class="dropdown-item" href="newExhList.do">${newExhListCnt} 개의 새로운 게시물 등록 요청!</a>
					<div class="dropdown-divider"></div>
				</c:if>
				<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">로그아웃</a>
			</div>
		</li>
	</ul>

</nav>