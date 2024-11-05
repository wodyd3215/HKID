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
            복구 신청
        </div>
        <div class="content">
            <table id="common-table">
                <thead>
                    <tr id="common-table-header">
                        <th class="type-width33">신청자명</th>
                        <th class="type-width33">신청 날짜</th>
                        <th class="type-width33">계정 복구</th>
                    </tr>
                </thead>
                <tbody>
                    <tr id="common-table-body">
                        <td>chldydwns036</td>
                        <td>2024-10-30</td>
                        <td>
                            <div class="uManagement">
                                <form action="">
                                    <input type="text" name="mno" value="" hidden>
                                    <button class="btn btn-primary custom-btn">계정 복구</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>