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

// -------------------------------------------------------------------------------------------


function addItem(loginMember){
    const productNo = document.querySelector(".productNo").value;
    const productQuantity = document.querySelector(".quantityBtnText").value;

    const data = {
        memberNo: loginMember,
        productNo : productNo,
        quantity: productQuantity
    };

    addAjaxItem(data, function(res){
    })
}

function addAjaxItem(data, callback){
    $.ajax({
        url:'addCart.c',
        type: 'POST',
        data:data,
        success:function(res){
            alert("장바구니에 담겨졌습니다.");
            callback(res)
        }
    })
}




// 수량 증가 및 감소 버튼
$('.increaseBtn').click(function() {
    let productNo = $(this).closest('.cartQuantity').data('productNo');
    let memberNo = $(this).closest('.cartQuantity').data('memberNo');
    updateQuantity(memberNo, productNo, 1); // 1은 수량 증가
});

$('.decreaseBtn').click(function() {
    let productNo = $(this).closest('.cartQuantity').data('productNo');
    let memberNo = $(this).closest('.cartQuantity').data('memberNo');
    updateQuantity(memberNo, productNo, -1); // -1은 수량 감소
});



// 숫자 3자리 콤마찍기
// Number.prototype.formatNumber = function(){
//     if(this==0) return 0;
//     let regex = /(^[+-]?\d+)(\d)/;
//     let nstr = (this + '');
//     while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
//     return nstr;
// };


function bottomBtn(){
    let valueArr = new Array();
    let list = $("input[name='selectBox']");
    for(let i=0; i<list.length; i++){
        if(list[i].checked){
            valueArr.push(list[i].value);
        }
    }

    if(valueArr.length == 0){
        alert("선택된 상품이 없습니다.");
    } else{
        let chk = confirm("");
        $.ajax({
            url:'delete.c',
            type:'GET',
            data:{valueArr : valueArr},
            success:function(){
               
            }
        })
    }

}


function deleteAll(){
    checkCounts = document.querySelectorAll(".check");
    let lis;

    checkNone(deleteList);

    checkCounts.forEach(check => {
        lis = document.querySelector(""+check.value);
        lis.closest("").remove();
    });

}
