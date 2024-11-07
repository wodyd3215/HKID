// 매개변수 받아서 게시글 수정/삭제하는 함수
function postFormSubmit(type){
    const $formEl = $(".postForm"); //요소 선택.

    console.log($formEl)
    switch(type){ 
        // 게시글 수정
        case "edit": 
            $formEl.attr("action", "updateForm.bo");
            console.log("수정요청 전달 성공!")
            break;
        
            // 게시글 삭제
        case "delete":
            $formEl.attr("action", "boardDelete.bo");
            console.log("삭제요청 전달 성공!")
            break;
    }
    $formEl.submit(); //공통기능
}


$(function(){ //DOM이 로드된 후 자동실행
    const sendData = {
        bno: 1 // ${list.boardNo}
    }
    //댓글 목록 가져오기
    getReplyList(sendData, function(replyList){
        
        //댓글 갯수 세는 함수 호출
        setReplyCount(replyList.length)
        
        //댓글작성 div
        const replyBody = $("#comments-body-wrapper")

        //댓글 목록 그려주는 함수 호출
        
        
    })
})

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

// 댓글 갯수 
function setReplyCount(count) {
    $("#reply-count").html(count);
}

//댓글 추가 ajax
function addReplyAjax(data, callback){
    $.ajax({
        url: "addReply.bo",
        data: data,
        success:function(res){
            callback(res)
        },
        error: function(){
            console.log("댓글 생성 ajax 실패")
        }
    })
}

//댓글 등록
function addReply(){
    const boardNo = 1 //${list.boardNo}
    const userId = "개떡도지떡상"
    const replyContent = $("#content")
    const replyDate = "2024.11.07"//${list.replyDate}
    
    addReplyAjax()
}