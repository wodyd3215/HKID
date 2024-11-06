<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="wrapper">
        <div class="productDetailHeader"> <!-- 상품 맨 위 -->

            <div class="productImg">
                <div class="representImg">
                    <!-- 상품 이미지 -->
                    <div class="reImg"></div>
                    
                </div>
                <div class="detailImg"> <!-- 상품이미지 밑에 있는 다른 이미지들 -->
                    <div class="diImg"></div> <!-- 이미지 1 -->
                    <div class="diImg"></div> <!-- 이미지 2 -->
                    <div class="diImg"></div> <!-- 이미지 3 -->
                    <div class="diImg"></div> <!-- 이미지 4 -->
                </div>
            </div>            
            
    
            <div class="productContent"> <!-- 상품 버튼-->
                <div class="productLocation"> 상품 > 가구</div>
    
                <div class="productDetail">                
                    <div> 멀킨 육각덤벨 3Kg</div>
                    <div class="assess"> 평점 () </div>
                </div>            
    
                <div class="BtnPrice">
                    <div class="quantityBtn">
                        <button class="Btnmin">-</button>
                        <span class="quanText">1</span>
                        <button class="Btnpls">+</button>
                    </div>                                       
                    <div class="priceText"> 가격 </div>
                </div>
    
                <div class="phaseCartBtn">
                    <button class="phaseBtn"> 구매 </button>
                    <button class="cartBtn"> 장바구니 </button> 
                    <button class="favoriteBtn"><img src="${pageContext.request.contextPath}/resources/image/favoriteIcon.svg"></button>          
                </div>
                
            </div>
        </div>
    
        <div class="productMid">
            <div class="detailMenu">
                <ul class="tab">
                    <li class="detailMenuContent"><a href=""> 상세 내용 </a></li>
                    <li class="detailMenuReview"><a href=""> 리 뷰 </a></li>
                    <li class="detailMenuInform"><a href=""> 상품 정보 </a></li>
                    <li class="detailMenuExchange"><a href=""> 반품 / 교환 </a></li>
                </ul>

                <ul class="tabContent">
                    <li class="contentDetail"> <!-- 상품 상세 이미지 -->
                        <div class="contentImg"></div>
                    </li>

                    <li class="contentReview"> <!-- 리뷰 -->
                        <div class="review1">
                            <br>
                            <div class="reviewHeader"> <!-- 리뷰 상단 -->
                                <div class="reviewUser">닉네임</div> <!-- 유저 닉네임 -->
                                <div class="assessUser">ㅁㅁㅁㅁㅁ</div> <!-- 평점 -->
                                <div class="assessDate">9999.99.99</div> <!-- 리뷰 작성일 -->
                            </div> 
                            <div class="reviewImg">
                                <div class="reviImg"></div>
                            </div>
                            <div class="reviewProName"> 상품 이름</div> <!-- 상품 이름 -->
                            <div> !@#%$#!^@#$^@$%!#%!^ </div> <!-- 리뷰 내용 -->
                        </div>
                        <div class="review1">
                            <div class="reviewHeader"> <!-- 리뷰 상단 -->
                                <div class="reviewUser">닉네임</div> <!-- 유저 닉네임 -->
                                <div class="assessUser">ㅁㅁㅁㅁㅁ</div> <!-- 평점 -->
                                <div class="assessDate">9999.99.99</div> <!-- 리뷰 작성일 -->
                            </div> 
                            <div class="reviewImg">
                                <div class="reviImg"></div>
                            </div>
                            <div class="reviewProName"> 상품 이름</div> <!-- 상품 이름 -->
                            <div> !@#%$#!^@#$^@$%!#%!^ </div> <!-- 리뷰 내용 -->
                        </div>
                        <div class="review1">
                            <div class="reviewHeader"> <!-- 리뷰 상단 -->
                                <div class="reviewUser">닉네임</div> <!-- 유저 닉네임 -->
                                <div class="assessUser">ㅁㅁㅁㅁㅁ</div> <!-- 평점 -->
                                <div class="assessDate">9999.99.99</div> <!-- 리뷰 작성일 -->
                            </div> 
                            <div class="reviewImg">
                                <div class="reviImg"></div>
                            </div>
                            <div class="reviewProName"> 상품 이름</div> <!-- 상품 이름 -->
                            <div> !@#%$#!^@#$^@$%!#%!^ </div> <!-- 리뷰 내용 -->
                        </div>
                        
                        
                    </li>
                </ul>
            </div>
            
        </div>
    </div>    
</body>
</html>