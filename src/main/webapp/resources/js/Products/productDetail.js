 // 초기 수량
 let quantity = 1;

function initProductDetail(contextPath, optional) {
    const imgArr = optional.imgs.split(',');

    drawDetailImg(contextPath, imgArr)
    drawContent(optional.content)
    drawReview(optional.productNo)
}

// 디테일 이미지 가져오기
function drawDetailImg(contextPath, imgArr) {
    imgArr.forEach((img, index) => {
        const imgsArea = $('.detailImg')
        const imgForm = $('<div>').addClass('diImg').click(() => {
            drawRepresentImg(contextPath + imgArr[index])
        })
        const imgArea = $('<img>')

        imgArea.attr('src', contextPath + img)

        imgForm.append(imgArea)
        imgsArea.append(imgForm)
    });

    $('.reImg img').attr('src', contextPath + imgArr[0])
}

// 클릭 시, 대표 이미지 변경
function drawRepresentImg(img) {
    $('.reImg img').attr('src', img)
}

function drawContent(content) {
    $('.contentImg').html(content)
}

function drawReview(productNo) {
    let pageInfo = {
        productNo: productNo,
        currentPage: 1,
        maxPage: null,
    }

    const loadReview = loadReviewAjax(pageInfo, (res) => {
        pageInfo.maxPage = res.maxPage;

        const reviewArea = $('.contentReview')
        reviewArea.children().not('.pageInfo').remove()
        
        $('#currentPage').text(pageInfo.currentPage)

        res.list.forEach((review) => {
            const star = drawStar(review.reviewRate)

            const html = `<div class="review1">
                            <div class="reviewHeader">
                            <div class="reviewUser">${review.nickname}</div>
                            <div class="assessUser">${star}</div>
                            <div class="assessDate">${review.reviewDate}</div>
                          </div>  
                          <div class="reviewImg">
                            <div class="reviImg"></div>
                          </div>
                          <div class="reviewProName">${review.productName}</div>
                            <div>${review.reviewContent}</div>
                          </div>`
            
            reviewArea.append(html);              
        })
    })

    loadReview()

    document.querySelector('.pageInfo #prev').onclick = () => {
        if(pageInfo.currentPage !== 1 && pageInfo.currentPage > 1) {
            pageInfo.currentPage--

            loadReview()
        } else {
            return
        }
    }

    document.querySelector('.pageInfo #next').onclick = () => {
        if(pageInfo.currentPage < pageInfo.maxPage) {
            pageInfo.currentPage++

            loadReview()
        } else {
            return
        }
    }
}

function drawStar(reviewRate) {
    const max = 5
    let star = ''

    for(let i = 0; i < max; i++) {
        if(i < reviewRate) {
            star += '★';
        } else {
            star += '☆'
        }
    }

    return star;
}

function loadReviewAjax(pageInfo, callback) {
    return function() {
        $.ajax({
            type: 'POST',
            url: 'loadReviewAjax',
            data: pageInfo,
            success: callback,
            error: () => {
                console.log('리뷰 조회 실패')
            }
        })
    }
}

 // 증가 함수
 function increaseQuantity() {
     const quantityBtn = document.querySelector(".quantityBtn");
     const maxQuantity = parseInt(quantityBtn.getAttribute("data-max-quantity"), 10); // 최대 재고
     const quanText = quantityBtn.querySelector(".quanText");
     const priceText = document.querySelector(".priceText");
     const unitPrice = parseInt(priceText.getAttribute("data-price"), 10); // 단가 가져오기

     if (quantity < maxQuantity) {
         quantity += 1; // 수량 증가
         quanText.textContent = quantity; // 수량 업데이트
         priceText.textContent = (quantity * unitPrice).toLocaleString() + " 원"; // 총 가격 업데이트
     } else {
         alert("재고가 부족합니다.");
     }
 }

 // 감소 함수
 function decreaseQuantity() {
     const quantityBtn = document.querySelector(".quantityBtn");
     const quanText = quantityBtn.querySelector(".quanText");
     const priceText = document.querySelector(".priceText");
     const unitPrice = parseInt(priceText.getAttribute("data-price"), 10); // 단가 가져오기

     if (quantity > 1) {
         quantity -= 1; // 수량 감소
         quanText.textContent = quantity; // 수량 업데이트
         priceText.textContent = (quantity * unitPrice).toLocaleString() + " 원"; // 총 가격 업데이트
     }
 }

 function activateTab(clickedElement) {
    // 모든 탭 링크에서 'active' 클래스 제거
    const tabs = document.getElementsByClassName("tab-link");
    for (let i = 0; i < tabs.length; i++) {
        tabs[i].classList.remove("active");
    }

    // 클릭된 요소의 부모 중 'tab-link' 클래스가 있는 요소에 'active' 클래스 추가
    const tabLinkElement = clickedElement.closest(".tab-link");
    if (tabLinkElement) {
        tabLinkElement.classList.add("active");
    }
}

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
        
        $('.tabContent').attr('data-offset-top', offsetTop);
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