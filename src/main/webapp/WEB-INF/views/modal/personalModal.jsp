<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/PersonalModal.css">

<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">

</head>
<body>
    <div class="modal" id="password-change">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">비밀번호 변경</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">close</button>
            </div>
            <div class="custom-modal-content">
                <form action="updatePwd.me" method="POST">
                    <div class="enroll-input-area custom-input-area">
                        <div>
                            <div>*현재 비밀번호</div>
                            <div><input type="password" id="currPw" name="currPw" placeholder="현재 비밀번호 입력"></div>
                        </div>
                        <div>
                            <div>*새 비밀번호</div>
                            <div><input type="password" id="memberPwd" name="memberPwd" placeholder="새 비밀번호 입력"></div>
                        </div>
                        <div>
                            <div>*새 비밀번호 확인</div>
                            <div><input type="password" id="checkMemberPwd" name="checkMemberPwd" placeholder="새 비밀번호 재입력"></div>
                        </div>
                    </div>
                    <div class="button-area">
                        <button type="submit" onclick="return checkPwd()">변경하기</button>
                        <button type="reset" onclick="closeModal()">취소하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>

    <div class="modal" id="withdraw">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">회원 탈퇴</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">close</button>
            </div>
            <div class="custom-modal-content">
                <form action="deleteMember.me" method="POST">
                    <div>
                        <h2>경고!: 정말로 탈퇴하시겠습니까?</h2>
                    </div>
                    <div id="checkPwd">
                        <div>*비밀번호 확인</div>
                        <div><input type="password" id="memberPwd" name="memberPwd" placeholder="비밀번호 입력"></div>
                    </div>
                    <div class="button-area">
                        <button type="submit" onclick="return checkPwd()">탈퇴하기</button>
                        <button type="reset" onclick="closeModal()">취소하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</body>
</html>