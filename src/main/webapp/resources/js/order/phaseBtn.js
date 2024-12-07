function disableBtn(){
    // 날짜 비교 후 버튼 비활성화 처리
    const createdDate = new Date("${createdDate}"); // 서버에서 전달받은 작성일
    const currentDate = new Date(); // 현재 날짜


    // 작성일 + 3일 계산
    const expirationDate = new Date(createdDate);
    expirationDate.setDate(createdDate.getDate() + 3);

    if (currentDate > expirationDate) {
        document.getElementById("actionButton").disabled = true;
    }
}