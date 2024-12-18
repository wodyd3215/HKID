<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://static.toss.im/icons/png/4x/icon-toss-logo.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>

<div class="wrapper w-100">
<div class="flex-column align-center confirm-loading w-100 max-w-540">
  <div class="flex-column align-center">
    <img src="https://static.toss.im/lotties/loading-spot-apng.png" width="120" height="120"></img>
    <h2 class="title text-center">결제 요청까지 성공했어요.</h2>
    <h4 class="text-center description">결제 승인하고 완료해보세요.</h4>
  </div>
  <div class="w-100">
    <button id="confirmPaymentButton" class="btn primary w-100">결제 승인하기</button>
  </div>
</div>
<div class="flex-column align-center confirm-success w-100 max-w-540">
  <img src="https://static.toss.im/illusts/check-blue-spot-ending-frame.png" width="120" height="120"></img>
  <h2 class="title">결제를 완료했어요</h2>
  <div class="response-section w-100">
    <div class="flex justify-between">
      <span class="response-label">결제 금액</span>
      <span id="amount" class="response-text"></span>
    </div>
    <div class="flex justify-between">
      <span class="response-label">주문번호</span>
      <span id="orderId" class="response-text"></span>
    </div>
    <div class="flex justify-between">
      <span class="response-label">paymentKey</span>
      <span id="paymentKey" class="response-text"></span>
    </div>
  </div>

  <div class="w-100 button-group">
    
    <div class="flex" style="gap: 16px;">
      <a class="btn w-100" href="https://developers.tosspayments.com/sandbox">다시 테스트하기</a>
      <a class="btn w-100" href="https://docs.tosspayments.com/guides/v2/payment-widget/integration" target="_blank" rel="noreferrer noopener">결제 연동 문서가기</a>
    </div>
  </div>
</div>
</div>

</body>
</html>