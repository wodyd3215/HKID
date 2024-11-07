<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<div class="wrapper">
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