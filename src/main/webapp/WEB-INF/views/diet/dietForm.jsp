<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/modal.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/diet/dietForm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/diet/dietFormModal.css">
    <script src="${pageContext.request.contextPath}/resources/js/diet/dietForm.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <br><br>

    <div class="wrapper">
        <h1>영양</h1>
        <br>

        <div id="food-search-btn">
            <button data-target="test-modal" onclick="openModal(event)">검색</button>
        </div>

        <br><br>

        <table class="food-info-table">
            <thead>
                <tr id="food-title">
                    <th id="food-name">음식 이름(100g)</th>
                    <th id="food-kcal">칼로리(kcal)</th>
                    <th id="food-carbo">탄수화물(g)</th>
                    <th id="food-pro">단백질(g)</th>
                    <th id="food-fat">지방(g)</th>
                    <th id="food-btn"></th>
                </tr>
            </thead>
            <!-- 반복 -->
            <tbody>
                <tr id="food-detail">
                    <td>샌드위치</td>
                    <td>252 kcal</td>
                    <td>27.29 g</td>
                    <td>8.09 g</td>
                    <td>12.08 g</td>
                    <td id="delete-btn"><button>-</button></td>
                </tr>
            </tbody>
        </table>

        <br>
        
        <div id="food-calc-btn">
            <button>계산</button>
        </div>

        <br><br><br><br><br>

        <table class="food-info-table">
            <thead>
                <tr id="food-title">
                    <th id="food-name"></th>
                    <th id="food-kcal">총 칼로리(kcal)</th>
                    <th id="food-carbo">총 탄수화물(g)</th>
                    <th id="food-pro">총 단백질(g)</th>
                    <th id="food-fat">총 지방(g)</th>
                    <th id="food-btn"></th>
                </tr>
            </thead>
            <!-- 반복 -->
            <tbody>
                <tr id="food-detail">
                    <td>오늘 드신 음식의 영양정보는</td>
                    <td>1,512 kcal</td>
                    <td>163.74 g</td>
                    <td>48.54 g</td>
                    <td>72.48 g</td>
                    <td id="delete-btn"></td>
                </tr>
            </tbody>
        </table>

        <br>
        
        <div id="food-save-btn">
            <button>저장</button>
        </div>

    </div>
    
    <br>

    <jsp:include page="../common/footer.jsp" />
    
    <!-- modal -->
    <div class="modal" id="test-modal">

        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">음식 검색</div>

                <div id="searchbar-div">
                    <input type="search" name="" id="board-search-bar" placeholder="음식을 입력해주세요">
                    <button id="search-btn" type="submit">
                        <img id="searchIcon" src="resources/image/searchIcon.png">
                    </button>
                </div>
            </div>
            <div class="custom-modal-content">
            </div>
        </div>
    </div>
</body>
</html>