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

function updateQuantity(memberNo, productNo, productQuantity){    
    $.ajax({
        url:'/qchange',
        type:'POST',
        data:{
            memberNo : memberNo,
            productNo: productNo,
            productQuantity : productQuantity
        },
        success: function(response){
                // 수량 업데이트
                $('#quantity' + productNo).text(response.newQuantity);

                // 총 금액 업데이트
                $('#totalPrice').text(response.totalPrice);
            
        }, error: function(){
            alert('서버 요청 중 오류가 발생하였습니다.');
        }
    });
}

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
            type:"POST",
            data:{valueArr : valueArr},
            success:function(){
                callback
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

$(function(){
    $("checkAll").click(function(){
        $(".check").prop("checked", this.checked);
        // 첫 화면 들어오자마다 모두 체크 되어 있는 상태
        if(this.checked){
            checkCounts.forEach((check,index) => {
                pushList(checkList, check.value);
                pushList(deleteList, check.value);
            });
        } else {

        }
    })
})