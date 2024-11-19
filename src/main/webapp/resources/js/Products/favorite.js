// 클릭 시 모든 체크박스 버튼이 눌림
function selectAll(selectAll){
    const checkboxes = document.querySelectorAll('input[type="checkBox"]');

    checkboxes.forEach((checkbox) =>{
        checkbox.checked = selectAll.checked
    })
}

