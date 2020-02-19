<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/module/1doctype_head.jsp"></jsp:include>       
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ page import ="com.doArtShow.dto.ExhibitionDto"%> 
<%@ page import = "java.util.List"%>
<jsp:include page="/module/1doctype_head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 -->
<body>
<jsp:include page="/module/2body_first.jsp"></jsp:include>
<%
//List<ExhibitionDto> exhibitionList = (List<ExhibitionDto>)request.getAttribute("exhibitionList"); 
//for (int i = 0; i <exhibitionList.size(); i++)
//	System.out.println("$$$"+exhibitionList.get(i).getExhID());
%> 
<% 
if(request.getAttribute("uRsCnt")!=null) {
	int uRsCnt = Integer.parseInt(String.valueOf(request.getAttribute("uRsCnt")));
	System.out.println("*****uRsCnt:"+uRsCnt);
	if(uRsCnt==1){%>
		<script>alert('전시회 수정이 완료되었습니다.')</script>
<%	
	}else{%>
		<script>alert('전시회 수정에 실패했습니다. 잠시 후 다시 시도하거나 관리자에게 문의하세요.')</script>
<%	}
}%>	
<% 
if(request.getAttribute("dRsCnt")!=null) {
	int dRsCnt = Integer.parseInt(String.valueOf(request.getAttribute("dRsCnt")));
	System.out.println("*****dRsCnt:"+dRsCnt);
	if(dRsCnt==1){%>
		<script>alert('전시회 삭제가 완료되었습니다.')</script>
<%	
	}else{%>
		<script>alert('전시회 삭제에 실패했습니다. 잠시 후 다시 시도하거나 관리자에게 문의하세요.')</script>
<%	}
}%>	
<div class="container" style="min-height:660px;">
	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr class="info">
				<th>번호</th>
				<th text-align="center">전시회명</th>
				<th>전시관</th>
				<th>전시시작일</th>
				<th>전시종료일</th>
				<th>작성일</th>
				<th>수정</th>
				<th>삭제</th>
				<!-- <th>activeFlag</th>  -->				
			</tr>
		</thead>
		<tbody>
		<c:set var="i" value="1" />
		<c:forEach items="${exhibitionList}" var="exhibitionList">
			<tr>
				<!-- <td>${exhibitionList.exhID}</td>  --> 
				<td>${i}	</td> 
				<td>${exhibitionList.exhName}</td>
				<td>${exhibitionList.exhPlace}</td>					
				<td>${exhibitionList.exhStartDate}</td>
				<td>${exhibitionList.exhEndDate}</td>
				<c:set var="registerDate" value="${exhibitionList.registerDate }"/>
				<td>${fn:substring(registerDate,0,10)}</td>
				<c:choose> 
				<c:when test="${exhibitionList.activeFlag eq 'N' }">
				<td>
					<a href="update.do?exhID=${exhibitionList.exhID}">수정</a>
				</td>
				<td>
					<a href="javascript:var check1=confirm('정말로 삭제하시겠습니까?');if(check1){location.href='delete.do?exhID=${exhibitionList.exhID}';}">삭제</a>
				</td>
				</c:when>
				<c:otherwise>
				<td><a href="javascript:alert('전시중인 콘텐츠는 수정할 수 없습니다.')">수정</a></td>
				<td><a href="javascript:alert('전시중인 콘텐츠는 삭제할 수 없습니다.')">삭제</a></td>
				</c:otherwise>	
				</c:choose>		
				<!-- <td>${exhibitionList.activeFlag}</td>  -->		
			</tr>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
		<c:out value="${sum}"/>
		</tbody>
	</table>
</div>
<jsp:include page="/module/3body_last.html" />
<script>
	function openExhModal(num) {
	    $("#exhUpdateModal" + num).modal({
	        backdrop: true
	    });
	}
</script>
</body>
</html>