<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/searchMemberId.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/searchMemberId.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">  
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <div id="search-id-area">
            <h1>아이디 찾기</h1>
            <div>
                <input type="text" id="search-id" placeholder="이메일 입력">
            </div>
            <!-- JS로 AJAX요청! -->
            <div>
                <input type="submit" onclick="searchId()" value="아이디 찾기">
            </div>
        </div>
        
        <div id="search-id-text"></div>

        <div class="login-searchPwd">
            <a href="loginForm.me">로그인</a>&nbsp;
            &nbsp;<p>|</p>&nbsp;
            &nbsp;<a href="searchPwdForm.me">비밀번호 찾기</a>
        </div>
    </div>
</body>
</html>