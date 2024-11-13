function initDiaryPage() {
    dummyDateInsert()
    infinitiscroll()
}

function dummyDateInsert() {
    $('.list-area').empty()

    const str = `<div class="my-content">
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
                </div>`

    for(let i = 0; i < 10; i++) {
        $('.list-area').append(str)
    }
}

function infinitiscroll() {
    // $(window).scrollTop() : 스크롤이 시작하는 부분부터 스크롤바 맨 위 부분의 사이 간격(스크롤바 맨 위 부분 위치)
    // $(window).height() : 우리가 보는 화면 크기(100vh)
    // $(document).height() : 전체(모든 요소 포함) 화면 크기

    $(window).on("scroll", function() {
        if($('.list-area .my-content').length < 30 && $(window).scrollTop() + $(window).height() > $(document).height() - 100) {
            for(let i = 0; i < 5; i++) {
                $('.list-area').append(`<div class="my-content">
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
                </div>`)
            }
        }
    })
}