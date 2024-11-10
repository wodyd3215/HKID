<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member/myDiaryPage.css">
</head>
<body>
    <jsp:include page="../common/header.jsp" />
    <div class="wrapper">
        <div id="side-navi">
            <div id="side-title">태그 목록</div>
            <div id="title-list">
                <div>나의 일기</div>
            </div>
        </div>
        <div id="content-area">
            <div id="btn-area"><a href="diaryEnroll.me" class="btn btn-primary custom-btn">글쓰기</a></div>
            <div class="list-area">
                <div class="img-area">
                    <img src="${pageContext.request.contextPath}/resources/image/3b579a9bc531180d72a68a9686c6da3b.jpg" alt="">
                </div>
                <div class="content-area">
                    <div class="diary-title"><a href="myDiary.me">목표까지 단 한걸음</a></div>
                    <p class="diary-content">[함수-FUNCTION]
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
                    </p>
                    <div class="enroll-date">2024년 10월 22일</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>