<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!-- css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Products/favoriteList.css">

    <!-- js -->
    <script src="${pageContext.request.contextPath }/resources/js/Products/carts.js" defer></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="wrapper">

        <div class="location-text">
            찜목록
        </div>

        <table class="falist">



            <!-- 찜한 목록들 -->
            <tbody>
                <tr class="content-space">
                    <th>
                        <input type="checkbox" class="selected">
                    </th>

                    <th class="imageSpace">
                        이미지 구역
                    </th>

                    <th class="nameSpace">
                        상품이름 구역
                    </th>

                    <th class="priceSpace">
                        가격 구역
                    </th>


                    <th>
                        <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                    </th>
                </tr>
            </tbody>
            
            <!-- 맨 아래 체크버튼 delete버튼-->
            <tfoot class="falistfoot">
                <tr class="content-top">

                    <!-- 체크박스 -->
                    <th>
                        <input type="checkbox" class="selected" onclick="selectAll(this)">
                    </th>

                    <!-- 체크박스와 delete 사이에 있는 공간 -->
                    <th class="emptySpace" colspan="3"></th>

                    <!-- delete 버튼 -->
                    <th>
                        <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                    </th>

                </tr>
            </tfoot>
            



        </table>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>