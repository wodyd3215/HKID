<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/challenge/challengeD.css?after">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardList.css">
<link rel="stylesheet" href="./resources/css/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="wrapper">
		<div class="challengeDtitle">
			<p>푸쉬업 챌린지</p>
		</div>
		<table id="common-table">
			<thead>
				<tr id="common-table-header">
					<th class="type-width"></th>
					<th class="type-width50">제목</th>
                    <th class="type-width6">작성자</th>
                    <th class="type-width18">작성일</th>
                    <th class="type-width8">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${list}">
                <tr class="notice">
                    <td class="board-category">공지</td>
                    <td>
						<a href="boardDetail.bo?bno=${b.boardNo}">${c.challengeTitle}
							<img src="./resources/img/file.png" alt="없음">
						</a>
					</td>
                    <td>꾸준히운동</td>
                    <td>2024-10-22</td>
                    <td>2</td>
                </tr>
                </c:forEach>
			</tbody>
		</table>

		<div id="boCount-wirte-div">
            <!-- 게시글 수  -->
            <form action="list.bo" method="Get">
                <input type="hidden" name="category" value="${category}">
                <input type="hidden" name="listCount" value="${pi.listCount}">
                <input type="hidden" name="cpage" value="${pi.currentPage}">
                <select name="choiceBoardCount" class="table-category" onchange="this.form.submit()">
                    <option value="게시글 수" hidden>글 개수</option>
                    <option value="5">5개씩</option>
                    <option value="10">10개씩</option>
                    <option value="15">15개씩</option>
                </select>
            </form>
            <!-- 글쓰기  -->
            <c:if test="${not empty loginMember}">
        	    <a class="btn" id="write-btn" href="enrollForm.bo">글쓰기</a>
            </c:if> 
        </div>

		<!-------------------------- 검색 바 -------------------------->
        <div id="searchbar-div">
            <form action="searchBoard.bo" id="search-form">
                <!-- 필요 데이터 전송 -->
                <input type="hidden" name="cpage" value="${pi.currentPage}">
                <input type="hidden" name="choiceBoardCount" value="${pi.boardLimit}">
                <input type="hidden" name="category" value="${category}">
                
                <select name="condition" id="search-category" >전체
                    <option value="writer" selected>작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                
                <div id="search-wrapper">
                    <input type="search" name="keyword" id="boardsearch-bar" placeholder="검색어를 입력해주세요">
                    <button id="board-search-btn" type="submit">
                        <img id="searchIcon" src="resources/image/searchIcon.png">
                    </button>
                </div>
            </form>
        </div> 
		
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>