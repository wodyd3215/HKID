window.onload = function() {
    const checkBox = document.getElementById("all-check"); // 'all-check'라는 ID를 가진 체크박스를 가져옵니다.
    allCheckBtn(checkBox); // 페이지 로드 시 체크박스 상태에 맞게 버튼 상태 초기화
};

function allCheckBtn(checkBox) {
    const enBtn = document.querySelector(".agreeContent button[type='submit']");
    enBtn.disabled = !checkBox.checked;

    const checkList = document.getElementsByName("agreeCheck");

    for (const list of checkList) {
        list.checked = checkBox.checked;
    }

    for (const list of checkList) {
        list.onchange = function() {
            const allCheckBox = document.getElementById("all-check");
            allCheckBox.checked = agreeCheckBox();
        }
    }
}

function agreeCheckBox() {
    const checkList = document.getElementsByName("agreeCheck");

    for (const list of checkList) {
        if (!list.checked) {
            return false;
        }
    }
    return true;
}

