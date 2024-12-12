function loadTodayCal() {
    const kcalArea = $('#today-ate-cal-info')
    kcalArea.empty()

    let isLoad = false

    loadDietAjax((res) => {
        drawTableDiet(res)
    })
}

function loadDietAjax(callback) {
    $.ajax({
        url: "loadDietAjax",
        type: 'POST',
        success: callback,
        error: () => {
            console.log('영양 정보 조회 실패')
        }
    })
}

function drawTableDiet(calLog) {
    const calInfo = $('#today-ate-cal-info')
    if(calLog) {
        const str = `<table class="food-info-table">
                        <thead>
                            <tr id="food-title">
                                <th id="food-kcal">칼로리(kcal)</th>
                                <th id="food-carbo">탄수화물(g)</th>
                                <th id="food-pro">단백질(g)</th>
                                <th id="food-fat">지방(g)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="food-detail">
                                <td class="kcal-figure">${calLog.totalKcal}</td>
                                <td class="carbo-figure">${calLog.totalCarbo}</td>
                                <td class="pro-figure">${calLog.totalProtein}</td>
                                <td class="fat-figure">${calLog.totalFat}</td>
                            </tr>
                        </tbody>
                    </table>`

        $('input[name="foodNo"]').val(calLog.foodNo)

        calInfo.append(str)
    } else {
        alert("조회 정보가 없습니다.")
        return
    }

}