
// 리뷰 작성 창 띄우기
function reviewBtn(){
    e.preventDefault();

    const memberNo = '${member.memberId}';
    const productNo = '${product.productNo}';

    let popUrl = "Product/review" + memberNo + "?productNo=" + productNo;
    console.log(popUrl);
    let popOption = "width = 490px, height=490px, top=300px, left=300px, scrollbars=yes";

    window.open(popUrl, "리뷰 작성", popOption); // 팝업 주소, 팝업창 이름, 팝업창 설정
}

// 리류 별
function star(){
    $(this).parent().children('span').removeClass('on');
    $(this).addClass('on').prevAll('span').addClass('on');
}