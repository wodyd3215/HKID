<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/personalPage.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/PersonalModal.css">
<!-- js -->
<script src="${pageContext.request.contextPath}/resources/js/member/personalPage.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/apis/findAddressAPI.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
	<jsp:include page="../common/header.jsp" />
    <jsp:include page="/WEB-INF/views//modal/personalModal.jsp" />
    <div class="wrapper">
        <div id="pageName">내 프로필</div>
        <form id="content-area" action="updateMember?memberNo=${loginMember.memberNo}" method="POST" enctype="multipart/form-data">
            <div id="img-area">
                <img src="${pageContext.request.contextPath}${loginMember.profileImg}" class="profile-img" data-target="profile-change" onclick="openModal(event)">
                <div id="notice">*이미지를 눌러 프로필 변경</div>
                <div id="account-deletion" data-target="withdraw" onclick="openModal(event)">회원탈퇴</div>
            </div>
            <div id="info-area">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" name="memberId" value="${loginMember.memberId}" readonly></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><div id="password" class="btn" data-target="password-change" onclick="openModal(event)">변경하기</div></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="memberName" value="${loginMember.memberName}" readonly></td>
                    </tr>
                    <tr>
                        <th>*닉네임</th>
                        <td><input type="text" name="nickName" value="${loginMember.nickName}" placeholder="닉네임" required></td>
                    </tr>
                    <tr>
                        <th>*전화번호</th>
                        <td><input type="text" name="phone" value="${loginMember.phone}" placeholder="전화번호" minlength="11" maxlength="11" required></td>
                    </tr>
                    <tr>
                        <th>*이메일</th>
                        <td><input type="text" name="email" value="${loginMember.email}" placeholder="이메일" required></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td id="address-info">
                            <input id="post-no" type="text" name="postNo" value="${loginMember.postNo}" placeholder="우편번호">
                            <span class="btn" onclick="sample6_execDaumPostcode()">주소 찾기</span>
                            <input id="input-address" type="text" name="address" value="${loginMember.address}" placeholder="주소">
                            <input type="text" id="detail-address" name="detailAddress" value="${loginMember.detailAddress}" placeholder="상세주소"> 
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2" id="submit-btn">
                            <button type="submit">변경하기</button>
                        </th>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</body>
</html>