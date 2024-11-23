<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardWrite.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/nEnroll.css">

    <script src="${pageContext.request.contextPath}/resources/js/admin/nEnroll.js"></script>
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            공지 등록
        </div>
        <div class="content">
            <form id="write-wrapper" action="insertNotice" method="post">
                <select name="noticeType" id="search-category">
                    <option value="1">게시판</option>
                    <option value="2">챌린지</option>
                </select>
                <input type="text" name="noticeTitle" id="board-title" placeholder="제목을 입력해주세요">
                <textarea id="content" name="noticeContent" required></textarea>
            
                <div id="submit-btn-wrapper">
                    <button id="submit-btn" type="submit">게시글 등록</button>
                </div>
            </form>
        </div>
</body>
</html>