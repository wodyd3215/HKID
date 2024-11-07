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
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="wrapper">
        <br><br>
        <h1>전체</h1>

        <table id="common-table">
            <thead>
                <tr id="common-table-header">
                    <th class="type-width8">
                        <select name="category" class="table-category">전체
                            <option value="all">전체</option>
                            <option value="question">질문</option>
                            <option value="tip">팁</option>
                            <option value="show-off">자랑</option>
                            <option value="ad">홍보</option>
                        </select>
                    </th>
                    <th class="type-width50">제목</th>
                    <th class="type-width6">작성자</th>
                    <th class="type-width18">작성일</th>
                    <th class="type-width8">조회수</th>
                </tr>
            </thead>
            <tbody>
                <tr id="common-table-body">
                    <td>공지</td>
                    <td><a href="">게시글 작성 시 지켜야할 규칙</a></td>
                    <td>꾸준히 운동</td>
                    <td>2024-10-10</td>
                    <td>12</td>
                </tr>
                <tr>
                    <td id="board-category">질문</td>
                    <td><a href="boardDetail.bo">세트별 개수 설정에 대해 질문드립니다</a></td>
                    <td>꾸준히 운동</td>
                    <td>2024-10-10</td>
                    <td>4</td>
                </tr>
            </tbody>
        </table>


        
        
        <!-- 게시글 수 + 글쓰기 버튼 -->
        <div id="boCount-wirte-div">
            <select name="board-bottom-div" class="table-category">
                <option value="">5개씩</option>
                <option value="">10개씩</option>
                <option value="">15개씩</option>
            </select>
            <!-- <form action="boardWrite.bo" method="POST"> -->
            <button id="write-btn" data-target="login-modal" onclick="openModal(event)">글쓰기</button>
            <!-- </form> -->
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


    <%@ include file="/WEB-INF/views/common/footer.jsp" %>"
</body>




 <!-------- 로그인 필요 모달 --------->
 <div class="modal" id="login-modal">
    <div class="custom-modal">
        <div class="custom-modal-header">
            <div class="custom-modal-title"><%= (alert != null) ? alert : "로그인이 필요합니다. 로그인 하시겠습니까?" %></div>
        </div>
        <div class="custom-modal-content">
            <!-- 로그인하러가는  "예" 버튼 -->
             <form action="boardWrite.bo" method="POST">
                <button class="modal-btn" id="yes-btn" onclick="postFormSubmit('delete')">예</button>
             </form>
            <!-- 모달 닫기 -->
            <button class="modal-btn" id="no-btn" onclick="closeModal()">아니오</button>
        </div>
    </div>
</div>
</html>