<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<script src="${pageContext.request.contextPath}/resources/js/diary/diary.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/member/diaryEnroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/summernote.js"></script>

</head>
<body onload="init('${pageContext.request.contextPath}', '${fn:escapeXml(diary.diaryContent)}')">
    <div class="wrapper">
        <form action="updateDiary.di?diaryNo=${diary.diaryNo}" class="enroll-form" method="POST">
            <div id="diary-title">
                <input type="text" name="diaryTitle" placeholder="제목을 입력하세요" value="${diary.diaryTitle}" required>
            </div>
            <div id="today-ate-cal-info">
                <c:choose>
                    <c:when test="${diary.foodNo != 0}">
                        <table class="food-info-table">
                            <thead>
                                <tr id="food-title">
                                    <th id="food-kcal">칼로리(kcal)</th>
                                    <th id="food-carbo">탄수화물(g)</th>
                                    <th id="food-pro">단백질(g)</th>
                                    <th id="food-fat">지방(g)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr id="food-detail">
                                    <td class="kcal-figure">${diet.totalKcal}</td>
                                    <td class="carbo-figure">${diet.totalCarbo}</td>
                                    <td class="pro-figure">${diet.totalProtein}</td>
                                    <td class="fat-figure">${diet.totalFat}</td>
                                </tr>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <div>저장한 정보가 없습니다.</div>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="edit-area">
                <textarea id="content" name="diaryContent" required></textarea>
            </div> 
            <div id="content-bottom">
                <a href="detailDiary.di?diaryNo=${diary.diaryNo}">나가기</a>
                <button type="submit">저장하기</button>
            </div>
        </form>
    </div>
</body>
</html>