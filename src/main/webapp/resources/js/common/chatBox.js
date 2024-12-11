// socket객체와 session이 스트림을 공유(연결)하여 데이터를 서로 전송할 수 있게 됨
// websocket요청이긴 하지만 http와 같은 양식으로 전달됨
// /server로 요청이 가면 interceptor가 해당 요청을 http요청에서 websocket요청으로 변환해줌
const socket = new WebSocket("ws://localhost:7777/HKID/server");

function initChatBox(path, memberNo) {

    // 채팅방 목록 불러오기
    chatList(path, memberNo);

    socket.onopen = function () {
        console.log("연결성공...")
    }

    socket.onclose = function () {
        console.log("연결끊어짐...")
    }

    socket.onerror = function () {
        console.log("연결실패...")
    }

    // socket연결로부터 데이터가 도착했을 때 실행하는 이벤트
    socket.onmessage = function (ev) {
        const receive = JSON.parse(ev.data); // 서버에서 보내준 data를 JSON 객체로 파싱

        const chatLog = document.querySelector("#chat-log-area > div");

        const receivedChat = document.createElement("div");

        console.log(typeof receive.senderNo);
        console.log(typeof memberNo);

        
        if (parseInt(receive.senderNo) === parseInt(memberNo)) {
            console.log("오른쪽")
            receivedChat.className = "right-log"; // 내 메시지는 오른쪽
            receivedChat.innerHTML = `
                <div>
                    <div>${receive.nick}</div>
                    <p>${receive.msg}</p>
                </div>
                <img src="${path}${receive.profileImg}"></img>
            `;
        } else {
            console.log("왼쪽")
            receivedChat.className = "left-log"; // 상대방의 메시지는 왼쪽
            receivedChat.innerHTML = `
                <img src="${path}${receive.profileImg}"></img>
                <div>
                    <div>${receive.nick}</div>
                    <p>${receive.msg}</p>
                </div>
            `;
        }

        // 수신된 채팅 메시지에 대해 HTML을 구성

        chatLog.appendChild(receivedChat);

        const chatLogHeight = chatLog.scrollHeight;
        chatLog.scrollTop = chatLogHeight;
    }

}

// 채팅방 목록
function chatList(path, memberNo) {
    $.ajax({
        url: "chatList",   // 채팅방 목록을 불러오는 API
        data: { senderNo: memberNo },
        success: function (result) {
            console.log("채팅방 조회 ajax 성공");
            // 채팅방 목록을 동적으로 생성하여 chat-trade-user에 추가
            const tradeUserContainer = document.querySelector("#chat-trade-user");
            tradeUserContainer.innerHTML = ""; // 기존 목록 초기화

            // 채팅방 목록에 맞춰 동적으로 HTML을 추가
            result.forEach(m => {
                let exists = false;
                const chatList = tradeUserContainer.querySelectorAll("button[name='chat-name']"); // 채팅방 목록의 버튼 요소들

                // 기존 채팅방 목록에 있는 닉네임과 비교
                chatList.forEach(c => {
                    if (c.innerText === m.nickName) {
                        exists = true;
                    }
                });

                // 만약 닉네임이 이미 있으면 추가하지 않음
                if (exists) {
                    return; // 반복문을 종료하고, 다음 항목으로 넘어감
                }
                const chatItem = document.createElement("div");
                chatItem.innerHTML = `
                    <img class="delete-btn" src="${path}${m.profileImg}" onclick="nickToDelete(this)">
                    <button name="chat-name" class="trade-user-nick" onclick="changeElement('${path}', this, '#chat-search', '#chat-content', ${memberNo}, ${m.receiverNo}, ${m.senderNo})">${m.nickName}</button>
                    <button class="delete-chat hide" onclick="deleteChat(this, ${memberNo}, ${m.receiverNo})">
                        <img src="resources/image/trash2.png">
                    </button>
                `;
                tradeUserContainer.appendChild(chatItem);
            });
        },
        error: function () {
            console.log("채팅방 조회 ajax 실패");
        }
    });
}

