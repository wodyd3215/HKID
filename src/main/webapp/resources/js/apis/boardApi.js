//좋아요 상태 확인
function checkGood(data, callback){
    const jsonData = JSON.parse(data)
    
    //로그인 되지 않았을 경우 null
    if (jsonData.memberNo === undefined){
        jsonData.memberNo = null
    }
    $.ajax({
        url: "checkGood",
        data: {
            boardNo: jsonData.boardNo,
            memberNo: jsonData.memberNo
        },
        dataType: "json",
        success: function(res) {
            //좋아요 있음
            if(res === 1){
                // 빨간 하트 선택
                // console.log("빨간하트 출력!")
                $("#heart-img").attr("src", "resources/image/board/heart.png")
                return true;
            } else if (res === 0){
                // 텅 빈 하트 선택
                // console.log("빈 하트 출력!")
                $("#heart-img").attr("src", "resources/image/board/emptyHeart.png")
                return false;
            }else{
                console.log("checkGood AJAX 실패!!!!")
            }
        },
        error: function () {
            console.log("좋아요 추가 실패")
        }
    })
}

//좋아요 존재 여부만을 확인
function ExistGood(data, callback){
    console.log("ExistGood의 데이터: " + data.boardNo)
    $.ajax({
        url: "ExistGood",
        data: {
            boardNo: data.boardNo,
            memberNo: data.memberNo
        },
        success: function (res) {
            callback(res)
        }
    })
}

// 좋아요 추가 ajax
function insertGood(data, callback){
    $.ajax({
        url: "insertGood",
        data: {
            boardNo: data.boardNo,
            memberNo: data.memberNo
        },
        success: function (res) {
            if(res === 1){
                // console.log("좋아요 추가 성공")
            } else if (res === 1){
                console.log("좋아요 추가 안함")
            }else{
                console.log("좋아요 추가 중 예외발생")
            }
        },
        error: function () {
            console.log("좋아요 추가 중 에러발생")
        }
    })
}

//좋아요 수정 ajax
function updateGood(data, callback){
    $.ajax({
        url: "updateGood",
        data: {
            boardNo: data.boardNo,
            memberNo: data.memberNo,
            heartStatus: data.isHeartOnOff
        },
        success: function () {
        },
        error: function () {
            console.log("좋아요 DB수정 실패")
        }
    })
}

//좋아요 개수 ajax
function countGood(data, callback){
    $.ajax({
        url: "countGood",
        data:{
            boardNo : data.boardNo
        },
        success: function(res){
            callback(res)
        },
        error: function(){
            console.log("실패")
        }
    })
}

/* ================= 댓글 ajax ================= */

//댓글 수정ajax
function updateReplyAjax(data, callback){
    $.ajax({
        type: "POST",
        url: "updateReply.bo",
        data: {
            boardNo : data.boardNo,
            replyNo : data.replyNo,
            replyContent : data.content
        },
        success: function(){
            console.log("댓글 수정ajxa통신 성공")
            callback()
        },
        error: console.log("댓글 수정 ajax 통신 실패ㅠㅠ")
    })
}

//댓글 추가 ajax
function addReplyAjax(data, callback){
    $.ajax({
        url: "insertReply.bo",
        type: "POST",
        data: data,
        success : function(){
            callback();
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
        data: {boardNo: data},
        success: function(res){
            callback(res)
        },
        error: function(){
            console.log("댓글 목록 가져오기 실패! [getReplyList]")
        }
    })
}

//댓글 삭제
function deldeteReplyAjax(data, callback) {
    $.ajax({
        url: "deleteReply",
        type: "POST",
        data: {
            boardNo: data.boardNo,
            replyNo: data.replyNo
        },
        success: function() {
            callback();
        },
        error: function () {
        }
    })
}

//댓글 수정완료
function updateReplyAjax2(data, callback){
    console.log("data: " + data)
    $.ajax({
        url: "updateReply",
        type: "POST",
        data:{
            boardMo : data.boardNo,
            replyNo : data.replyNo,
            content: data.content
        }, 
        success: function () {
            // callback();
        },
        error: function () {
        }
    })
}