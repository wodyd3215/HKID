<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
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
			<p>${c.challengeTitle}</p>
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
                <!-- 공지 게시글 -->
                <c:if test="${pi.currentPage == 1}">
                    <c:forEach var="n" items="${nList}" varStatus="status">
                        <tr class="notice">
                            <td class="board-category">공지</td>
                            <td><a href="noticeDetail.bo?noticeNo=${n.noticeNo}">${n.noticeTitle}<img src="./resources/img/file.png" alt="없음"></a>
                            </td>
                            <td>${n.nickName}</td>
                            <td>${n.noticeDate}</td>
                            <td>${n.viewCount}</td>
                        </tr>
                    </c:forEach>
                </c:if>
				<c:forEach var="c" items="${list}" varStatus="status">
                <tr class="">
                    <td class="board-category">${status.index + 1}</td>
                    <td>
						<a href="cboardDetail.bo?cbno=${c.challengeBoardNo}">${c.chaTitle}
							<img src="./resources/img/file.png" alt="없음">
						</a>
					</td>
                    <td>${c.nickName}</td>
                    <td>${c.chaDate}</td>
                    <td>${c.commentCount}</td>
                </tr>
                </c:forEach>
			</tbody>
		</table>

		<div id="boCount-wirte-div">
            <!-- 게시글 수  -->
            <form action="ch.b" method="Get">
                <input type="hidden" name="cno" value="${cno}"> <!-- cno 추가 -->
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
        	    <a class="btn" id="write-btn" href="cenrollForm.bo?cno=${cno}">글쓰기</a>
            </c:if> 
        </div>

		<!-------------------------- 검색 바 -------------------------->
        <div id="searchbar-div">
            <form action="searchBoard.ch" id="search-form">
                <!-- 필요 데이터 전송 -->
                <input type="hidden" name="cno" value="${cno}">
                <input type="hidden" name="cpage" value="${pi.currentPage}">
                <input type="hidden" name="choiceBoardCount" value="${pi.boardLimit}">
                
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