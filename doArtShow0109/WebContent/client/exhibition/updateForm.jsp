<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ page import ="com.doArtShow.dao.ExhibitionDao"%> 
<%@ page import ="com.doArtShow.dto.ExhibitionDto"%> 
<%@ page import ="com.doArtShow.dto.TagDto"%>
<%@ page import = "java.text.SimpleDateFormat"%> 
<%@ page import = "java.util.Date"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "java.util.StringTokenizer"%>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
ExhibitionDto exhibition = (ExhibitionDto)request.getAttribute("exhibition");
ArrayList<TagDto> tagList = (ArrayList<TagDto>)request.getAttribute("tagList");
String tel = exhibition.getTel();
StringTokenizer st = new StringTokenizer(tel, "-");
String[] telArr = new String[st.countTokens()];
int k = 0;
while(st.hasMoreTokens()){
	telArr[k] = st.nextToken();
	k++;
}
if(telArr[0] == null) telArr[0] = ""; 
if(telArr[1] == null) telArr[1] = "";
if(telArr[2] == null) telArr[2] = "";



String test = "010-111-1111";
StringTokenizer test2 = new StringTokenizer(test, "-");
String[] testArr = new String[test2.countTokens()];
int j = 0;
while(test2.hasMoreTokens()){
	testArr[j] = test2.nextToken();
	System.out.println(j+":@@"+testArr[j]);
	j++;
}


String	realFolder	= "";
String	saveFolder	="/clientImages";

ServletContext context = getServletContext();
realFolder			= context.getRealPath(saveFolder);
realFolder = "http://localhost:8089/doArtShow/clientImages";

