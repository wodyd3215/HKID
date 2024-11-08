<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
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
        <!-- 음식 검색(모달창 오픈) -->
        <div id="food-search-btn">
            <button data-target="search-food-modal" onclick="openModal(event)">검색</button>
        </div>

        <br><br>

        <!-- 음식 영양 정보 테이블 -->
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
                    <td class="kcal-figure">252</td>
                    <td class="carbo-figure">27.29</td>
                    <td class="pro-figure">8.09</td>
                    <td class="fat-figure">12.08</td>
                    <td class="delete-btn"><button onclick="foodDeleteBtn(this)">-</button></td>
                </tr>
                <tr id="food-detail">
                    <td>샌드위치</td>
                    <td class="kcal-figure">252</td>
                    <td class="carbo-figure">27.29</td>
                    <td class="pro-figure">8.09</td>
                    <td class="fat-figure">12.08</td>
                    <td class="delete-btn"><button onclick="foodDeleteBtn(this)">-</button></td>
                </tr>
            </tbody>
        </table>

        <br>
        <div id="food-calc-btn">
            <button onclick="foodFigureCalc()">계산</button>
        </div>

        <br><br><br><br><br>

        <!-- 총 영양 정보 테이블 -->
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
                    <td class="total-kcal"></td>
                    <td class="total-carbo"></td>
                    <td class="total-pro"></td>
                    <td class="total-fat"></td>
                    <td class="delete-btn"></td>
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
    
    <!-- 음식 검색 모달창 -->
    <div class="modal" id="search-food-modal">

        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">
                    <div></div>
                    <h4>음식 검색</h4>
                    <button class="material-symbols-outlined close-btn " onclick="closeModal()">x</button>
                </div>
                
                <div id="searchbar-div">
                    <input type="search" name="" id="board-search-bar" placeholder="음식을 입력해주세요">
                    <button id="search-btn" type="submit">
                        <img id="searchIcon" src="resources/image/searchIcon.png">
                    </button>
                </div>
            </div>

            <!-- 검색된 음식 테이블 -->
            <div class="custom-modal-content">
                <table id="common-table">
                    <thead>
                        <tr id="common-table-header">
                            <th class="type-width35">음식 이름</th>
                            <th class="type-width27">칼로리(kcal)</th>
                            <th class="type-width5"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr id="common-table-body">
                            <td>스테이크</td>
                            <td>620</td>
                            <td id="food-add-btn"><button onclick="foodAddBtn(this)">+</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>