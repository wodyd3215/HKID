<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String contextPath = request.getContextPath();
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- include libraries(jQuery, bootstrap) -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js-->
<link href="${pageContext.servletContext.contextPath}/resources/summernote/summernote-bs5.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath}/resources/summernote/summernote-bs5.js"></script>

<!--css-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/header.css?after">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/modal.css">

<script src="${pageContext.request.contextPath}/resources/js/common/default.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/summernote.js"></script>
</head>
<body onload="init('${pageContext.request.contextPath}', '${loginMember.memberNo}', '${pageName}', '${fn:escapeXml(optional)}')">
    <c:if test="${ not empty alertMsg}">
        <script>
            alert("${alertMsg}");
        </script>
        <c:remove var="alertMsg" scope="session"/>
    </c:if> 
    <div class="header">
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img class="icon" src="./resources/img/icon.png" alt="없음"></a>
        </div>
        <div id="navigator">
            <ul id="nav">
                <li class="content">
                    <a href="list.ex">가이드</a>
                </li>
                <li class="content">
                    <a href="diet.ca">식단</a>
                </li>
                <li id="community-drop-bar" class="content">
                    <a href="list.bo">게시판</a>
                    <ul>
                        <li><a href="list.bo">커뮤니티</a></li>
                        <li><a href="ch.m">챌린지</a></li>
                    </ul>
                </li>
                <li id="product-drop-bar" class="content">
                    <a href="product.li">상점</a>
                    <ul>
                        <li><a href="">상품</a></li>
                        <li><a href="">중고</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div id="login-form-btn" class="content">
        <c:choose>
        	<c:when test="${empty loginMember}">
            	<a class="login" href="loginForm.me">로그인</a>
            </c:when>
            <c:otherwise>
                <div id="myPage-btn" onclick="showAndHideElement('.myPage-area')">
                    <button>
                        <c:choose>
                            <c:when test="${loginMember.profileImg eq null}">
                                <img src="${pageContext.request.contextPath}/resources/image/profileImg/guest-icon.png">
                            </c:when>
                            <c:otherwise>
                                <img class="profile-img" src="${pageContext.request.contextPath}${loginMember.profileImg}">
                            </c:otherwise>
                        </c:choose>
                        
                    </button>
                    <div class="myPage-area hide" >
                        <p>${loginMember.nickName}</p>
                        <hr>
                       	<a href="personal.me">개인설정</a>
                        <a href="myDiaryList.me">내 다이어리</a>
                        <hr>
                        <a href="cartlist.li?memberNo=${loginMember.memberNo}">장바구니</a>
                        <a href="favorite.li?memberNo=${loginMember.memberNo}">찜목록</a>
                        <a href="phase.li?memberNo=${loginMember.memberNo}">구매목록</a>
                        <hr>
                        <a href="logout.me" id="logout-btn">로그아웃</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/chatBox.jsp" />
</body>
</html>

<!-- favorite.li -->