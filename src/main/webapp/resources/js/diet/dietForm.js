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
    kcalResult.innerHTML = Math.floor(totalKcal);
    carboResult.innerHTML = totalCarbo.toFixed(0);
    proResult.innerHTML = totalPro.toFixed(0);
    fatResult.innerHTML = totalFat.toFixed(0);
}

// 음식 삭제 버튼
function foodDeleteBtn(_this) {
    const row = _this.closest('tr');

    row.remove();
}

// 음식 검색 리스트
function searchFoodList() {
    const food = $("#diet-search-bar").val();
    const tbody = document.querySelector("#common-table tbody");
    console.log("Food:" + food);

    tbody.innerHTML = ("<tr class='container mt-3'>"
                            + "<td id='table-spinner' colspan='3'>"
                                + "<div class='spinner-border'>" + "</div>"
                            + "</td>"
                        + "</tr>");

    getFoodList({food: food}, function(itemList){
        console.log(itemList);
        drawFoodBody(tbody, itemList);
    })
}

function getFoodList(data, callback) {
    console.log(data);
    $.ajax({
        url : "foods",
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',       
        data : data,
        success : function(result) {
            console.log(result.body.items)
            callback(result.body.items)
        },
        error : function() {
            console.log("음식 정보 api 요청 실패")
        }
    })
}

function drawFoodBody(parent, itemArr) {
    parent.innerHTML = "";

    for(const item of itemArr){
        parent.innerHTML += ("<tr id='common-table-body'>"
                                + "<td>" + item.FOOD_NM_KR + "</td>"
                                + "<td>" + Math.floor(item.AMT_NUM1) + "</td>"
                                + "<td id='food-add-btn'>" 
                                    + "<button onclick='foodAddBtn(" + JSON.stringify(item) + ")'>" + "+" + "</button>" 
                                + "</td>"
                            + "</tr>")
    }
}

// 음식 추가 버튼
function foodAddBtn(item) {
    // 새로운 행을 만들기
    const newRow = document.createElement('tr');
    newRow.id = 'food-detail';

    // 기존 행에서 td를 복사해서 새로운 행에 추가
    // 이후 AJAX로 요청받은 데이터 그려서 넣기
    newRow.innerHTML = (
        "<td>" + item.FOOD_NM_KR + "</td>"
        + "<td class='kcal-figure'>" + Math.floor(item.AMT_NUM1) + "</td>"
        + "<td class='carbo-figure'>" + Math.floor(item.AMT_NUM7) + "</td>"
        + "<td class='pro-figure'>" + Math.floor(item.AMT_NUM3) + "</td>"
        + "<td class='fat-figure'>" + Math.floor(item.AMT_NUM4) + "</td>"
        + "<td class='delete-btn'>" + "<button onclick='foodDeleteBtn(this)'>" + "-" + "</button>" + "</td>"
        );
    
    // 기존 테이블의 tbody에 새 행 추가
    const tbody = document.querySelector('tbody');
    tbody.appendChild(newRow);
}

function saveDietInfo(){
    const kcal = document.querySelector(".total-kcal").innerText;
    const carbo = document.querySelector(".total-carbo").innerText;
    const protein = document.querySelector(".total-pro").innerText;
    const fat = document.querySelector(".total-fat").innerText;
    
    location.href = `saveDietInfo.ca?totalKcal=${Number(kcal)}&totalCarbo=${Number(carbo)}&totalProtein=${Number(protein)}&totalFat=${Number(fat)}`;
}