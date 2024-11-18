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
}

function totalEmail(){
    const emailId = document.querySelector("#email-input1").value;
    const emailAt = document.querySelector("#email-input3").value;
    const emailArea = document.querySelector("#email-input2").value;
    const submitEmail = document.querySelector("#submit-email");

    const fullEmail = emailId + emailAt + emailArea;

    submitEmail.value = fullEmail;
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
            $("#enroll-enter").attr("disabled", true);
        } else {
            checkPwdArea.style.color = 'blue';
            checkPwdArea.innerText = '비밀번호가 일치합니다.';
            $("#enroll-enter").attr("disabled", false);
        }
    } else {
        checkPwdArea.innerText = '';
    }
}

function enrollIdCheck() {
    $.ajax({
        url: "idCheck.me",
        type : "post",
        data: {checkId : $("#userInputId").val()},
        success : function(result) {
            console.log("중복체크 ajax 성공!");
            if(result === "N") {
                $("#idArea div").css("color", "red");
                $("#idArea div").text("이미 존재하는 아이디 입니다.");
                $("#enroll-enter").attr("disabled", true);
            } else {
                $("#idArea div").css("color", "blue");
                $("#idArea div").text("사용 가능한 아이디 입니다.");
                $("#enroll-enter").attr("disabled", false);
            }
        },
        error : function(result){
            console.log("error: " + result);
            console.log("아이디 중복체크 실패");
        }
    })
}

function enrollNickCheck() {
    $.ajax({
        url : "nickCheck.me",
        type : "post",
        data : {checkNick : $(".enroll-input-area input[name=nickName]").val()},
        success : function(result) {
            if(result === "N") {
                $("#nickArea div").css("color", "red");
                $("#nickArea div").text("이미 존재하는 닉네임 입니다.");
                $("#enroll-enter").attr("disabled", true);
            } else {
                $("#nickArea div").css("color", "blue");
                $("#nickArea div").text("사용 가능한 닉네임 입니다.");
                $("#enroll-enter").attr("disabled", false);
            }
        },
        error : function(result){
            console.log("error: " + result);
            console.log("닉네임 중복체크 실패");
        }
    })
}