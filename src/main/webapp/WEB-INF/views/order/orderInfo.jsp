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
	<script src="${pageContext.request.contextPath}/resources/js/order/orderInfo.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="wrapper">
			<div class="orderTitle">
				<p>주문/결제</p>
				<hr>
			</div>

			<br>

			<!-- 구매자 정보 -->
			<form action="order.cp" method="POST">
				<div class="byerInfo-title">
					<p>구매자 정보</p>
				</div>
			
				<div class="byerInfo">
					<table>
						<tbody>
							<c:forEach var="p" items="${phases}">
								<tr>
									<th>이름</th>
									<td><input type="text" readonly name="memberName" value="${p.memberName}"></td>
									<input type="hidden" name="memberNo" value="${p.memberNo}">
									<input type="hidden" name="productNo" value="${p.productNo}">
								</tr>
								<tr>
									<th>이메일</th>
									<td><input type="text" readonly name="email" value="${p.email}"></td>
								</tr>
								<tr>
									<th>연락처</th>
									<td><input type="text" readonly name="phone" value="${p.phone}"></td>
								</tr>
								<tr>
									<th>배송주소</th>
									<td><input type="text" readonly name="address" value="${p.address}"></td>
								</tr>
								<tr>
									<th>배송 요청사항</th>
									<td><input type="text" id="purchase-request" name="request"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
				<br><br><br>
			
				<div class="paymentInfo-title">
					<p>결제 정보</p>
				</div>
			
				<div class="paymentInfo">
					<table>
						<tbody>
							<c:forEach var="p" items="${phases}">
								<tr>
									<th>상품명</th>
									<td><input type="text" id="product-name" name="productName" value="${p.productName}" readonly></td>
								</tr>
								<tr>
									<th>총 상품가격</th>
									<td><input type="text" id="totalProductPrice" name="totalPurchase" value="${p.price}" readonly></td>
								</tr>
								<tr>
									<th>배송비</th>
									<td>3000원</td>
								</tr>
								<tr>
									<th>총 결제금액</th>
									<td><input type="text" id="totalAmount" name="totalAmount" readonly></td>
								</tr>
							</c:forEach>
			
							<tr id="productCountArea">
								<th>상품개수</th>
								<td><input type="text" name="quantity" value="${productCount}" readonly></td>
							</tr>
						</tbody>
					</table>
				</div>
			
				<br><br>
				<div class="pay-btn">
					<button id="kaobtn">결제하기</button>
				</div>
			</form>	
		
		</div>
		<br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>