$(document).ready(function(){
	var exhGubun1 = $('#exhGubun1').val();
	var exhGubun2 = $('#exhGubun2').val();
	var exhGubun3 = $('#exhGubun3').val();
	var exhGubun4 = $('#exhGubun4').val();
	var admFee = $('#admFee').val();
	var exhGubun1Radio = $('input[name="exhGubun1Radio"]');
	var exhGubun2Radio = $('input[name="exhGubun2Radio"]');
	var exhGubun3Check = $('input[name="exhGubun3Check"]');
	var exhGubun4Radio = $('input[name="exhGubun4Radio"]');
	var admFeeRadio = $('input[name="admFeeRadio"]');

	for (var i = 0; i < exhGubun1Radio.length; i++) {
		if (exhGubun1Radio[i].value == exhGubun1) {
			exhGubun1Radio[i].checked = "true";
		}
	}
	
	for (var i = 0; i < exhGubun2Radio.length; i++) {
		if (exhGubun2Radio[i].value == exhGubun2) {
			exhGubun2Radio[i].checked = "true";
		}
	}
	
	var exhGubun3List = exhGubun3.split(" ");

	for (var i = 0; i < exhGubun3Check.length; i++) {
		for (var j = 0; j < exhGubun3List.length; j++) {
			if (exhGubun3Check[i].value == exhGubun3List[j]) {
				exhGubun3Check[i].checked = "true";
			}
		}
	}

	for (var i = 0; i < exhGubun4Radio.length; i++) {
		if (exhGubun4Radio[i].value == exhGubun4) {
			exhGubun4Radio[i].checked = "true";
		}
	}
	
	for (var i = 0; i < admFeeRadio.length; i++) {
		if (admFeeRadio[i].value == admFee) {
			admFeeRadio[i].checked = "true";
		}
	}
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
            //document.getElementById("exhPlaceAddr1").value = addr;
            $('#exhPlaceAddr1').text(addr);
            // 커서를 상세주소 필드로 이동한다.
            //document.getElementById("exhGubun4").focus();
        }
    }).open();
}

$('.content')
	.on("dragover", dragOver)
	.on("dragleave", dragOver)
	.on("drop", uploadFiles);

function dragOver(e){
	e.stopPropagation();
	e.preventDefault();
}

function uploadFiles(e){
	e.stopPropagation();
	e.preventDefault();
}

function dragOver(e) {
    e.stopPropagation();
    e.preventDefault();
    if (e.type == "dragover") {
        $(e.target).css({
            "background-color": "black",
            "outline-offset": "-20px"
        });
    } else {
        $(e.target).css({
            "background-color": "gray",
            "outline-offset": "-10px"
        });
    }
}


var imageFile1;
var imageFile2;
var imageFile3;
var imageFile4;

function uploadFiles(e) {
    e.stopPropagation();
    e.preventDefault();
    dragOver(e); //1
 
    e.dataTransfer = e.originalEvent.dataTransfer; //2
    var files = e.target.files || e.dataTransfer.files;
 
    if (files.length > 1) {
        alert('하나만 올려라.');
        return;
    }
    
    if (files[0].type.match(/image.*/)) {
        
    } else {
        alert('이미지가 아닙니다.');
        return;
    }
    
    if (files[0].type.match(/image.*/)) {
    	$(e.target).attr('src', window.URL.createObjectURL(files[0]));
    	
        $(e.target).css({
            "outline": "none",
            "background-size": "100% 100%"
        });
        
        if ($(this)[0].id == "imageFile1") {
        	imageFile1 = files[0];
		} else if ($(this)[0].id == "imageFile2") {
        	imageFile2 = files[0];
		} else if ($(this)[0].id == "imageFile3") {
        	imageFile3 = files[0];
		} else if ($(this)[0].id == "imageFile4") {
        	imageFile4 = files[0];
		}

    } else {
      alert('이미지가 아닙니다.');
      return;
    }
}

function sendModifyExhData() {
	var tags = "";
	$("input[name=exhGubun3Check]:checked").each(function() {
		var tag = $(this).val();
		tags += ",";
		tags += tag;
	});

	var formData = new FormData();
	formData.append("exhID", $('#exhID').text());
	formData.append("memberID", $('#memberID').text());
	formData.append("exhGubun1", $('input[name="exhGubun1Radio"]:checked').val());
	formData.append("exhGubun2", $('input[name="exhGubun2Radio"]:checked').val());
	formData.append("exhGubun3", tags);
	formData.append("exhName", $('#exhName').val());
	formData.append("artistName", $('#artistName').val());
	formData.append("artistInfo", $('#artistInfo').val());
	formData.append("exhContent", $('#exhContent').val());
	formData.append("exhPlace", $('#exhPlace').val());
	formData.append("exhPlaceZip", $('#exhPlaceZip').text());
	formData.append("exhGubun4", $('input[name="exhGubun4Radio"]:checked').val());
	formData.append("exhPlaceAddr1", $('#exhPlaceAddr1').text());
	formData.append("exhPlaceAddr2", $('#exhPlaceAddr2').val());
	formData.append("exhUrl", $('#exhUrl').val());
	formData.append("exhStartDate", $('#exhStartDate').val());
	formData.append("exhEndDate", $('#exhEndDate').val());
	formData.append("opTime", $('#opTime').val());
	var tel = $('#tel1').val() + "-" + $('#tel2').val() + "-" + $('#tel3').val();
	formData.append("tel", tel);
	formData.append("admFee", $('input[name="admFeeRadio"]:checked').val());
	formData.append("imageFile1", imageFile1);
	formData.append("imageFile2", imageFile2);
	formData.append("imageFile3", imageFile3);
	formData.append("imageFile4", imageFile4);
	
	var img = ["O", "O", "O", "O"];
	
	if (formData.get("imageFile1") == "undefined") {
		img[0] = "X";
	}
	if (formData.get("imageFile2") == "undefined") {
		img[1] = "X";
	}
	if (formData.get("imageFile3") == "undefined") {
		img[2] = "X";
	}
	if (formData.get("imageFile4") == "undefined") {
		img[3] = "X";
	}
	console.log(img);
	formData.append("img", img);
	console.log("asdhfjashdlkjfhasdkjfhkljsadf");
	
	$.ajax({
		url: "/doArtShow/modifyExh.do",
		type: "POST",
		enctype:"multipart/form-data",
		data: formData,
		processData: false,
		contentType: false,
		cache: false,
		success: function(data){
			if (data == "success") {
				alert("수정하였습니다.");
				
				location.href = "allExhList.do";
			} else {
				alert("실패하였습니다.");
				
				location.reload();
			}
		},
		error:function(request,status,error){			
	        alert("수정할 수 없습니다.");
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }

	});
	
	


}

function cancelModify() {
	var conf = confirm("취소하시겠습니까?");
	
	if (conf == true) {
		history.go(-1);
	}
}