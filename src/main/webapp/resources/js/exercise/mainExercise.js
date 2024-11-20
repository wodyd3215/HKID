window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    const selectedParts = urlParams.getAll("part");
    const selectedDifficulties = urlParams.getAll("difficulty");

    // 부위별 선택 유지
    selectedParts.forEach(part => {
        const checkbox = document.querySelector(`input[name="part"][value="${part}"]`);
        if (checkbox) {
            checkbox.checked = true;
        }
    });

    // 난이도 선택 유지
    selectedDifficulties.forEach(difficulty => {
        const checkbox = document.querySelector(`input[name="difficulty"][value="${difficulty}"]`);
        if (checkbox) {
            checkbox.checked = true;
        }
    });
};


/*swiper */
var swiper = new Swiper(".mySwiper", {
    direction: 'vertical',
      slidesPerView: 3,//보여줄 이미지갯수
      spaceBetween: 15,
      slidesPerGroup: 1,//페이징 그룹핑할 갯수(슬라이드할 이미지 갯수)
      loop: true,
      loopFillGroupWithBlank: true,
      /*하단 ... 페이징 ui 표시 여부
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      */
      navigation: {//좌우 이동 클릭
        nextEl: ".slider__prev",
        prevEl: ".slider__next",
      },
      
      
    });