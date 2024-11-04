<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/modal.css">

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
                    <div>
                        <input type="text" class="input-text" placeholder="이메일 입력(특수문자 제외)">
                        <input type="text" class="atSign" name="" value="@" readonly>
                        <input type="text" class="direct-input">
                        <select name="" id="">
                            <option>gamil.com</option>
                            <option>naver.com</option>
                            <option>직접 입력</option>
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
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <form action="">
                    <div>
                        <input type="text" class="input-text" placeholder="이메일 입력(특수문자 제외)">
                        <input type="text" class="atSign" name="" value="@" readonly>
                        <input type="text" class="direct-input">
                        <select name="" id="">
                            <option>gamil.com</option>
                            <option>naver.com</option>
                            <option>직접 입력</option>
                        </select>
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
                    <div>
                        <input type="text" class="input-text" placeholder="이메일 입력(특수문자 제외)">
                        <input type="text" class="atSign" name="" value="@" readonly>
                        <input type="text" class="direct-input">
                        <select name="" id="">
                            <option>gamil.com</option>
                            <option>naver.com</option>
                            <option>직접 입력</option>
                        </select>
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
                    <div>
                        <input type="text" class="input-text" placeholder="이메일 입력(특수문자 제외)">
                        <input type="text" class="atSign" name="" value="@" readonly>
                        <input type="text" class="direct-input">
                        <select name="" id="">
                            <option>gamil.com</option>
                            <option>naver.com</option>
                            <option>직접 입력</option>
                        </select>
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