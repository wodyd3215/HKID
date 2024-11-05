<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/diet/dietForm.css">
    <script src="${pageContext.request.contextPath}/resources/js/diet/dietForm.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <br>

    <div class="wrapper">
        <div id="food-btn-area">
            <button id="food-search-btn">검색</button>
        </div>

        <br><br>

        <table>
            <thead>
                <tr>
                    <th>음식 이름(100g)</th>
                    <th>칼로리(kcal)</th>
                    <th>탄수화물(g)</th>
                    <th>단백질(g)</th>
                    <th>지방</th>
                    <th></th>
                </tr>
            </thead>
            <!-- 반복 -->
            <tbody>
                <tr>
                    <td>샌드위치</td>
                    <td>252 kcal</td>
                    <td>27.29 g</td>
                    <td>8.09 g</td>
                    <td>12.08 g</td>
                    <td><button>-</button></td>
                </tr>
            </tbody>
        </table>

        <br>
    
        <button>계산</button>

        <br><br><br><br>

        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>총 칼로리(kcal)</th>
                    <th>총 탄수화물(g)</th>
                    <th>총 단백질(g)</th>
                    <th>총 지방(g)</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>오늘 드신 음식의 영양정보는</td>
                    <td>1,512 kcal</td>
                    <td>163.74 g</td>
                    <td>48.54 g</td>
                    <td>72.48 g</td>
                </tr>
            </tbody>
        </table>

        <br>
        
        <button>저장</button>
    </div>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>