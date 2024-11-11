function init(alertMsg){
    checkAlertMessage(alertMsg)
}

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