<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/loginForm.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/loginForm.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">  
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <form action="login.me">
            <!-- 아이디 / 비밀번호 입력 -->
            <h1>로그인</h1>
            <div>
                <input type="text" id="login-id" placeholder="아이디 입력">
                <input type="text" id="login-pwd" placeholder="비밀번호 입력">
            </div>
            <!-- 자동로그인 / 아이디저장 버튼 -->
            <div class = "checkbox-btn-area">
                <label id="autoLogin">
                    <input type="checkbox">&nbsp;자동로그인
                </label>
                <label id="saveLogin">
                    <input type="checkbox">&nbsp;아이디저장
                </label>
            </div>

            <br><br>

            <div>
                <input type="submit" onclick="loginBtn()" value="로그인">
            </div>
        </form>
        <!-- 회원가입 / 아이디 & 비밀번호 찾기 -->
        <div class="enroll-search">
            <a href="agreeForm.me">회원가입</a>&nbsp;
            &nbsp;<p>|</p>&nbsp;
            &nbsp;<a href="searchIdForm.me">아이디 찾기</a>&nbsp;
            &nbsp;<p>|</p>&nbsp;
            &nbsp;<a href="searchPwdForm.me">비밀번호 찾기</a>
        </div>
        <!-- 간편로그인 -->
        <fieldset style="text-align: center; border: none; border-top: 1px solid rgb(223, 223, 223);">
            <legend>&nbsp;&nbsp;간편 로그인&nbsp;&nbsp;</legend>
            <button id="kakao-login"><img src="${pageContext.request.contextPath}/resources/image/Kakao_Logo.png"><p>카카오 로그인</p></button>
            <button id="naver-login"><img src="${pageContext.request.contextPath}/resources/image/Naver_Logo.png"><p>네이버 로그인</p></button>
            <button id="google-login"><img src="${pageContext.request.contextPath}/resources/image/Google_Logo.png"><p>Google 로그인</p></button>
        </fieldset>
    </div>
</body>
</html>