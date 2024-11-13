function changeElement(selector, searchUser, selectChat) {
    const otherEls = document.getElementsByName("chat-name"); // 여러 요소를 반환합니다.

    // 다른 요소들 배경 색을 흰색으로 변경
    for (let el of otherEls) {
        el.style.backgroundColor = "white";
    }

    // 선택된 요소의 배경 색을 변경
    if (window.getComputedStyle(selector).backgroundColor !== "rgba(132, 213, 255, 1)") {
        selector.style.backgroundColor = "rgba(132, 213, 255, 1)";
    }
    
    showChat(searchUser, selectChat);
}

// 채팅창 삭제 기능
function deleteChat(_this) {
    // 클릭된 버튼의 부모 요소 (즉, 해당 채팅창의 div)를 찾습니다.
    const chatDiv = _this.closest('div');  // button이 포함된 div 요소 찾기
    
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

// 채팅창 보여주기
function showChat(searchUser, selectChat){

    // selector가 받은 클래스를 탐색
    const showAndHideEl = document.querySelector(searchUser);
    const showAndHideEl2 = document.querySelector(selectChat);

    // classList 함수를 사용하여 해당 클래스에 hide클래스가 포함되어 있는지 탐색(있다면 true 없다면 false)
    if(showAndHideEl2.classList.contains("hide")){
        // if가 true라면 해당 클래스에서 hide클래스를 제거
        showAndHideEl.classList.add("hide");
        showAndHideEl2.classList.remove("hide");
    }
}

// 채팅방 추가
function addChattingRoom(path, _this){
    const newChat = document.createElement("div");
    const newUser = _this.closest('.search-users').querySelector('p').innerText;
    
    newChat.innerHTML = `
        <img class="delete-btn" src="${path}/resources/image/dogdduck.png" onclick="nickToDelete(this)">
        <button name="chat-name" class="trade-user-nick" onclick="changeElement(this, '#chat-search', '#chat-content')">${newUser}</button>
        <button class="delete-chat hide" onclick="deleteChat(this)"><img src="${path}/resources/image/trash2.png"></button>
    `

    const tradeUser = document.querySelector("#chat-trade-user");
    tradeUser.appendChild(newChat);
}

// 채팅 입력 시 채팅창에 로딩
function inputChatting(path) {
    const chatText = document.querySelector("#input-chat-text");

    // 채팅 내용이 비어 있지 않으면
    if (chatText.value.trim() === "") {
        return; // 비어 있으면 채팅을 보내지 않음
    }

    const myChat = document.createElement("div");
    myChat.className = "right-log";

    myChat.innerHTML = `
        <p>${chatText.value}</p>
        <img src="${path}/resources/image/dogdduck.png">
    `;

    const chatLog = document.querySelector("#chat-log-area > div");
    chatLog.appendChild(myChat);

    const chatLogHeight = chatLog.scrollHeight; // 전체 채팅 내용의 높이
    chatLog.scrollTop = chatLogHeight;

    chatText.value = ""; // 채팅 입력창 초기화
    useChatBtn(chatText); // 입력창을 비우면 버튼 비활성화
}

// 채팅 입력창에 값이 있을 때 버튼을 활성화하고, 없으면 비활성화
function useChatBtn(_this) {
    const sendBtn = document.querySelector("#send-chat-btn");

    if (_this.value.trim() === "") {
        sendBtn.disabled = true;  // 입력값이 없으면 비활성화
    } else {
        sendBtn.disabled = false; // 입력값이 있으면 활성화
    }
}

// Enter 키를 눌렀을 때 채팅을 보내고, Shift + Enter는 줄바꿈을 허용하는 함수
function handleEnterKey(event, path) {
    const chatText = document.querySelector("#input-chat-text");

    if (event.key === "Enter") {
        if (event.shiftKey) {
            // Shift + Enter: 줄바꿈 허용 (event.preventDefault() 하지 않음)
            return; // 줄바꿈 허용, 아무 작업도 하지 않음
        } else {
            // Enter만 누른 경우: 채팅 전송
            event.preventDefault(); // 기본 줄바꿈 방지
            if (chatText.value.trim() !== "") {
                inputChatting(path);
            }
        }
    }
}
