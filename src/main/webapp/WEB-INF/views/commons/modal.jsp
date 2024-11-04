<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons/modal.css">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=disabled_by_default,edit_square" />
<script src="${pageContext.request.contextPath}/resources/js/commons/modal.js"></script>

</head>
<body>
    <!-- 
        id: data-set으로 id를 전달받아 해당 팝업창을 열어줌
        팝업창을 띄울 필요가 있는 요소에 data-target="요소 id"를 작성해주면 됨
        ex) <button class="btn" data-target="test-modal" onclick="openModal(event)"></button>
    -->
    <div class="modal" id="test-modal">
        <!-- 실제 모달창은 이곳에 작성 -->
        <div class="modal-test">
            <div class="modal-header">
                <!-- X 버튼 필요없다면 closeModal()을 닫음 버튼에 적용-->
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
        </div>
    </div>

    <div class="modal" id="email-change">
        <div class="email-change">
            <div class="modal-header">
                <div class="modal-title">이메일변경</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="modal-content">
                <form action="">
                    <div>
                        <input type="text" placeholder="이메일 입력(특수문자 제외)">
                        <input type="text" name="" value="@" readonly>
                        <input type="text" class="direct-input">
                        <select name="" id="">
                            <option>gamil.com</option>
                            <option>naver.com</option>
                            <option>직접 입력</option>
                        </select>
                    </div>
                    <div>
                        <button class="btn" type="submit">변경하기</button>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</body>
</html>