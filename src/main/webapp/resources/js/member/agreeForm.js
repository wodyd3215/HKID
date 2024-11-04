function allCheckBtn(checkBox) {
    const enBtn = document.querySelector(".agreeContent button[type='submit']");
    enBtn.disabled = !checkBox.checked;

    const allBtn = checkBox.checked;
    const checkList = document.getElementsByName("agreeCheck");

    for (const list of checkList) {
        list.checked = allBtn;
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

