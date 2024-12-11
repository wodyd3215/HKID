<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardUpdate.css">
    
    <script src="${pageContext.request.contextPath}/resources/js/community/board.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/community/boardUpdate.js"></script>
    HKID/src/main/webapp/WEB-INF/views/community
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div id="space"></div>
    <div class="wrapper">
        <h3>게시글 수정</h3>
        <hr class="board-Write-hr">
        <form id="postForm" class="postForm" action="" method="post" enctype="multipart/form-data">
            <input type="hidden" name="boardNo" value="${b.boardNo}">
            <select name="communityNo" id="search-category" onchange="btnDisable()" required>
                <option value="" selected disabled hidden>게시판 선택</option>
                <option value="1">질문</option>
                <option value="2">팁</option>
                <option value="3">자랑</option>
                <option value="4">홍보</option>
            </select>

            <input type="text" name="boardTitle" id="board-title" value="${b.boardTitle}" onchange="btnDisable()" placeholder="제목을 입력해주세요">
            <textarea id="content" rows="10" name="content" onchange="btnDisable()" required>${b.content}</textarea>
            <p id="can-file-types">첨부파일 'png', 'gif', 'jpg', 'jpeg' 파일만 업로드가 가능합니다.</p>
            <div id="att-files">
                <input type="file" class="add-file" name="reupfile">
            </div>

            <button id="att-add-btn">첨부파일 추가</button>

            <div id="submit-btn-wrapper">
                <button id="submit-btn" type="submit" onclick="postFormSubmit('update.bo')">게시글 등록</button>
            </div>
        </form>

        <hr class="board-Write-hr">
    </div>
    

</body>
</html>