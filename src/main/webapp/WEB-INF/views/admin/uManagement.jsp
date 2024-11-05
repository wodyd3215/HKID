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
            유저 관리
        </div>
        <div class="mContent">
            <table id="main-table" class="custom-table">
                <tr>
                    <th>전체</th>
                    <th id="th-title" onclick="location.href='ab'">게시글 작성 시 지켜야할 규칙</th>
                    <th>개떡도지</th>
                    <th>2024-10-10</th>
                    <th>2</th>
                </tr>
            </table> 
        </div>
        <div id="searchbar-div">
            <select name="search-category" id="search-category">전체
                <option value="all">전체</option>
                <option value="question">질문</option>
                <option value="tip">팁</option>
                <option value="show-off">자랑</option>
                <option value="ad">홍보</option>
            </select>
            
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