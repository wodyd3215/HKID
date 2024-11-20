/*swiper */
var swiper = new Swiper(".mySwiper", {
    direction: 'vertical',
      slidesPerView: 3,//보여줄 이미지갯수
      spaceBetween: 15,
      slidesPerGroup: 1,//페이징 그룹핑할 갯수(슬라이드할 이미지 갯수)
      loop: true,
      loopFillGroupWithBlank: true,
      
      navigation: {//좌우 이동 클릭
        nextEl: ".slider__prev",
        prevEl: ".slider__next",
      },
      
    });

      
      
    function buy() {
      const container = document.getElementById('message-container');
  
      // 메시지 생성
      const message = document.createElement('div');
      message.className = 'message';
      message.innerText = '운동을 추가했습니다';
  
      // 메시지 추가
      container.appendChild(message);
  
      // 3초 후 메시지 제거
      setTimeout(() => {
          container.removeChild(message);
      }, 3000);
  }


//   // Swiper에 이미지를 추가하는 함수
//   function addToSwiper(imageSrc) {
//     const swiperWrapper = document.querySelector('.swiper-wrapper');

//     // 새로운 li 요소 생성
//     const newSlide = document.createElement('li');
//     newSlide.classList.add('swiper-slide', 'box-size');

//      // 새로운 img 요소 생성
//     const imgElement = document.createElement('img');
//     imgElement.src = `./resources/image/exerciseImages/${imageSrc}`;
//     imgElement.alt = '새 운동 이미지';
//     imgElement.onclick = function () {
//       removeFromSwiper(newSlide); // 이미지 클릭 시 삭제
//   };

//    // li에 img 추가
//     newSlide.appendChild(imgElement);
//     swiperWrapper.appendChild(newSlide);

//     // Swiper 업데이트
//     const swiperInstance = document.querySelector('.mySwiper').swiper;
//     swiperInstance.update();
// }

// // Swiper에서 이미지를 제거하는 함수
// function removeFromSwiper(slideElement) {
//   slideElement.remove(); // UI에서 해당 슬라이드 제거

//   // Swiper 업데이트
//   const swiperInstance = document.querySelector('.mySwiper').swiper;
//   swiperInstance.update();
// }


// Swiper 초기화 및 LocalStorage에서 데이터 로드
(function initializeSwiper() {
  // LocalStorage에서 이미지 리스트 불러오기
  const savedImages = JSON.parse(localStorage.getItem("selectedImages")) || [];
  savedImages.forEach((image) => addImageToSwiper(image));
  swiper.update(); // Swiper 업데이트
})();

// Swiper에 이미지를 추가하는 함수
function addToSwiper(imageSrc) {
  // Swiper에 이미지 추가
  addImageToSwiper(imageSrc);

  // LocalStorage에 이미지 추가
  const savedImages = JSON.parse(localStorage.getItem("selectedImages")) || [];
  if (!savedImages.includes(imageSrc)) {
      savedImages.push(imageSrc);
      localStorage.setItem("selectedImages", JSON.stringify(savedImages));
  }
}

// Swiper에 이미지를 추가하는 함수 (DOM 업데이트)
function addImageToSwiper(imageSrc) {
  const swiperWrapper = document.querySelector('.swiper-wrapper');

  // 새로운 li 요소 생성
  const newSlide = document.createElement('li');
  newSlide.classList.add('swiper-slide', 'box-size');

  // 새로운 img 요소 생성
  const imgElement = document.createElement('img');
  imgElement.src = `./resources/image/exerciseImages/${imageSrc}`;
  imgElement.alt = '추가된 운동 이미지';
  imgElement.setAttribute("onclick", `removeFromSwiper('${imageSrc}')`); // 삭제 동작 연결

  newSlide.appendChild(imgElement);
  swiperWrapper.appendChild(newSlide);

  // Swiper 업데이트
  swiper.update(); // Swiper에 추가된 슬라이드를 반영
}

// Swiper에서 이미지를 제거하는 함수
function removeFromSwiper(imageSrc) {
  // LocalStorage에서 이미지 제거
  const savedImages = JSON.parse(localStorage.getItem("selectedImages")) || [];
  const updatedImages = savedImages.filter((img) => img !== imageSrc);
  localStorage.setItem("selectedImages", JSON.stringify(updatedImages));

  // UI에서 슬라이드 제거
  const swiperWrapper = document.querySelector('.swiper-wrapper');
  const slides = swiperWrapper.querySelectorAll(`img[src="./resources/image/exerciseImages/${imageSrc}"]`);
  slides.forEach((slide) => slide.parentElement.remove());

  // Swiper 업데이트
  swiper.update(); // Swiper에서 제거된 슬라이드를 반영
}