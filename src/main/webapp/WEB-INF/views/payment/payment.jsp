<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="UTF-8">

<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/payment/paymentMain.js" defer></script>

<title>결제위젯 샘플</title>
</head>
<body>

    <!-- 할인 쿠폰 -->
    <div>
      <input type="checkbox" id="coupon-box" />
      <label for="coupon-box"> 5,000원 쿠폰 적용 </label>
    </div>
    <!-- 결제 UI -->
    <div id="payment-method"></div>
    <!-- 이용약관 UI -->
    <div id="agreement"></div>
    <!-- 결제하기 버튼 -->
    <button class="button" id="payment-button" style="margin-top: 30px">결제하기</button>


</body>
</html>