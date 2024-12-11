<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/recoveryForm.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/recoveryForm.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/apis/sendMailApi.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">
        <c:if test="${ not empty alertMsg}">
			<script>
				alert("${alertMsg}");
			</script>
			<c:remove var="alertMsg" scope="session"/>
		</c:if>
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <form action="recovery.me?memberNo=${memberNo}" method="post">
            <h1>계정 복구 신청</h1>
            <div id="enroll-email-certify">
                <div id="enroll-email">
                    <div class="enroll-input-area">
                        <input id="email-input1" type="text" name="email" placeholder="이메일 입력" required>
                        <div class="all-btn" id="email-certify" onclick="certifyEmail()">인증번호 받기</div>
                    </div>
                </div>
                <br>

                <div id="enroll-certify">
                    <div id="certifyClick" class="enroll-input-area">
                        <input type="text" id="certifyNo" name="certifyNo" placeholder="인증번호 입력" required>
                        <input type="text" id="receiveCertifyNo" hidden>
                        <div class="all-btn" onclick="checkCertify()">인증</div>
                    </div>
                </div>
            </div>

            <div id="certifyArea">
            </div>

            <div>
                <input type="submit" id="recoveryApply" value="복구 신청">
            </div>
        </form>
    </div>
</body>
</html>