<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- css -->    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Products/productDetail.css">

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

    
<title>상품 상세 페이지</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    
    <div class="wrapper">
        <div class="productDetailHeader" id="top"> <!-- 상품 맨 위 -->

            <div class="productImg">
                <!-- 상품 대표이미지 -->
                <div class="representImg">                     
                    <div class="reImg">
                        <img src="" alt="없음">
                    </div>                    
                </div>

                <!-- 상품이미지 밑에 있는 다른 이미지들 -->
                <div class="detailImg"> 
                </div>
            </div>            
            
            <form action="" method="">
                <input type="hidden" name="memberNo" value="${p.memberNo}">
                <input type="hidden" name="productNo" value="${p.productNo}">
            </form>
                <div class="productContent"> <!-- 상품 버튼-->
                    <!-- 상품 위치 -->
                    <div class="productLocation"> 상품 > ${p.category}</div>
        
                    <!-- 상품 이름 및 평점 -->
                    <div class="productDetail">
                         <!-- 상품 이름 -->
                        <div> ${p.productName}</div>
    
                        <!-- 평점 -->
                        <div class="assess" data-star="${p.rate}" data-count="${p.reviewCount}"></div> 
                    </div>            
        
                    <!-- 수량 버튼 -->
                    <div class="BtnPrice">
                        <div class="quantityBtn" data-max-quantity="${p.quantity}">
                            <button class="Btnmin" onclick="decreaseQuantity()">-</button>
                            <span class="quanText">1</span>
                            <button class="Btnpls" onclick="increaseQuantity()">+</button>
                        </div>                                       
                        <div class="priceText" data-price="${p.price}">                         
                            ${p.price} 원
                        </div>
                    </div>

                        <!-- 구매 및 장바구니 버튼 -->
                    <div class="phaseCartBtn">
                        <button type="submit" class="phaseBtn"> <a href="phaseInfo.li"> 구매 </a></button>
                        <button class="cartBtn" onclick="addItem('${loginMember.memberNo}')"> 장바구니 </button> 
                        <button class="favoriteBtn"><img src="${pageContext.request.contextPath}/resources/image/favoriteIcon.svg"></button>          
                    </div>                
                </div>

                
        </div>     




        <!-- 상세 ~ 반품/교환  메뉴 페이지  -->

        <div class="productMid">
            <div class="detailMenu">
                <ul class="tab">

                    <li class="tab-link">
                        <!--<input type="radio" id="contentDetail" name="show"  onclick="moveScroll('contentDetail')" checked/>                        
                         <label for="contentDetail"> 상세 내용</label> -->
                         <a href="#contentDetail" onclick="activateTab(this)"> 상세 내용 </a>
                    </li>

                    <li class="tab-link">
                        <!-- <input type="radio" id="contentReview" name="show"  onclick="moveScroll('contentReview')"/>
                        <label for="contentReview">리 뷰</label> -->
                        <a href="#contentReview"  onclick="activateTab(this)"> 리 뷰 </a>
                    </li> 
                    
                    <li class="tab-link">
                        <a href="#top" onclick="activateTab(this)"> 상품 정보 </a>
                    </li>

                    <li class="tab-link">
                        <!-- <input type="radio" id="contentExchange" name="show"  onclick="moveScroll('contentExchange')"/>
                        <label for="contentExchange">반품 / 교환</label> -->
                        <a href="#contentExchange" onclick="activateTab(this)"> 반품/교환 </a>
                    </li>

                </ul>



                <ul class="tabContent">

                    <!-- 상품 상세 이미지 -->
                    <li id="contentDetail" class="contentDetail"> 
                        <div class="contentImg">
                        </div>
                    </li>

                    <li id="contentReview" class="contentReview"> <!-- 리뷰 -->
                        <br>
                        <div class="pageInfo">
                            <button id="prev">&lt;</button>
                            <button id="currentPage"></button>
                            <button id="next">&gt;</button>
                        </div>
                        <div class="review1">
                            <!-- 리뷰 내용 -->
                            <div class="reviewHeader"> <!-- 리뷰 상단 -->
                                <div class="reviewUser">닉네임</div> <!-- 유저 닉네임 -->
                                <div class="assessUser">★★★★★</div> <!-- 평점 -->
                                <div class="assessDate">2024.12.12</div> <!-- 리뷰 작성일 -->
                            </div>  
                            <div class="reviewImg">
                                <div class="reviImg"></div>
                            </div>
                            <div class="reviewProName"> 상품 이름</div> <!-- 상품 이름 -->
                            <div> 너무 좋아요!! </div> <!-- 리뷰 내용 -->
                        </div>

                        <div class="review1">
                            <!-- 리뷰 내용 -->
                            <div class="reviewHeader"> <!-- 리뷰 상단 -->
                                <div class="reviewUser">닉네임</div> <!-- 유저 닉네임 -->
                                <div class="assessUser">★★★★★</div> <!-- 평점 -->
                                <div class="assessDate">2024.12.12</div> <!-- 리뷰 작성일 -->
                            </div>  
                            <div class="reviewImg">
                                <div class="reviImg"></div>
                            </div>
                            <div class="reviewProName"> 상품 이름</div> <!-- 상품 이름 -->
                            <div> 너무 좋아요!! </div> <!-- 리뷰 내용 -->
                        </div>

                        <div class="review1">
                            <!-- 리뷰 내용 -->
                            <div class="reviewHeader"> <!-- 리뷰 상단 -->
                                <div class="reviewUser">닉네임</div> <!-- 유저 닉네임 -->
                                <div class="assessUser">★★★★★</div> <!-- 평점 -->
                                <div class="assessDate">2024.12.12</div> <!-- 리뷰 작성일 -->
                            </div>  
                            <div class="reviewImg">
                                <div class="reviImg"></div>
                            </div>
                            <div class="reviewProName"> 상품 이름</div> <!-- 상품 이름 -->
                            <div> 너무 좋아요!! </div> <!-- 리뷰 내용 -->
                        </div>
   
                    </li>

                    <li id="contentExchange" class="contentExchange">
                        <div class="exchange-text">반품/교환 안내</div>
                            <table class="exchange-info">
                                <tr>
                                    <td>
                                        <div>반품/교환 비용</div>                                     
                                    </td>
                                    <td>
                                        [총 주문금액] - [반품상품금액]
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        교환/반품 신청 기준일
                                    </td>
                                    <td>
                                        <p>
                                            ◼ 단순변심에 의한 로켓배송 상품의 교환/반품은 제품 수령 후 30일 이내까지, 교환/반품 제한사항에 해당하지 않는 경우에만 가능 (교환/반품 비용 고객부담) <br>
                                            ◼ 상품의 내용이 표시·광고의 내용과 다른 경우에는 상품을 수령한 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터
                                            30일 이내에 청약철회 가능
                                        </p>
                                        
                                    </td>
                                </tr>
                            </table>
                        <br>

                        <div>교환/반품 제한사항</div>

                        <ul>
                            <li>주문/제작 상품의 경우, 상품의 제작이 이미 진행된 경우</li>
                            <li>상품 포장을 개봉하여 사용 또는 설치 완료되어 상품의 가치가 훼손된 경우 (단, 내용 확인을 위한 포장 개봉의 경우는 예외)</li>
                            <li>고객의 사용, 시간경과, 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우</li>
                        </ul>
                    </li> 
                </ul>
            </div>
            
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <!-- js -->
    <script src="${pageContext.request.contextPath }/resources/js/Products/productDetail.js" defer></script>
</body>
</html>