// 유저 닉네임 조회
function searchNickName(path, memberNo) {
    const nickList = document.querySelector(".search-users");
    nickList.innerHTML = "";
    $.ajax({
        url: "search.me",
        data: { nickName: $("#chat-search-bar").val() },
        success: function (result) {
            console.log("유저정보 조회 성공")
            for (let m of result) {
                nickList.innerHTML += `
                                <div>
                                    <img src="${path}${m.profileImg}">
                                    <p>${m.nickName}</p>
                                    <button onclick="addChattingRoom('${path}', this, ${memberNo}, ${m.memberNo}, '${m.profileImg}', '${m.nickName}')">
                                        <img src="resources/image/chat_bubble.png">
                                    </button>
                                </div>
                                `
            }
        },
        error: function () {
            console.log("유저정보 조회 AJAX 실패")
        }
    })
}

// 채팅방 추가
function addChattingRoom(path, _this, memberNo, receiverNo, profileImg, nickName) {
    console.log(path)
    console.log(profileImg)
    const newChat = document.createElement("div");
    const newUser = _this.closest('div').querySelector('p').innerText;  // 새로운 사용자 닉네임 (공백 제거)
    const chatList = document.querySelectorAll("#chat-trade-user button[name='chat-name']");

    // 이미 존재하는 닉네임이 있으면 채팅방을 추가하지 않음
    for (const c of chatList) {
        if (c.innerText === newUser) {
            console.log('이미 채팅방에 추가된 사용자입니다.');
            return false;  // 이미 닉네임이있으면 함수를 종료
        }
    }

    newChat.innerHTML = `
        <img class="delete-btn" src="${path}${profileImg}" onclick="nickToDelete(this)">
        <button name="chat-name" class="trade-user-nick" onclick="changeElement('${path}', this, '#chat-search', '#chat-content', ${memberNo}, ${receiverNo}, ${memberNo})">${nickName}</button>
        <button class="delete-chat hide" onclick="deleteChat(this, ${memberNo}, ${receiverNo})">
            <img src="resources/image/trash2.png">
        </button>
        `;

    // 채팅방 리스트에 새로운 채팅방을 추가
    const tradeUser = document.querySelector("#chat-trade-user");
    tradeUser.appendChild(newChat);
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

// 채팅창 삭제 기능
function deleteChat(_this, memberNo, receiverNo) {

    $.ajax({
        url: "deleteChat",
        data: {
            memberNo: memberNo,
            receiverNo: receiverNo
        },
        success: function () {
            console.log("채팅방 삭제 ajax 성공")
        },
        error: function () {
            console.log("채팅방 삭제 ajax 실패")
        }
    })

    // 클릭된 버튼의 부모 요소 (즉, 해당 채팅창의 div)를 찾습니다.
    const chatDiv = _this.closest('div');  // button이 포함된 div 요소 찾기

    // 해당 채팅창(div)을 삭제합니다.
    chatDiv.remove();
}

function changeElement(path, _this, searchUser, selectChat, memberNo, receiverNo, senderNo) {
    const otherEls = document.getElementsByName("chat-name"); // 여러 요소를 반환합니다.
    console.log(_this);

    // 다른 요소들 배경 색을 흰색으로 변경
    for (let el of otherEls) {
        el.style.backgroundColor = "white";
    }

    // 선택된 요소의 배경 색을 변경
    if (window.getComputedStyle(_this).backgroundColor !== "rgba(132, 213, 255, 1)") {
        _this.style.backgroundColor = "rgba(132, 213, 255, 1)";
    }

    // 채팅창 보여주기
    showChat(path, searchUser, selectChat, memberNo, receiverNo, senderNo);
}

// 채팅창 보여주기
function showChat(path, searchUser, selectChat, memberNo, receiverNo, senderNo) {

    // selector가 받은 클래스를 탐색
    const showAndHideEl = document.querySelector(searchUser);
    const showAndHideEl2 = document.querySelector(selectChat);

    // classList 함수를 사용하여 해당 클래스에 hide클래스가 포함되어 있는지 탐색(있다면 true 없다면 false)
    if (showAndHideEl2.classList.contains("hide")) {
        // if가 true라면 해당 클래스에서 hide클래스를 제거
        showAndHideEl.classList.add("hide");
        showAndHideEl2.classList.remove("hide");
    }

    $.ajax({
        url: "selectChatLog",
        data: {
            senderNo: senderNo,
            receiverNo: receiverNo
        },
        success: function (result) {
            console.log("채팅방 로그 조회 ajax 성공");

            // 채팅 로그를 표시할 영역
            const chatLogArea = document.querySelector("#chat-log-area > div");

            // chatLogArea 초기화
            chatLogArea.innerHTML = '';

            // result 배열을 반복하여 각 메시지를 처리
            result.forEach(m => {
                // 내가 보낸 메시지인지 확인 (예: senderNo와 메시지의 senderNo가 같으면 내 메시지)
                const isMyMessage = m.senderNo === memberNo;
                // 메시지 HTML을 동적으로 생성
                let messageHTML = '';

                if (isMyMessage) {
                    // 내 메시지일 경우
                    messageHTML = `
                        <div class="right-log">
                            <div>
                                <div>${m.nickName}</div>
                                <p>${m.messageContent}</p>
                            </div>
                            <img src="${path}${m.profileImg}">
                        </div>
                    `;
                } else {
                    // 상대방 메시지일 경우
                    messageHTML = `
                        <div class="left-log">
                            <img src="${path}${m.profileImg}">
                            <div>
                                <div>${m.nickName}</div>
                                <p>${m.messageContent}</p>
                            </div>
                        </div>
                    `;
                }

                chatLogArea.innerHTML += messageHTML;
            });

            // 채팅 입력 부분을 추가
            const showAndHideEl2 = document.querySelector('#chat-content');
            showAndHideEl2.innerHTML += `
                <!-- 채팅 입력 -->
                <div id="chat-input-area">
                    <div>
                        <textarea id="input-chat-text" name="input-chatting" placeholder="채팅 입력" 
                                  oninput="useChatBtn(this)" onkeydown="handleEnterKey(event, ${memberNo}, ${receiverNo}, ${senderNo})"></textarea>
                        <div>
                            <button id="send-chat-btn" onclick="inputChatting(${memberNo}, ${receiverNo}, ${senderNo})" disabled>
                                <img src="resources/image/Corner-down-right.png">
                            </button>
                        </div>
                    </div>
                </div>
            `;
        }
        ,
        error: function () {
            console.log("채팅방 로그 조회 ajax 실패");
        }
    })
}





// 채팅 입력 저장/전달
function inputChatting(memberNo, receiverNo, senderNo) {

    const chatText = document.querySelector("#input-chat-text");
    const chatUser = document.querySelector(".trade-user-nick");
    // 채팅 내용이 비어 있지 않으면
    if (chatText.value.trim() === "") {
        return; // 비어 있으면 채팅을 보내지 않음
    }
    console.log("채팅 입력 ajax 실행 전")

    $.ajax({
        url: "inputChat",
        data: {
            messageContent: chatText.value,
            senderNo: senderNo,
            receiverNo: receiverNo,
            memberNo: memberNo
        },
        success: function (res) {
            console.log("채팅 입력/저장 ajax 성공");
            // const myChat = document.createElement("div");
            // myChat.className = "right-log";

            // myChat.innerHTML = `
            //     <div>
            //         <div>${res.nickName}</div>
            //         <p>${chatText.value}</p>
            //     </div>
            //     <img src="${res.profileImg}"></img>
            // `;

            // const chatLog = document.querySelector("#chat-log-area > div");
            // chatLog.appendChild(myChat);

            // const chatLogHeight = chatLog.scrollHeight; // 전체 채팅 내용의 높이
            // chatLog.scrollTop = chatLogHeight;

            chatText.value = ""; // 채팅 입력창 초기화
            useChatBtn(chatText); // 입력창을 비우면 버튼 비활성화
        },
        error: function () {
            console.log("채팅 입력/저장 ajax 실패");
        }
    })

    const msgData = {
        message: chatText.value,
        target: chatUser.innerText
    }
    // send할 때는 string으로 보내야해서 stringify로 문자열로 변경해서 보낸다.
    socket.send(JSON.stringify(msgData));
    console.log("메세지 전송");
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
function handleEnterKey(event, memberNo, receiverNo, senderNo) {
    const chatText = document.querySelector("#input-chat-text");

    if (event.key === "Enter") {
        if (event.shiftKey) {
            // Shift + Enter: 줄바꿈 허용 (event.preventDefault() 하지 않음)
            return; // 줄바꿈 허용, 아무 작업도 하지 않음
        } else {
            // Enter만 누른 경우: 채팅 전송
            event.preventDefault(); // 기본 줄바꿈 방지
            if (chatText.value.trim() !== "") {
                inputChatting(memberNo, receiverNo, senderNo);
            }
        }
    }
}