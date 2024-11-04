<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/enrollForm.css">
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div>
        <h1>회원가입</h1>
        
        <form action="insert.me">
            <h2 class="enroll-input-title">*아이디</h2>
            <div class="enroll-input-area">
                <input type="text" placeholder="아이디 입력(특수문자 제외)">
                <button>중복확인</button>
            </div>
            
            <h2 class="enroll-input-title">*비밀번호</h2>
            <div class="enroll-input-area">
                <input type="password" placeholder="비밀번호 입력">
            </div>

            <h2 class="enroll-input-title">*비밀번호 확인</h2>
            <div class="enroll-input-area">
                <input type="password" placeholder="비밀번호 재입력">
            </div>

            <h2 class="enroll-input-title">*이름</h2>
            <div class="enroll-input-area">
                <input type="text" placeholder="이름 입력">
            </div>

            <h2 class="enroll-input-title">*닉네임</h2>
            <div class="enroll-input-area">
                <input type="text" placeholder="닉네임 입력(특수문자 제외)">
            </div>

            <div id="enroll-phone-certify">
                <div id="enroll-phone">
                    <h2 class="enroll-input-title">*전화번호</h2>
                    <div class="enroll-input-area">
                        <input type="text" placeholder="휴대폰 번호 입력('-'제외 11자리 입력)">
                        <button>인증번호 받기</button>
                    </div>
                </div>
                <div id="enroll-certify">
                    <h2 class="enroll-input-title">*인증번호</h2>
                    <div class="enroll-input-area">
                        <input type="text" placeholder="인증번호 입력">
                        <button>인증</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>