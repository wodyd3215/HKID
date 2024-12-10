<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/challenge/cboardDetail.css?after">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardDetail.css">
<link rel="stylesheet" href="./resources/css/default.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div class="wrapper">
        <hr>
        <div id="top-wrapper">
            <!-- 게시글 제목칸-->
            <div id="board-title-wrapper">
                <div id="board-title">
                     <p>${c.chaTitle}</p>
                </div>
                <div id="writer-date--update-delete">
                    <div id="writer-date">
                        <div>${c.nickName}</div> &nbsp;&nbsp;&nbsp;
                        <div>${c.chaDate}</div>
                    </div>
                    <div class="btn-div">
                        <!--게시글의 작성자일 경우-->
                        <c:choose>
                            <c:when test="${c.memberNo == m.memberNo}">
                                <a class="btn" href="updateForm.cbo?cbno=${c.challengeBoardNo}">수정</a>
                                <button class="btn" data-target="delete-modal" onclick="openModal(event)">삭제</button>
                            </c:when>
                            <c:otherwise>
                                <a class="btn" href="">&nbsp;&nbsp;</a>
                                <button class="btn">&nbsp;&nbsp;</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>

        <hr>

        <div id="second-div">
            <div id="content" name="boardContent" required>${c.chaContent}</div>
        </div>

        <!------------------ 아래쪽 게시글 목록 -------------------->
        <div id="bottom-wrapper">
            <table id="top-table">
                <tr>
                    <th>
                        <select name="category" class="category-choice">전체
                            <option value="all">전체</option>
                            <option value="question">질문</option>
                            <option value="tip">팁</option>
                            <option value="show-off">자랑</option>
                            <option value="ad">홍보</option>
                        </select>
                    </th>
                    <th id="th-title">제목</th>
                    <th id="writer">작성자</th>
                    <th id="write-date">작성일</th>
                    <th id="view-count">조회수</th>
                </tr>
            </table>
            
            <!-------------- 게시글 목록  ---------------->
            <table id="main-table">
                <tr>
                    <td id="board-category">질문</td>
                    <td><a href="boardDetail.bo">세트별 개수 설정에 대해 질문드립니다 [0]</a></td>
                    <td id="writer2">꾸준히 운동</td>
                    <td id="write-date2">2024-10-10</td>
                    <td class id="view-counts">4</td>
                </tr>
            </table>
            
            
            <!-- 게시글 수 + 글쓰기 버튼 -->
            <div id="boCount-wirte-div">
                <select name="board-bottom-div" class="category-choice">
                    <option value="">5개씩</option>
                    <option value="">10개씩</option>
                    <option value="">15개씩</option>
                </select>

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

    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>