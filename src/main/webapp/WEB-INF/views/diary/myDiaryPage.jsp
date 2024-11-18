<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/myDiaryPage.css">
    <script src="${pageContext.request.contextPath}/resources/js/diary/myDiaryPage.js"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="wrapper">
        <!-- <div id="side-navi">
            <div id="side-title">태그 목록</div>
            <div id="title-list">
                <div>나의 일기</div>
            </div>
        </div> -->
        <div id="content-area">
            <div id="btn-area"><a href="diaryEnroll.me" class="btn btn-primary custom-btn">글쓰기</a></div>
            <div class="list-area">
            </div>
        </div>
    </div>
</body>
</html>