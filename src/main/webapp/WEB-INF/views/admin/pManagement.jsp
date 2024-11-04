<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/pManagement.css">
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper" style="border: 1px solid black;">
        <div class="managementTitle">
            상품관리
        </div>
        <div class="pmContent">
            <form action="">
                <select name="" id="pCategory">
                    <option value="">식품</option>
                    <option value="">의류</option>
                    <option value="">기구</option>
                </select>
            </form>
        </div>
    </div>
</body>
</html>