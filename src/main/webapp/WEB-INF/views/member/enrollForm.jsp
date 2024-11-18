<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/enrollForm.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/enrollForm.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/apis/findAddressAPI.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div>
        <h1>회원가입</h1>
        
        <form action="insert.me" method="post">
            <!-- 아이디 -->
            <div id="idArea">
                <h3 class="enroll-input-title">*아이디&nbsp;</h3>
                <div></div>
            </div>
            <div class="enroll-input-area">
                <input type="text" id="userInputId" name="memberId" placeholder="아이디 입력(특수문자 제외)" onkeyup="checkUserId(this)" required>
                <div id="checkIdBtn" class="all-btn" onclick="enrollIdCheck()" required>중복확인</div>
            </div>
            
            <!-- 비밀번호 -->
            <h3 class="enroll-input-title">*비밀번호</h3>
            <div class="enroll-input-area">
                <input type="password" id="userInputPwd" name="memberPwd" placeholder="비밀번호 입력(4 ~ 12글자)" onkeyup="inputPwdCheck()" minlength="4" maxlength="12" required>
            </div>

            <!-- 비밀번호 확인 -->
            <div id="pwdArea">
                <h3 class="enroll-input-title">*비밀번호 확인&nbsp;</h3>
                <div></div>
            </div>
            <div class="enroll-input-area">
                <input type="password" id="checkPwd" name="checkMemberPwd" placeholder="비밀번호 재입력" onkeyup="inputPwdCheck()" minlength="4" maxlength="12" required>
            </div>

            <!-- 이름 -->
            <h3 class="enroll-input-title">*이름</h3>
            <div class="enroll-input-area">
                <input type="text" name="memberName" placeholder="이름 입력" required>
            </div>

            <!-- 닉네임 -->
            <div id="nickArea">
                <h3 class="enroll-input-title">*닉네임&nbsp;</h3>
                <div></div>
            </div>
            <div class="enroll-input-area">
                <input type="text" name="nickName" placeholder="닉네임 입력(특수문자 제외 / 최대 8글자)" maxlength="8" required>
                <div id="checkNickBtn" class="all-btn" onclick="enrollNickCheck()" required>중복확인</div>
            </div>

            <!-- 전화번호 -->
            <div id="enroll-phone">
                <h3 class="enroll-input-title">*전화번호</h3>
                <div class="enroll-input-area">
                    <input type="text" name="phone" placeholder="휴대폰 번호 입력('-'제외 11자리 입력)" maxlength="11" required>
                    <!-- <div class="all-btn">인증번호 받기</div> -->
                </div>
            </div>
            <!-- 인증번호 -->
            <!-- <div id="enroll-certify">
                <div id="certifyArea">
                    <h3 class="enroll-input-title">*인증번호&nbsp;</h3>
                    <div>인증번호가 일치하지 않습니다.</div>
                </div>
                <div class="enroll-input-area">
                    <input type="text" name="certifyNo" placeholder="인증번호 입력" required>
                    <div class="all-btn">인증</div>
                </div>
            </div> -->

            <!-- 이메일 -->
            <div id="enroll-email-certify">
                <div id="enroll-email">
                    <h3 class="enroll-input-title">*이메일</h3>
                    <div class="enroll-input-area">
                        <input id="email-input1" type="text" name="email" placeholder="이메일 입력" required>
                        <div class="all-btn" id="email-certify">이메일 인증</div>
                    </div>
                </div>
                <div id="enroll-certify">
                    <div id="certifyArea">
                        <h3 class="enroll-input-title">*인증번호&nbsp;</h3>
                        <div>인증번호가 일치하지 않습니다.</div>
                    </div>
                    <div class="enroll-input-area">
                        <input type="text" id="certifyNo" name="certifyNo" placeholder="인증번호 입력" required>
                        <div class="all-btn">인증</div>
                    </div>
                </div>
            </div>

            <!-- 주소 -->
            <h3 class="enroll-input-title">주소</h3>
            <div id="enroll-address" class="enroll-input-area">
                <input type="text" id="input-address" name="address" placeholder="주소 입력(도로명, 지번)">
                <div class="all-btn" onclick="sample6_execDaumPostcode()">주소찾기</div>
            </div>
            <div id="post-detail-address" class="enroll-input-area">
                <input id="post-no" name="postNo" type="text" placeholder="우편번호">
                <input id="detail-address" name="detailAddress" type="text" placeholder="상세주소 입력">
            </div>
            <div class="enroll-btn">
                <button type="submit" id="enroll-enter">가입</button>
                <a href="loginForm.me" id="enroll-cancel">취소</a>
            </div>
        </form>
    </div>
</body>
<!-- 주소찾기 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</html>