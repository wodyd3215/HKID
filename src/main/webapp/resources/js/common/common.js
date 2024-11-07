// 요소를 보여주고 숨겨주는 라이브러리
function showAndHideElement(selector){
    // selector가 받은 클래스를 탐색
    const showAndHideEl = document.querySelector(selector);

    // classList 함수를 사용하여 해당 클래스에 hide클래스가 포함되어 있는지 탐색(있다면 true 없다면 false)
    if(showAndHideEl.classList.contains("hide")){
        // if가 true라면 해당 클래스에서 hide클래스를 제거
        showAndHideEl.classList.remove("hide");
    } else {
        // if가 false라면 해당 클래스에 hide클래스를 추가
        showAndHideEl.classList.add("hide");
    }
}

// 요소를 보여주고 숨겨주는 라이브러리
function showAndHideElement2(selector, selector2){

    // selector가 받은 클래스를 탐색
    const showAndHideEl = document.querySelector(selector);
    const showAndHideEl2 = document.querySelector(selector2);

    // classList 함수를 사용하여 해당 클래스에 hide클래스가 포함되어 있는지 탐색(있다면 true 없다면 false)
    if(showAndHideEl.classList.contains("hide")){
        // if가 true라면 해당 클래스에서 hide클래스를 제거
        showAndHideEl2.classList.add("hide");
        showAndHideEl.classList.remove("hide");
    }
}