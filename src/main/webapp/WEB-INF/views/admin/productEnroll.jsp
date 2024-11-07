<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/pEnroll.css">
</head>
<body>
    <jsp:include page="sideNavi.jsp" />
    <div class="wrapper">
        <div class="managementTitle">
            상품 등록
        </div>
        <form action="" method="post" class="content">
            <div class="enroll-body">
                <table>
                    <tr>
                        <th>상품명</th>
                        <td><input type="text" placeholder="입력" required></td>
                    </tr>
                    <tr>
                        <th>카테고리</th>
                        <td><input type="text" placeholder="입력" required></td>
                    </tr>
                    <tr>
                        <th>상품 수량</th>
                        <td><input type="text" placeholder="입력" required></td>
                    </tr>
                    <tr>
                        <th>상품 가격</th>
                        <td><input type="number" placeholder="입력" required></td>
                    </tr>
                    <tr>
                        <th class="he-50" id="sumHe" data-he="308">상세내용</th>
                        <td><textarea id="content" name="detail-content"></textarea></td>
                    </tr>
                    <tr>
                        <th class="he-20">대표 이미지 추가</th>
                        <td>
                            <input type="file">
                        </td>
                    </tr>
                </table>
                <div>
                    <button type="submit" class="btn btn-primary custom-btn">등록하기</button>
                    <button class="btn btn-danger custom-btn" data-target="cancel">취소하기</button>
                </div>
            </div>
        </form>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/common/summernote.js"></script>
</body>
</html>