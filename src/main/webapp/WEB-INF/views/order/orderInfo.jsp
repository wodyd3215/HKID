<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/order/orderInfo.css?after">
<link rel="stylesheet" href="./resources/css/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="wrapper">
			<div class="orderTitle">
				<p>주문/결제</p>
				<hr>
			</div>
		
		
		</div>
		<br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>