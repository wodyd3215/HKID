<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Products/carts.css">     

    <!-- js -->
    <script src="${pageContext.request.contextPath }/resources/js/Products/carts.js"></script>
    
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />  
    
    <div class="wrapper">


        <div class="cart-text">
           	 장바구니
        </div>

        
        
            <table class="productCartLists">
                <thead class="cartTableHead">
                    <tr>
                        <th class="check-space">
                            <input type="checkbox" class="selectCart" name="selectAll" onclick="selectAll(this)">
                        </th>
                        <th class="img-space"></th> <!-- 상품이미지 영역 -->
                        <th class="name-space">상품명</th>
                        <th class="quantity-space">수량</th> <!-- 수량조절 버튼 영역 -->
                        <th class="price-space">가격</th>
                        <th class="delete-space"></th> <!-- 삭제 버튼 영역 -->
                    </tr>
                </thead>                       
    
                <tbody class="cartTableBody">
                    <c:choose>
                        <c:when test="${empty list}">
                            <tr>
                                <td colspan="6" class="cartListNone">장바구니에 담긴 상품이 없어요 !</td>
                            </tr>
                        </c:when>
                    <c:otherwise>
                    
                    
                                
                <c:forEach var="item" items="${list}">
                    
                    <tr class="content-space">
                        <td>
                            <input type="checkbox" class="selectCart" name="selectBox" value="${item.productNo}" onclick="checkSelectAll(this)">
                        </td>
                        
                        <td>
                            <!-- <c:if test="${}">
                                <img src="${pageContext.request.contextPath}/resources/image/${entry.key}.jpg" alt="${entry.key}" class="product-image">
                            </c:if> -->
                        </td>
                        
                        <td class="cartItemName">                            
                            ${item.productName}
                        </td>
                        
                        <td>
                            <div class="cartQuantity" data-product-no="${item.productNo}" data-member-no="${loginMember.memberNo}">
                                <button class="decreaseBtn" onclick="decreaseBtn()" >-</button>
                                <div class="quantityBtnText">${item.productQuantity}</div>
                                <button class="increaseBtn" onclick="increaseBtn()">+</button>
                            </div>
                        </td>
                        <td class="productPrice" data-price="${item.price}">${item.price}</td>
                        <td>
                            <button class="btn delete-button" data-product-no="${item.productNo}" data-member-no="${loginMember.memberNo}" onclick="delectOne()"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg" alt="삭제"></button>
                        </td>
                    </tr>
                </c:forEach>
                

            </tbody>
        </c:otherwise>
    </c:choose>        
            <tfoot class="cartTableFoot">
                <tr>

                    
                    <th>
                        <!-- <input type="checkbox" class="selectCart" name="selectBox" onclick="selectAll(this)"> -->
                    </th>
                    
                    <td>총</td>
                    <td class="totalPrice" id="totalPrice"></td>
                    <td>원</td>

                    <td class="BuyBtn">
                        <button type="submit" class="cartBuyBtn" onclick="bottomBtn('buy')">구매하기</button>
                    </td>

                    <td>
                        <button class="delete-button" data-member-no="${loginMember.memberNo}" onclick="deleteAll()"><img src="${pageContext.request.contextPath}/resources/image/garbage.svg"></button>
                    </td>
                
                    
                </tr>
            </tfoot>
        </table>
        
            
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>