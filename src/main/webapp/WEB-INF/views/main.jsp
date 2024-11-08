<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/main/main.css?after">
<link rel="stylesheet" href="./resources/css/default.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main/main.js"></script>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="wrapper">
		<div class="swiper">
			<!-- Additional required wrapper -->
			<div class="swiper-wrapper">
			  <!-- Slides -->
			  <div class="swiper-slide">
				  <img src="https://via.placeholder.com/200x200" alt="1">
			  </div>
			  <div class="swiper-slide">
				  <img src="https://via.placeholder.com/200x200" alt="1">
			   </div>
			  <div class="swiper-slide">
				  <img src="https://via.placeholder.com/200x200" alt="1">
			  </div>
			  <div class="swiper-slide">
				  <img src="https://via.placeholder.com/200x200" alt="1">
			  </div>  
			</div>
			<!-- If we need navigation buttons -->
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-pagination"></div>

	  </div>

		<!-- 기능 미완성으로 인한 예비 링크 -->
		<a href="personal.me">개인페이지 가기</a>
		<br>
		<a href="product.ad">상품페이지</a>
		<br>
		<a href="reportedBoard.ad">게시글 관리</a>
		<a href="chatting.ch">채팅창</a>

		<a href="myDiary.me">마이페이지</a>

		<a href="order.in">주문 정보</a>
		<a href="order.cp">주문 완료</a>
	</div>
	<jsp:include page="common/footer.jsp" />
</body>
</html>