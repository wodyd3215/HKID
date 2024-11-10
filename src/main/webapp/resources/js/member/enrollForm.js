window.onload = function() {
    emailSelect();
};

// 아이디에 특수문자 입력시 버튼 비활성화
function checkUserId(_this){
    const regExp = /[^a-zA-Z0-9]/; 

    const checkBtn = document.querySelector("#checkIdBtn");

    if(regExp.test(_this.value)){
        checkBtn.disabled = true;
        checkBtn.style.backgroundColor = "rgb(116, 116, 116)";
    } else {
        checkBtn.disabled = false;
        checkBtn.style.backgroundColor = "";
    }
}

// 이메일 선택시 input창에 value값 삽입
function emailSelect() {
    const emailOpt = document.querySelector("select[name=emailType] option:checked").value;
    const emailArea = document.querySelector("#email-input2");

    if (emailOpt) {
        emailArea.value = emailOpt;
    } else {
        emailArea.value = '';
    }

    // 이메일 합치기
    const emailId = document.getElementById('email-input1').value;
    const emailAt = document.getElementById('email-input3').value;
    const emailAddress = document.getElementById('email-input2').value;
    const fullEmail = emailId + emailAt + emailAddress;

    // 기존에 hidden input이 있으면 삭제
    let hiddenEmailInput = document.querySelector("input[name='email']");
    if (hiddenEmailInput) {
        hiddenEmailInput.remove();
    }

    // 새로운 hidden input 생성
    hiddenEmailInput = document.createElement('input');
    hiddenEmailInput.type = 'hidden';
    hiddenEmailInput.name = 'email';
    hiddenEmailInput.value = fullEmail;

    // 이메일 폼에 hidden input을 추가
    const newEmail = document.querySelector('#enroll-email');
    newEmail.appendChild(hiddenEmailInput);
}


// 비밀번호 확인
function inputPwdCheck() {
    const userPwd = document.querySelector("#userInputPwd").value; 
    const checkPwd = document.querySelector("#checkPwd").value;
    const checkPwdArea = document.querySelector("#pwdArea div"); 

    if (userPwd && checkPwd) {  
        if (userPwd !== checkPwd) {
            checkPwdArea.style.color = 'red';
            checkPwdArea.innerText = '비밀번호가 일치하지 않습니다.';
        } else {
            checkPwdArea.style.color = 'blue';
            checkPwdArea.innerText = '비밀번호가 일치합니다.';
        }
    } else {
        checkPwdArea.innerText = '';
    }
}

document.forms['yourFormName'].onsubmit = function() {
    const emailId = document.getElementById('email-input1').value;
    const emailAt = document.getElementById('email-input3').value;
    const emailAddress = document.getElementById('email-input2').value;
    const fullEmail = emailId + emailAt + emailAddress;
    
    // 이메일을 합쳐서 hidden input에 넣어 서버로 전송
    const hiddenEmailInput = document.createElement('input');
    hiddenEmailInput.type = 'hidden';
    hiddenEmailInput.name = 'email';  // 서버에서 받을 파라미터 이름
    hiddenEmailInput.value = fullEmail;
    
    const newEmail = document.querySelector('#enroll-email');
    newEmail.appendChild(hiddenEmailInput);
}