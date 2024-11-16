function searchId() {
    console.log($("#search-id").val());
    $.ajax({
        url : "searchId.me",
        type : "post",
        data : {email : $("#search-id").val()},
        success : function(res){
            console.log("아이디 찾기 ajax 성공 :" + res);
            if(!res) {
                $("#search-id-text").text("해당 이메일로 가입된 아이디는 존재하지 않습니다.")
            } else {
                $("#search-id-text").html("해당 이메일로 가입된 아이디는 '" + res + "' 입니다.")
            }
        },
        error : function(){
            console.log("아이디 찾기 ajax 실패!")
        }
    })
}