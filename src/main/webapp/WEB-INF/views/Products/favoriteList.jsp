<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
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
            <thead>
                <tr>
                    <th class="selected"></th>
                    <th class="imageSpace"></th>
                    <th class="nameSpace">상품 이름</th>
                    <th class="priceSpace">상품 가격</th>
                    <th class="delete-button"></th>
                </tr>
            </thead>


            <!-- 찜한 목록들 -->
            <tbody>
                <c:forEach var="f" items="${flist}">
                    <tr class="content-space">
                        <td>
                            <input type="checkbox" class="selected" name="selectBox" value="${item.productNo}" onclick="checkSelectAll(this)">                            
                        </td>
    
                        <td class="imageSpace">
                            이미지 구역
                        </td>
    
                        <td class="nameSpace">
                            ${f.productName}
                            <!-- <a href="detailItem.li?f={f.productNo}"></a> -->
                        </td>
    
                        <td class="priceSpace">
                            ${f.price}
                        </td>
    
    
                        <td>
                            <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                        </td>
                    </tr>
                </c:forEach>
                
            </tbody>
            
            <!-- 맨 아래 체크버튼 delete버튼-->
            <tfoot class="falistfoot">
                <tr class="content-top">

                    <!-- 체크박스 -->
                    <th>
                        <input type="checkbox" class="selected" name="selectBox" onclick="selectAll(this)">
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
        <div class="pageBtn"> <!-- bottom -->
            <c:choose>
                <c:when test="${pi.currentPage eq 1}">
                    <a class="leftBtn" href=""><button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button></a>
                </c:when>

                <c:otherwise>
                    <a class="" href="favorite.li?cpage=${pi.currentPage - 1}"><button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button></a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="p" begin ="${pi.startPage}" end="${pi.endPage}">
                <a class="paging-link ${p == pi.currentPage ? 'active' : ''}" href="favorite.li?cpage=${p}">${p}</a>
            </c:forEach>

            <c:choose>
                <c:when test="${pi.currentPage eq pi.maxPage}">
                    <a class="" href="#"><button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button></a>
                </c:when>
                <c:otherwise>
                    <a class="" href="favorite.li?cpage=${pi.currentPage + 1}"><button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button></a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>