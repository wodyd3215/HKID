// 상세정보, 리뷰 클릭 시 메뉴 이동
// function moveScroll(name) {
//     // 클릭 시 메뉴 색깔 바뀜
//     let input = document.getElementById(name);
//     if (input){
//         input.checked = true;
//         console.log("Radio button '" + name + "' is checked."); // 디버깅용
//     } else {
//         console.log("Radio button with id '" + name + "' not found.");
//     }

//     // location 오타 수정 및 디버깅용 콘솔 로그 추가
//     let location = document.querySelector("." + name);
    
//     if (location) { // 요소가 존재하는지 확인
//         let offsetTop = location.offsetTop;
//         console.log("Offset top for", name, ":", offsetTop); // 디버깅용
//         window.scrollTo({ top: offsetTop, behavior: 'smooth' });
//     } else {
//         console.log("Element with class '" + name + "' not found.");
//     }

    
// }



$('.tab > ul > li > a').click(function(e) {
    let href = $(this).attr('href');

    let targetTop = $(href).offset().top;

    $('html, body').stop().animate({scrollTop:targetTop}, 300);
    
    e.preventDefault();
});

function Page__updateIndicatorActive() {
    let scrollTop = $(window).scrollTop();
    
    // 역순으로 검색해야 편하다
    $($('.tabContent').get().reverse()).each(function(index, node) {
        let $node = $(this);
        let offsetTop = parseInt($node.attr('data-offset-top'));
        
        if ( scrollTop >= offsetTop ) {
            // 기존 녀석에게 활성화 풀고
            $('.tab > ul > li.active').removeClass('active');
            // 해당하는 녀석에게 활성화 넣고
            
            let currentPageIndex = $node.index();
            $('.tab > ul > li').eq(currentPageIndex).addClass('active');
            
            $('html').attr('data-current-page-index', currentPageIndex);
            
            return false; // 더 이상 다른 페이지를 검사하지 않는다.
        }
    });
}

// 각 페이지의 offsetTop 속성을 업데이트
function Page__updateOffsetTop() {
    
    $('.tabContent').each(function(index, node) {
        let $page = $(node);
        let offsetTop = $page.offset().top;
        
        $tabContent.attr('data-offset-top', offsetTop);
    });
    
    // 계산이 바뀌었으니까, 다시 상태 업데이트
    Page__updateIndicatorActive();
}

function Page__init() {
    Page__updateOffsetTop();
}

// 초기화
Page__init();

// 화면이 리사이즈 할 때 마다, offsetTop을 다시계산
$(window).resize(Page__updateOffsetTop);

// 스크롤이 될 때 마다, 인디케이터의 상태를 갱신
$(window).scroll(Page__updateIndicatorActive);