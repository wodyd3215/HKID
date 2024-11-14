<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/changeMemberPwd.css">
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">  
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <form action="changePwd.me">
            <h1>비밀번호 변경</h1>
            <div>
                <input type="text" id="pwd-input" placeholder="비밀번호 입력">
                <input type="text" id="pwd-reInput" placeholder="비밀번호 재입력">
            </div>

            <div>
                <input type="submit" value="비밀번호 변경">
            </div>
        </form>
    </div>
</body>
</html>