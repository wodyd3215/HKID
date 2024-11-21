<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<link rel="stylesheet" href="./resources/css/order/orderComplete.css?after">
<link rel="stylesheet" href="./resources/css/default.css">

<!-- js -->
<script src="./resources/js/order/orderComplete.js" defer></script>
</head>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="wrapper">
			<div class="orderCp-Title">
				<p>주문 완료</p>
			</div>

			<hr>

			<div class="orderCp-Comment">
				<p>
					<strong>구매가 완료</strong>되었습니다.
				</p>
			</div>

			<hr>

			<div class="productPaymentInfo-title">
				<p>
					상품결제 정보
				</p>
			</div>

			<hr id="shortLine">

		
			<div class="infoContent">
				<div id="personInfo-title">
					<p>받는 사람 정보</p>
					<div class="personInfo-content">
						<table>
							<tbody>
								<tr>
									<th>이름</th>
									<td>김철수 / 010-1111-2222</td>
								</tr>
								<tr>
									<th>이메일</th>
									<td>kimironwater@naver.com</td>
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
				</div>
				<div id="payInfo-title">
					<p>결제 정보</p>
					<div class="payInfo-content">
						<table>
							<tbody>
								<tr>
									<th>운송장 번호</th>
									<td>A91LA88K</td>
								</tr>
								<tr>
									<th>상품명</th>
									<td>덤벨 3kg</td>
								</tr>
								<tr>
									<th>주문 금액</th>
									<td>7,200원</td>
								</tr>
								<tr>
									<th>배송비</th>
									<td>3,000원</td>
								</tr>
								<tr>
									<th>총 결제 금액</th>
									<td style="color: #FF0000;">10,200원</td>
								</tr>
								<tr>
									<th>결제일</th>
									<td>24/10/31</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<br><br>

			<hr>
			
			<div class="btns">
				<button onclick="goHome()" id="home" type="button">홈으로</button>
				<button onclick="ContinueBtn()" id="shpping" type="button">쇼핑 계속하기</button>
			</div>

		</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
		

</body>
</html>