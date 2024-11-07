// 칼로리 계산기
function foodFigureCalc() {
    const kcal = document.querySelectorAll('.kcal-figure');
    const carbo = document.querySelectorAll('.carbo-figure');
    const pro = document.querySelectorAll('.pro-figure');
    const fat = document.querySelectorAll('.fat-figure');

    const kcalResult = document.querySelector('.total-kcal');
    const carboResult = document.querySelector('.total-carbo');
    const proResult = document.querySelector('.total-pro');
    const fatResult = document.querySelector('.total-fat');
    
    // kcal 계산
    let totalKcal = 0;
    for (let kcalText of kcal) {
        totalKcal += parseFloat(kcalText.textContent);
    }

    // 탄수화물 계산
    let totalCarbo = 0;
    for (let carboText of carbo) {
        totalCarbo += parseFloat(carboText.textContent);
    }

    // 단백질 계산
    let totalPro = 0;
    for (let proText of pro) {
        totalPro += parseFloat(proText.textContent);
    }

    // 지방 계산
    let totalFat = 0;
    for (let fatText of fat) {
        totalFat += parseFloat(fatText.textContent);
    }

    // 결과 삽입
    kcalResult.innerHTML = totalKcal;
    carboResult.innerHTML = totalCarbo;
    proResult.innerHTML = totalPro;
    fatResult.innerHTML = totalFat;
}

// 음식 삭제 버튼
function foodDeleteBtn(_this) {
    const row = _this.closest('tr');

    row.remove();
}