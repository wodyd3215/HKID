<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<h1>OpenAI 챗봇1</h1>
	    <div>
	        <textarea id="userInput" placeholder="메시지를 입력하세요"></textarea>
	        <button id="sendButton">전송</button>
	    </div>
	    <div id="chatOutput"></div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="./resources/js/common/gpt.js"></script>
</body>
</html>