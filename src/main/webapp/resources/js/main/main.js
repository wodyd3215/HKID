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

// 지역선택 기능
function categoryChange(e) {
    const state = document.getElementById("state");
  
    const gangwon = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
    const gyeonggi = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
    const gyeongsangnam = ["거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시", "진해시", "창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군", "하동군", "함안군", "함양군", "합천군"];
    const gyeongsangbuk = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
    const gwangju = ["광산구", "남구", "동구", "북구", "서구"];
    const daegu = ["남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군"];
    const daejeon = ["대덕구", "동구", "서구", "유성구", "중구"];
    const busan = ["강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
    const seoul = ["강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
    const ulsan = ["남구","동구","북구","중구","울주군"];
    const incheon = ["계양구","남구","남동구","동구","부평구","서구","연수구","중구","강화군","옹진군"];
    const jeonnam = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
    const jeonbuk = ["군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군"];
    const jeju = ["서귀포시","제주시","남제주군","북제주군"];
    const chungbuk = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
    
  
    if (e.value == "general01") {
      add = gangwon;
    } else if (e.value == "general02") {
      add = gyeonggi;
    } else if (e.value == "general03") {
      add = gyeongsangnam;
    } else if (e.value == "general04") {
      add = gyeongsangbuk;
    } else if (e.value == "general05") {
      add = gwangju;
    } else if (e.value == "general06") {
      add = daegu;
    } else if (e.value == "general07") {
      add = daejeon;
    } else if (e.value == "general08") {
      add = busan;
    } else if (e.value == "general09") {
      add = seoul;
    } else if (e.value == "general10") {
      add = ulsan;
    } else if (e.value == "general11") {
      add = incheon;
    } else if (e.value == "general12") {
      add = jeonnam;
    } else if (e.value == "general13") {
      add = jeonbuk;
    } else if (e.value == "general14") {
      add = jeju;
    } else if (e.value == "general15") {
      add = chungnam;
    } else if (e.value == "general16") {
      add = chungbuk;
    }
  
    state.options.length = 1;
    // 군/구 갯수;
  
      for (property in add) {
          let opt = document.createElement("option");
          opt.value = add[property];
          opt.innerHTML = add[property];
          state.appendChild(opt);
      }
  }

const dayNight = document.querySelector('#dayNight');

const locationName = document.querySelector('#location');
const timeText = document.querySelector('#time');

const mainIcon = document.querySelector('#mainIcon');
const tempText = document.querySelector('#temperature');
const WeatherInfoText = document.querySelector('#WeatherInfo');

const windText = document.querySelector('#wind');
const humidityText = document.querySelector('#humidity');

// 시계 구현

function clock(){
  const now = new Date();
  
  const day = now.getDay();
  const week = ['일', '월', '화', '수', '목', '금', '토'];
  let hours = now.getHours();
  const minutes = now.getMinutes();

  let ampm =  '';
  if(hours > 12){
    hours -= 12;
    ampm = '오후';
  }else ampm = '오전';

  // 화, 오후 12:36
  timeText.innerText = `${week[day]}, ${ampm} ${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}`

   // 현재시간 초로
   let nowSecTime = now.getHours()*3600 + now.getMinutes()*60 + now.getSeconds();
   return nowSecTime
  
}

// // 1초마다 시간 실행
(() => {
  clock();
  setInterval(clock, 1000);
})();
    
 

// 위도, 경도
navigator.geolocation.getCurrentPosition((position) => {
    const lat = position.coords.latitude; // 위도
    const lon = position.coords.longitude; // 경도
    showWeather(lat, lon)
  });
  
  // 날씨 데이터 가져오기
  async function weatherData(lat, lon){
    const res = await fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=e2fb79919cc09bf2b401929864ad7cd1`);
    const data = await res.json();
  
    return data;
  }
  
  // 필요한 날씨 데이터 사용
  async function showWeather(lat, lon){
    const data = await weatherData(lat, lon);
    console.log(data);

    const temp = data.main.temp // 온도
    const cityName = data.name; // 도시 이름
    const weather = data.weather[0].main // 날씨
    const icon = data.weather[0].icon // 날씨 아이콘
    const windSppeed = data.wind.speed; // 풍속
    const humidity = data.main.humidity; // 습도
    const sunrise = data.sys.sunrise; // 일출시간
    const sunset = data.sys.sunset; // 일몰시간

    locationName.innerText = `${cityName}`
    
    tempText.innerText = `${Math.floor(temp - 273.15)}°`
    WeatherInfoText.innerText = `${weather}`

    windText.innerText = `${Math.floor(windSppeed)}m / s`
    humidityText.innerText = `${humidity}%`

    const sunTime = unixChange(sunrise, sunset);
    const dayAndNight = dayNightChange(sunTime['sunrise'], sunTime['sunset'], clock());
    
    skyconWeather(icon, dayAndNight);
  }

  // 유닉스시간 일반시간으로 변경 -> 초시간으로 변경
function unixChange(sunrise, sunset){
    const sunriseDate = new Date(sunrise*1000);
    const sunsetDate = new Date(sunset*1000);
  
    // 일반시간 시, 분, 초를 다 합산하여 초로 만들기
    const sunriseSec = sunriseDate.getHours()*3600 + sunriseDate.getMinutes()*60 + sunriseDate.getSeconds();
    const sunsetSec = sunsetDate.getHours()*3600 + sunsetDate.getMinutes()*60 + sunsetDate.getSeconds();
  
    return {'sunrise': sunriseSec, 'sunset': sunsetSec}
  }
  
  // 낮, 밤 구현하기
  function dayNightChange(sunrise, sunset, now){
    if(now >= sunrise && now < sunset){
      dayNight.classList.remove('night');
      dayNight.classList.add('day');
      return 1;
    }else{
      dayNight.classList.remove('day');
      dayNight.classList.add('night');
      return 0;
    }
  }
  
  // 날씨데이터에 따라 skycon적용
  function skyconWeather(icon, dayAndNight){
    const iconNum = icon.slice(0, -1);
    const weatherData = {
      '01' : ['clear-day', 'clear-night'],
      '02' : ['partly-cloudy-day', 'partly-cloudy-night'],
      '03' : 'cloudy',
      '04' : 'cloudy',
      '09' : 'rain',
      '10' : 'rain',
      '13' : 'snow',
      '50' : 'fog',
    }
  
    let skyconName = '';
    if(iconNum === '01' || iconNum === '02'){
      skyconName = dayAndNight ? weatherData[iconNum][0] : weatherData[iconNum][1];
    }else{
      skyconName = weatherData[iconNum];
    }
  
    let icons = new Skycons({'color': dayAndNight ? '#2B323C' : '#DBE2EA'});
    icons.set(mainIcon, skyconName);
    icons.play();
  }