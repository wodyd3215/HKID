<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String alert =(String)session.getAttribute("alertMsg"); %> <!-- alert 받기 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardList.css">
    <script src="${pageContext.request.contextPath}/resources/js/community/boardList.js"></script>
     
</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">   <!--favicon.ico:1 에러 해결용-->
<body onload="defaultCategory('${category}')">
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    
    게시글 = ${list}
    <br><br><br>
    공지 = ${nList}
    <br><br>
    pi = ${pi}
    <br><br>
    listCount = ${pi.listCount}
    <br><br>
    pi.boardLimit = ${pi.boardLimit}
    <br><br>
    category = ${category}


    <div class="wrapper">
        <br><br><br><br><br>
        <c:choose>
            <c:when test="${category != null}"> <!-- 카테고리 정보가 있으면 출력 -->   
                <h1>${category}</h1>
            </c:when>
            <c:otherwise>
                <h1>전체</h1>
            </c:otherwise>
        </c:choose>
        

        <table id="common-table">
            <thead>
                <tr id="common-table-header">
                    <th class="type-width">
                        <form action="categoryList.bo">
                            <select name="category" class="table-category" onchange="this.form.submit()" >전체
                                <option value="전체">전체</option>
                                <option value="질문" >질문</option>
                                <option value="팁">팁</option>
                                <option value="자랑">자랑</option>
                                <option value="홍보">홍보</option>
                            </select>
                        </form>
                    </th>
                    <th class="type-width50">제목</th>
                    <th class="type-width6">작성자</th>
                    <th class="type-width18">작성일</th>
                    <th class="type-width8">조회수</th>
                </tr>
            </thead>
            <tbody>
                <!-- 공지 게시글 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq 1}"> <!-- 현재페이지가 1일 경우 공지 출력 -->   
                        <c:forEach var="n" items="${nList}">
                            <tr id="common-table-body">
                                <td>${n.communityName}</td>
                                <td><a href="">${n.boardName}</a></td>
                                <td>${n.userName}</td>
                                <td>${n.boardDate}</td>
                                <td>${n.boardViewCount}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
                <!-------------- 일반 게시글 --------------->
                <c:forEach var="b" items="${list}">
                    <tr>
                    <td class="board-category">${b.communityName}</td>
                    <td><a href="boardDetail.bo?bno=${b.boardNo}">${b.boardName}</a></td>
                    <td>${b.userName}</td>
                    <td>${b.boardDate}</td>
                    <td>${b.boardViewCount}</td>
                </tr>
                </c:forEach>

            </tbody>
        </table>
        
        
        <div id="boCount-wirte-div">
            <!-- 게시글 수  -->
            <form action="boardCount.bo" method="post">
                <input type="hidden" name="category" value="${category}">
                <input type="hidden" name="listCount" value="${pi.listCount}">
                <input type="hidden" name="currentPage" value="${pi.currentPage}">
                <select name="choiceBoardCount" class="table-category" onchange="this.form.submit()">
                    <option value="게시글 수" hidden>글 개수</option>
                    <option value="5">5개씩</option>
                    <option value="10">10개씩</option>
                    <option value="15">15개씩</option>
                </select>
            </form>
            <!-- 글쓰기  -->
            <button id="write-btn" data-target="login-modal" onclick="openModal(event)">글쓰기</button>
        </div>

        <!-------------------------- 검색 바 -------------------------->
        <div id="searchbar-div">
            <form action="searchBoard.bo" id="search-form">
                <!-- 필요 데이터 전송 -->
                <input type="hidden" name="choiceBoardCount" value="${choiceBoardCount}">
                <input type="hidden" name="currentPage" value="${pi.currentPage}">

                <select name="condition" id="search-category" >전체
                    <option value="writer">작성자</option>
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
        
        <!------------------------ 페이징 처리 ----------------------->
        <div id="paging-div">
            <!-- 이전페이지 버튼 -->
            <c:choose>
                <c:when test="${pi.currentPage eq 1 }"> <!-- 현재 페이지가 1이면 -->
                    <a class="page-btn disabled" href="">&lt;</a> <!-- 비활성화 -->
                </c:when>
                <c:otherwise>
                    <a class="page-btn" href="list.bo?cpage=${pi.currentPage - 1}">&lt;</a>
                </c:otherwise>
            </c:choose>

            <!-- 1~5 페이지 -->
             <c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
                    <!-- 현재페이지가 아닐 경우 active 클래스 추가(회색) -->
                    <a class="page-btn ${pi.currentPage != p ? 'active' : ''}" href="list.bo?cpage=${p}">${p}</a> <!-- 현재 페이지 검정색 -->
             </c:forEach>
             <c:choose>
                <c:when test="${pi.currentPage eq pi.maxPage }"> <!-- 현재 페이지가 마지막 페이지라면 -->
                    <a class="page-btn disabled" href="">&gt;</a> <!-- 비활성화 -->
                </c:when>
                <c:otherwise>
                    <a class="page-btn" href="list.bo?cpage=${pi.currentPage + 1}">&gt;</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <%@ include file="/WEB-INF/views/common/footer.jsp" %>"
</body>




 <!-------- 로그인 필요 모달 --------->
 <div class="modal" id="login-modal">
    <div class="custom-modal">
        <div class="custom-modal-header">
            <div class="custom-modal-title"><%= (alert != null) ? alert : "로그인 인터페이스 주석처리 중" %></div>
        </div>
        <div class="custom-modal-content">
            <!-- 로그인하러가는  "예" 버튼 -->
             <form action="boardWrite.bo" method="GET">
                <button class="modal-btn" id="yes-btn" onclick="postFormSubmit('delete')">로그인</button>
             </form>
            <!-- 모달 닫기 -->
            <button class="modal-btn" id="no-btn" onclick="closeModal()">닫기</button>
        </div>
    </div>
</div>

</html>