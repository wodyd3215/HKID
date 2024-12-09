<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/pEnroll.css">

    <script src="${pageContext.request.contextPath}/resources/js/admin/pEnroll.js"></script>
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            상품 등록
        </div>
            <div class="enroll-body">
                <table>
                    <tr>
                        <th>상품명</th>
                        <td><input type="text" placeholder="입력" class="productName" required></td>
                    </tr>
                    <tr>
                        <th>카테고리</th>
                        <td>
                            <select class="category">
                                <option>식품</option>
                                <option>의류</option>
                                <option>기구</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>상품 수량</th>
                        <td><input type="number" placeholder="입력" class="quantity" required></td>
                    </tr>
                    <tr>
                        <th>상품 가격</th>
                        <td><input type="number" placeholder="입력" class="price" required></td>
                    </tr>
                    <tr>
                        <th class="he-50" id="sumHe" data-he="308">상세내용</th>
                        <td id="detail-area"><textarea id="content" class="content"></textarea></td>
                    </tr>
                    <tr>
                        <th class="he-20">대표 이미지 추가</th>
                        <td id="img-area">
                            <input type="file" class="include-img" name="fileList" multiple>
                            <div class="material-symbols-outlined" onclick="includeImg()">add</div>
                        </td>
                    </tr>
                </table>
                <div>
                    <button class="btn btn-primary custom-btn submit-btn" data-url="insertProduct">등록하기</button>
                    <button class="btn btn-danger custom-btn" data-target="cancel">취소하기</button>
                </div>
            </div>
    </div>
</body>
</html>