<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- css -->    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Products/productDetail.css">

<title>리뷰 작성</title>
</head>
<body>
    <form action="" input="hidden" value="rate">
        <div class="star+rating">
            <span class="star on" value="1"></span>
            <span class="star" value="2"> </span>
            ​​<span class="star" value="3"> </span>
            ​​<span class="star" value="4"> </span>
            ​​<span class="star" value="5"> </span>
        </div>
        <input type="hidden" value="">
        <input type="hidden" value="">
        <div>
            <textarea name="" id="" placeholder="리뷰 내용을 작성해주세요."></textarea>
        </div>
        <div>
            <input type="submit" value="리뷰등록">
        </div>
    </form>
</body>
</html>