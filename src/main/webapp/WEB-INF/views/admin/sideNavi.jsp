<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/sideNavi.css">

    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="sideNavi">
        <div id="logo">
            <a href="">대충 로고</a>
        </div>
        <div id="nav">
            <ul>
                <li>
                    <a href="">유저관리</a>
                    <ul>
                        <li><a href="">계정복구</a></li>
                    </ul>
                </li>
                <li><a href="">상품관리</a></li>
                <li><a href="">신고관리</a></li>
                <li><a href="">공지</a></li>
            </ul>
        </div>
    </div>
</body>
</html>