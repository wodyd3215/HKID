// 라디오박스의 선택된 값을 가져오는 코드
/* 
    .change(function() { ... }) 에서 change 는 이벤트 타입이며,
    특정 요소의 상태가 변경되었을 때 발생하는 이벤트 타입이다.

*/
$(function(){
    $('input[name=sideNav]').change(function(){
        const selectedValue = $(this).val(); // 현재 선택된 라디오 버튼의 값
        console.log('선택된 값 : ', selectedValue);
    
        $.ajax({
            url: 'chooseNav',
            method: 'GET', // 또는 'POST' 필요에 따라 변경
            data: { sideNav: selectedValue }, // name 의  sideNav 의 값을 받음
            success: function(response) {
                // 성공 시 페이지 업데이트
                $('#result').html(response);
            },
            error: function() {
                alert('데이터 로드 중 오류가 발생했습니다.');
            }
        });
    });

    $('input[name=ItemRbtn]').change(function(){
        const Rbtn = $(this).val(); // 현재 선택된 라디오 버튼의 값
        console.log('선택된 값 : ', Rbtn);
    
        $.ajax({
            url: 'chooseNav',
            method: 'GET', // 또는 'POST' 필요에 따라 변경
            data: { ItemRbtn: Rbtn }, // name 의  ItemRbtn 의 값을 받음
            success: function(response) {
                // 성공 시 페이지 업데이트
                $('#result').html(response);
            },
            error: function() {
                alert('데이터 로드 중 오류가 발생했습니다.');
            }
        });
    });

    console.log($('input[name=sideNav]'))
    console.log($('input[name=ItemRbtn]'))
})