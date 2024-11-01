<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <!-- css -->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Products/productPage.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">

     <!-- font -->
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<title>상품 페이지</title>
</head>
<body>
    <div class="wrapper">
        <div id="productPage">
            <div id="selected"> <!-- 왼쪽 사이드바 nav -->
                <ul class="side-nav">
                    <li class="side-nav-header"> 상품 </li>
                    <li onclick="handleClick('식품')"> 식품 </li>
                    <li> 의류 </li>
                    <li> 기구 </li>
                </ul>
            </div>

            <div class="productPageA">
                <div class="MoveBtn"> <!-- 상품, 중고 전환 버튼-->            
                    <button class="productMove"> 상품 </button>
                    <button class="usedMove" > 중고 </button>
                </div>
                <div class="productListArr"> <!-- 상품 목록 -->
                    <div class="productList">
                        <!-- 상품 이미지 -->
                        <div class="productImg" ><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png"></div>
                        <!-- 상품 text -->
                        <div class="productText">                            
                            <div class="productName">
                                상품 <!-- 상품 이름 -->
                            </div>
                        </div>

                    </div>                    
                </div>

                <div class=> <!-- bottom -->
                    <button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button>
                    <span><button>1</button></span>
                    <span><button>2</button></span>
                    <span><button>3</button></span>
                    <span><button>4</button></span>
                    <span><button>5</button></span>
                    <button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button>
                </div>

                <div class="produBottom">                    
                    <select name="" id="produCategory">
                        <option value="전체">전체</option>
                        <option value="식품">식품</option>
                        <option value="의류">의류</option>
                        <option value="기구">기구</option>
                    </select>
                    
                    <div class="produSearch">
                        <input type="text" class="produSearchCan" placeholder="검색어를 입력하세요.">
                        <button type="submit"><img src="${pageContext.request.contextPath}/resources/image/SearchIcon.svg" alt=""></button>                       
                    </div>
                    
                </div>
            </div>

            
        </div>
    </div>
</body>
</html>