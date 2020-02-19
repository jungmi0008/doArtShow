<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.seeAll{
      text-align : right;
      float: right;
      padding-top: 5px;
    }
.box a:link, .iconDiv a:link {
color: gray;
text-decoration: none;
}

.box a:visited,.iconDiv a:visited {
color: gray;
text-decoration: none;
}

.box a:hover,.iconDiv a:hover {
color: gray;
text-decoration: underline;
}

.box a {
vertical-align: middle;
line-height: 250px;
}

.iconDiv label {
color: gray;
font-size: 1.2em;
}

.boxFull{
		min-height : 600px;
		overflow: hidden;
	}

@media(max-width: 1200px){
	.boxFull{
		min-width: 100%;
		min-height: 40vh;
		height:auto;
	}
	.oneRev{
		min-width: 36vw;
		min-height: 20vh;
	}

}
@media(min-width: 1200px){
	.boxFull{
		min-width: 100%;
		min-height: 40vh;
		height:auto;
	}
	.oneRev{
		min-width : 30vw;
		min-height: 20vh;
		
	}
}
@media(max-width: 1200px){	
	#profileImg{	
	width: 40%;
	min-height: 35vh;
	
	display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
	float: left;
	
	}
	#profileImg img{
	min-width : 200px;
	height : auto;
	}
	#profile{
	padding: 30px;
	
	width: 60%;
	min-height: 35vh;
	float : left;
	
	}
	#profileName{
		text-align: center;
	}
	
}

@media(min-width: 1200px){
	#profileDiv{
		width:25%;
	}
	#profileName{
		text-align: center;
	}
	#profileImg{
	width: 100%;
	min-height: 35vh;
	
	display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
	float: left;
	}
	#profileImg img{
	width : 200px;
	height : auto;
	}
	#profile{
	padding: 30px;
	
	width: 100%;
	min-height: 35vh;
	}
}
.iconDiv{
	min-width : 33%;
	width: auto;
	height: 80px;
	overflow: hidden;
	float : left;
}
.iconDiv img{
	max-width : 100%;
	max-height: 100%;
	overflow: hidden;
}

.mainDiv{
	padding-left : 50px;
}


.exhNameDiv b{
	display: inline-block;
	padding:0px;
	width: 190px;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
.oneExhDiv {
	text-align: center;
    width: 18.75vw;
    height : 35vh;
    overflow: hidden;
    float: left;
    margin: 10px;
}

.exhImgDiv {
	padding: 0.75vw;
    width: 18vw;
    height: 32vh;
    overflow: hidden;
    display:flex;
    justify-content:center;
    align-items:center;
}

.exhImgDiv img {
    width: 80%;
    height: auto;
    overflow: hidden;
}

.exhNameDiv {
    height: 3vh;
    overflow: hidden;
    font-size: 12pt;
    padding-top: 2px;
}

/* 리뷰 */
.revImg {
    max-height: 20vh;
    width: 40%;
    
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    float: left;
}

.revImgA{
	max-height: 100%;
    max-width: 100%;
}
.revImgA img{
	padding : 5px;
	max-width: 98%;
	max-height: 20vh;
	overflow: hidden;
}

        


        .revBody {
            float: left;
            width: 60%;
            height: 190px;
            padding: 10px;
        }

        .revContent {
            height: 130px;
            max-width: 100%;
            padding : 10px;
            background-color: #f5f5f5;
            
			white-space: nowrap;
			text-overflow: ellipsis;
			overflow: hidden;
			
			border-radius: 4px;
		}	

        .reviewNav {
            padding: 0px;
        }

        .reviewNav a {
            padding: 0px;
        }
        
        .revExhNameSpan, .revNav{
        	max-width:100%;
        }
        .oneRev{
        float:left;
        margin-bottom:20px;
        margin-right:10px;
		overflow: hidden;
		width:37.5%;
}
.revExhName{
	max-width:100%;
	overflow: hidden;
}
.revExhNameSpan{
	font-weight : bold;
	font-size : 15pt;
	display : inline-block;
	padding : 0px;
	width: 80%;
	float : left;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
.exhImgDivA{
	max-height: 100%;
    max-width: 100%;
}

.exhImgDivA img{
padding : 5px;
	max-width: 98%;
	max-height: 32vh;
	overflow: hidden;
}

#dropdown-menu{
	max-width: 80px;
	width:auto;
}

#dropdown-menu a{
	 margin-left: 20px;
	 width: 80px;
	 font-size: 14pt;
}

#revWriteModal-content .modal-body{
         padding: 30px;
            padding-top: 40px;
          padding-bottom: 10px;
      }
      #revWriteModal-content .modal-header .close {
          font-size: 35px;
      }
      #revWriteModal-content .modal-header .close {
          margin-top: -5px;
          margin-right: 10px;
      }
      #revWriteModal-content .modal-header {
          padding: 10px;
      }
      
      input#exhName{
         width: 100%;
      }
      textarea#revContent{
         width: 100%;
          height: 250px;
      }

</style>
<!-- ======================= profileDiv ================================= -->


<div class="container col-lg-2" id="profileDiv" style="margin-top:25px; padding-rigth:20px;">
    <div id="profileImg">
        <img  style="max-width : 200px; border-radius:100px;" src="/doArtShow/memberProfileImages/${member.profileImg}" alt="${member.profileImg}">
    </div>
    <div id="profile">
        <div id="profileName" style="font-size: 3em; margin-top:20px; font-weight:bold; margin-bottom:80px;">
            ${member.name}
        </div>
        <div style="max-width: 100%; overflow: hidden; min-height:80px;">
        
	        <div class="iconDiv">
	        <a href="<%=request.getContextPath()%>/client/auth/reviewList.do">
	        <img src="/doArtShow/resourcesImages/myreview.png">
	        </a>
	        </div>
	        <div class="iconDiv">
	        <a href="<%=request.getContextPath()%>/client/auth/memberPage.do">
	        <img src="/doArtShow/resourcesImages/mypage.png">
	        </a>
	        </div>
	        <div class="iconDiv">
	        <a href="<%=request.getContextPath()%>/client/auth/memberDetail.do">
	        <img src="/doArtShow/resourcesImages/setting.png">
	        </a>
	        </div>
	     </div>
    </div>
</div>
<!-- ====================================================================== -->