<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/diet/dietForm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/myDiaryDetail.css">

    <script src="${pageContext.request.contextPath}/resources/js/diary/myDiaryDetail.js"></script>
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="wrapper">
        <div id="diary-title-area">
            <div id="diary-title">${diary.diaryTitle}</div>
            <div id="sub-info-area">
                <div id="sub-info">
                    <div id="writer">${diary.writer}</div>
                    <div id="enroll-date">${diary.createDate}</div>
                </div>
                <div id="btn-area">
                    <button onclick="postFormSubmit('edit', 'updateDiaryForm.di')">수정</button>
                    <button onclick="postFormSubmit('delete', 'delete.di')">삭제</button>
                </div>
            </div>
        </div>
        <div id="my-cal-data-area">
            <div id="today-ate-cal">오늘 섭취한 영양정보~</div>
            <div id="today-ate-cal-info">
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
                            <td class="kcal-figure"></td>
                            <td class="carbo-figure"></td>
                            <td class="pro-figure"></td>
                            <td class="fat-figure"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="diary-content">
            ${diary.diaryContent}
        </div>
    </div>

    <form action="" method="POST" id="postForm">
        <input type="hidden" name="diaryNo" value="${diary.diaryNo}">
    </form>
</body>
</html>