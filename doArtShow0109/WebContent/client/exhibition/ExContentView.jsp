<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/module/1doctype_head.jsp"></jsp:include>
<jsp:include page="../../module/exhibition_view.jsp"></jsp:include>

<body>

	<jsp:include page="/module/2body_first.jsp"></jsp:include>
	<c:set var="member" value="${sessionScope.member}" />

	<div class="contentContainer" id="mainContainer" style="width: 90%;">
		<div style="margin-left: 2%; margin-right: 5%">
			<h2><b>${listOne.exhName}</b></h2>
			<h4>${listOne.artistName}</h4>
		</div>
		<div style="margin-left: 2%; margin-right: 5%">
			<table class="table nanum">
				<tr>
					<td rowspan="7" style="height: 500px; width: 30%;">
						<img src="/doArtShow/exhibitionImages/${listOne.imageFile1}" id="exhImage" />
					</td>
					<td>&nbsp;기간 : ${listOne.exhStartDate}&nbsp;~&nbsp;${listOne.exhEndDate}</td>
				</tr>
				<tr>
					<td style="width: 80%">&nbsp;전시관 : ${listOne.exhPlace}</td>
				</tr>
				<tr>
					<td>&nbsp;주소 : ${listOne.exhPlaceAddr1}</td>
				</tr>
				<tr>
					<td>&nbsp;시간 : ${listOne.opTime}</td>
				</tr>
				<tr>
					<td>&nbsp;입장료 : ${listOne.admFee}</td>
				</tr>
				<tr>
					<td>&nbsp;문의 : ${listOne.tel}</td>
				</tr>
				<tr>
					<td>&nbsp;사이트 : <a href="${listOne.exhUrl}">${listOne.exhUrl}</a></td>
				</tr>
				<tr>
					<td id="myHist">
						<div>
							<c:choose>
								<c:when test="${!empty sessionScope.member}">
									<c:if test="${wishChk == 0}">
										<!-- 가고싶어요 안누른 전시 -->
										<label class="heart-switch"> <input id="wishBtn" type="checkbox"> <!-- 하트체크박스 가운데로 맞추기 --> 
											<svg viewBox="0 0 33 23" fill="white"><path d="M23.5,0.5 C28.4705627,0.5 32.5,4.52943725 32.5,9.5 C32.5,16.9484448 21.46672,22.5 16.5,22.5 C11.53328,22.5 0.5,16.9484448 0.5,9.5 C0.5,4.52952206 4.52943725,0.5 9.5,0.5 C12.3277083,0.5 14.8508336,1.80407476 16.5007741,3.84362242 C18.1491664,1.80407476 20.6722917,0.5 23.5,0.5 Z"></path></svg>
											가고싶어요
										</label>
									</c:if>
									<c:if test="${wishChk == 1}">
										<!-- 가고싶어요 누른 전시 -->
										<label class="heart-switch"> <input id="wishBtn" type="checkbox" checked="checked"> <!-- 하트체크박스 가운데로 맞추기 -->
											<svg viewBox="0 0 33 23" fill="white"><path d="M23.5,0.5 C28.4705627,0.5 32.5,4.52943725 32.5,9.5 C32.5,16.9484448 21.46672,22.5 16.5,22.5 C11.53328,22.5 0.5,16.9484448 0.5,9.5 C0.5,4.52952206 4.52943725,0.5 9.5,0.5 C12.3277083,0.5 14.8508336,1.80407476 16.5007741,3.84362242 C18.1491664,1.80407476 20.6722917,0.5 23.5,0.5 Z"></path></svg>
											가고싶어요
										</label>
									</c:if>
								</c:when>
								<c:otherwise>
									<label class="heart-switch" onclick="javascript:login_need()">
										<input type="checkbox" disabled="true"> <!-- content화면 출력시 로그인 되어있는지 확인 후, 로그인 안되있을 경우 ajax에서 처리할 사항 : 체크를 아예 못하게 막아놓기, login_need()로 가게 하기-->
										<svg viewBox="0 0 33 23" fill="white"><path d="M23.5,0.5 C28.4705627,0.5 32.5,4.52943725 32.5,9.5 C32.5,16.9484448 21.46672,22.5 16.5,22.5 C11.53328,22.5 0.5,16.9484448 0.5,9.5 C0.5,4.52952206 4.52943725,0.5 9.5,0.5 C12.3277083,0.5 14.8508336,1.80407476 16.5007741,3.84362242 C18.1491664,1.80407476 20.6722917,0.5 23.5,0.5 Z"></path></svg>
										가고싶어요
									</label>
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							<c:choose>
								<c:when test="${!empty sessionScope.member}">
									<a href="javascript:visitBtn_func();" id="visitBtn" style="color: #3d3d3d;"> <!-- visitArt_func(); --> 
										<i class="fa fa-check fa-2x"></i><br> 
										<label>다녀왔어요</label>
									</a>
								</c:when>
								<c:otherwise>
									<a href="javascript:login_need(this);" id="visitBtn" style="color: #3d3d3d;"> <!-- visitArt_func(); --> 
										<i class="fa fa-check fa-2x"></i><br> 
										<label>다녀왔어요</label>
									</a>
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							<a href="javascript:;" id="reviewBtn" style="color: #3d3d3d; visibility: hidden;"> <!-- 평소에 숨겨져있다가 다녀왔어요 클릭하면 리뷰작성버튼 show로 변경 -->
								<i class="fa fa-pencil fa-2x"></i><br> 
								<label>리뷰작성</label>
							</a>
						</div>
						<div class="dropdown dropright" style="display: inline-flex;">
							<a href="#shareModal" id="shareBtn" class="dropdown-toggle" data-toggle="dropdown" style="color: #3d3d3d;"> 
								<i class="fa fa-share-alt fa-2x"></i><br> 
								<label>공유</label>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="javascript:sendLinkFaceBook()" title="페이스북으로 공유하기">
									<img src="/doArtShow/resourcesImages/sns_face.png" width="36" alt="FaceBook">
								</a> 
								<a class="dropdown-item" href="javascript:sendLinkTwitter()" title="트위터로 공유하기">
									<img src="/doArtShow/resourcesImages/sns_tw.png" width="36" alt="Twitter">
								</a> 
								<a class="dropdown-item" href="javascript:sendLinkNaver()" title="네이버로 공유하기">
									<img src="/doArtShow/resourcesImages/sns_naver.png" width="36" alt="Naver">
								</a> 
								<a class="dropdown-item" href="javascript:sendLinkKakao()" id="kakao-link-btn" title="카카오톡으로 공유하기">
									<img src="/doArtShow/resourcesImages/sns_ka.png" width="36" alt="KakaoTalk">
								</a>
							</div>
						</div>
					</td>
					<td>
						<div id="tagctgList" style="display: inline-flex;">
							<c:forEach var="ctg" items="${listOneTag}">
								<div id="gubun1">
									<label>#</label>${ctg.exhTagName}&nbsp;
								</div>
							</c:forEach>
							<div id="gubun2">${listOne.exhGubun4}&nbsp;</div>
							<div id="gubun3">${listOne.exhGubun2}</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="padding-bottom: 2%; padding-top: 2%;">
						<pre id="exhContent">${listOne.exhContent}</pre>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<p style="color: #1a1a1a"><b><i class="fa fa-image"></i>&nbsp;전시 사진</b></p>
						<div class="swiper-container">
							<div class="swiper-wrapper">
								<c:if test="${listOne.imageFile1 != null}">
									<div class="swiper-slide">
										<div class="oneSwiper">
											<div class="slide-content">
												<p class="slide-imageName">${listOne.imageName1}</p>
												<p class="slide-imageType">${listOne.imageType1}</p>
											</div>
											<img src="/doArtShow/exhibitionImages/${listOne.imageFile1}" />
										</div>
									</div>
								</c:if>
								<c:if test="${listOne.imageFile2 != null}">
									<div class="swiper-slide">
										<div class="oneSwiper">
											<img src="/doArtShow/exhibitionImages/${listOne.imageFile2}" />
											<div class="slide-content">
												<p class="slide-imageName">${listOne.imageName2}</p>
												<p class="slide-imageType">${listOne.imageType2}</p>
											</div>
										</div>
									</div>
								</c:if>
								<c:if test="${listOne.imageFile3 != null}">
									<div class="swiper-slide">
										<div class="oneSwiper">
											<img src="/doArtShow/exhibitionImages/${listOne.imageFile3}" />
											<div class="slide-content">
												<p class="slide-imageName">${listOne.imageName3}</p>
												<p class="slide-imageType">${listOne.imageType3}</p>
											</div>
										</div>
									</div>
								</c:if>
								<c:if test="${listOne.imageFile4 != null}">
									<div class="swiper-slide">
										<div class="oneSwiper">
											<img src="/doArtShow/exhibitionImages/${listOne.imageFile4}" />
											<div class="slide-content">
												<p class="slide-imageName">${listOne.imageName4}</p>
												<p class="slide-imageType">${listOne.imageType4}</p>
											</div>
										</div>
									</div>
								</c:if>
							</div>
							<!-- 좌우 화살표 -->
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<!-- 리뷰 보여지는 부분 -->
						<div>
							<p style="color: #1a1a1a"><b><i class="fa fa-edit"></i>&nbsp;리뷰 보기</b></p>
							<c:choose>
								<c:when test="${revCnt == 0}">
									<div id="reviewView">
										<center style="line-height: 200px;">다녀온 전시로 등록하고, 첫 리뷰를 작성해주세요!</center>
									</div>
								</c:when>
								<c:otherwise>
									<div id="revList">
										<c:forEach var="revlist" items="${revLists}">
											<div class="revOne">
												<table>
													<tr>
														<td rowspan="2" width="25%">
															<img src="/doArtShow/memberProfileImages/${revlist.profileImg}" class="memberProfile" /></td>
														<td width="75%">
															<div class="memberName"><b>${revlist.name}</b></div>
														</td>
													</tr>
													<tr>
														<td><div class="revContent">${revlist.revContent}</div></td>
													</tr>
													<tr>
														<td colspan="2" style="color: #808080; text-align: right;">${revlist.revDate}에 작성되었습니다.&nbsp;&nbsp;&nbsp;</td>
													</tr>
												</table>
											</div>
										</c:forEach>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>


	<!-- 리뷰창 모달 -->
	<div class="modal fade" id="revWriteModal" role="dialog">
		<div class="modal-dialog">
			<form method="post" name="revForm" id="revForm">
				<!-- Modal content-->
				<div class="modal-content" id="revWriteModal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body">
						<h4 class="modal-title">
							<b>다녀온 전시관의 리뷰를 작성해 주세요</b>
						</h4>
						<br>
						<br>
						<table class="table nanum">
							<tr>
								<td width="20%">전시 내용</td>
								<td width="80%"><input type="text" id="exhName" name="exhName" readonly="readonly" value="${listOne.exhName}"></td>
							</tr>
							<tr>
								<td>리뷰 내용</td>
								<td><textarea name="revContent" id="revContent" placeholder="리뷰는 50자 이내로 작성 가능합니다."></textarea></td>
							</tr>
						</table>
					</div>
					<!-- Modal footer -->
					<div id="shareModal-footer">
						<button type="button" class="btn btn-light" onclick="javascript:chkreviewForm(this.form, 100)">등록하기</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="../../module/3body_last.html"></jsp:include>
	<script src="/doArtShow/libs/swiper/js/swiper.js"></script>
	
	<script>
		function login_need() {
			alert('로그인이 필요합니다');
		}

		/* 다녀왔어요 버튼 눌렀을때 적용하는 함수 */
		function visitBtn_func() {
			$.ajax({
				url : "checkVisit.do",
				type : "POST",
				dataType : "JSON",
				data : {
					email : '${member.email}',
					exhID : '${listOne.exhID}'
				},
				success : function(data) {
					if (data.checkRev == 1) {
						//visibility 속성 안변함(리뷰버튼 안나타남)
						alert("이미 리뷰를 작성한 전시입니다.");
					} else if (data.checkRev == 0) {
						if (data.checkVisit == 0) {
							document.getElementById('reviewBtn').style.visibility = "visible";
							alert("다녀온 전시로 등록되었습니다.\n나의 다녀온 전시는 마이페이지에서 확인 가능합니다!\n리뷰를 작성해주세요!");
						} else if (data.checkVisit == 1) {
							document.getElementById('reviewBtn').style.visibility = "visible";
							alert("이미 다녀온 전시입니다.\n리뷰를 작성해주세요!");
						}
					}
				},
				error : function(request, status, error) {
					var msg = "ERROR : <br>"
					msg += request.status + "<br>" + request.responseText + "<br>" + error;
				}
			});
		}

		function sendLinkFaceBook() {
			var facebook_share_url = "https://www.facebook.com/sharer/sharer.php?u="
					+ encodeURI(document.location.href)
					+ "&t="
					+ encodeURI('${listOne.exhName} 보러갈래?');
			window.open(facebook_share_url, 'Share on Facebook',
					'scrollbars=no, width=500, height=500');
		}
		function sendLinkTwitter() {
			var twitter_share_text = encodeURI('${listOne.exhName} 보러갈래?');
			var twitter_share_url = encodeURI(document.location.href);
			window.open("https://twitter.com/share?text=" + twitter_share_text
					+ "&url=" + twitter_share_url, 'Share on Twitter',
					'scrollbars=no, width=500, height=500');
		}
		function sendLinkNaver() {
			var raw_url = document.location.href;
			var raw_title = '${listOne.exhName} 보러갈래?';
			var naver_root_url = "http://share.naver.com/web/shareView.nhn?url="
			var naver_share_url = naver_root_url + encodeURIComponent(raw_url)
					+ "&title=" + encodeURIComponent(raw_title);
			window.open(naver_share_url, 'Share on Naver',
					'scrollbars=no, width=500, height=500');
		}
		/* Kakao.init('3f954d79af6a536ec76db999e7f2ba5b'); */
		function sendLinkKakao() {
			Kakao.Link.sendDefault({
				objectType : 'feed',
				content : {
				title : '${listOne.exhName} 보러갈래?',
				description : '나만의 인생전시 찾아서, 전시:해',
				imageUrl : 'https://blogfiles.pstatic.net/MjAyMDAxMDJfMTgg/MDAxNTc3OTUzMDM0NTg0.mUQhLuECjSx5lvE4HxOz8je68sHTSsz5NgDtmw47cfkg.sDN5cQYDWuQVLKI9IU_s7qXwlDgwNS_dxCdXbfaMrrwg.PNG.rladudrl286/%EC%A0%84%EC%8B%9C%ED%95%B43.png',
				link : {
						mobileWebUrl : document.location.href,
						webUrl : document.location.href
					}
				},
				buttons : [{
					title : '링크 열기',
					link : {
						mobileWebUrl : document.location.href,
						webUrl : document.location.href
					}
				}]
			});
		}

		/* 리뷰작성폼에서 전송버튼 누르면 적용하는 함수 */
		function chkreviewForm(revForm, maxByte) {
			/* 리뷰 작성 폼 유효성 검사 */
			if (!revForm.revContent.value) {
				alert("내용을 작성해주세요");
				revForm.revConter.focus();
				return false;
			}

			/* 글자수 유효성검사 */
			var rev = revForm.revContent.value;
			var revLength = rev.length;

			var chkByte = 0;
			var chkLen = 0;
			var oneChar = '';
			var rev2 = '';

			for (var i = 0; i < revLength; i++) {
				oneChar = rev.charAt(i);

				if (escape(oneChar).length > 4) {
					chkByte += 2; //한글
				} else {
					chkByte++;
				}

				if (chkByte <= maxByte) {
					chkLen = i + 1;
				}
			}

			if (chkByte > maxByte) {
				alert("해당 입력 창은 최대 " + maxByte + "Byte를 초과할 수 없습니다.");
				rev2 = rev.substr(0, chkLen);
				revForm.revContent.value = rev2;
				revForm.revContent.focus();
				return false;
			}

			/* 전송 */
			revForm.action = "revAdd.do?exhID=" + '${listOne.exhID}' + "&email=" + '${member.email}';
			revForm.submit();
			alert("리뷰 작성 완료!\n내가 쓴 리뷰는 마이페이지에서도 확인 가능합니다.");
		}

		/* 가고싶어요 버튼 눌렀을때 적용하는 함수 */
		$("#wishBtn").click(function() {
			$.ajax({
				url : "checkWish.do",
				type : "POST",
				dataType : "JSON",
				data : {
					email : '${member.email}',
					exhID : '${listOne.exhID}'
				},
				success : function(data) {
					if (data.checkWish == 0) {
						$("#wishBtn").attr("checked","checked");
						alert("가고싶은 전시로 등록되었습니다.\n나의 가고싶은 전시는 마이페이지에서도 확인 가능합니다!")
					} else if (data.checkWish == 1) {
						$("#wishBtn").removeAttr("checked");
						alert("가고싶은 전시가 취소되었습니다.");
					}
				},
				error : function(request, status, error) {
					var msg = "ERROR : <br>"
						msg += request.status + "<br>" + request.responseText + "<br>" + error;
				}
			});
		});

		/* 리뷰작성 버튼 눌렀을때 리뷰작성모달 불러오는 함수 */
		$(document).ready(function() {
			$("#reviewBtn").click(function() {
				$("#revWriteModal").modal({
					backdrop : true
				});
			});
		});
		
		
		/* 전시사진 슬라이더 */
		var swiper = new Swiper('.swiper-container', {
	      navigation: {
	        nextEl: '.swiper-button-next',
	        prevEl: '.swiper-button-prev',
	      },
	    });
	</script>

</body>
</html>
