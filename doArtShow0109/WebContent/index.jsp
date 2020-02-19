<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/module/1doctype_head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/doArtShow/libs/swiper/css/swiper.css" />
<link rel="stylesheet" type="text/css" href="/doArtShow/css/indexStyle.css" />
<!-- <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-kr.css' rel='stylesheet' type='text/css'> -->
<!-- font-family: 'Spoqa Han Sans', 'Spoqa Han Sans JP', 'Sans-serif'; -->

<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet"> 
<!-- font-family: 'Jua', sans-serif; -->
<style>

</style>
<body>

<jsp:include page="/module/2body_first.jsp"></jsp:include>

<div style="margin-bottom: 580px;"></div>


<div class="rotating">
<div class="rotating-text">
  <p>전시:해에서 </p>
  <p>
    <span class="word alizarin">지도로  찾아요.</span>
    <span class="word wisteria">내 전시를 알려요.</span>
    <span class="word peter-river">#태그로 둘러봐요.</span>
    <span class="word emerald">최신 전시를 만나요.</span>
    <span class="word sun-flower">영감을 얻어요.</span>
  </p>
</div>
</div>



<div class="mainwall" style="position: absolute; top: 0;">
			<div class="wallpaper">
				<div>
					<div>
						<img id="wallPaper" src="/doArtShow/resourcesImages/mainwall0.jpg" width="100%" height="480px;"/>
					</div>
				</div>
				
			</div>
</div>
<div style="height:80px;">
</div>
					

		<div class="slider-container">
			<div class="slider-head"><h1 class="slider-h">최근 등록된 전시</h1> <a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do?" class="slider-more">&nbsp;더보기&nbsp;></a></div>
			<div class="swiper-container">
				<div class="swiper-wrapper">
			 <c:forEach  var="i" items="${lists}" varStatus="vs1" begin="0" end="8" >
					<div class="swiper-slide">
						<a href="client/exhibition/ExContentView.do?exhID=${i.exhID}">
							<div class="slide-content">
							<p class="slide-exhName">${i.exhName }</p>
							<p class="slide-exhPlace">${i.exhPlace }</p>
							</div>
							<img src="/doArtShow/exhibitionImages/${i.imageFile1 }"/>
						</a>
					</div>
				</c:forEach>
 				    
				</div>
				<!-- 스크롤 바  -->
				<div class="swiper-scrollbar" style="width:283px;left:37%;"></div>
				<!-- 좌우 화살표 추가 -->
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>

			</div>
		</div>
		
		
		
		<div class="slider-container">
		<div class="slider-head"><h1 class="slider-h">지금 주목받는 전시</h1> <a href="<%=request.getContextPath()%>/client/exhibition/ExListView.do?" class="slider-more">&nbsp;더보기&nbsp;></a></div>
			<div class="swiper-container">
				<div class="swiper-wrapper">
					
			 <c:forEach  var="i" items="${lists}" varStatus="vs1" begin="9" end="17">
					<div class="swiper-slide">
						<a href="client/exhibition/ExContentView.do?exhID=${i.exhID}">
							<div class="slide-content">
							<p class="slide-exhName">${i.exhName }</p>
							<p class="slide-exhPlace">${i.exhPlace }</p>
							</div>
							<img src="/doArtShow/exhibitionImages/${i.imageFile1 }"/>
						</a>
					</div>
				</c:forEach>
 				    
				</div>
				<!-- 스크롤 바  -->
				<div class="swiper-scrollbar" style="width:283px;left:37%;"></div>
				<!-- 좌우 화살표 추가 -->
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>

			</div>
		</div>


<jsp:include page="/module/3body_last.html" />
<script src="/doArtShow/libs/swiper/js/swiper.js"></script>
<!-- Initialize Swiper Library Begin - Younggi -->
  <script>
  
/*   function dudrl(){
	  $.ajax({
	      url : "indexContent.do",
	      type : "GET",
	      dataType : "JSON", 
	      success : function(data){
	    	  console.log('안녕 영기들?');
	    	  console.log(data);
	    	  
	    	  if(data. == 0){
	            $("#wishBtn").attr("checked", "checked");
	            alert("가고싶은 전시로 등록되었습니다.\n나의 가고싶은 전시는 마이페이지에서도 확인 가능합니다!")
	         }else if(data.checkWish == 1){
	            $("#wishBtn").removeAttr("checked");
	            alert("가고싶은 전시가 취소되었습니다.");
	         }
	      },
	      error : function(request, status, error){
	    	  console.log('에러났다영기들');
	    	  console.log(error);
	      }
	   });
  }
*/
   
  
  
  var mySwiper = new Swiper ('.swiper-container', {
    // Optional parameters
    direction: 'horizontal',
    spaceBetween: 55,
    slidesPerView: 3,
    slidesPerGroup: 3,
    // 네비 화살표 처리
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    // 스크롤바 처리
     scrollbar: {
      el: '.swiper-scrollbar',
      hide: false,
    },
  });
  
  </script>
<!-- Swiper Library End - Younggi -->




<script>
//최상단 배경이미지 슬라이드 전환 효과
$(function(){

    var imgArray = new Array();
    imgArray[0] = "/doArtShow/resourcesImages/mainwall1.jpg";
    imgArray[1] = "/doArtShow/resourcesImages/mainwall2.jpg";
    imgArray[2] = "/doArtShow/resourcesImages/mainwall3.jpg";
    imgArray[3] = "/doArtShow/resourcesImages/mainwall4.jpg";
    imgArray[4] = "/doArtShow/resourcesImages/mainwall5.jpg";
    var cnt = 0;

    setInterval(function() {
        $('#wallPaper').fadeOut(400,function(){
        $('#wallPaper').attr("src", imgArray[cnt]);
        }).fadeIn(400);
        
        cnt++;
        if (cnt == 5) {
            cnt = 0;
        }
    }, 4000);
});


/////////////////////////////
/* 글자 회전 이펙트  */

var words = document.querySelectorAll(".word");
words.forEach(function (word) {
  var letters = word.textContent.split("");
  word.textContent = "";
  letters.forEach(function (letter) {
    var span = document.createElement("span");
    span.textContent = letter;
    span.className = "letter";
    word.append(span);
  });
});
var currentWordIndex = 0;
var maxWordIndex = words.length - 1;
words[currentWordIndex].style.opacity = "1";
var rotateText = function () {
  var currentWord = words[currentWordIndex];
  var nextWord = currentWordIndex === maxWordIndex ? words[0] : words[currentWordIndex + 1];
  // rotate out letters of current word
  Array.from(currentWord.children).forEach(function (letter, i) {
    setTimeout(function () {
      letter.className = "letter out";
    }, i * 80);
  });
  // reveal and rotate in letters of next word
  nextWord.style.opacity = "1";
  Array.from(nextWord.children).forEach(function (letter, i) {
    letter.className = "letter behind";
    setTimeout(function () {
      letter.className = "letter in";
    }, 340 + i * 80);
  });
  currentWordIndex =
  currentWordIndex === maxWordIndex ? 0 : currentWordIndex + 1;
};
rotateText();
setInterval(rotateText, 4000);
//////////////////////////////////////


</script>




</body>
</html>













