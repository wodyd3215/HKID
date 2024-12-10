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
let quantity = 1;

// 수량 증가 및 감소 버튼
function increaseBtn(){    
    const cartQuantity = document.querySelector(".cartQuantity");
    const quantityBtnText = document.querySelector(".quantityBtnText");
    const productPrice = document.querySelector(".productPrice");
    const price = parseInt(price.getAttribute("data-price"));

    const mNo = document.querySelector(".mNo");
    const pNo = document.querySelector(".pNo");

    

    quantity += 1;
    quantityBtnText.textContent = quantity;

    $.ajax({
        url:'/qchange',
        data:'{}'
    })
}

function decreaseBtn(){
    let productNo = $(this).closest('.cartQuantity').data('productNo');
    let memberNo = $(this).closest('.cartQuantity').data('memberNo');
    updateQuantity(memberNo, productNo, -1); // -1은 수량 감소
}


// -------------------------------------------------------------------------------------------
function delectOne(){
    const btn = document.querySelector('.btn.delete-button')
    const pNo = btn.getAttribute('data-product-no')
    const mNo = btn.getAttribute('data-member-no')

    console.log(pNo); 
    console.log(mNo); 

    $.ajax({
        url:'delete.c',
        data:{
            productNo : pNo,
            memberNo : mNo
        },
        success : function(res){
            console.log("전송완료");
            location.href = `cartlist.li?memberNo=${mNo}`;
        }, error : function() {
            console.log("실패");
        }
    });
}


