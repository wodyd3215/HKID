function initOrderPage(totalPrice) {
    console.log(totalPrice);
    const priceArea = document.querySelector("#totalProductPrice");
    const totalAmount = document.querySelector("#totalAmount");
    priceArea.value = totalPrice + "원";

    totalAmount.value = parseInt(totalPrice) + 3000 + "원";
}

// $("#kaobtn").click(function(){
//     const productName = document.querySelector("#productName");
//     const totalAmount = document.querySelector("#totalAmount");
//     const productCount = document.querySelector("#productCount");

//     $.ajax({
//         url: "payReady",
//         type: "get",
//         data: {
//             name: productName.innerText,    // 카카오페이에 보낼 대표 상품명
//             totalPrice: totalAmount.innerText,  // 총 결제금액
//             productCount: productCount.innerText,
//             tax_free_amount: "0"
//         },
//         success: function(res){
//             location.href = res.next_redirect_mobile_url;
//         },
//         error: function(){
//             console.log("카카오 결제 api 실패");
//         }
//     })
// })

// $(function() {
//     $("#kaobtn").click(function(e) {
//         // 아래 데이터 외에도 필요한 데이터를 원하는 대로 담고, Controller에서 @RequestBody로 받으면 됨
//         const productName = document.querySelector("#productName");
//         const totalAmount = document.querySelector("#totalAmount");
//         const productCount = document.querySelector("#productCount");

//         let data = {
//             name: productName.innerText,    // 카카오페이에 보낼 대표 상품명
//             totalPrice: totalAmount.innerText, // 총 결제금액
//             productCount: productCount.innerText,
//             tax_free_amount: "0"
//         };
      
//         $.ajax({
//             url: '/ready',
//             type: 'POST',
//             data: JSON.stringify(data),
//             contentType: 'application/json',
//             success: function(res) {
//                 location.href = res.next_redirect_pc_url;
//             }
//         });
//     });
// });