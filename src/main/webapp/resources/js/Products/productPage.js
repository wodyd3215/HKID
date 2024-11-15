function productView(viewType) {
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