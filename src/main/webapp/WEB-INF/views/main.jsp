<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/main/main.css?after">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/default.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/skycons/1396634940/skycons.min.js"></script>


</head>
<body>
	<jsp:include page="common/header.jsp" />

	<!-- 배너 슬라이퍼-->
	<div class="wrapper">
			<div class="swiper mySwiper">
				<div class="swiper-wrapper">
				  <div class="swiper-slide" style="margin-right: 0px !important;">
					<a href="">
						<img src="${pageContext.servletContext.contextPath}/resources/img/4db3c23a64a7de754efc2b2930a35a10.jpg" alt="없음">
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

			<!-- SELECT BOX -->
			<div class="mainContent2">
				<div class="weather">
					<div class="weather-header">
						<p>날씨 정보</p>
						<div class="area-select">
							<!-- <select name="area" id="area" onchange="categoryChange(this)">
								<option value>시/도 선택</option>
								<option value="geranel01">강원</option>
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
							</select> -->
						</div>
					</div>

					<!-- 날시 API 화면 -->
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

				<!-- BMI 계산기 -->
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


						<button id="btn" onclick="calculateBMI()">계산하기</button>
						&nbsp;
						<button id="btn2" onclick="resetFields()">초기화</button>
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

			<!-- 아래쪽 슬라이퍼 -->
		<div class="popular-product">
			<div class="product-title">
				<p class="product-text">인기상품</p>
				<div class="product-link">
					<a href="">자세히보기
						<img src="./resources/img/arrow.png" alt="없음">
					</a>
				</div>
			</div>
			<div class="swiper underSwiper">
				<div class="swiper-wrapper">
				  <div class="swiper-slide">
					<a href="">
						<img src="./resources/img/20241211094256_73141.jpg" alt="없음" id="underImg">
					</a>
				</div>
				  <div class="swiper-slide">
					<a href="">
						<img src="./resources/img/20241212152409_63532.jpg" alt="없음" id="underImg">
					</a>
				  </div>
				  <div class="swiper-slide">
					<a href="">
						<img src="./resources/img/20241212152209_13377.jpg" alt="없음" id="underImg">
					</a>
				  </div>
				  <div class="swiper-slide">
					<a href="">
						<img src="./resources/img/20241211114712_18753.jpg" alt="없음" id="underImg">
					</a>
				  </div>
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
		</div>

		<!-- 공지사항 -->
		<div class="notice">
			<div class="notice-title">
				<p class="notice-head">공지사항</p>
				<div class="notice-link">
					<a href="">자세히보기
						<img src="./resources/img/arrow.png" alt="없음">
					</a>
				</div>
			</div>
			<table>
				<tbody>
					<tr id="common-table-body">
						<td>공지</td>
						<td>
							<a href="">게시글 작성 시 지켜야할 규칙 [필독]
								<img src="./resources/img/file.png" alt="없음">
							</a>
						</td>
						<td>꾸준히 운동</td>
						<td>2024-10-10</td>
						<td>2</td>
					</tr>
					<tr id="common-table-body">
						<td>공지</td>
						<td>
							<a href="">게시글 작성 시 지켜야할 규칙 [필독]</a>
						</td>
						<td>꾸준히 운동</td>
						<td>2024-10-10</td>
						<td>2</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 커뮤니티 -->
		<div class="notice">
			<div class="notice-title">
				<p class="notice-head">커뮤니티</p>
				<div class="notice-link">
					<a href="">자세히보기
						<img src="./resources/img/arrow.png" alt="없음">
					</a>
				</div>
			</div>
			<table>
				<tbody>
					<tr id="community-table-body">
						<td>자랑</td>
						<td>
							<a href="">세트별 개수 설정에 대해 질문드립니다 [0]
								<img src="./resources/img/file.png" alt="없음">
							</a>
						</td>
						<td>꾸준히 운동</td>
						<td>2024-10-10</td>
						<td>16</td>
					</tr>
					<tr id="community-table-body">
						<td>자랑</td>
						<td>
							<a href="">세트별 개수 설정에 대해 질문드립니다 [0]
								<img src="./resources/img/file.png" alt="없음">
							</a>
						</td>
						<td>꾸준히 운동</td>
						<td>2024-10-10</td>
						<td>16</td>
					</tr>
					<tr id="community-table-body">
						<td>자랑</td>
						<td>
							<a href="">세트별 개수 설정에 대해 질문드립니다 [0]
								<img src="./resources/img/file.png" alt="없음">
							</a>
						</td>
						<td>꾸준히 운동</td>
						<td>2024-10-10</td>
						<td>16</td>
					</tr>
				</tbody>
			</table>
		</div>	
	</div>
	<a href="chat.ex">gpt랍니다</a>
	<jsp:include page="common/footer.jsp" />
	<script src="${pageContext.servletContext.contextPath}/resources/js/main/main.js"></script>
</body>
</html>