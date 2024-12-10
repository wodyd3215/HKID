<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/recoveryForm.css">
    <script src="${pageContext.request.contextPath}/resources/js/member/recoveryForm.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div class="wrapper">
        <c:if test="${ not empty alertMsg}">
			<script>
				alert("${alertMsg1}");
                alert("${alertMsg2}");
			</script>
			<c:remove var="alertMsg1" scope="session"/>
            <c:remove var="alertMsg2" scope="session"/>
		</c:if>
        <div id="logo-img">
            <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
        </div> 
        <form action="recovery.me" method="post">
            <h1>계정 복구 신청</h1>
            <div>
                <input type="text" id="certifyNo" name="recoveryId" oninput="checkCertify()" placeholder="인증번호 입력">
            </div>
            
            <input type="text" id="receiveCertifyNo" value="${certifyNo}" hidden>
            <input type="text" value="${memberNo}">
            <div id="certifyArea">

            </div>
            <div>
                <input type="submit" id="recoveryApply" value="복구 신청">
            </div>
        </form>
    </div>
</body>
</html>