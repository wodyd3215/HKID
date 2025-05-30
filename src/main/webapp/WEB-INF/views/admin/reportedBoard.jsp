<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/bManagement.css">
</head>
<body>
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
                    <c:forEach var="r" items="${list}">
                        <tr id="common-table-body">
                            <td>${r.typeContent}</td>
                            <td>${r.nickname}</td>
                            <td data-target="content-detail" onclick="loadContent('${r.boardNo}'), openModal(event)">${r.boardTitle}</td>
                            <td>
                                <div class="management">
                                    <button class="btn btn-primary custom-btn" data-target="report-detail" onclick="inputDetailData(['${r.nickname}', '${r.boardTitle}', '${r.typeContent}', '${r.detailContent}']), openModal(event)">확인하기</button>
                                </div>
                            </td>
                            <td>
                                <div class="management">
                                    <form action="deleteReportB?boardNo=${r.boardNo}" method="post">
                                        <button class="material-symbols-outlined btn btn-danger custom-btn">
                                            delete
                                        </button>
                                    </form>
                                </div> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <jsp:include page="detailModal.jsp" />
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