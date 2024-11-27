// DOM 요소 참조
const sendButton = document.getElementById("sendButton");
const userInput = document.getElementById("userInput");
const chatOutput = document.getElementById("chatOutput");

// 로딩 메시지 추가 함수
function showLoadingMessage() {
    const loadingMessage = document.createElement("div");
    loadingMessage.id = "loadingMessage"; // 로딩 메시지를 구분할 ID
    loadingMessage.className = "bot-message";
    loadingMessage.innerHTML = `
        <p>챗봇이 응답을 준비 중입니다...</p>
    `;
    chatOutput.appendChild(loadingMessage);
    chatOutput.scrollTop = chatOutput.scrollHeight; // 스크롤을 맨 아래로 이동
}

// 로딩 메시지 제거 함수
function removeLoadingMessage() {
    const loadingMessage = document.getElementById("loadingMessage");
    if (loadingMessage) {
        loadingMessage.remove();
    }
}

// 로컬스토리지에서 exNames 가져오기
const exNames = JSON.parse(localStorage.getItem("exNames")) || [];

if (exNames.length > 0) {
    // 로딩 메시지 표시
    showLoadingMessage();

    // 서버로 exNames 데이터 전송
    fetch("chat/message", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ message: exNames.join(", ") }), // 운동 이름 목록을 문자열로 전송
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error("서버 응답이 올바르지 않습니다.");
            }
            return response.json(); // JSON 응답 처리
        })
        .then((data) => {
            // 로딩 메시지 제거
            removeLoadingMessage();

            if (data.response) {
                // 챗봇의 응답 출력
                const botMessageElement = document.createElement("div");
                botMessageElement.className = "bot-message"; // 클래스명 변경
                botMessageElement.innerHTML = `
                    <pre>${data.response}</pre>
                `;
                chatOutput.appendChild(botMessageElement);

                // 스크롤을 맨 아래로 이동
                chatOutput.scrollTop = chatOutput.scrollHeight;
            } else {
                console.error("응답 데이터에 'response' 속성이 없습니다.");
            }
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("메시지를 전송하는 중 문제가 발생했습니다.");
        });
} 

// 버튼 클릭 이벤트
sendButton.onclick = function () {
    const message = userInput.value.trim();

    if (!message) {
        alert("메시지를 입력하세요.");
        return;
    }

    // 사용자의 메시지 출력
    const userMessageElement = document.createElement("div");
    userMessageElement.className = "user-message"; // 클래스명 변경
    userMessageElement.innerHTML = `
        <p>${message}</p>
        <img src="./resources/image/dogdduck.png" alt="user">
    `;
    chatOutput.appendChild(userMessageElement);

    showLoadingMessage();
    
// 서버로 메시지 전송
    fetch("chat/message", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ message })
    })
    .then((response) => {
        removeLoadingMessage()
        if (!response.ok) {
            throw new Error("서버 응답이 올바르지 않습니다.");
        }
        return response.json(); // JSON 응답 처리
    })
    .then((data) => {
        if (data.response) {
            // 챗봇의 응답 출력
            displayChatbotResponse(data.response);
        } else {
            console.error("응답 데이터에 'response' 속성이 없습니다.");
        }
    })
    .catch((error) => {
        console.error("Error:", error);
        alert("메시지를 전송하는 중 문제가 발생했습니다.");
    });

    // 입력 필드 초기화
    userInput.value = "";
    };

    // 챗봇 응답 출력 함수
    function displayChatbotResponse(responseMessage) {
    const chatOutput = document.getElementById("chatOutput");

    if (chatOutput) {
        const responseElement = document.createElement("div");
        responseElement.className = "bot-message";

        // HTML로 반환된 메시지를 그대로 출력 (줄 바꿈, 공백 등 보존)
        responseElement.innerHTML = `<pre>${responseMessage}</pre>`;
        chatOutput.appendChild(responseElement);

        // 스크롤을 맨 아래로 이동
        chatOutput.scrollTop = chatOutput.scrollHeight;
    } else {
        alert("챗봇 응답을 출력할 요소를 찾을 수 없습니다.");
    }
};
