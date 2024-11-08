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
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            공지 등록
        </div>
        <div class="content">
            <form id="write-wrapper" action="" method="post">
                <select name="search-category" id="search-category">
                    <option value="board">게시판</option>
                    <option value="challenge">챌린지</option>
                </select>
                <input type="text" name="boardTitle" id="board-title" placeholder="제목을 입력해주세요">
                
                <textarea id="content" name="boardContent" required></textarea>
            
                <div id="submit-btn-wrapper">
                    <button id="submit-btn" type="submit">게시글 등록</button>
                </div>
            </form>
        </div>
        <!-- 서머노트 js 추가 (헤더에 jQuery가 있어서 아래에 추가함) -->
        <script src="${pageContext.request.contextPath}/resources/js/common/summernote.js"></script>
        </div>
    <script src="${pageContext.request.contextPath}/resources/js/common/summernote.js"></script>
</body>
</html>