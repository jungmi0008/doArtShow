<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<title>비밀번호 찾기</title>
<jsp:include page="../../module/2body_first.jsp"></jsp:include>
</head>

<body>
    <div class="container" id="mainContainer">
        <form style="height: 63vh; padding:10vh;" method="post" name="findPwForm">
            <table align="center">
                <tr>
                    <td id="formTitle" colspan="2">비밀번호 찾기</td>
                </tr>
                <tr>
                    <td class="check_tr" colspan="2"></td>
                </tr>
                <tr>
                    <th><label class="tableLabel">이메일</label></th>
                    <td><input class="form-control" type="text" name="email" id="input_email" placeholder="이메일"></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="check_tr">
                        <div id="chkEmail"></div>
                    </td>
                </tr>
                <tr>
                    <th><label class="tableLabel">생년월일</label></th>
                    <td><input class="form-control" type="text" name="birth" id="input_birth" placeholder="생년월일 (8자리)">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td class="check_tr">
                        <div id="chkBirth"></div>
                    </td>
                </tr>
                <tr>
                	<td></td>
                    <td><input class="btn" type="button" id="findPwBtn" value="인증번호 보내기"
                            onclick="chkFindPwForm(this.form)" style="color:white; width: 100%;"></td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    
    <script type="text/javascript">
        $(document).ready(function () {
            $("#input_email").keyup(function () {
                if ($("#input_email").val() != "") {
                    $("#chkEmail").text("")
                }
                var email = $("#input_email").val();
                var filter =
                    /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
                if (filter.test(email)) {
                    $("#chkEmail").text("");
                    $("#findPwBtn").attr("disabled", false);
                } else {
                    $("#chkEmail").text("이메일 형식에 맞게 작성해주세요. 예시)123@art.com");
                    $("#chkEmail").css('color', 'red');
                    $("#findPwBtn").attr("disabled", true);
                }
            });
            $("#input_birth").keyup(function () {
                if ($("#input_birth").val() != "") {
                    $("#chkBirth").text("")
                }
                var birth = $("#input_birth").val();
                var filter = /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
                if (filter.test(birth)) {
                    $("#chkBirth").text(" ");
                    $("#findPwBtn").attr("disabled", false);
                } else {

                    $("#chkBirth").text("생년월일 8자리를 입력해주세요.");
                    $("#chkBirth").css('color', 'red');
                    $("#findPwBtn").attr("disabled", true);
                }
            });
        });
    </script>
</body>

</html>