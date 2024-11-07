<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Products/carts.css">     

    <!-- js -->
    <script src="${pageContext.request.contextPath }/resources/js/Products/carts.js" defer></script>
</head>
<body>
    
    <div class="wrapper">


        <div class="cart-text">
           	 장바구니
        </div>


        
        <table class="productCartLists">


            <thead class="cartTableHead">
                <tr>
                    <th class="check-space">
                        <input type="checkbox" class="selectCart"  onclick="selectAll(this)">                        
                    </th>

                    <!-- 체크박스와 delete 사이에 있는 공간 -->
                    <th class="img-space"></th> <!-- 상품이미지 영역 -->
                    <th class="name-space"></th> <!-- 상품이름 영역 -->
                    <th class="quantity-space"></th> <!-- 수량조절 버튼 영역 -->
                    <th class="price-space"></th> <!-- 가격 영역 -->

                    <th delete-space>
                        <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                    </th>
                </tr>                
            </thead>

  
            <tbody class="cartTableBody">
                <tr class="content-space">
                    <td>
                        <input type="checkbox" class="selectCart" name="selectBox">                        
                    </td>

                    <td><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" class="product-image"></td>
                    
                    <td class="cartItemName">장바구니에 담겨있다</td>

                    
                    <td>
                        <div class="cartQuantity">
                            <button>-</button>
                            <div>1</div>
                            <button>+</button>
                        </div>                        
                    </td>


                    <td class="product-price">26,880 원</td>


                    <td>
                        <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                    </td>
                </tr>                
            </tbody>



            <tfoot class="cartTableFoot">
                <tr>
                    <th>
                        <input type="checkbox" class="selectCart"  id="selectAll" onclick="selectAll(this)">
                    </th>
                    

                    <td class="totalPrice" colspan="3">총 100,000 원 </td>
                    
                    <td class="BuyBtn">
                        <button class="cartBuyBtn">구매하기</button>
                    </td>

                    <td>
                        <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                    </td>
                    
                </tr>
            </tfoot>

        </table>

    </div>
</body>
</html>