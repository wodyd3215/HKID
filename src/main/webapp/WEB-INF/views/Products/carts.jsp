<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- css -->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Products/carts.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">

</head>
<body class="wrapper">
    <div class="productPageDetailSty">
        <div class="PDheader">
           	 장바구니
        </div>
        
        <table class="productCartLists" border="1px solid #000000">
            <thead>
                <tr>
                    <th>
                        <input type="checkbox" class="selectCart"  id="selectAll">
                        <label for="selectAll"></label>
                    </th>
                    <th>상품 이미지</th>
                    <th>상품 이름</th>
                    <th>수량</th>
                    <th>가격</th>
                    <th>삭제</th>
                </tr>                
            </thead>

            <tbody class="cartList1">
                <tr>
                    <td>
                        <input type="checkbox" class="selectCart">
                        <label for="selectItem1"></label>
                    </td>
                    <td><img src="상품이미지.jpg" alt="상품 이미지" class="product-image"></td>
                    <td><span>장바구니에 담겨있다</span></td>
                    <td class="cartQuantity">
                        <button>-</button>
                        <span>1</span>
                        <button>+</button>
                    </td>
                    <td>26,880 원</td>
                    <td>
                        <button class="delete-button"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                    </td>
                </tr>                
            </tbody>
        </table>
    </div>
</body>
</html>