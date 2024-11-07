<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/sideNavi.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/modal.css">

    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin/common.js"></script>
    
    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">

    <!-- include libraries(jQuery, bootstrap) -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body onload="init('${pageContext.request.contextPath}', '${pageName}', '${optional}')">
    <div class="sideNavi">
        <div id="logo">
            <a href="">대충 로고</a>
        </div>
        <div id="nav">
            <ul>
                <li>
                    유저관리
                    <ul>
                        <li><a href="">정지 유저</a></li>
                        <li><a href="accRecovery.ad">계정복구</a></li>
                    </ul>
                </li>
                <li><a href="product.ad">상품관리</a></li>
                <li>
                    신고관리
                    <ul>
                        <li><a href="reportedUser.ad">신고 유저<a></li>
                        <li><a href="reportedBoard.ad">신고 게시글</a></li>
                        <li><a href="reportedReply.ad">신고 댓글</a></li>
                    </ul>
                </li>
                <li><a href="notice.ad">공지</a></li>
            </ul>
        </div>
    </div>
    
    <c:if test="">
        <jsp:include page="detailModal.jsp" />
    </c:if> 
</body>
</html>