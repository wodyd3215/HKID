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
<script src="https://cdnjs.cloudflare.com/ajax/libs/skycons/1396634940/skycons.min.js"></script>

</head>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="wrapper">
			<div class="swiper mySwiper">
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
							<select name="area" id="area" onchange="categoryChange(this)">
								<option value>시/도 선택</option>
								<option value="general01">강원</option>
								<option value="general02">경기</option>
								<option value="general03">경남</option>
								<option value="general04">경북</option>
								<option value="general05">광주</option>
								<option value="general06">대구</option>
								<option value="general07">대전</option>
								<option value="general08">부산</option>
								<option value="general09">서울</option>
								<option value="general10">울산</option>
								<option value="general11">인천</option>
								<option value="general12">전남</option>
								<option value="general13">전북</option>
								<option value="general14">제주</option>
								<option value="general15">충남</option>
								<option value="general16">충북</option>
							</select>
							<select name="location" id="state">
								<option>군/구 선택</option>
							</select>
						</div>
					</div>
					<div id="dayNight" class="container day">
						<div class="top">
							<p id="location">서울, 강서구</p>
							<p id="time"></p>
						</div>
						<div class="middle">
							<div class="main_icon">
								<canvas id="mainIcon" width="72" height="72">
							</div>
							<p id="temperature"></p>
							<p id="WeatherInfo">맑음</p>
						  </div>
						  <div class="bottom">
							<div class="weather1">
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="M32 192h320c52.94 0 96-43.06 96-96s-43.06-96-96-96h-32c-17.69 0-32 14.31-32 32s14.31 32 32 32h32c17.66 0 32 14.34 32 32s-14.34 32-32 32H32C14.31 128 0 142.3 0 160S14.31 192 32 192zM160 320H32c-17.69 0-32 14.31-32 32s14.31 32 32 32h128c17.66 0 32 14.34 32 32s-14.34 32-32 32H128c-17.69 0-32 14.31-32 32s14.31 32 32 32h32c52.94 0 96-43.06 96-96S212.9 320 160 320zM416 224H32C14.31 224 0 238.3 0 256s14.31 32 32 32h384c17.66 0 32 14.34 32 32s-14.34 32-32 32h-32c-17.69 0-32 14.31-32 32s14.31 32 32 32h32c52.94 0 96-43.06 96-96S468.9 224 416 224z"/></svg>
								<p>바람</p>
								<p id="wind">sadsad</p>
							</div>
							<div class="weather1"> 
								<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"><path d="M16 319.1C16 245.9 118.3 89.43 166.9 19.3C179.2 1.585 204.8 1.585 217.1 19.3C265.7 89.43 368 245.9 368 319.1C368 417.2 289.2 496 192 496C94.8 496 16 417.2 16 319.1zM112 319.1C112 311.2 104.8 303.1 96 303.1C87.16 303.1 80 311.2 80 319.1C80 381.9 130.1 432 192 432C200.8 432 208 424.8 208 416C208 407.2 200.8 400 192 400C147.8 400 112 364.2 112 319.1z"/></svg>
								<p>습도</p>
        						<p id="humidity">dsdasd</p>
							</div>
						  </div>
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


						<button id="btn">계산하기</button>
						&nbsp;
						<button id="btn2">초기화</button>
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

			<a href="myDiary.me">마이페이지</a>

			<a href="order.in">주문 정보</a>
			<a href="order.cp">주문 완료</a>
		
	</div>
	<jsp:include page="common/footer.jsp" />


<script src="./resources/js/main/main.js"></script>
</body>
</html>