/*
try {
	managerId=(String)session.getAttribute("id");
	//세션값이 없으면 정상적으로 로그인을 하지 않은 경우이므로 쫓아낸다. 
	if(managerId==null || managerId.equals("")) {
		response.sendRedirect("../logon/memberLoginForm.jsp");
	}else{
		//정상적으로 로그인하고 들어온경우는 페이지를 보여준다. 
	}
*/	
%>
<jsp:include page="/module/1doctype_head.jsp"></jsp:include>
<style>
.updateForm1{
display: inline-block;
}
</style>
<body>
<jsp:include page="/module/2body_first.jsp"></jsp:include>
<%	Date nowTime = new Date();
	//SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
	SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	SimpleDateFormat month = new SimpleDateFormat("MM");
	SimpleDateFormat day = new SimpleDateFormat("dd");
 %>
    <div class="container">
        <!-- <h3 style ="width:100%; text-align:center">(주) 전시해</h3>  -->
        <h3 style ="width:100%; border-bottom:2px; solid #000; padding-bottom:14px;">전시회 수정하기</h3>
        <form action="update.do" method="post" enctype="multipart/form-data" name="exhUpdateform">   
			<!-- <table class="table table-bordered table-striped nanum table-hover" > -->
			<table class="table nanum table-hover" >
				<input type="hidden" name="exhID" value="<%=exhibition.getExhID() %>" class="updateForm">
				<colgroup>
					<col class="col-sm-1">
					<col class="col-sm-3">
				</colgroup>
				<tbody>
                <tr>
                    <th>*분류</th>
                    <td>
                    	<select id="exhGubun1" name="exhGubun1" id="exhGubun1" style="width:100%; padding: .8em .5em;" required>
                             <option value="">전시회 분류를 선택하세요</option> 
                            <!--  <option  <c:if test="${exhibition.exhGubun1 == '단체전' }">value="단체전"</c:if>>단체전</option>
                            <option  <c:if test="${exhibition.exhGubun1 == '개인전' }">value="개인전" selected</c:if>>개인전</option>!-->
                            <option  value="개인전" <%if(exhibition.getExhGubun1().equals("개인전")){%>selected<%} %>>개인전</option>
                            <option  value="개인전" <%if(exhibition.getExhGubun1().equals("단체전")){%>selected<%} %>>단체전</option>
                        </select>
					</td>
                </tr>
                <tr>
                    <th>
                        <label for="">*신청자</label> <!-- member 테이블에서 가져온다. readonly-->
                    </th>
                    <td><input type="text" name="memberID" id="memberID" value="${exhibition.memberID }" readOnly style="width:100%; padding: .8em .5em;" class="updateForm"></td>
                </tr>
                <tr>
                    <th>
                        <label for="">*장르</label>
                    </th>
                    <td>          
                        <select name="exhGubun2" id="exhGubun2" style="width:100%; padding: .8em .5em;" required>
                            <option value="">장르를 선택하세요</option>
                            <option value="서양화" 		<%if(exhibition.getExhGubun2().equals("서양화"))			{ %>selected<%} %>>서양화		</option>
                            <option value="동양화" 		<%if(exhibition.getExhGubun2().equals("동양화"))			{ %>selected<%} %>>동양화		</option>
                            <option value="유화" 			<%if(exhibition.getExhGubun2().equals("유화"))			{ %>selected<%} %>>유화			</option>
                            <option value="조각" 			<%if(exhibition.getExhGubun2().equals("조각"))			{ %>selected<%} %>>조각			</option>
                            <option value="설치미술" 		<%if(exhibition.getExhGubun2().equals("설치미술"))		{ %>selected<%} %>>설치미술	</option>
                            <option value="미디어아트" 	<%if(exhibition.getExhGubun2().equals("미디어아트"))	{ %>selected<%} %>>미디어아트</option>
                            <option value="사진" 			<%if(exhibition.getExhGubun2().equals("사진"))			{ %>selected<%} %>>사진			</option>
                            <option value="디자인" 		<%if(exhibition.getExhGubun2().equals("디자인"))			{ %>selected<%} %>>디자인		</option>
                            <option value="공예" 			<%if(exhibition.getExhGubun2().equals("공예"))			{ %>selected<%} %>>공예			</option>
                       </select>
                    </td>
                </tr>
                <tr>
                    <th><label for="">*태그</label>
                    <p style="font-size:14px; line-height:22px; letter-spacing:-0.6px; font-weight:300;">(최대 3개 선택)</p></th>
                    <td style="padding: .8em .5em;">
           				<label for="exhGubun31" style="font-weight:300;">
           				<input name="exhGubun3" type="checkbox" value="데이트" class="updateForm1" id="exhGubun31" <%for(int i=0; i<tagList.size(); i++) if ("데이트".equals(tagList.get(i).getExhTagName())) 			{%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        #데이트
                        </label>
                        <br>
           				<label for="exhGubun32" style="font-weight:300;">
                    	<input name="exhGubun3" type="checkbox" value="인생샷" class="updateForm1" id="exhGubun32" <%for(int i=0; i<tagList.size(); i++) if ("인생샷".equals(tagList.get(i).getExhTagName())) 			{%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    	#인생샷
                        </label>
                        <br>
           				<label for="exhGubun33" style="font-weight:300;">
                    	<input name="exhGubun3" type="checkbox" value="친구와함께" class="updateForm1"	id="exhGubun33"	<%for(int i=0; i<tagList.size(); i++) if ("친구와함께".equals(tagList.get(i).getExhTagName()))		{%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    	#친구와함께
                        </label>
                        <br>
           				<label for="exhGubun34" style="font-weight:300;">
                    	<input name="exhGubun3" type="checkbox" value="나혼자문화생활"	class="updateForm1"	id="exhGubun34" <%for(int i=0; i<tagList.size(); i++) if ("나혼자문화생활".equals(tagList.get(i).getExhTagName())) {%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    	#나혼자문화생활
                        </label>
                        <br>
           				<label for="exhGubun35" style="font-weight:300;">
                    	<input name="exhGubun3" type="checkbox" value="부모님과함께" class="updateForm1" id="exhGubun35" <%for(int i=0; i<tagList.size(); i++) if ("부모님과함께".equals(tagList.get(i).getExhTagName()))	{%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    	#부모님과함께
                        </label>
                        <br>
           				<label for="exhGubun36" style="font-weight:300;">
                    	<input name="exhGubun3" type="checkbox" value="아이와함께" 	class="updateForm1"	id="exhGubun36"	<%for(int i=0; i<tagList.size(); i++) if ("아이와함께".equals(tagList.get(i).getExhTagName())) 		{%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    	#아이와함께
                        </label>
                        <br>
           				<label for="exhGubun37" style="font-weight:300;">
                    	<input name="exhGubun3" type="checkbox" value="교육전시" class="updateForm1" id="exhGubun37" <%for(int i=0; i<tagList.size(); i++) if ("교육전시".equals(tagList.get(i).getExhTagName())) 			{%>checked<%} %>>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    	#교육전시			
                    </td>	
                </tr>
                <tr>
                    <th><label for="">*전시회명</label></th>
                    <td><input type="text" class="updateForm" name="exhName" id="exhName" value="${exhibition.exhName }" style="width:100%;"></td>
                </tr>
                <tr>
                    <th><label for="">*작가명</label></th>
                    <td><input type="text" class="updateForm" name="artistName" id="artistName" value="<%=exhibition.getArtistName()%>" style="width:100%;"></td>
                </tr>
                <tr>
                    <th>	<label for="">작가정보</label>
                    		<p style="font-size:14px; line-height:22px; letter-spacing:-0.6px; font-weight:300;">작가 정보<br/>(전시,수상이력 등)를<br/>입력해주세요</p>
                  	</th>
                    <td><textarea name="artistInfo" id="artistInfo" rows="20" cols="100" style="width:100%; height:250px;"><%=exhibition.getArtistInfo() %></textarea></td></td>
                </tr>
                <tr>
                	<th>	<label for="">전시내용</label>
                			<p style="font-size:14px; line-height:22px; letter-spacing:-0.6px; font-weight:300;">텍스트, 평론</p>
                	</th>
                    <td><textarea name="exhContent" id="exhContent" rows="20" cols="100" style="width:100%; height:250px;">${exhibition.exhContent }</textarea></td>
                </tr>
                <tr>
                 	<th>*전시관</th>
                	<td>
                		<input type="text" class="updateForm" name="exhPlace" id="exhPlace" value="${exhibition.exhPlace }" style="width:100%;">
                	</td>
                </tr>
                <tr>
                        <th>*전시관 주소</th>
                        <td>
               			<input type="text"  class="updateForm" id="exhPlaceAddr1" name="exhPlaceAddr1" id="exhPlaceAddr1" value="${exhibition.exhPlaceAddr1}" style="width:90%;" readOnly onclick="sample6_execDaumPostcode_1()"> 
                		<input type="button" class="updateForm" onclick="sample6_execDaumPostcode_1()" value="주소 검색" style="width:9%;"><br> 
						<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>
						</td>
				</tr>
                <tr>
                    <th>
                        <label for="">*전시관지역</label>
                    </th>
                    <td>          
                        <select name="exhGubun4" id="exhGubun4" style="width:100%;">
                            <option value="">전시관지역를 선택하세요</option>
                            <option value="서울"		<%if(exhibition.getExhGubun4().equals("서울"))			{ %>selected<%} %>>서울</option>
                            <option value="인천/경기"	<%if(exhibition.getExhGubun4().equals("인천/경기"))		{ %>selected<%} %>>인천/경기</option>
                            <option value="대전/충청"	<%if(exhibition.getExhGubun4().equals("대전/충청"))		{ %>selected<%} %>>대전/충청</option>
                            <option value="광주/전라"	<%if(exhibition.getExhGubun4().equals("광주/전라"))		{ %>selected<%} %>>광주/전라</option>
                            <option value="부산/경상"	<%if(exhibition.getExhGubun4().equals("부산/경상"))		{ %>selected<%} %>>부산/경상</option>
                            <option value="강원"		<%if(exhibition.getExhGubun4().equals("강원"))			{ %>selected<%} %>>강원</option>
                            <option value="제주"		<%if(exhibition.getExhGubun4().equals("제주"))			{ %>selected<%} %>>제주</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><label for="">전시회 홈페이지 주소</label></th>
                    <td><input type="text" class="updateForm" name="exhUrl" id="exhUrl" value="${exhibition.exhUrl }" style="width:100%;"></td>
                </tr>
                <tr>
                	<th>*전시일정</th>
                	<td>
                		<input type="date" class="updateForm" name="exhStartDate" id="exhStartDate" value=${exhibition.exhStartDate } style="width:30%;">부터 
                		<input type="date" class="updateForm" name="exhEndDate" id="exhEndDate" value=${exhibition.exhStartDate } style="width:30%;">까지
                	</td>
                </tr>
                <tr>
                    <th><label for="">*전시운영시간</label></th>
                    <td><input type="text" class="updateForm" name="opTime" id="opTime" value="${exhibition.opTime }" style="width:100%;"></td>
                </tr>    
             	<tr>   
					<th><label>전화번호</label></th>
					<td>
						<div>
						<select name="tel1" id="tel1" style="width:20%;">
							<option value="" <%if(telArr[0].equals("")) {}%>>선택하세요</option>
							<option value="02" 	<%if(telArr[0].equals("02"))		{ %>selected<%} %>>02</option>
							<option value="051"	<%if(telArr[0].equals("051"))	{ %>selected<%} %>>051</option>
							<option value="053"	<%if(telArr[0].equals("053"))	{ %>selected<%} %>>053</option>
							<option value="032" <%if(telArr[0].equals("032"))	{ %>selected<%} %>>032</option>
							<option value="062" <%if(telArr[0].equals("062"))	{ %>selected<%} %>>062</option>
							<option value="042" <%if(telArr[0].equals("042"))	{ %>selected<%} %>>042</option>
							<option value="052" <%if(telArr[0].equals("052"))	{ %>selected<%} %>>052</option>
							<option value="044" <%if(telArr[0].equals("044"))	{ %>selected<%} %>>044</option>
							<option value="031" <%if(telArr[0].equals("031"))	{ %>selected<%} %>>031</option>
							<option value="033" <%if(telArr[0].equals("033"))	{ %>selected<%} %>>033</option> 
							<option value="043" <%if(telArr[0].equals("043"))	{ %>selected<%} %>>043</option> 
							<option value="041" <%if(telArr[0].equals("041"))	{ %>selected<%} %>>041</option> 
							<option value="063" <%if(telArr[0].equals("063"))	{ %>selected<%} %>>063</option>
							<option value="061" <%if(telArr[0].equals("061"))	{ %>selected<%} %>>061</option>
							<option value="054" <%if(telArr[0].equals("054"))	{ %>selected<%} %>>054</option>
							<option value="055" <%if(telArr[0].equals("055"))	{ %>selected<%} %>>055</option>
							<option value="064" <%if(telArr[0].equals("064"))	{ %>selected<%} %>>064</option>
							<option value="010" <%if(telArr[0].equals("010"))	{ %>selected<%} %>>010</option>
							<option value="011" <%if(telArr[0].equals("011"))	{ %>selected<%} %>>011</option>
							<option value="017" <%if(telArr[0].equals("017"))	{ %>selected<%} %>>017</option>
							<option value="018" <%if(telArr[0].equals("018"))	{ %>selected<%} %>>018</option>
							<option value="019" <%if(telArr[0].equals("019"))	{ %>selected<%} %>>019</option>
							<option value="070" <%if(telArr[0].equals("070"))	{ %>selected<%} %>>070</option>
						</select>
						-
						<input type="text" name="tel2" id="tel2" class="updateForm"
							maxlength="4" value="<%=telArr[1]%>" style="width:20%;">
						-	
						<input type="text" name="tel3" id="tel3" class="updateForm"
							maxlength="4" value="<%=telArr[2]%>" style="width:20%;">
						</div>	
					</td>		
				</tr>                
                <tr>
                    <th><label for="">*입장료</label></th>
                    <td>유료<input type="radio" class="updateForm" name="admFee" id="admFee" value="유료"  <%if(exhibition.getAdmFee().equals("유료"))	{             %>checked<%} %>>
                        무료<input type="radio" class="updateForm" name="admFee" id="admFee" value="무료" 	<%if(exhibition.getAdmFee().equals("무료"))	{ %>checked<%} %>> 
                    </td>
                </tr>                
					<th class="td_left"><label for="">*포스터</label></th>
					<td class="td_right"><pre class="brush:html">
						<input type="file" class="updateForm" name="file1" id="profile_pt1" accept="image/*" onchange="previewImage(this,'View_area1')">
						<div id='View_area1' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div>
					</pre>							
					</td>
				</tr>
				<tr> 
					<th class="td_left"><label for="">*작품사진1</label></th>
					<td class="td_right"><pre class="brush:html">
						<input type="file" class="updateForm" name="file2" id="profile_pt2" 
							 accept="image/*"  onchange="previewImage2(this,'View_area2')"> 
						<div id='View_area2' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div>
					</td>
				</tr>
				<tr>
					<th class="td_left"><label for="">작품사진1-이름</label></th>
					<td><input type="text" class="updateForm" name="imageName2" id="imageName2" value="${exhibition.imageName2 }"></td>
				</tr>
				<tr>
					<th class="td_left"><label for="">작품사진1-설명</label></th>
					<td><input type="text" class="updateForm" name="imageType2" id="imageType2" value="${exhibition.imageType2 }"></td>
				</tr>				
				<tr> 
					<th class="td_left"><label for="">작품사진2</label></th>
					<td class="td_right"><pre class="brush:html">
						<input type="file" class="updateForm" name="file3" id="profile_pt3" accept="image/*" onchange="previewImage3(this,'View_area3')">
						<div id='View_area3' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div>
					</td>
				</tr>
				<tr>
					<th class="td_left"><label for="">작품사진2-이름</label></th>
					<td><input type="text" class="updateForm" name="imageName3" id="imageName3" value="${exhibition.imageName3 }"></td>
				</tr>
				<tr>
					<th class="td_left"><label for="">작품사진2-설명</label></th>
					<td><input type="text" class="updateForm" name="imageType3" id="imageType3" value="${exhibition.imageType3 }"></td>
				</tr>	
				<tr> 
					<th class="td_left"><label for="">작품사진3</label></th>
					<td class="td_right"><pre class="brush:html">
						<input type="file" class="updateForm" name="file4" id="profile_pt4" accept="image/*" onchange="previewImage4(this,'View_area4')">
						<div id='View_area4' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div>
					</td>
				</tr>	
				<tr>
					<th class="td_left"><label for="">작품사진3-이름</label></th>
					<td><input type="text" class="updateForm" name="imageName4" id="imageName4" value="${exhibition.imageName4 }"></td>
				</tr>	
				<tr>
					<th class="td_left"><label for="">작품사진3-설명</label></th>
					<td><input type="text" class="updateForm" name="imageType4" id="imageType4" value="${exhibition.imageType4 }"></td>
				</tr>											   	
				<!-- <tr>
					<th class="td_left"><label for="">작품사진</label></th>
					<td class="td_right"><input type="file" name="file2" id="#"></td>
			   	</tr> --> 
			  	<tr>
                    <td colspan="2" align="center">
                        <!-- <input style="width:150px; height:60px; margin:10px;" type="submit" value="전시회수정" />  -->
                        <button type="button" style="width:150px; height:60px; margin:10px;"
								onclick="exhUpdateCheckForm(this.form)">전시회수정</button>
                    </td>
                </tr>                            
  			</tbody>
            </table>
        </form>
    </div>
<jsp:include page="/module/3body_last.html" />   
<script>   
$("input:checkbox").click(function() {
	var bol = $("input:checkbox:checked").length >= 3;     
	$("input:checkbox").not(":checked").attr("disabled",bol);
	}); 
	
function sample6_execDaumPostcode_1() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                //document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                //document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            //document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("exhPlaceAddr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            //document.getElementById("exhGubun4").focus();
        }
    }).open();
}
</script>
</body>
</html>