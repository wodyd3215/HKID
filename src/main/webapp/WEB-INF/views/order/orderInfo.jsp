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

			<br>

			<!-- 구매자 정보 -->
			<form action="phaseInfo.li" method="GET">
				<div class="byerInfo-title">
					<p>구매자 정보</p>
				</div>

				<div class="byerInfo">
					<table>
						<tbody>
							<tr>
								<th>이름</th>
								<td><input type="text" readonly name="userName" value="${p.name}"></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="text" readonly name="userEmail" value="${p.email}"></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td><input type="text" readonly name="userPhone" value="${p.phone}"></td>
							</tr>
							<tr>
								<th>배송주소</th>
								<td><input type="text" readonly name="userAddress" value="${p.address}"></td>
							</tr>
							<tr>
								<th>배송 요청사항</th>
								<td>배송 전 문자 바랍니다.</td>
							</tr>
						</tbody>
					</table>
				</div>

				<br><br><br>

				<!-- 금액 -->
				<div class="paymentInfo-title">
					<p>결제 정보</p>
				</div>

				<div class="paymentInfo">
					<table>
						<tbody>
							<tr>
								<th>총 상품가격</th>
								<td> 21,500원</td>
							</tr>
							<tr>
								<th>배송비</th>
								<td>3000원</td>
							</tr>
							<tr>
								<th>총 결제금액</th>
								<td id="totalAmount"></td>
							</tr>
						</tbody>
					</table>
				</div>

				<br><br>
				<div class="pay-btn">
					<button type="submit"><a href="${phase.in}">결제하기</a></button>
				</div>
			</form>
		
		</div>
		<br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>