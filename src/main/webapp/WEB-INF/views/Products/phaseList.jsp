<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css -->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Products/phaseList.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">

     <!-- js -->
     <script src="${pageContext.request.contextPath }/resources/js/order/phaseBtn.js" defer></script>

</head>
<body onload="disableBtn()">
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="wrapper">


        <div class="phase-text">
           	 구매내역
        </div>


        
        <table class="phaseLists">


            <thead class="phaseTableHead">
                <tr>                   
                    
                    <th class="img-space"></th> <!-- 상품이미지 영역 -->
                    <th class="name-space"></th> <!-- 상품이름 영역 -->
                    <th class="quantity-space"></th> <!-- 갯수 영역 -->
                    <th class="price-space"></th> <!-- 가격 영역 -->
                    <th class="date-space"></th> <!-- 구매 날짜 -->
                    <th class="reviewBtn-space"></th> <!-- 리뷰 버튼 -->
                </tr>                
            </thead>

  
            <tbody class="phaseTableBody">
                <c:if test="${not empty list}">
                    <c:forEach var="cell" items="${list}" >
                        <tr class="content-space">                    
                        
                            <td class="img-space"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" class="product-image"></td>
                            
                            <td class="item-name"><div class="name-text"> ${cell.productName} </div></td>
        
                            <td class="quantity-space"><div class="box">${cell.quantity}</div></td>
        
                            <td class="price-space">${cell.price} 원</td>
        
                            <td>
                                <div class="date-space">
                                    <div class="date-text"> ${cell.purchaseDate} </div>
                                    <div class="method-space">결제방식 : ${cell.bankName}</div>
                                </div>                        
                            </td>
        
                            
                        </tr>
                    </c:forEach>  
                </c:if>
                <c:if test="${empty list}">
                    <td colspan="5"> 조회된 데이터가 없거나 아예 없습니다.</td>
                </c:if>
            </tbody>

            <tfoot>
                <tr>
                    <div class="reviewInfo">
                        리뷰는 결제 이후로부터 3일 이내에 작성이 가능합니다.
                    </div> 
                </tr>
            </tfoot>


        </table> 

        <div class="pageBtn"> <!-- bottom -->
            <c:choose>
                <c:when test="${pi.currentPage eq 1}">
                    <a class="leftBtn" href=""><button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button></a>
                </c:when>

                <c:otherwise>
                    <a class="" href="phase.li?cpage=${pi.currentPage - 1}"><button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button></a>
                </c:otherwise>
            </c:choose>

            <c:forEach var="p" begin ="${pi.startPage}" end="${pi.endPage}">
                <a class="paging-link ${p == pi.currentPage ? 'active' : ''}" href="phase.li?cpage=${p}">${p}</a>
            </c:forEach>

            <c:choose>
                <c:when test="${pi.currentPage eq pi.maxPage}">
                    <a class="" href="#"><button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button></a>
                </c:when>
                <c:otherwise>
                    <a class="" href="phase.li?cpage=${pi.currentPage + 1}"><button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button></a>
                </c:otherwise>
            </c:choose>
        </div>
</body>
</html>