<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/diet/dietForm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/myDiaryDetail.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="wrapper">
        <div id="diary-title-area">
            <div id="diary-title">목표까지 단 한걸음</div>
            <div id="sub-info-area">
                <div id="sub-info">
                    <div id="writer">개떡도지</div>
                    <div id="enroll-date">2024년 10월 22일</div>
                </div>
                <div id="btn-area">
                    <button>수정</button>
                    <button>삭제</button>
                </div>
            </div>
        </div>
        <div id="my-cal-data-area">
            <div id="today-ate-cal">오늘 섭취한 영양정보~</div>
            <div id="today-ate-cal-info">
                <table class="food-info-table">
                    <thead>
                        <tr id="food-title">
                            <th id="food-kcal">칼로리(kcal)</th>
                            <th id="food-carbo">탄수화물(g)</th>
                            <th id="food-pro">단백질(g)</th>
                            <th id="food-fat">지방(g)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr id="food-detail">
                            <td class="kcal-figure">252</td>
                            <td class="carbo-figure">27.29</td>
                            <td class="pro-figure">8.09</td>
                            <td class="fat-figure">12.08</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="diary-content">
            전달된 컬럼 값을 받아서 함수를 실행한 결과를 반환한다
                        
            [단일행 함수]
            N개의 값을 읽어들여서 N개의 결과 값을 리턴한다.
            매행마다 함수실행 결과를 반환한다.
            
            [LENGTH | LENGTHB]
            문자열의 길이 | 바이트 수를 구한다.
            [표현법]
            
            -- 해당 문자열의 글자 수를 반환한다.
            LENGTH(컬럼 | '문자열') 
            
            -- 해당 문자열의 바이트 수를 반환한다.
            LENGTHB(컬럼 | '문자열')
            
            -- 한글은 글자당 3BYTE, 영문자는 글자당 1BYTE
            [INSTR]
            문자열로부터 특정 문자의 시작 위치를 찾아서 반환한다.
            [표현법]
        </div>
    </div>
</body>
</html>