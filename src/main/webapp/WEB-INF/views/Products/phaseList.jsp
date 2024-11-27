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

</head>
<body>
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
                <tr class="content-space">
                    
                    
                    <td class="img-space"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" class="product-image"></td>
                    
                    <td class="item-name"><div class="name-text"> 구매한 상품 </div></td>

                    <td class="quantity-space"><div class="box">1</div></td>


                    <td class="price-space">26,880 원</td>

                    <td>
                        <div class="date-space">
                            <div class="date-text"> 9999.99.99  99:99:99 결제 </div>
                            <div class="method-space">결제방식 : 토스페이</div>
                        </div>                        
                    </td>

                    <c:if test="${}"> <!-- 작성했을 땐 숨기고, 작성하지 않았을 땐 뜸-->
                        <td>
                            <button onclick=""> 리뷰 작성 </button>
                        </td>
                    </c:if>
                </tr>                
            </tbody>




        </table>

</body>
</html>