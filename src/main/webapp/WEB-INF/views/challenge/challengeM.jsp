<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/challenge/challengeM.css?after">
<link rel="stylesheet" href="./resources/css/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="wrapper">
		<div class="challengeTitle">
			<p>챌린지</p>
		</div>
		<div class="challengeContent">
			<c:forEach var="c" items="${list}">
			<div class="chList">
				<a href="ch.b?cno=${c.challengeNo }">
					<div class="listImg">
						<img src="${ c.thumbnail}" alt="">
					</div>
					<div class="under">
						<div class="challengeName">
							<p>[챌린지]${c.challengeTitle}</p>
						</div>
						<div class="challengeStatus">
							<div class="statusContent" data-end-date="${c.endDate}">
								진행중
							</div>
							<div>
								${ c.startDate} ~ ${ c.endDate}
							</div>
						</div>
					</div>
				</a>
			</div>
			</c:forEach>
		</div>
<br>
		<div id="paging-area">
            <c:if test="${pi.currentPage ne 1}">
                <a href="ch.m?cpage=${pi.currentPage - 1}">[이전]</a>
            </c:if>
            <c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}">
            	<a href="ch.m?cpage=${i}">${i}</a>
            </c:forEach>
            <c:if test="${pi.currentPage ne pi.maxPage}">
                <a href="ch.m?cpage=${pi.currentPage + 1}">[다음]</a>
            </c:if>
        </div>
	</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="./resources/js/challenge/challengeM.js"></script>
</body>
</html>