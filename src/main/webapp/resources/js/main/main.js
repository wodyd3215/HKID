document.addEventListener("DOMContentLoaded", function() {
  var swiper = new Swiper(".mySwiper", {
    slidesPerView: 1,
    spaceBetween: 30,
    loop: true,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
  });
});


document.addEventListener("DOMContentLoaded", function() {
  document.getElementById("btn").addEventListener("click", function() {
      const heightInput = document.getElementById("height").value;
      const weightInput = document.getElementById("weight").value;
      const height = parseFloat(heightInput) / 100; // cm to meters
      const weight = parseFloat(weightInput);
      const isMale = document.getElementById("man").checked;
      const isFemale = document.getElementById("woman").checked;

      if (!height || !weight || (!isMale && !isFemale)) {
          document.getElementById("result").innerHTML = "모든 정보를 입력해주세요.";
          document.getElementById("result").style.color = "red";
          return;
      }

      const bmi = weight / (height * height);
      let category = "";
      let color = "";
      let position = 0;

      // 성별에 따른 BMI 기준 설정
      if (isMale) {
          // 남성 기준
          if (bmi < 20) {
              category = "저체중";
              color = "blue";
              position = (bmi / 20) * 20;
          } else if (bmi < 25) {
              category = "정상 체중";
              color = "green";
              position = 20 + ((bmi - 20) / 5) * 30;
          } else if (bmi < 30) {
              category = "과체중";
              color = "orange";
              position = 50 + ((bmi - 25) / 5) * 20;
          } else {
              category = "비만";
              color = "red";
              position = 70 + ((bmi - 30) / 10) * 30;
          }
      } else if (isFemale) {
          // 여성 기준
          if (bmi < 19) {
              category = "저체중";
              color = "blue";
              position = (bmi / 19) * 20;
          } else if (bmi < 24) {
              category = "정상 체중";
              color = "green";
              position = 20 + ((bmi - 19) / 5) * 30;
          } else if (bmi < 29) {
              category = "과체중";
              color = "orange";
              position = 50 + ((bmi - 24) / 5) * 20;
          } else {
              category = "비만";
              color = "red";
              position = 70 + ((bmi - 29) / 10) * 30;
          }
      }

      // 결과 표시 및 색상 적용
      document.getElementById("result").innerHTML = 
          `<p>비만도 결과: ${category}</p><p>BMI 지수: ${bmi.toFixed(1)}</p>`;
      document.getElementById("result").style.color = color;

      // BMI 막대 그래프에 현재 BMI 위치 표시
      const currentBmiElement = document.getElementById("current-bmi");
      currentBmiElement.innerHTML = `BMI: ${bmi.toFixed(1)}`;
      currentBmiElement.style.left = `calc(${position}% - 30px)`; // -30px은 BMI 텍스트 크기 보정
  });

  // 초기화 버튼 기능
  document.getElementById("btn2").addEventListener("click", function() {
      document.getElementById("height").value = "";
      document.getElementById("weight").value = "";
      document.getElementById("man").checked = false;
      document.getElementById("woman").checked = false;
      document.getElementById("result").innerHTML = "<p>비만도 결과</p><br><p>BMI 지수</p>";
      document.getElementById("result").style.color = "black"; // 초기 색상
      document.getElementById("current-bmi").innerHTML = "BMI";
      document.getElementById("current-bmi").style.left = "0";
  });
});

