// 클릭 시 모든 체크박스 버튼이 눌림
function selectAll(){

    const selectAllBox = document.querySelectorAll('input[name="selectbox"]');

    const checked = document.querySelectorAll('input[name="selectBox"]:checked');

    const selectAll = document.querySelector('input[name="selectAll"]');

    if(checkboxes.length === checked.length) {
        selectAll.checked = true;
    }else{
        selectAll.checked = false;
    }

}


function selectAll(selectAll)  {
    const checkboxes 
       = document.getElementsByName('selectBox');
    
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

function updateQuantity(memberNo, productNo, change){    
    $.ajax({
        url:'/qchange',
        type:'POST',
        data:{
            memberNo : memberNo,
            productNo: productNo,
            change : change
        },
        success: function(response){
            if (response.success) {
                // 수량 업데이트
                $('#quantity' + productNo).text(response.newQuantity);

                // 총 금액 업데이트
                $('#totalPrice').text(response.totalPrice);
            } else {
                alert('수량 업데이트에 실패했습니다.');
            }
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

// 한 개의 상품 삭제 (맨 오른쪽 삭제 버튼 클릭할 시)
function deleteCart(deCart){ 
        $.ajax({
            url: '/deleteCart',
            type: 'POST',
            data: { items: selected }, 
            
            success: function(response) {
                console.log("삭제 요청 성공:", response);
                //alert("선택된 상품이 삭제되었습니다.");
                // 페이지를 다시 로드하거나 특정 요소를 업데이트할 수 있습니다.
                callback(response)
            },
            error: function(error) {
                console.log("삭제 요청 실패");
                //alert("삭제 중 문제가 발생했습니다.");
            }
        });
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