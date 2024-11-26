<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/default.css">
<link rel="stylesheet" href="./resources/css/common/exGpt.css?after">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<div class="wrapper">
		<div class="logo-title">
			<img src="./resources/img/icon.png" alt="logo">
		</div>
		<div class="gpt-content">
			<div class="chatting">
				<div id="chatOutput">
					
				</div>
				<div class="user">
					
				</div>
			</div>
		</div>
		<div id="chat-input">
			<textarea id="userInput" placeholder="메시지를 입력하세요"></textarea>
			<button id="sendButton"><img src="./resources/img/enter.png" alt="없음"></button>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="./resources/js/common/gpt.js"></script>
</body>
</html>