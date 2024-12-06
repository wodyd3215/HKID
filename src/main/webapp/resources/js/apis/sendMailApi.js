// 이메일 인증 번호 보내기
function certifyEmail() {
    const memberEmail = $("#email-input1").val();
    const subject = "HKID 이메일 인증번호 입니다."
    const content = "인증번호 : "

    console.log(memberEmail);

    $.ajax({
        url : "send",
        data : {
            email : memberEmail,
            subject : subject,
            content : content
        },
        success : function(res) {
            console.log("인증번호 전송 ajax 완료")
            $("#receiveCertifyNo").val(res); // hidden요소
        },
        error : function() {
            console.log("인증번호 전송 ajax 실패")
        }
    })
}