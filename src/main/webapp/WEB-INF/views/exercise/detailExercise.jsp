<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/default.css">
<link rel="stylesheet" href="./resources/css/exercise/detailExercise.css?after">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div id="container">
		<div class="wrapper">
			<div class="exerTitle">
				<p>${e.exerciseName}</p>
			</div>
			<br><br>
			<div class="under-area">
				<p>#${e.partName }</p>
				<div class="exerDiffy">
				<c:choose>
					<c:when test="${e.exerciseDifficulty == '쉬움'}">
        					<p style="color: #21D97D;">난이도 ${e.exerciseDifficulty}</p>
    					</c:when>
    					<c:when test="${e.exerciseDifficulty == '보통'}">
        					<p style="color: #EADDC9;">난이도 ${e.exerciseDifficulty}</p>
    					</c:when>
    					<c:when test="${e.exerciseDifficulty == '어려움'}">
       						<p style="color: #EB3616;">난이도 ${e.exerciseDifficulty}</p>
    					</c:when>
					</c:choose>
				</div>
			</div>
			<div class="detailContent">
				<img src="./resources/image/exerciseImages/${ e.exerciseImg}" alt="없음">
			</div>
			<div class="detailMainContent">
				<p>자세는 이렇게 하세요</p>
				<div id="long-text">
					<ol>
						<c:forEach var="desc" items="${descriptionList}">
					        <li>${desc}</li>
					    </c:forEach>
					</ol>
				</div>
				<div id="exerIcon">
					<button type="button">
						<img src="./resources/img/buy.png">
					</button>
				</div>
			</div>
		</div>

		<div class="flootbox">
			<div class="flootbox-title">
				My 루틴
			</div>
			<div class="flootbox-content">
				<button type="button" id="upbtn"></button>
				<div class="buyContent">
					<div class="rutinContent">
						<img src="./resources/image/exerciseImages/45_SIDE_BEND.gif" alt="없음">
					</div>
					<div class="rutinContent">
						<img src="./resources/image/exerciseImages/45_SIDE_BEND.gif" alt="없음">
					</div>
					<div class="rutinContent">
						<img src="./resources/image/exerciseImages/45_SIDE_BEND.gif" alt="없음">
					</div>
				</div>
				<button type="button" id="downbtn"></button>
			</div>
		</div>

	</div>	
		<br><br><br>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>