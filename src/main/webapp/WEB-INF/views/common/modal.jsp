<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/enrollForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/PersonalModal.css">

<script src="${pageContext.request.contextPath}/resources/js/member/enrollForm.js"></script> 

<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">

</head>
<body>
    <div class="modal" id="email-change">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">이메일 변경</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">close</button>
            </div>
            <div class="custom-modal-content">
                <form action="changeEmail.me">
                    <div id="enroll-email" class="enroll-input-area">
                        <input id="email-input1" type="text" name="emailId" oninput="totalEmail()" placeholder="이메일 입력(특수문자 제외)" required>
                        <input id="email-input3" type="text" name="@" value="@" readonly>
                        <input id="email-input2" type="text" name="emailAddress" oninput="totalEmail()" placeholder="ex) naver.com" required>
                        <select name="emailType" onchange="emailSelect()">
                            <option value="">직접 입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="gmail.com">gmail.com</option>
                            <option value="daum.net">daum.net</option>
                        </select>
                        <input id="submit-email" type="text" name="email" hidden>
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
                    <div id="enroll-phone-certify">
                        <div id="enroll-phone">
                            <div class="enroll-input-area">
                                <input type="text" name="phone" placeholder="휴대폰 번호 입력('-'제외 11자리 입력)" maxlength="11" required>
                                <button>인증번호 받기</button>
                            </div>
                        </div>
                        <!-- 인증번호 -->
                        <div id="enroll-certify">
                            <!-- <div id="certifyArea">
                                <div>인증번호가 일치하지 않습니다.</div>
                            </div> -->
                            <div class="enroll-input-area">
                                <input type="text" name="certifyNo" placeholder="인증번호 입력" required>
                                <button>인증</button>
                            </div>
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
                <form action="" >
                    <div class="enroll-input-area custom-input-area">
                        <div>
                            <div>현재 비밀번호</div>
                            <div><input type="password" id="currPW" name="currPw" placeholder="현재 비밀번호 입력"></div>
                        </div>
                        <div>
                            <div>새 비밀번호</div>
                            <div><input type="password" id="memberPwd" name="memberPwd" placeholder="새 비밀번호 입력"></div>
                        </div>
                        <div>
                            <div>새 비밀번호 확인</div>
                            <div><input type="password" id="checkmemberPwd" name="checkmemberPwd" placeholder="새 비밀번호 재입력"></div>
                        </div>
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