<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/searchMemberPwd.css">
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
        <form action="changePwdForm.me">
            <h1>비밀번호 찾기</h1>
            <div>
                <input type="text" name="memberId" id="searchPwd-id" placeholder="아이디 입력" required>
                <input type="text" name="phone" id="searchPwd-phone" placeholder="전화번호 입력" maxlength="11" required>
            </div>

            <div>
                <input type="submit" onclick="eee()" value="비밀번호 찾기">
            </div>
        </form>
    </div>
    <script>
        function eee() {
            console.log(document.querySelector("#searchPwd-id").value)
            console.log(document.querySelector("#searchPwd-phone").value)
        }
    </script>
</body>
</html>