// 처음 실행
$(function(){ //DOM이 로드된 후 자동실행
    const sendData = {
        bno: 1 // ${list.boardNo}
    }
    //댓글 목록 가져오기
    getReplyList(sendData, setReplyData)
})

// 매개변수 받아서 게시글 수정/삭제/신고 기능
function postFormSubmit(type){
    const $formEl = $(".postForm"); //요소 선택.

    switch(type){ 
        // 게시글 수정
        case "edit": 
            $formEl.attr("action", "updateForm.bo");
            console.log("게시글 수정요청 전달 성공!")
            break;
        
        // 게시글 삭제
        case "delete":
            $formEl.attr("action", "boardDelete.bo");
            console.log("게시글 삭제요청 전달 성공!")
            break;
        //신고 요청
        case "report":
            $formEl.attr("action", "report.bo");
            console.log("신고요청 전달 성공!")
    }
    $formEl.submit(); //공통기능
}

//댓글 갯수 및 목록 초기화
function setReplyData(commentsList){
    $("#reply-count").html(commentsList.length);
    drawReplyList(document.querySelector("#all-reply-wrapper"), commentsList);
}


//댓글 그려주는 함수
function drawReplyList(tbody, commentsList) {
    tbody.innerHTML = ""; // 기존 내용을 초기화

    let str = "";
    for(const comment of commentsList) { // 반복문 시작
        str +="<hr>\n" + 
        "<div class=\"comments-body\">\n" +
        "<div class=\"main-comment\">\n" +
        "<div id=\"comment-left\">\n"+
        "<p class=\"user-name\">" + comment.userName + "</p>\n"+
        "</p>" + comment.date + "&nbsp;</p>\n"+
        "<button class=\"add-sub-comment\">답글쓰기</button>\n"+
        "</div>\n"+
        "<div class=\"comment-middle\" id='comment-area'>" + comment.content + "</div>\n"+
        "<div class=\"comment-right\">\n"+
        "<button class=\"reply-update-btn\" data-target=\"updateReply\" onclick=\"updateReply()\">수정</button>\n" +
        "<button class=\"reply-delete-btn\">삭제</button>\n" +
        "</div>\n"+
        "</div>\n"+
        "</div>\n";
    }
    tbody.innerHTML += str;
}

//댓글 등록
function addReply(){
    const boardNo = 1 //${list.boardNo}
    const memberNo = "1"
    const replyContent = $("#content").val();
    const replyDate = "2024.11.07"//${list.replyDate}
    
    addReplyAjax({
        boardNo: boardNo,
        //replyNo: replyNo,
        //replyDate,
        memberNo: memberNo,
        replyContent: replyContent,
        
    }, function(res){
       
        $("#content").val(""); // div 비우고
        getReplyList({bno: boardNo}, setReplyData);
        
    })
}

             /*********** 댓글수정 ***********/
//댓글 수정
function updateReply(){
    
    const commentMiddle = document.getElementsByClassName("comment-middle"); // 넣을 div
    const beforeContent = $(".comment-middle").val(); //기존 댓글내용

    // const commentMiddle2 = document.getElementsByClassName("comment-middle").innerHTML

    const innerTextarea = document.createElement("textarea"); //textarea 생성

    commentMiddle.innerText="."; //div안쪽 제거
    console.log("여기까지1")
    innerTextarea.setAttribute("id", "comment-middle-input"); //textarea id 추가
    console.log("여기까지2")
    innerTextarea.setAttribute("width", "100%"); //가로 100%
    innerTextarea.setAttribute("height", "100%"); //세로 100%
    console.log("여기까지3")
  

    commentMiddle.appendChild(innerTextarea); // Textarea 삽입

    $("#comment-middle-input").innerText(beforeContent); // 기존 내용삽입

}


