<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/searchMemberId.css">
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">  
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <form action="searchId.me">
            <h1>아이디 찾기</h1>
            <div>
                <input type="text" id="search-id" placeholder="이메일 입력">
            </div>

            <div>
                <input type="submit" value="아이디 찾기">
            </div>
        </form>

        <div id="search-id-text">해당 이메일로 가입된 아이디는 'xxxxxxx' 입니다.</div>

        <div class="login-searchPwd">
            <a href="loginForm.me">로그인</a>&nbsp;
            &nbsp;<p>|</p>&nbsp;
            &nbsp;<a href="searchPwdForm.me">비밀번호 찾기</a>
        </div>
    </div>
</body>
</html>