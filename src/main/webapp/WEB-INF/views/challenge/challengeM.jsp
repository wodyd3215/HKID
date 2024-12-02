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
				<a href="ch.b">
					<div class="listImg">
						<img src="${ c.thumbnail}" alt="">
					</div>
					<div class="under">
						<div class="challengeName">
							<p>${p.challengeTitle}</p>
						</div>
						<div class="challengeStatus">
							<div class="statusContent">
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
	</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>