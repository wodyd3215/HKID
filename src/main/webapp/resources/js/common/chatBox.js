function changeElement(selector) {
    const otherEls = document.getElementsByName("chat-name"); // 여러 요소를 반환합니다.

    // 다른 요소들 배경 색을 흰색으로 변경
    for (let el of otherEls) {
        el.style.backgroundColor = "white";
    }

    // 선택된 요소의 배경 색을 변경
    if (window.getComputedStyle(selector).backgroundColor !== "rgba(132, 213, 255, 1)") {
        selector.style.backgroundColor = "rgba(132, 213, 255, 1)";
    }
}

// 채팅창 삭제 기능
function deleteChat(button) {
    // 클릭된 버튼의 부모 요소 (즉, 해당 채팅창의 div)를 찾습니다.
    const chatDiv = button.closest('div');  // button이 포함된 div 요소 찾기
    
    // 해당 채팅창(div)을 삭제합니다.
    chatDiv.remove();
}

// 삭제버튼 보이기
function nickToDelete(element) {
    // 클릭된 이미지를 기준으로 부모 요소 선택
    const parent = element.parentElement;

    // 부모 요소 내에서 닉네임과 삭제 버튼 선택
    const nickname = parent.querySelector(".trade-user-nick");
    const deleteButton = parent.querySelector(".delete-chat");

    // 닉네임 숨기고 삭제 버튼 표시
    nickname.classList.toggle("hide");
    deleteButton.classList.toggle("hide");
}



// 채팅 추가 구현해야함
function addChatting(){

}