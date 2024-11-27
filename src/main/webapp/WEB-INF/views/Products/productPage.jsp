<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="wrapper">
        <div id="productPage">
            <form id="sidecategory" action="product.se">
                <div id="selected"> <!-- 왼쪽 사이드바 nav -->
                    <ul class="side-nav">
                        <li class="side-nav-header"> 상품 </li> 
                        <li>
                            <input type="radio" id="sideAll" name="category" value="전체"onchange="this.form.submit()"/>                        
                            <label for="sideAll"> 전체 </label>
                        </li>

                        <li>
                            <input type="radio" id="sideFood" name="category" value="식품" onchange="this.form.submit()"/>                        
                            <label for="sideFood"> 식품 </label>                    
                        </li>                    

                        <li>
                            <input type="radio" id="sideClothes" name="category" value="의류" onchange="this.form.submit()" />                        
                            <label for="sideClothes"> 의류 </label>
                        </li>
                        
                        <li>
                            <input type="radio" id="sideEquipment" name="category" value="기구" onchange="this.form.submit()"/>                        
                            <label for="sideEquipment"> 기구 </label>                    
                        </li>
                    </ul>
                </div>
            </form>

            <div class="productPageAll">
                <div class="tabItem"> <!-- 상품, 중고 전환 버튼-->
                    <ul class="ItemBtn">
                        <li>
                            <input type="radio" class="productMove" id="storeItem" name="ItemRbtn" onclick="productView('store')" checked/> 
                            <label for="storeItem"> 상품 </label> 
                        </li>

                        <li>
                            <input type="radio" class="usedMove" id="usedItem" name="ItemRbtn" onclick="productView('used')" /> 
                            <label for="usedItem"> 중고 </label>
                        </li>
                    </ul>                
                </div>

                <div class="productListArr"> <!-- 상품 목록 -->
                    <c:forEach var="p" items="${list}">
                        <div class="productList" id="storeItemDiv">
                        <!-- 상품 이미지 -->
                            <div class="productImg" >
                                <a href="deteilItem.li?pno=${p.productNo }">
                                    <img src="./resources/image/exerciseImages/45_SIDE_BEND.gif" alt="noting">
                                </a>
                            </div>

                            <!-- 상품 text -->
                            <div class="productText">
                                <div class="productTextHeader">
                                    <div class="productName">
                                        <!-- 상품 이름 -->
                                        ${p.productName}
                                    </div>
                                    
                                    <input type="checkbox" class="favoriteBtn"></input>
                                </div>
                                
                                <div class="productTextMid">
                                    <div class="productTexts">
                                        <div class="textStar">★</div>
                                        
                                        <c:choose >
                                            <c:when test="${r.rate == null}">
                                                <div class="totalRate">
                                                    0.0
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="totalRate">
                                                    ${r.rate}
                                                </div>
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </div>                                                                
                                    <div class="mainPrice">${p.price}원</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <c:forEach var="p" items="${list}">
                        <div class="productList" id="usedItemDiv" style="display: none;">
                        <!-- 상품 이미지 -->
                            <div class="productImg" >
                                <a href="">
                                    <img src="./resources/image/exerciseImages/45_SIDE_BEND.gif" alt="noting">
                                </a>
                            </div>

                            <!-- 상품 text -->
                            <div class="productText">
                                <div class="productTextHeader">
                                    <div class="productName">
                                        <!-- 상품 이름 -->
                                        ${p.productName}
                                    </div>
                                    
                                    <input type="checkbox" class="favoriteBtn"></input>
                                </div>
                                
                                <div class="productTextMid">
                                    <div class="productTexts">
                                        <div class="textStar">★</div>
                                        
                                        <c:choose >
                                            <c:when test="${r.rate == null}">
                                                <div class="totalRate">
                                                    0.0
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="totalRate">
                                                    ${r.rate}
                                                </div>
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </div>                                                                
                                    <div class="mainPrice">${p.price}원</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                
                

                <div class="productPageBtn"> <!-- bottom -->
                    <c:choose>
                        <c:when test="${pi.currentPage eq 1}">
                            <a class="leftBtn" href="#"><button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button></a>
                        </c:when>

                        <c:otherwise>
                            <a class="" href="product.li?cpage=${pi.currentPage - 1}"><button><img src="${pageContext.request.contextPath}/resources/image/leftBtn.svg"></button></a>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="p" begin ="${pi.startPage}" end="${pi.endPage}">
                        <a class="paging-link ${p == pi.currentPage ? 'active' : ''}" href="product.li?cpage=${p}">${p}</a>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${pi.currentPage eq pi.maxPage}">
                            <a class="" href="#"><button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button></a>
                        </c:when>
                        <c:otherwise>
                            <a class="" href="product.li?cpage=${pi.currentPage + 1}"><button><img src="${pageContext.request.contextPath}/resources/image/rightBtn.svg"></button></a>
                        </c:otherwise>
                    </c:choose>
                </div>

            <!-- 검색 바 -->
            <form action="product.se">
                <div class="produBottom">
                    <input type="hidden" name="pPage" value="1"> 
                    <input type="hidden" name="">                  
                    <select name="searchCategory" id="produCategory">
                        <option value="전체">전체</option>
                        <option value="식품">식품</option>
                        <option value="의류">의류</option>
                        <option value="기구">기구</option>
                    </select>
                        
                    <div class="produSearch">
                        <input type="text" class="produSearchCan" name="keyword" value="${keyword}" placeholder="검색어를 입력하세요.">
                        <button type="submit"><img src="${pageContext.request.contextPath}/resources/image/SearchIcon.svg" alt=""></button>                       
                    </div>                        
                </div>
            </form>
        </div>
    </div>
    
     <!-- js -->
     <script src="${pageContext.request.contextPath }/resources/js/Products/productPage.js" defer></script>
</body>
</html>