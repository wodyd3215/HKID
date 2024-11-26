// DOM 요소 참조
const sendButton = document.getElementById("sendButton");
const userInput = document.getElementById("userInput");
const chatOutput = document.getElementById("chatOutput");

// 버튼 클릭 이벤트
sendButton.onclick = function () {
    const message = userInput.value.trim();

    if (!message) {
        alert("메시지를 입력하세요.");
        return;
    }

    // 사용자의 메시지 출력
    const userMessageElement = document.createElement("div");
    userMessageElement.className = "user";
    userMessageElement.innerHTML = `
        <p>${message}</p>
        <img src="./resources/image/dogdduck.png" alt="user">
    `;
    chatOutput.appendChild(userMessageElement);

    // 서버로 메시지 전송
    fetch("chat/message", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ message }),
    })
        .then((response) => response.json())  // JSON 응답 처리
        .then((data) => {
            // 챗봇의 응답 출력
            const botMessageElement = document.createElement("div");
            botMessageElement.className = "bot";
            botMessageElement.innerHTML = `
                <img src="./resources/image/chat-bot.png" alt="bot">
                <p>${data.response}</p>
            `;
            chatOutput.appendChild(botMessageElement);

            // 입력 필드 초기화
            userInput.value = "";

            // 스크롤을 맨 아래로 이동
            chatOutput.scrollTop = chatOutput.scrollHeight;
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("메시지를 전송하는 중 문제가 발생했습니다.");
        });
};
