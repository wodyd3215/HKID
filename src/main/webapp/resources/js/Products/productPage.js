function initProduct() {
    initCategory()
    drawReviewAvg()

}

function productView(viewType) {
    return false;
    // 상품 및 중고 상품 div 요소를 변수로 저장
    const storeItemDiv = document.getElementById("storeItemDiv");
    const usedItemDiv = document.getElementById("usedItemDiv");

    // 전달받은 viewType 값에 따라 화면 표시 변경
    if (viewType === 'store') {
        storeItemDiv.style.display = "block";
        usedItemDiv.style.display = "none";
    } else if (viewType === 'used') {
        storeItemDiv.style.display = "none";
        usedItemDiv.style.display = "block";
    }

    
}

function initCategory() {
    const urlParams = new URLSearchParams(window.location.search);
    const selectedCategory = urlParams.get("category"); // 단일 값 가져오기

    if (selectedCategory) {
        const radiobox = document.querySelector(`input[name="category"][value="${selectedCategory}"]`);
        if (radiobox) {
            radiobox.checked = true;
        }
    }
};

function drawReviewAvg() {
    const textStars = document.querySelectorAll('.textStar')

    textStars.forEach(textstar => {
        const star = drawStar(textstar.getAttribute('data-star'))
        const count = '(' + textstar.getAttribute('data-count') + ')'

        textstar.innerText = star + ' ' + count
    });
    
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