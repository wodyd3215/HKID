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
            상품관리
        </div>
        <div class="content">
            <table id="common-table">
                <thead>
                    <tr id="common-table-header">
                        <th class="type-width8">유형</th>
                        <th class="type-width50">상품명</th>
                        <th class="type-width6">재고</th>
                        <th class="type-width12">등록일</th>
                        <th class="type-width6">상태</th>
                        <th class="type-width8">관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${list}">
                        <tr id="common-table-body">
                            <td>${p.productNo}</td>
                            <td>${p.productName}</td>
                            <td>${p.quantity}</td>
                            <td>${p.registrationDate}</td>
                            <c:choose>
                                <c:when test="${p.status eq 'Y'}">
                                    <td>활성</td>
                                </c:when>
                                <c:otherwise>
                                    <td>비활성</td>
                                </c:otherwise>
                            </c:choose>
                            <td>
                                <div class="management">
                                    <button class="material-symbols-outlined btn btn-warning custom-btn" onclick="postFormSubmit('update', 'editProduct')">
                                        edit
                                    </button>
                                    <button class="material-symbols-outlined btn btn-danger custom-btn" onclick="postFormSubmit('delete', 'deleteProduct')">
                                        delete
                                    </button>
        
                                    <form action="" method="POST" id="postForm">
                                        <input type="hidden" name="productNo" value="${p.productNo}">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div id="boCount-wirte-div" class="custom-div">
                <a href="pEnroll.ad" class="btn btn-primary custom-btn">상품 등록</a>
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
            <div id="paging-div">
                <!-- 이전 페이지 버튼 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq 1}">
                        <a class="page-btn disabled startEnd-btn" href=""></a> <!-- 비활성화 -->
                    </c:when>
                    <c:otherwise>
                        <a class="page-btn startEnd-btn" href="product.ad?cpage=${pi.currentPage - 1}">&nbsp;[이전]</a>
                    </c:otherwise>
                </c:choose>
            
                <!-- 1~5 페이지 -->
                <c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
                    <a class="page-btn ${pi.currentPage ne p ? 'active' : 'nowpage'}" 
                        href="product.ad?cpage=${p}">
                        ${p}
                    </a>
                </c:forEach>
            
                <!-- 다음 페이지 버튼 -->
                <c:choose>
                    <c:when test="${pi.currentPage eq pi.maxPage}">
                        <a class="page-btn disabled" href=""></a> <!-- 비활성화 -->
                    </c:when>
                    <c:otherwise>
                        <a class="page-btn startEnd-btn" href="product.ad?cpage=${pi.currentPage + 1}">&nbsp;[다음]</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</body>
</html>