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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/modal.css">

<!--js-->
<script src="${pageContext.request.contextPath}/resources/js/common/default.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js-->
<link href="${pageContext.servletContext.contextPath}/resources/summernote/summernote-bs5.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath}/resources/summernote/summernote-bs5.js"></script>

</head>
<body onload="init('${pageName}', '${optional}')">
    <div class="header">
        <div id="navigator">
            <ul id="nav">
                <li>
                    <a href="${pageContext.request.contextPath}"><img class="icon" src="./resources/img/icon.png" alt="없음"></a>
                </li>
                <li class="content">
                    <a href="list.ex">가이드</a>
                </li>
                <li class="content">
                    <a href="diet.ca">식단</a>
                </li>
                <li class="content">
                    <a href="list.bo">커뮤니티</a>
                </li>
                <li class="content">
                    <a href="">상점</a>
                </li>
                <li class="content">
                    <a class="login" href="loginForm.me">로그인</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>