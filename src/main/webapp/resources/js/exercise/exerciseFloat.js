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
  const savedNames = JSON.parse(localStorage.getItem("exNames")) || [];

  savedImages.forEach((image, index) => {
    addImageToSwiper(image, savedNames[index]); // 이미지와 운동 이름을 함께 추가
  });
  swiper.update(); // Swiper 업데이트
})();

function addToSwiper(imageSrc, exName) {
  // Swiper에 이미지 추가
  addImageToSwiper(imageSrc, exName);

  // 운동 이름 및 이미지 저장
  saveToLocalStorage("selectedImages", imageSrc);
  saveToLocalStorage("exNames", exName);

  console.log(exName);
}

// LocalStorage에 데이터를 저장하는 함수
function saveToLocalStorage(key, value) {
  const savedData = JSON.parse(localStorage.getItem(key)) || [];
  if (!savedData.includes(value)) {
    savedData.push(value);
    localStorage.setItem(key, JSON.stringify(savedData));
  }
}

// Swiper에 이미지를 추가하는 함수 (DOM 업데이트)
function addImageToSwiper(imageSrc, exName) {
  const swiperWrapper = document.querySelector('.swiper-wrapper');

  // 새로운 li 요소 생성
  const newSlide = document.createElement('li');
  newSlide.classList.add('swiper-slide', 'box-size');

  // 새로운 img 요소 생성
  const imgElement = document.createElement('img');
  imgElement.src = `./resources/image/exerciseImages/${imageSrc}`;
  imgElement.alt = exName;
  imgElement.setAttribute("onclick", `removeFromSwiper('${imageSrc}', '${exName}')`); // 삭제 동작 연결

  newSlide.appendChild(imgElement);
  swiperWrapper.appendChild(newSlide);

  // Swiper 업데이트
  swiper.update(); // Swiper에 추가된 슬라이드를 반영
}

// Swiper에서 이미지를 제거하는 함수
function removeFromSwiper(imageSrc, exName) {
  // LocalStorage에서 이미지 제거
  const savedImages = JSON.parse(localStorage.getItem("selectedImages")) || [];
  const savedNames = JSON.parse(localStorage.getItem("exNames")) || [];

  const updatedImages = savedImages.filter((img) => img !== imageSrc);
  const updatedNames = savedNames.filter((name) => name !== exName);

  localStorage.setItem("selectedImages", JSON.stringify(updatedImages));
  localStorage.setItem("exNames", JSON.stringify(updatedNames));

  // UI에서 슬라이드 제거
  const swiperWrapper = document.querySelector('.swiper-wrapper');
  const slides = swiperWrapper.querySelectorAll(`img[src="./resources/image/exerciseImages/${imageSrc}"]`);
  slides.forEach((slide) => slide.parentElement.remove());

  // Swiper 업데이트
  swiper.update(); // Swiper에서 제거된 슬라이드를 반영
}


// DOM 요소 가져오기
const ulElement = document.querySelector('.swiper-wrapper');
const instructionElement = document.getElementById('instruction');

// 초기 상태의 <p> 내용 저장
const initialContent = instructionElement.innerHTML;

// 텍스트 변경 함수
function changeText(newContent) {
    // 상태 저장
    localStorage.setItem('instructionContent', newContent);

    // 변경 효과
    instructionElement.innerHTML = newContent;
}

// 초기 상태 설정 함수
function initializeContent() {
    const savedContent = localStorage.getItem('instructionContent');

    if (savedContent) {
        // 저장된 상태가 있으면 적용
        instructionElement.innerHTML = savedContent;
    } else {
        // 저장된 상태가 없으면 기본값 사용
        instructionElement.innerHTML = initialContent;
    }
}

// MutationObserver 설정
if (instructionElement && ulElement) {
    // 초기 상태 설정
    initializeContent();

    const observer = new MutationObserver(() => {
        if (ulElement.children.length > 0) {
            changeText(`<a href="#">AI가 짜주는 운동루틴!</a>`);
        } else {
            changeText(initialContent);
        }
    });

    // <ul> 요소에 MutationObserver 연결
    observer.observe(ulElement, { childList: true });
} else {
    console.error("필수 요소를 찾을 수 없습니다.");
}
