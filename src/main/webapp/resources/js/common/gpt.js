// DOM 요소 참조
const sendButton = document.getElementById("sendButton");
const userInput = document.getElementById("userInput");
const chatOutput = document.getElementById("chatOutput");

// 버튼 클릭 이벤트
sendButton.onclick = function () {
    const message = userInput.value;

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
            // 챗봇 응답 출력
            const responseElement = document.createElement("p");
            responseElement.textContent = "GPT: " + data.response;  // response 키 사용
            chatOutput.appendChild(responseElement);

            // 입력 필드 초기화
            userInput.value = "";
        })
        .catch((error) => console.error("Error:", error));
};
