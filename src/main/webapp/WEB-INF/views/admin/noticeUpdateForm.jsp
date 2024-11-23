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
            공지 수정
        </div>
        <div class="content">
            <form id="write-wrapper" action="updateNotice?noticeNo=${notice.noticeNo}" method="post">
                <input type="text" name="noticeTypeName" id="search-category" value="${notice.noticeTypeName}" readonly>
                <input type="text" name="noticeTitle" id="board-title" placeholder="제목을 입력해주세요" value="${notice.noticeTitle}">
                <textarea id="content" name="noticeContent" required></textarea>
            
                <div id="submit-btn-wrapper">
                    <button id="submit-btn" type="submit">수정 완료</button>
                </div>
            </form>
        </div>
</body>
</html>