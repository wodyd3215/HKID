<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            공지
        </div>
        <div class="content">
            <table id="common-table">
                <thead>
                    <tr id="common-table-header">
                        <th data-width="8%">게시판</th>
                        <th data-width="50%">제목</th>
                        <th data-width="13%">작성자</th>
                        <th data-width="13%">등록일</th>
                        <th data-width="8%">조회수</th>
                        <th data-width="8%">관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="n" items="${list}">
                        <tr id="common-table-body">
                            <td>${n.noticeTypeName}</td>
                            <td>${n.noticeTitle}</td>
                            <td>${n.nickName}</td>
                            <td>${n.noticeDate}</td>
                            <td>${n.viewCount}</td>
                            <td>
                                <div class="management">
                                    <button class="material-symbols-outlined btn btn-warning custom-btn" onclick="postFormSubmit('edit')">
                                        edit
                                    </button>
                                    <button class="material-symbols-outlined btn btn-danger custom-btn" onclick="postFormSubmit('delete')">
                                        delete
                                    </button>
        
                                    <form action="" method="POST" id="postForm">
                                        <input type="text" hidden name="noticeNo" value="${n.noticeNo}">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="boCount-wirte-div" class="custom-div">
            <a href="nEnroll.ad" class="btn btn-primary custom-btn">공지 등록</a>
        </div>            
        <div id="searchbar-div">
            <input type="search" name="" id="board-search-bar" placeholder="검색어를 입력해주세요">
            <button id="search-btn" type="submit">
                <img id="searchIcon" src="resources/image/searchIcon.png">
            </button>
        </div>  

        <!-- 페이지 버튼 -->
        <div id="paging-div">
            <div id="paging-div">
                <!-- 이전 페이지 버튼 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq 1}">
                        <a class="page-btn disabled startEnd-btn" href=""></a> <!-- 비활성화 -->
                    </c:when>
                    <c:otherwise>
                        <a class="page-btn startEnd-btn" href="notice.ad?cpage=${pi.currentPage - 1}">&nbsp;[이전]</a>
                    </c:otherwise>
                </c:choose>
            
                <!-- 1~5 페이지 -->
                <c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
                    <a class="page-btn ${pi.currentPage ne p ? 'active' : 'nowpage'}" 
                        href="notice.ad?cpage=${p}">
                        ${p}
                    </a>
                </c:forEach>
            
                <!-- 다음 페이지 버튼 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq pi.maxPage}">
                        <a class="page-btn disabled" href=""></a> <!-- 비활성화 -->
                    </c:when>
                    <c:otherwise>
                        <a class="page-btn startEnd-btn" href="notice.ad?cpage=${pi.currentPage + 1}">&nbsp;[다음]</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</body>
</html>