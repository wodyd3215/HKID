<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- include libraries(jQuery, bootstrap) -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js-->
<link href="${pageContext.servletContext.contextPath}/resources/summernote/summernote-bs5.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath}/resources/summernote/summernote-bs5.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/diet/dietForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/diaryEnroll.css">

<script src="${pageContext.request.contextPath}/resources/js/common/default.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/diary/diaryEnroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/diaryEnroll.js"></script>

</head>
<body onload="init('${pageContext.request.contextPath}')" onunload="initUnload()">
    <div class="wrapper">
        <form action="insertDiary.di" class="enroll-form" method="POST">
            <div id="diary-title">
                <input type="text" name="diaryTitle" placeholder="제목을 입력하세요">
            </div>
            <div id="today-ate-cal-info" onclick="loadTodayCal()">
                <div id="not-loaded-status">클릭해서 가져오기</div>
            </div>
            <div class="edit-area">
                <textarea id="content" name="diaryContent"></textarea>
            </div>
            <div id="content-bottom">
                <a href="">나가기</a>
                <button type="submit">저장하기</button>
            </div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/resources/js/common/summernote.js"></script>
</body>
</html>