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
    <!-- 테이블 구조 및 css 전면 교체 못하면 나 죽어버려 -->
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            신고 게시글
        </div>
        <div class="content">
            <table>
                <thead>
                    <tr id="common-table-header">
                        <th class="type-width8">유형</th>
                        <th class="type-width18">신고자명</th>
                        <th class="type-width50">신고대상</th>
                        <th class="type-width18">상세 내용</th>
                        <th class="type-width6">관리</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="common-table-body">
                        <td>욕설</td>
                        <td>개떡도지</td>
                        <td>게시글 작성 시 지켜야할 규칙</td>
                        <td>
                            <div class="management">
                                <button class="btn btn-primary custom-btn" data-target="reportDetail">확인하기</button>
                            </div>
                        </td>
                        <td>
                            <div class="management">
                                <form action="">
                                    <input type="text" name="bno" value="" hidden>
                                    <button class="material-symbols-outlined btn btn-danger custom-btn" >
                                        delete
                                    </button>
                                </form>
                            </div> 
                        </td>
                    </tr>
                </tbody>
            </table>
            <jsp:include page="detailModal.jsp" />
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