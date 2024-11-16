<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/changeMemberPwd.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/enrollForm.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">  
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <form action="changePwd.me?memberId=${memberId}" method="post">
            <h1>비밀번호 변경</h1>
            <div id="pwdArea">
                <input type="password" name="memberPwd" id="userInputPwd" onkeyup="inputPwdCheck()" placeholder="비밀번호 입력(4 ~ 12글자)" minlength="4" maxlength="12" required>
                <input type="password" id="checkPwd" onkeyup="inputPwdCheck()" placeholder="비밀번호 재입력" minlength="4" maxlength="12" required>
                <div></div>
            </div>

            <div>
                <input type="submit" id="enroll-enter" value="비밀번호 변경">
            </div>
        </form>
    </div>
</body>
</html>