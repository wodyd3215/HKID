(function () {
    var noticeRow = document.getElementById("noticeRow");

    // 첫 번째 셀의 내용 확인
    var category = noticeRow.querySelector(".board-category").textContent.trim();
    var title = noticeRow.querySelector("a").textContent.trim();

    // 값이 없으면 숨기기
    if (!category || !title) {
        noticeRow.style.display = "none";
    }
})();