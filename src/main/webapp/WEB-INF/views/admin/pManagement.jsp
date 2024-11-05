<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/pManagement.css">
    <script src="${pageContext.request.contextPath}/resources/js/admin/pManagement.js"></script>
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            상품관리
        </div>
        <div class="pmContent">
            <table id="top-table">
                <tr>
                    <th>
                        <select name="category" class="category-choice">전체
                            <option value="all">식품</option>
                            <option value="question">의류</option>
                            <option value="tip">기구</option>
                        </select>
                    </th>
                    <th id="th-title">상품명</th>
                    <th>재고</th>
                    <th>등록일</th>
                    <th>관리</th>
                </tr>
            </table>
            <table id="main-table" class="custom-table">
                <tr>
                    <th>식품</th>
                    <th id="th-title">게시글 작성 시 지켜야할 규칙</th>
                    <th>100</th>
                    <th>2024-10-10</th>
                    <th class="managementP">
                        <div>
                            <button class="material-symbols-outlined btn btn-warning custom-btn" onclick="postFormSubmit('edit')">
                                edit
                            </button>
                            <button class="material-symbols-outlined btn btn-danger custom-btn" onclick="postFormSubmit('delete')">
                                delete
                            </button>

                            <form action="" method="POST" id="postForm">
                                <input type="text" hidden name="pno" value="">
                            </form>
                        </div>
                    </th>
                </tr>
            </table>
        </div>
        <div id="boCount-wirte-div" class="custom-div">
            <form action="" method="POST">
                <button id="write-btn">글쓰기</button>
            </form>
        </div>

        <div id="searchbar-div">
            <select name="search-category" id="search-category">전체
                <option value="all">전체</option>
                <option value="question">식품</option>
                <option value="tip">의류</option>
                <option value="show-off">기구</option>

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