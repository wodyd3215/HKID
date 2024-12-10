// 클릭 시 모든 체크박스 버튼이 눌림
function selectAll(checkbox){

    const selectall = document.querySelector('input[name="selectall"]');
  
  if(checkbox.checked === false)  {
    selectall.checked = false;
  }

}


function selectAll(selectAll)  {
    const checkboxes = document.getElementsByName('selectBox');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  })
}

function checkSelectAll(checkbox) {
    const selectAllCheckbox = document.querySelector('input[name="selectBox"][onclick="selectAll(this)"]');
    const checkboxes = document.querySelectorAll('input[name="selectBox"]:not([onclick="selectAll(this)"])');

    // 모든 체크박스가 체크되었는지 확인
    const allChecked = Array.from(checkboxes).every((cb) => cb.checked);

    // 전체 체크박스의 상태를 업데이트
    selectAllCheckbox.checked = allChecked;
}

