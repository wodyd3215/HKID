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
<link rel="stylesheet" href="./resources/css/exercise/exerciseFloat.css?after">
 <!-- Link Swiper's CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
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
					<button type="button" onclick="addToSwiper('${e.exerciseImg}')">
						<img src="./resources/img/buy.png" class="like(this)" onclick="buy()">
					</button>
				</div>
			</div>
		</div>
		<div id="message-container"></div> <!-- 메시지가 표시될 위치 -->

		<div class="flootbox">
			<div>
				<p><img src="./resources/img/buy.png" alt="없음">
					를 눌러 운동을 담아보세요!
				</p>
			</div>
			<!-- Swiper -->
			<div class="slider__prev"></div>
			<div class="swiper mySwiper" style="height: 39rem;width: 15rem;">
			  <ul class="swiper-wrapper">
				
			  </ul>
			</div>
			<div class="slider__next"></div>
		</div>

	</div>	
		<br><br><br>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<script src="./resources/js/exercise/exerciseFloat.js"></script>
</body>
</html>