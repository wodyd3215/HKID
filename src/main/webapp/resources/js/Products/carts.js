// 클릭 시 모든 체크박스 버튼이 눌림
function selectAll(selectAll){
    const checkboxes = document.querySelectorAll('input[type="checkBox"]');

    checkboxes.forEach((checkbox) =>{
        checkbox.checked = selectAll.checked
    })
}
function addItem(){
    //const productNo = ${};
    const memberNo = "${loginUser.userNo}";
    const productQuantity = document.querySelector(".quantityBtnText").value;

    addAjaxItem
}

function addAjaxItem(data, callback){
    $.ajax({
        url:'addCart.c',
        data:data,
        success:function(res){
            callback(res)
        }
    })
}




// 수량 증가 및 감소 버튼
$('.increaseBtn').click(function() {
    let productId = $(this).closest('.cartQuantity').data('productId');
    updateQuantity(productId, 1); // 1은 수량 증가
});

$('.decreaseBtn').click(function() {
    let productId = $(this).closest('.cartQuantity').data('productId');
    updateQuantity(productId, -1); // -1은 수량 감소
});

function updateQuantity(productId, change){    
    $.ajax({
        url:'/qchange',
        type:'POST',
        data:{
            productId: productId,
            change : change
        },
        success: function(response){
            if (response.success) {
                // 수량 업데이트
                $('#quantity-' + productId).text(response.newQuantity);

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
function deleteOne(){
    $('.delete-button').on('click', function(){
        let $checked = $('table input[type=checkbox]:checked');

        if($checked.length < 1){
            alert('선택된 상품이 없습니다 !');
            return false;
        }
        
        let selected = [];

        $.each($checked, function(){
            selected.push($(this).val());
        });

        $.ajax({
            url: '/deleteOne',
            type: 'POST',
            data: { items: selected }, // 'items'라는 이름으로 배열을 전송
            traditional: true, // 배열을 기본적인 방식으로 전송
            success: function(response) {
                console.log("삭제 요청 성공:", response);
                //alert("선택된 상품이 삭제되었습니다.");
                // 페이지를 다시 로드하거나 특정 요소를 업데이트할 수 있습니다.
                callback(response)
            },
            error: function() {
                console.log("삭제 요청 실패");
                //alert("삭제 중 문제가 발생했습니다.");
            }
        });
       
    });

}