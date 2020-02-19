<jsp:include page="/module/1doctype_head.jsp"></jsp:include>
<style>
	*:before,
	*:after {
	  box-sizing: border-box;
	  transition: 0.3s ease-in-out;
	  z-index: -1;
	}
	
	#content_div {
    	text-align: center;
    	padding-left: 5%;
    	padding-right: 5%;
    	padding-top: 5em;
    }
    
	#content_list{
		display: -webkit-inline-box;
    	flex-wrap: wrap;
    	-webkit-box-pack: center;
	}
	
	#content_list_div{ 
		margin-left: auto;
	    margin-right: auto;
	    margin-bottom: 20px;
	    width: 275px;
	    height: 450px;
	    text-align: center;
	    border-radius: 20px;
	}
	
	#content_list_div img{ 
		border-radius: 20px;
	}
	
	#content_list_div a{ 
		color: #474747;
		text-decoration: none;
	}
	
	#content_list_div:hover{ 
		-moz-box-shadow: 0px 12px 20px rgba(54, 24, 79, 0.5);
		-webkit-box-shadow: 0px 12px 20px rgba(54, 24, 79, 0.5);
		box-shadow: 0px 12px 20px rgba(54, 24, 79, 0.5);
		transition: all .3s;
	}
	
	#content_list_div a:hover{ 
		color: #8a8a8a;
		text-decoration: none;
	}
	
	#moreBtn_div{
		padding: 30px;
	}	
</style>

<body>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:include page="/module/2body_first.jsp"></jsp:include>


<c:choose>

<c:when test="${0 ne searchResult.size() }">
	<div class="container minheight">
		<div class="row">
			<div class="wrapper">
				<div class="text-center">
					<h1 style="border-bottom: 2px solid black;display: inline-block;">
						<input type="text" value="${search }" readonly="readonly"
							style="text-align: center;border: 0px;">
							
					</h1>
					
					<p>
						총
						<c:out value="${searchResult.size() }" />
						건이 검색되었습니다.
					</p>
				</div>

				<div id="content_div" class="container">
					<div id="content_list">
						<c:forEach var="list" items="${searchResult}">
							<div id="content_list_div">
								<a href="<%=request.getContextPath()%>/client/exhibition/ExContentView.do?exhID=${list.exhID}" id="ExContentView" style="width: 290px; height: 470px;">
									<!-- 아무데나 눌러도 상세페이지로 넘어가게 --> <img
									src="/doArtShow/exhibitionImages/${list.imageFile1}"
									style="height: 370px; width: 275px;"/><br>
									<b>${list.exhName}</b><br> ${list.exhPlace}<br>
									${list.exhStartDate}&nbsp;~&nbsp;${list.exhEndDate}
								</a>
							</div>
						</c:forEach>
					</div>
					<div id="moreBtn_div" align="center">
						<button type="button" id="more_btn">더보기</button>
					</div>
				</div>
			</div>

		</div>
	</div>
		</c:when>
	<c:otherwise>
	
	<div class="container minheight">
		<div class="row">
			<div class="wrapper" style="min-height: 700px;">
				<div class="text-center" style="line-height: 200px;">
					<h1 style="border-bottom: 2px solid black;display: inline-block;">
						<input type="text" value="'${search } '" readonly="readonly"
							style="text-align: center;border: 0px;">
					</h1><h1>검색한 결과가 없어요.</h1>
					<a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do">전시목록 둘러보기</a>
					<a href="<%=request.getContextPath()%>/searchMap.do">지도에서 찾아보기</a>
					<a href="<%=request.getContextPath() %>/client/exhibition/addForm.do">그냥 내가 등록해버리기</a>
					
				</div>
			</div>
		</div>
	</div>
	<style>
.text-center a {
  height: 40px;
  padding: 0 30px;
  border-radius: 50px;
  cursor: pointer;
  box-shadow: 0px 15px 20px rgba(54, 24, 79, 0.5);
  z-index: 3;
  color: #695681;
  background-color: white;
  text-transform: uppercase;
  font-weight: 600;
  font-size: 22px;
  transition: all 0.3s ease;
}
.text-center a:hover {
  box-shadow: 0px 10px 10px -10px rgba(54, 24, 79, 0.5);
  transform: translateY(5px);
  background: #FB8A8A;
  color: white;
  text-decoration: none;
}
	</style>
	
	
	</c:otherwise>
</c:choose>

	<jsp:include page="/module/3body_last.html"></jsp:include>
</body>
</html>