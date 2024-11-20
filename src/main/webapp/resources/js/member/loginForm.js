function init(alertMsg){
    checkAlertMessage(alertMsg)
}

// 기본 로그인
function loginBtn(){
    const inputId = document.querySelector("#login-id").value;
    const inputPwd = document.querySelector("#login-pwd").value;

    const logBtn = document.querySelector("input[type='submit']")
    if(inputId === '' || inputPwd === '') {
        logBtn.disabled = true;
        
    } else {
        logBtn.disabled = false;
    }
}

function checkAlertMessage(alertMsg){
    if(alertMsg) {
        alert(alertMsg);
    }
}

// 네이버로그인
function naverLogin() {
    const clientId = "BYvB7jWw1WtD06L3DUca";
    // 리다이렉트URL을 utf-8로 인코딩해서 저장
    const redirectURL = encodeURIComponent("http://localhost:7777/HKID/naver-login");
    
    const state = Math.random().toString(36).substring(2);

    let apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURL;
    apiURL += "&state=" + state;

    location.href = apiURL;
}

// 카카오로그인
function kakaoLogin() {
    
}