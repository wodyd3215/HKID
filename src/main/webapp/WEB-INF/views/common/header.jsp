<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--css-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/header.css?after">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">

<!-- include libraries(jQuery, bootstrap) -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
    <div class="header">
        <div id="navigator">
            <ul id="nav">
                <li>
                    <a href="${pageContext.request.contextPath}"><img class="icon" src="./resources/img/icon.png" alt="없음"></a>
                </li>
                <li class="content">
                    <a href="">가이드</a>
                </li>
                <li class="content">
                    <a href="">식단</a>
                </li>
                <li class="content">
                    <a href="list.bo">커뮤니티</a>
                </li>
                <li class="content">
                    <a href="">상점</a>
                </li>
                <li class="content">
                    <a class="login" href="loginView.me">로그인</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>