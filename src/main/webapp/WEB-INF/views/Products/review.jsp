<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- css -->    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Products/productDetail.css">

    <!-- js -->
    <script src="${pageContext.request.contextPath }/resources/js/Products/review.js" defer></script>
<title>리뷰 작성</title>
</head>
<body>
    <form id="rate">
        <input type="hidden" name="memberNo" value="${loginMember.memberNo}">
        <input type="hidden" name="productNo" value="${product.productNo}">
              
        <div class="rating">
            <label class="rating__label rating__label--full" for="star1">
                <input type="radio" id="star1" class="rating__input" name="rating" value="">
                <span class="star-icon"></span>
            </label>

            <label class="rating__label rating__label--full" for="star2">
                <input type="radio" id="star2" class="rating__input" name="rating" value="">
                <span class="star-icon"></span>
            </label>

            <label class="rating__label rating__label--full" for="star3">
                <input type="radio" id="star3" class="rating__input" name="rating" value="">
                <span class="star-icon"></span>
            </label>

            <label class="rating__label rating__label--full" for="star4">
                <input type="radio" id="star4" class="rating__input" name="rating" value="">
                <span class="star-icon"></span>
            </label>

            <label class="rating__label rating__label--full" for="star5">
                <input type="radio" id="star5" class="rating__input" name="rating" value="">
                <span class="star-icon"></span>
            </label>
        </div>
        
        <div>
            <textarea name="reviewContent" placeholder="리뷰 내용을 작성해주세요."></textarea>
        </div>
        <!-- <div>
            <input type="file" id="upfile" class="form-controll-file border" name="upfile">
            <c:if test="${not empty}">
                현재 업로드 된 사진 : 
                <a href=""></a>
            </c:if>
        </div> -->
        <div>
            <input type="submit" value="리뷰등록">
        </div>
    </form>
</body>
</html>