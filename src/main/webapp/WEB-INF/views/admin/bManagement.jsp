<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/bManagement.css">
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            게시글 관리
        </div>
        <div class="bContent">
            <table id="top-table">
                <tr>
                    <th class="type">유형</th>
                    <th class="reporter">신고자명</th>
                    <th class="th-title">신고대상</th>
                    <th class="detail">상세 내용</th>
                    <th class="management">관리</th>
                </tr>
            </table>
            <table id="main-table">
                <tr>
                    <th>공지</th>
                    <th>꾸준히 운동</th>
                    <th class="th-title" onclick="location.href='detail.ad?bno=?'">게시글 작성 시 지켜야할 규칙</th>
                    <th><div class="btn custom-btn">확인하기</div></th>
                    <th></th>
                </tr>
            </table>
        </div>
        <div id="searchbar-div">
            <input type="search" name="" id="board-search-bar" placeholder="검색어를 입력해주세요">
            <button id="search-btn" type="submit">
                <img id="searchIcon" src="resources/image/searchIcon.png">
            </button>
        </div>  

        <!-- 페이지 버튼 -->
        <div id="paging-div">
            <button class="page-btn">&lt;</button>
            <button class="page-btn">1</button>
            <button class="page-btn">2</button>
            <button class="page-btn">3</button>
            <button class="page-btn">4</button>
            <button class="page-btn">5</button>
            <button class="page-btn">&gt;</button>
        </div>
    </div>


</body>
</html>