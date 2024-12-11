<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardWrite.css">

    <script src="${pageContext.request.contextPath}/resources/js/community/board.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>



</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div id="space"></div>
    <div class="wrapper">
        <h3>게시글 작성</h3>
        <hr class="board-Write-hr">
        <form id="postForm" class="postForm" action="" method="post" enctype="multipart/form-data">
            <select name="communityNo" id="search-category">
                <option value="" selected disabled hidden>게시판 선택</option>
                <option value="전체">전체</option>
                <option value="1" selected>질문</option>
                <option value="2">팁</option>
                <option value="3">자랑</option>
                <option value="4">홍보</option>
            </select>

            <input type="text" name="boardTitle" id="board-title" placeholder="제목을 입력해주세요">
            <textarea id="content" rows="10" name="content" required></textarea>
            <p id="can-file-types">첨부파일 'png', 'gif', 'jpg', 'jpeg' 파일만 업로드가 가능합니다.</p>
            <div id="att-files">
                <input type="file" class="add-file" name="upfile">
            </div>

            <button id="att-add-btn">첨부파일 추가</button>

            <div id="submit-btn-wrapper">
                <button id="submit-btn" type="submit" onclick="postFormSubmit('insert.bo')">게시글 등록</button>
            </div>
        </form>

        <hr class="board-Write-hr">
    </div>
    

</body>
</html>