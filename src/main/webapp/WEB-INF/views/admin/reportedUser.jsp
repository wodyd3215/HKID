<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/uManagement.css">

</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            신고 유저
        </div>
        <div class="content">
            <table>
                <thead>
                    <tr id="common-table-header">
                        <th data-width="18%">유형</th>
                        <th data-width="24%">신고자명</th>
                        <th data-width="24%">신고 대상</th>
                        <th data-width="24%">상세 내용</th>
                        <th data-width="14%">관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="r" items="${list}">
                        <tr id="common-table-body">
                            <td>${r.typeContent}</td>
                            <td>${r.nickname}</td>
                            <td>${r.reportedNickname}</td>
                            <td>
                                <div class="management">
                                    <button class="btn btn-primary custom-btn" data-target="report-detail" onclick="inputDetailData(['${r.nickname}', '${r.reportedNickname}', '${r.typeContent}', '${r.detailContent}']), openModal(event)">확인하기</button>
                                </div>
                            </td>
                            <td>
                                <div class="management">
                                    <form action="suspensionMember" class="action-stop" method="post">
                                        <!-- <button class="btn btn-danger custom-btn">
                                            정지처분
                                        </button> -->
                                        <input type="hidden" value="${r.reportNo}" name="reportNo">
                                        <input type="hidden" value="${r.reportedMemberNo}" name="memberNo">
                                        <select name="suspension" id="suspension-date">
                                            <option value="7">7일</option>
                                            <option value="15">15일</option>
                                            <option value="30">30일</option>
                                            <option value="365">1년</option>
                                            <option value="0">무기한</option>
                                        </select>
                                        <button type="submit" class="material-symbols-outlined suspension-btn">check</button>
                                    </form>
                                </div> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <jsp:include page="detailModal.jsp" />
        </div>
        <div id="searchbar-div">
            <input type="search" name="" id="board-search-bar" placeholder="검색어를 입력해주세요">
            <button id="search-btn" type="submit">
                <img id="searchIcon" src="resources/image/searchIcon.png">
            </button>
        </div>  

        <!-- 페이지 버튼 -->
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