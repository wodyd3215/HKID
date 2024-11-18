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
    kcalResult.innerHTML = totalKcal.toFixed(1);
    carboResult.innerHTML = totalCarbo.toFixed(1);
    proResult.innerHTML = totalPro.toFixed(1);
    fatResult.innerHTML = totalFat.toFixed(1);
}

// 음식 삭제 버튼
function foodDeleteBtn(_this) {
    const row = _this.closest('tr');

    row.remove();
}

// 음식 추가 버튼
function foodAddBtn(_this) {
    // 새로운 행을 만들기
    const newRow = document.createElement('tr');
    newRow.id = 'food-detail';

    // 기존 행에서 td를 복사해서 새로운 행에 추가
    // 이후 AJAX로 요청받은 데이터 그려서 넣기
    newRow.innerHTML = `
        <td>스테이크</td>
        <td class="kcal-figure">620.0</td>
        <td class="carbo-figure">9.0</td>
        <td class="pro-figure">18.9</td>
        <td class="fat-figure">14.6</td>
        <td class="delete-btn"><button onclick="foodDeleteBtn(this)">-</button></td>
    `;
    
    // 기존 테이블의 tbody에 새 행 추가
    const tbody = document.querySelector('tbody');
    tbody.appendChild(newRow);
}

// 음식 검색 리스트
function searchFoodList() {
    const food = $("#diet-search-bar").val()
    console.log("Food:" + food);

    getFoodList({food: food}, function(foodList){
        const itemList = foodList.response.body.items;

        console.log("itemList : " + itemList);
        // drawFoodBody(document.querySelector("#common-table tbody"), itemList);
    })
}

function getFoodList(data, callback) {
    $.ajax({
        url : "foods",
        data : data,
        success : callback,
        error : function() {
            console.log("음식 정보 api 요청 실패")
        }
    })
}

// function drawFoodBody(parent, itemArr) {
//     parent.innerHTML = "";

//     for(const item of itemArr){
//         parent.innerHTML += ("<tr>"
//                                 + "<td>" + item. + "</td>"
//                             + "<tr>")
//     }
// }