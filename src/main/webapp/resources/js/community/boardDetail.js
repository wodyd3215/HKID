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
    
    addReplyAjax({
        refBno: boardNo,
        replyWriter: userId,
        replyContent: content
    }, function(res){
        if(res === "success"){
            $("#content").val(""); // div 비우고
            getReplyList({bno: boardNo}, function(replyList){ //댓글 리스트 가져오고
                setReplyCount(replyList.length);    // 댓글 개수 가져오기
            })
        }
    })
}

function drawReplyList(tbody, commentsList) {
    const container = document.getElementById(tbody);
    container.innerHTML = ""; // 기존 내용을 초기화

    // comments-body-wrapper 생성
    const wrapper = document.createElement("div");
    wrapper.className = "comments-body-wrapper";  // id 대신 class 사용
    
    // comments-body 생성
    const commentsBody = document.createElement("div");
    commentsBody.className = "comments-body";  // id 대신 class 사용

    commentsList.forEach(c => {
        // main-comment 생성
        const mainComment = document.createElement("div");
        mainComment.className = "main-comment";  // id 대신 class 사용

        // comment-left 생성
        const commentLeft = document.createElement("div");
        commentLeft.className = "comment-left";  // id 대신 class 사용

        const userName = document.createElement("p");
        userName.className = "user-name";
        userName.textContent = c.userName;

        const date = document.createElement("p");
        date.textContent = c.date + " ";

        const replyButton = document.createElement("button");
        replyButton.className = "add-sub-comment";  // id 대신 class 사용
        replyButton.textContent = "답글쓰기";

        commentLeft.appendChild(userName);
        commentLeft.appendChild(date);
        commentLeft.appendChild(replyButton);

        // comment-middle 생성
        const commentMiddle = document.createElement("div");
        commentMiddle.className = "comment-middle";  // id 대신 class 사용
        commentMiddle.textContent = c.content;

        // comment-right 생성
        const commentRight = document.createElement("div");
        commentRight.className = "comment-right";  // id 대신 class 사용

        const editButton = document.createElement("button");
        editButton.textContent = "수정";

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "삭제";

        commentRight.appendChild(editButton);
        commentRight.appendChild(deleteButton);

        // main-comment에 모든 요소 추가
        mainComment.appendChild(commentLeft);
        mainComment.appendChild(commentMiddle);
        mainComment.appendChild(commentRight);

        // comments-body에 main-comment 추가
        commentsBody.appendChild(mainComment);
    });

    // wrapper에 comments-body 추가
    wrapper.appendChild(commentsBody);
    // container에 wrapper 추가
    container.appendChild(wrapper);
}
