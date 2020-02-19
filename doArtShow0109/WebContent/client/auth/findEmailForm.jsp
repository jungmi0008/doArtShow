<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>

<body>
    <jsp:include page="../../module/2body_first.jsp"></jsp:include>
    <div class="container" id="mainContainer">
        <form style="height: 63vh; padding:10vh;" name="findEmailForm" method="post">
            <table align="center">
                <tr>
                    <td id="formTitle" colspan="2">이메일 찾기</td>
                </tr>
                <tr>
                    <td class="check_tr" colspan="2"></td>
                </tr>
                <tr>
                    <th><label class="tableLabel">이름</label></th>
                    <td><input class="form-control" type="text" name="name" id="input_name" placeholder="이름"></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="check_tr">
                        <div id="chkName"></div>
                    </td>
                </tr>
                <tr>
                    <th><label class="tableLabel">생년월일</label></th>
                    <td><input class="form-control" type="text" name="birth" id="input_birth" placeholder="생년월일(8자리)"
                            maxlength="10"></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="check_tr" colspan="2">
                        <div id="chkBirth"></div>
                    </td>
                </tr>
                <tr>
                	<td></td>
                    <td><input class="btn" type="button" value="다음" onclick="chkFindEmailForm(this.form)" style="color:white; width: 100%;"></td>
                </tr>
            </table>
        </form>
    </div>
    <jsp:include page="../../module/3body_last.html"></jsp:include>
    <jsp:include page="../../module/client_auth.jsp"></jsp:include>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#input_birth").keyup(function () {
                if ($("#input_birth").val() != "") {
                    $("#chkBirth").text("")
                }
            });
            $("#input_name").keyup(function () {
                if ($("#input_name").val() != "") {
                    $("#chkName").text("")
                }
            });
        });
    </script>
</body>

</html>