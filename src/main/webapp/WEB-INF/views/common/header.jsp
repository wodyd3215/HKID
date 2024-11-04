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
<link rel="stylesheet" href="./resources/css/common/header.css?after">
</head>
<body>
    <div class="header">
        <div id="navigator">
            <ul id="nav">
                <li>
                    <a href=""><img class="icon" src="./resources/img/icon.png" alt="없음"></a>
                </li>
                <li class="content">
                    <a href="list.ex">가이드</a>
                </li>
                <li class="content">
                    <a href="">식단</a>
                </li>
                <li class="content">
                    <a href="">커뮤니티</a>
                </li>
                <li class="content">
                    <a href="">상점</a>
                </li>
                <li class="content">
                    <a class="login" href="">로그인</a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>