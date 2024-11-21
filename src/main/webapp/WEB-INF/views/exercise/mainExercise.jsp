<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/exercise/mainExercise.css?after">
<link rel="stylesheet" href="./resources/css/default.css">
<link rel="stylesheet" href="./resources/css/exercise/exerciseFloat.css?after">
 <!-- Link Swiper's CSS -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div id="container">
		<div class="wrapper">
			<div class="exerTitle">
				<p>운동 라이브러리</p>
			</div>
			<div id="exerSearch-form">
				<form id="searchForm" action="exercise.se" method="get">
					<table>
						<tr>
							<th><p>부위별 선택</p></th>
							<td>
								<div class="part">
									<input type="checkbox" name="part" id="chest" value="가슴">
									<label for="chest">#가슴</label>

									<input type="checkbox" name="part" id="back" value="등">
									<label for="back">#등</label>

									<input type="checkbox" name="part" id="abs" value="복근">
									<label for="abs">#복근</label>

									<input type="checkbox" name="part" id="shoulder" value="어깨">
									<label for="shoulder">#어깨</label>

									<input type="checkbox" name="part" id="arm" value="팔">
									<label for="arm">#팔</label>

									<input type="checkbox" name="part" id="leg" value="하체">
									<label for="leg">#하체</label>
								</div>
							</td>
						</tr>

						<tr>
							<th><p>난이도 선택</p></th>
							<td>
								<div class="difficulty">
									<input type="checkbox" name="difficulty" id="hard" value="어려움">
									<label for="hard">어려움</label>

									<input type="checkbox" name="difficulty" id="middle" value="보통">
									<label for="middle">보통</label>

									<input type="checkbox" name="difficulty" id="easy" value="쉬움">
									<label for="easy">쉬움</label>
								</div>
							</td>
						</tr>
					</table>
			
					<div class="exerContent">
						<p class="exerTitle2">운동 리스트</p>
						<div>
							<input type="text" name="keyword" value="${ keyword}" placeholder="검색어를 입력해주세요.">
							<input type="submit" value="검색">
						</div>
					</div>
				</form>
			</div>
			<div class="content-box">
				<div class="list-box">
				<c:forEach var="e" items="${list}">
						<div id="list-con">
							<div id="list-img">
								<a href="exercise.de?eno=${e.exerciseNo }">
									<img src="./resources/image/exerciseImages/${ e.exerciseImg}">
								</a>
							</div>
							<br>
							<p class="list-text">${e.exerciseName}</p>
							<br>
							<div id="under-area">
								<p class="list-text2">${e.exerciseDifficulty}</p>
								<button type="button" onclick="addToSwiper('${e.exerciseImg}')">
									<img src="./resources/img/buy.png" class="like(this)" onclick="buy()">
								</button>
							</div>
						</div>
						<div id="message-container"></div> <!-- 메시지가 표시될 위치 -->
					</c:forEach>
					</div>
					
					

					<div id="paging-area">
						<c:choose>
							<c:when test="${pi.currentPage > 1}">
								<c:choose>
									<c:when test="${empty part and empty difficulty and empty keyword}">
										<a href="list.ex?cpage=${pi.currentPage - 5 > 1 ? pi.currentPage - 5 : 1}">&lt;</a>
									</c:when>
									<c:otherwise>
										<a href="exercise.se?cpage=${pi.currentPage - 5 > 1 ? pi.currentPage - 5 : 1}&part=${part}&difficulty=${difficulty}&keyword=${keyword}">&lt;</a>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>

						<c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}">
							
							<c:choose>
								<c:when test="${empty part and empty difficulty and empty keyword}">
									<a href="list.ex?cpage=${i}"
									class="paging-link ${i == pi.currentPage ? 'active' : ''}">${i}</a>
								</c:when>
								
								<c:otherwise>
									<a href="exercise.se?cpage=${i}&part=${part}&difficulty=${difficulty}&keyword=${keyword}"
									class="paging-link ${i == pi.currentPage ? 'active' : ''}">${i}</a>
								</c:otherwise>
							</c:choose>
							
						</c:forEach>

						<c:choose>
							<c:when test="${pi.currentPage < pi.maxPage}">
								<c:choose>
									<c:when test="${empty part and empty difficulty and empty keyword}">
										<a href="list.ex?cpage=${pi.currentPage + 5 < pi.maxPage ? pi.currentPage + 5 : pi.maxPage}">&gt;</a>
									</c:when>
									
									<c:otherwise>
										<a href="exercise.se?cpage=${pi.currentPage + 5 < pi.maxPage ? pi.currentPage + 5 : pi.maxPage}&part=${part}&difficulty=${difficulty}&keyword=${keyword}">&gt;</a>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose>
        			</div>
        <br><br>
    		</div>
		</div>

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
	<script src="./resources/js/exercise/mainExercise.js"></script>
	<script src="./resources/js/exercise/exerciseFloat.js"></script>
</body>
</html>