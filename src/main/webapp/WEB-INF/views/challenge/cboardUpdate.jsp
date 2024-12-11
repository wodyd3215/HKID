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
            <input type="hidden" name="cno" value="${cno}">

            <input type="text" name="chaTitle" id="board-title" value="${c.chaTitle}" placeholder="제목을 입력해주세요">
            <textarea id="content" rows="10" name="chaContent" required>${c.chaContent}</textarea>
            <p id="can-file-types">첨부파일 'png', 'gif', 'jpg', 'jpeg' 파일만 업로드가 가능합니다.</p>
            <div id="att-files">
                <input type="file" class="add-file" name="reupfile">
            </div>

            <div id="submit-btn-wrapper">
                <button id="submit-btn" type="submit" onclick="postFormSubmit('update.cbo')">게시글 등록</button>
            </div>
        </form>

        <hr class="board-Write-hr">
    </div>
    

</body>
</html>