<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/main/main.css?after">
<link rel="stylesheet" href="./resources/css/default.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/main/main.js"></script>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="wrapper">
			<div class="swiper mySwiper" style="height: 360px; border: 1px solid black; margin-top: 100px; border-radius: 15px;">
				<div class="swiper-wrapper">
				  <div class="swiper-slide">
					<a href="">
						<img src="./resources/img/image.png" alt="없음">
					</a>
				</div>
				  <div class="swiper-slide">Slide 2</div>
				  <div class="swiper-slide">Slide 3</div>
				  <div class="swiper-slide">Slide 4</div>
				  <div class="swiper-slide">Slide 5</div>
				  <div class="swiper-slide">Slide 6</div>
				  <div class="swiper-slide">Slide 7</div>
				  <div class="swiper-slide">Slide 8</div>
				  <div class="swiper-slide">Slide 9</div>
				</div>
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>
				<div class="swiper-pagination"></div>
			  </div>

			<div class="mainContent2">
				<div class="weather">
					<div class="weather-header">
						<p>날씨 정보</p>
						<div class="area-select">
							<select name="area" id="area">
								<option value="">서울</option>
							</select>
						</div>
					</div>
					<div>
						<p>날씨 api</p>
					</div>
				</div>
				<div class="BMI">
					<div class="BMI-header">
						<p>BMI 계산기</p>
					</div>
					<div class="bmi-input">
						<h6>신장</h6>&nbsp;&nbsp;
						<input type="text" id="height">cm&nbsp;  

						/&nbsp;

						<h6>체중</h6>&nbsp;&nbsp;
						<input type="text" id="weight">kg&nbsp; &nbsp; 
						
						<input type="radio" name="gender" id="man" value="man">&nbsp; 
						<label for="man">남자</label>
						&nbsp; &nbsp;
						<input type="radio" name="gender" id="woman" value="woman">&nbsp; 
						<label for="woman">여자</label>
						&nbsp; &nbsp; &nbsp; &nbsp; 


						<button id="btn" style="background-color: green;">계산하기</button>
						&nbsp;
						<button id="btn2" style="background-color: darkgray;">초기화</button>
					</div>
					<div id="result">
						<p>비만도 결과</p>
						<br>
						<p>BMI 지수</p>
					</div>
					<!-- BMI 구간을 표시할 그래프 -->
					<div class="bmi-range">
						<div id="range-section" class="range-section underweight">저체중</div>
						<div id="range-section" class="range-section normal">정상</div>
						<div id="range-section" class="range-section overweight">과체중</div>
						<div id="range-section" class="range-section obese">비만</div>
						<div id="current-bmi" class="current-bmi">BMI</div>
					</div>

					
				</div>

			</div>

			<!-- 기능 미완성으로 인한 예비 링크 -->
			<a href="personal.me">개인페이지 가기</a>
			<br>
			<a href="product.ad">상품페이지</a>
			<br>
			<a href="reportedBoard.ad">게시글 관리</a>
			<a href="chatting.ch">채팅창</a>

			<a href="myDiaryList.me">마이페이지</a>

			<a href="order.in">주문 정보</a>
			<a href="order.cp">주문 완료</a>
		
	</div>
	<jsp:include page="common/footer.jsp" />



</body>
</html>