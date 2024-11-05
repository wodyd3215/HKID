<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/enrollForm.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/enrollForm.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div>
        <h1>회원가입</h1>
        
        <form action="insert.me" method="post">
            <h2 class="enroll-input-title">*아이디</h2>
            <div class="enroll-input-area">
                <input type="text" id="userInputId" placeholder="아이디 입력(특수문자 제외)" onkeyup="checkUserId(this)">
                <button id="checkIdBtn">중복확인</button>
            </div>
            
            <h2 class="enroll-input-title">*비밀번호</h2>
            <div class="enroll-input-area">
                <input type="password" placeholder="비밀번호 입력(4 ~ 12글자)" minlength="4" maxlength="12">
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
                <input type="text" placeholder="닉네임 입력(특수문자 제외 / 최대 8글자)" maxlength="8">
            </div>

            <div id="enroll-phone-certify">
                <div id="enroll-phone">
                    <h2 class="enroll-input-title">*전화번호</h2>
                    <div class="enroll-input-area">
                        <input type="text" placeholder="휴대폰 번호 입력('-'제외 11자리 입력)" maxlength="11">
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

            <h2 class="enroll-input-title">*이메일</h2>
            <div id="enroll-email" class="enroll-input-area">
                <input id="email-input1" type="text" placeholder="이메일 입력(특수문자 제외)">
                <input id="email-input3" type="text" name="" value="@" readonly>
                <input id="email-input2" type="text" placeholder="ex) naver.com">
                <select name="emailType" onchange="emailSelect()">
                    <option value="">직접 입력</option>
                    <option value="naver.com">naver.com</option>
                    <option value="gmail.com">gmail.com</option>
                    <option value="daum.net">daum.net</option>
                </select>
            </div>

            <h2 class="enroll-input-title">주소</h2>
            <div id="enroll-address" class="enroll-input-area">
                <input type="text" placeholder="주소 입력(도로명, 지번)">
                <button>주소찾기</button>
            </div>
            <div id="post-detail-address" class="enroll-input-area">
                <input id="post-no" type="text" placeholder="우편번호">
                <input id="detail-address" type="text" placeholder="상세주소 입력">
            </div>
            <div class="enroll-btn">
                <button type="submit" id="enroll-enter">가입</button>
                <button id="enroll-cancel">취소</button>
            </div>
        </form>
    </div>
</body>
</html>