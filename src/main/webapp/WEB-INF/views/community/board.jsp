<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/communityBoard.css">
</head>
<body>
    <div class="wrapper">
        <h1>전체</h1>

        <!-- <table class="table" style="text-align: center;">
			<thead id="table-head">
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th width="600px">제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="7">존재하는 게시글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="c" items="${list }">
						<tr onclick="clickDetailPage(${c.communityNo})">
							<td>${c.communityNo}</td>
							<td>${c.communityCategory}</td>
							<td>${c.communityTitle}</td>
							<td>${c.nickname}</td>
							<td>${c.communityDate}</td>
							<td>${c.communityView}</td>
							<td>${c.communityGood}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table> -->
<!-- ---------------------------------------------- -->
        <!-- 헤더 대용 테이블  -->
        <table id="top-table">
            <tr>
                <th>
                    <select name="category" class="category-choice">전체
                        <option value="all">전체</option>
                        <option value="question">질문</option>
                        <option value="tip">팁</option>
                        <option value="show-off">자랑</option>
                        <option value="AD">홍보</option>
                    </select>
                </th>
                <th id="th-title">제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
        </table>

        <!-------------- 게시글 목록 테이블 ---------------->
        <table id="main-table">
            <tr>
                <th>공지</th>
                <th id="th-title">게시글 작성 시 지켜야할 규칙</th>
                <th>꾸준히 운동</th>
                <th>2024-10-10</th>
                <th>2</th>
            </tr>
            <tr>
                <td id="board-category">질문</td>
                <td>세트별 개수 설정에 대해 질문드립니다 [0]</td>
                <td>꾸준히 운동</td>
                <td>2024-10-10</td>
                <td>4</td>
            </tr>
        </table>
        
        <!-- 게시글 수 + 글쓰기 버튼 -->
        <div id="boCount-wirte-div">
            <select name="board-bottom-div" class="category-choice">
                <option value="">5개씩</option>
                <option value="">10개씩</option>
                <option value="">15개씩</option>
            </select>
            <button id="write-btn">
                글쓰기
            </button>
        </div>

        <!-- 검색 바 -->
        <div id="searchbar-div">
            <select name="search-category" id="search-category">전체
                <option value="all">전체</option>
                <option value="question">질문</option>
                <option value="tip">팁</option>
                <option value="show-off">자랑</option>
                <option value="ad">홍보</option>
            </select>
            
            <input type="search" name="" id="board-search-bar" placeholder="검색어를 입력해주세요">
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