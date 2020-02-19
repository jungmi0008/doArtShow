<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <title>프로필 사진 수정</title>
    <style>
        #img_preview {
            height: 50vh;
            overflow: hidden;
        }

        /*     img{
    	height : 30vh;
    	overflow : hidden;
    } */
    </style>

    <script language="javascript">
        /* 이미지 불러왔을 때 미리보기 */
        function previewImage(targetObj, img_preview) {
            $("#imgUseBtn").attr("disabled", false);
            var preview = document.getElementById(img_preview); //div id
            var ua = window.navigator.userAgent;

            //ie일때(IE8 이하에서만 작동)
            if (ua.indexOf("MSIE") > -1) {
                targetObj.select();
                try {
                    var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
                    var ie_preview_error = document.getElementById("ie_preview_error_" + img_preview);


                    if (ie_preview_error) {
                        preview.removeChild(ie_preview_error); //error가 있으면 delete
                    }

                    var img = document.getElementById(img_preview); //이미지가 뿌려질 곳

                    //이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
                    img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + src +
                        "', sizingMethod='scale')";
                } catch (e) {
                    if (!document.getElementById("ie_preview_error_" + img_preview)) {
                        var info = document.createElement("<p>");
                        info.id = "ie_preview_error_" + img_preview;
                        info.innerHTML = e.name;
                        preview.insertBefore(info, null);
                    }
                }
                //ie가 아닐때(크롬, 사파리, FF)
            } else {
                var files = targetObj.files;
                for (var i = 0; i < files.length; i++) {
                    var file = files[i];
                    var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
                    if (!file.type.match(imageType))
                        continue;
                    var prevImg = document.getElementById("prev_" + img_preview); //이전에 미리보기가 있다면 삭제
                    if (prevImg) {
                        preview.removeChild(prevImg);
                    }
                    var img = document.createElement("img");
                    img.id = "prev_" + img_preview;
                    img.classList.add("obj");
                    img.file = file;
                    img.style.width = '100px';
                    img.style.height = '100px';
                    preview.appendChild(img);
                    if (window.FileReader) { // FireFox, Chrome, Opera 확인.
                        var reader = new FileReader();
                        reader.onloadend = (function (aImg) {
                            return function (e) {
                                aImg.src = e.target.result;
                            };
                        })(img);
                        reader.readAsDataURL(file);
                    } else { // safari is not supported FileReader
                        //alert('not supported FileReader');
                        if (!document.getElementById("sfr_preview_error_" +
                                img_preview)) {
                            var info = document.createElement("p");
                            info.id = "sfr_preview_error_" + img_preview;
                            info.innerHTML = "not supported FileReader";
                            preview.insertBefore(info, null);
                        }
                    }
                }
            }
        }
    </script>
</head>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<jsp:include page="../../module/client_auth.jsp"></jsp:include>

<body>
    <div class="container" id="mainContainer">
        <form name="imgUpdateForm" action="profileImgUpdate.do" method="post" enctype="multipart/form-data">
            <table align="center">
                <tr>
                    <td id="formTitle">프로필 사진</td>
                </tr>
                <tr>
                    <td><input class="form-control" type="file" name="profileImg" id="profileImg"
                            onchange="previewImage(this,'img_preview')"></td>
                </tr>
                <tr>
                    <td>
                        <div id="img_preview"></div>
                    </td>
                </tr>
                <tr colspan="2">
                    <td><input class="btn" type="submit" value="이미지 사용" id="imgUseBtn" disabled></td>
                    <td><input class="btn" type="button" value="닫기" onclick="javascript:self.close()"></td>
                </tr>
            </table>
        </form>
    </div>
</body>

</html>