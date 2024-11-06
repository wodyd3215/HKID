<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/enrollForm.css">

<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>

</head>
<body>
    <div class="modal" id="email-change">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">이메일 변경</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <form action="">
                    <div id="enroll-email" class="enroll-input-area">
                        <input id="email-input1" type="text" placeholder="이메일 입력(특수문자 제외)">
                        <input id="email-input3" type="text" name="" value="@" readonly>
                        <input id="email-input2" type="text" placeholder="ex) naver.com">
                        <select name="">
                            <option value="">직접 입력</option>
                            <option value="">naver.com</option>
                            <option value="">gmail.com</option>
                            <option value="">daum.net</option>
                        </select>
                    </div>
                    <div class="button-area">
                        <button class="btn custom-btn modal-btn" type="submit">변경하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>

    <div class="modal" id="phone-change">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">전화번호 변경</div>
                <button class="material-symbols-outlined close-btn" onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <form action="">
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
                    <div class="button-area">
                        <button class="btn custom-btn modal-btn" type="submit">변경하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>

    <div class="modal" id="password-change">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">비밀번호 변경</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <form action="">
                    <div class="enroll-input-area">
                        <input type="password" placeholder="비밀번호 재입력">
                    </div>
                    <div class="button-area">
                        <button class="btn custom-btn modal-btn" type="submit">변경하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>

    <div class="modal" id="address-change">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">주소 변경</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <form action="">
                    <div id="enroll-address" class="enroll-input-area">
                        <input type="text" placeholder="주소 입력(도로명, 지번)">
                        <button>주소찾기</button>
                    </div>
                    <div id="post-detail-address" class="enroll-input-area">
                        <input id="post-no" type="text" placeholder="우편번호">
                        <input id="detail-address" type="text" placeholder="상세주소 입력">
                    </div>
                    <div class="button-area">
                        <button class="btn custom-btn modal-btn" type="submit">변경하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>

    <div class="modal" id="withdraw">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">회원 탈퇴</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <form action="">
                    <div>
                        <h2>정말로 탈퇴하시겠습니까?</h2>
                    </div>
                    <div class="button-area">
                        <button class="btn custom-btn modal-btn" type="submit">변경하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</body>
</html>