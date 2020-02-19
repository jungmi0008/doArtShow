<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="../js/chkEmailAjax.js"></script>
    <title>이메일 중복확인</title>
</head>
<jsp:include page="../../module/1doctype_head.jsp"></jsp:include>
<jsp:include page="../../module/client_auth.jsp"></jsp:include>

<body>
    <div class="container" id="mainContainer">
        <form name="emailChkForm">
            <table align="center">
                <tr>
                    <td id="formTitle">이메일</td>
                    <td><input class="form-control" type="text" name="email" id="email_value"
                            value="<%= request.getParameter("email")%>"></td>
                    <td><input class="btn" type="button" id="emailChkModalBtn" value="중복확인"></td>
                </tr>
                <tr>
                    <td colspan="3" style="overflow:hidden; height:15vh;">
                        <div id="email_result"></div>
                    </td>
                </tr>
                <tr colspan="3">
                    <td>
                        <input class="btn" type="button" value="이메일 사용" id="emailUseBtn" onclick="setId()" style="margin: 1vw;"></td>
                </tr>
            </table>
        </form>
    </div>
    <script language="javascript">
        $(document).ready(function () {
            $("#emailUseBtn").attr("disabled", true);
            $("#emailChkModalBtn").click(function () {
                $("#emailUseBtn").attr("disabled", false);
                $("#submitBtn").attr("disabled", true);
            });
        });

        function setId() {
            opener.document.signUpForm.email.value = document.emailChkForm.email.value;
            $("#submitBtn").attr("disabled", false);
            self.close();
        }
    </script>
</body>

</html>