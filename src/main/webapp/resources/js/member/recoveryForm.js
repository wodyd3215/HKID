// 인증번호 확인
function checkCertify() {
    const certifyNo = $("#certifyNo").val();
    console.log(certifyNo)
    const receiveCertifyNo = $("#receiveCertifyNo").val();
    console.log(receiveCertifyNo)
    console.log("되고있나..?")
    if(certifyNo === receiveCertifyNo) {
        $("#certifyArea").css("color", "blue");
        $("#certifyArea").text("인증번호가 일치합니다.")
        $("#recoveryApply").css("backgroundColor", "rgba(0, 166, 251, 1)");
        $("#recoveryApply").attr("disabled", false);

    } else {
        $("#certifyArea").css("color", "red");
        $("#certifyArea").text("인증번호가 일치하지 않습니다.")
        $("#recoveryApply").css("backgroundColor", "gray");
        $("#recoveryApply").attr("disabled", true);
    }
}