// 라디오박스의 선택된 값을 가져오는 코드
//document.querySelector('input[type=radio][name = {side}]:checked').value;
let side = 'sideNav'; 
$(`input:radio[name='{side}']:checked`).val();

// 라디오버튼에 선택된 값을 ajax 통신 post로 값을 넘겨주는 코드
let sideItem = '#element-id';
$(sideItem).on('click',function(){
    // 

    const content1 = {
        checked:document.querySelector('input[type=radio][name=enable]:checked').value
    } // 체크된 값을 content1에 담아서 아래 data 값에 넘겨준다.

    const url = '{product.li}';

    $.ajax({
        url:url,
        method:"POST",
        contentType:"application/json", // 각자 설정한 형식 입력
        data : JSON.stringify(content1),
        success:function(response){
            console.log(response)
        },
        error:function(error){
            console.log(error);
        }
    })
})

