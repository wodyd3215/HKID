//댓글 수정ajax
function updateReplyAjax(data, callback){
    $.ajax({
        type: "POST",
        url: "updateReply.bo",
        data: data,
        success: function(res){
            console.log("댓글 수정ajxa통신 성공")
            callback(res)
        },
        error: console.log("댓글 수정 ajax 통신 실패ㅠㅠ")
    })
}

//댓글 추가 ajax
function addReplyAjax(data, callback){
    $.ajax({
        url: "insertReply.bo",
        data: data,
        type: "POST",
        success:function(res){
            if(res === "success"){
                callback(res)
            }
        },
        error: function(xhr, status, error) {
            console.log("댓글 생성 ajax 실패");
            console.log("Error Status: " + status);  // 에러 상태 출력
            console.log("Error Details: " + error);  // 에러 세부 내용 출력
            console.log("Response Text: " + xhr.responseText);  // 서버 응답 내용 출력
        }
    })
}

// 댓글 목록 가져오기
function getReplyList(data, callback){
    $.ajax({
        url: "replyList.bo",
        data: data,
        success: function(res){
            callback(res)
        },
        error: function(){
        }
    })
}