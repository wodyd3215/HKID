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
		<div class="wrapper">
			<div class="exerTitle">
				<p>풀업</p>
			</div>
			<br><br>
			<div class="under-area">
				<p>#등</p>
				<div class="exerDiffy">
					<p>난이도</p>
					<p>쉬움</p>
				</div>
			</div>
			<div class="detailContent">
				<img src="./resources/image/exerciseImages/BB_DL.gif" alt="없음">
			</div>
			<div class="detailMainContent">
				<p>자세는 이렇게 하세요</p>
				<div id="long-text">
					<ol>
						<li>이 운동은 복잡한 동작으로, 적절한 지도가 가능한 트레이너와 상담하는 것을 추천합니다.</li>
						<li>시작 자세: 양발을 골반보다 약간 넓게 벌리고, 바벨의 그립을 어깨보다 조금 넓게하여 무릎과 팔이 겹치지 않도록 합니다.</li>
						<li>무릎 높이까지 끌기: 팔을 곧게 편 상태로, 중심을 잃지 않게 무릎 높이까지 바벨을 끌어 올립니다.</li>
						<li>몸통 펴고 잡아 채기: 지면의 수직 방향으로 발목, 무릎, 고관절을 강하고 빠르게 신전하여, 바벨을 던지듯이 추켜올립니다.</li>
						<li>앉아 받고 일어서기: 바벨을 위로 던진 상태에서 아래로 내려가 바벨을 앉아서 받고, 신체 균형을 유지하면서 일어섭니다.</li>
						<li>저크: 무릎을 굽히고 일어나는 반동으로 빠르게 바벨을 위로 올려줍니다. 바벨을 받고 굽혔던 모든 관절을 펴서 자세를 유지한 뒤, 바벨을 바닥에 내려놓습니다.</li>
					</ol>
				</div>
				<div id="exerIcon">
					<button type="button">
						<img src="./resources/img/buy.png">
					</button>
				</div>
			</div>
		</div>
		<br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>