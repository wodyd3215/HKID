// 상세정보, 리뷰 클릭 시 메뉴 이동
function moveScroll(name) {
    // location 오타 수정 및 디버깅용 콘솔 로그 추가
    var location = document.querySelector("." + name);
    
    if (location) { // 요소가 존재하는지 확인
        var offsetTop = location.offsetTop;
        console.log("Offset top for", name, ":", offsetTop); // 디버깅용
        window.scrollTo({ top: offsetTop, behavior: 'smooth' });
    } else {
        console.log("Element with class '" + name + "' not found.");
    }

    // 클릭 시 메뉴 색깔 바뀜
    var input = document.getElementById(name);
    if (input){
        input.checked = true;
        console.log("Radio button '" + name + "' is checked."); // 디버깅용
    } else {
        console.log("Radio button with id '" + name + "' not found.");
    }
}


