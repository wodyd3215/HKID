<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/challenge.css">

    <script src="${pageContext.request.contextPath}/resources/js/admin/cManagement.js"></script>
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            챌린지 관리
        </div>
        <div class="content">
            <table id="common-table">
                <thead>
                    <tr id="common-table-header">
                        <th class="thumbnail">썸네일</th>
                        <th class="chall-name">챌린지 명</th>
                        <th class="start-date">시작일</th>
                        <th class="end-date">종료일</th>
                        <th class="btn-area"></th>
                    </tr>
                </thead>
                <tbody>
                    <!-- <tr class="common-table-body">
                        <td><img src="${pageContext.request.contextPath}/resources/image/diary/20241119113231_59012.webp" alt=""></td>
                        <td>팔굽혀펴기 챌린지</td>
                        <td>2024-12-09</td>
                        <td>2025-02-09</td>
                        <td><button class="material-symbols-outlined btn btn-primary custom-btn single-btn" onclick="addFormChallenge()">add</button></td>
                    </tr> -->
                    <c:forEach var="c" items="${list}" varStatus="status">
                        <tr class="common-table-body">
                            <td><img src="${pageContext.request.contextPath}${c.thumbnail}" alt=""></td>
                            <td>${c.challengeTitle}</td>
                            <td>${c.startDate}</td>
                            <td>${c.endDate}</td>
                            <c:choose>
                                <c:when test="${status.index == 0}">
                                    <td><button class="material-symbols-outlined btn btn-primary custom-btn single-btn" onclick="addFormChallenge()">add</button></td>
                                </c:when>
                                <c:otherwise>
                                    <td></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- 페이지 버튼 -->
        <div id="paging-div">
            <div id="paging-div">
                <!-- 이전 페이지 버튼 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq 1}">
                        <a class="page-btn disabled startEnd-btn" href=""></a> <!-- 비활성화 -->
                    </c:when>
                    <c:otherwise>
                        <a class="page-btn startEnd-btn" href="challenges?cpage=${pi.currentPage - 1}">&nbsp;[이전]</a>
                    </c:otherwise>
                </c:choose>
            
                <!-- 1~5 페이지 -->
                <c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
                    <a class="page-btn ${pi.currentPage ne p ? 'active' : 'nowpage'}" 
                        href="challenges?cpage=${p}">
                        ${p}
                    </a>
                </c:forEach>
            
                <!-- 다음 페이지 버튼 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq pi.maxPage}">
                        <a class="page-btn disabled" href=""></a> <!-- 비활성화 -->
                    </c:when>
                    <c:otherwise>
                        <a class="page-btn startEnd-btn" href="challenges?cpage=${pi.currentPage + 1}">&nbsp;[다음]</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</body>
</html>