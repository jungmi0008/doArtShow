<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <title>프로필 사진 수정 완료</title>
    <style>
        #img_preview {
            height: 50vh;
            overflow: hidden;
        }

        img {
            height: 30vh;
            overflow: hidden;
        }
    </style>
</head>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<jsp:include page="../../module/client_auth.jsp"></jsp:include>
<body>
    <div class="container" id="mainContainer">
        <div id="pDiv">
            <center>수정이 완료되었습니다.</center>
        </div>
        <div align="center">
        <input class="btn" type="button" value="닫기" onClick="closeFn()">
        </div>
    </div>
</body>

<script>
	function closeFn(){
		opener.window.location.reload();
		self.close();
	}
</script>
</html>