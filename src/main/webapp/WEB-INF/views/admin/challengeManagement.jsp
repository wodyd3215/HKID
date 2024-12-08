<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/uManagement.css">
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            챌린지 관리
        </div>
        <div class="content">
            <table id="common-table">
                <thead>
                    <tr id="common-table-header">
                        <th class="type-width">챌린지 명</th>
                        <th class="type-width">시작일</th>
                        <th class="type-width">종료일</th>
                        <th class="type-width">썸네일</th>
                        <th class="type-width"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ar" items="${list}">
                        <tr id="common-table-body">
                            <td>${ar.nickname}</td>
                            <td>${ar.applicationDate}</td>
                            <td>
                                <div class="uManagement">
                                    <form action="recoveryAccount.ad" method="post">
                                        <input type="hidden" name="memberNo" value="${ar.memberNo}" >
                                        <button class="btn btn-primary custom-btn">계정 복구</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>