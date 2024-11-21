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

			<form action="">
				<div class="byerInfo-title">
					<p>구매자 정보</p>
				</div>

				<div class="byerInfo">
					<table>
						<tbody>
							<tr>
								<th>이름</th>
								<td>김철수</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>ironwater@naver.com</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>010-1234-5678</td>
							</tr>
							<tr>
								<th>배송주소</th>
								<td>서울시 강남구 구구구구</td>
							</tr>
							<tr>
								<th>배송 요청사항</th>
								<td>배송 전 문자 바랍니다.</td>
							</tr>
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
								<td>24,500원</td>
							</tr>
						</tbody>
					</table>
				</div>

				<br><br>
				<div class="pay-btn">
					<button type="submit">결제하기</button>
				</div>
			</form>
		
		</div>
		<br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>