<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/personalPage.css">

<script src="${pageContext.request.contextPath}/resources/js/member/personalPage.js"></script>
</head>
<body>

	<jsp:include page="../commons/modal.jsp" />
    <div class="wrapper">
        <div class="pageName">
            마이페이지 
        </div>
        <div class="content">
            <img src="${pageContext.request.contextPath}/resources/image/3b579a9bc531180d72a68a9686c6da3b.jpg" alt="" class="profile-image" accept=".jpg, .png" onclick="openFile()">
            <input type="file" class="select-profile" onchange="previewProfile(this)">
            <form action="" onclick="showBtn()">
                <div class="namespace">
                    <input type="text" name="memberNickName" id="nameInput" autocomplete="off">
                    <label for="nameInput">
                        <div class="material-symbols-outlined custom-icon">edit_square</div>
                    </label>
                </div>      
                <div class="sub-btn">
                    <button type="submit" class="btn">변경하기</button>
                </div>
            </form>
        </div>
        <div class="bottom-content">
            <table>
                <tr>
                    <td>이메일</td>
                    <td><button class="btn" data-target="email-change" onclick="openModal(event)">이메일 변경</button></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><button class="btn">전화번호 변경</button></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><button class="btn">비밀번호 변경</button></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><button class="btn">주소 변경</button></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="btn">탈퇴</button></td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>