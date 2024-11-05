// 아이디에 특수문자 입력시 버튼 비활성화
function checkUserId(_this){
    var regExp = /[^a-zA-Z0-9]/; 

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

    if(emailOpt){
        emailArea.value = emailOpt;
    } else {
        emailArea.value = '';
    }
    
}