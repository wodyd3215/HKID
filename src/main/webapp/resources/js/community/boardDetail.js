// 처음 실행
function detailOnload(bnoMno){ //DOM이 로드된 후 자동실행
    // console.log("detailOnload의 매개변수: "+bnoMno)

    checkGood(bnoMno)   //좋아요 상태를 확인
    const boardData = JSON.parse(bnoMno);   //String으로 온 데이터를 JSON으로 파싱
    countGood(boardData, drawCountGood);

    //댓글 목록 가져오기
    getReplyList(boardData.boardNo, setReplyData)
}

//하트 ON / OFF
let isHeartOnOff;

function changeHeart(_this, boardNo, memberNo){
    if (($("#heart-img").attr('src')) === 'resources/image/board/heart.png'){
        isHeartOnOff = true;
    }else{
        isHeartOnOff = false;
    }

    // 좋아요 insert ajax
    insertGood({ boardNo, memberNo });
    if(!isHeartOnOff){
        $(_this).attr("src", "resources/image/board/heart.png");
        isHeartOnOff = true;
        console.log("하트 on")
    }else{
        $(_this).attr("src", "resources/image/board/emptyHeart.png");
        isHeartOnOff = false;
        console.log("하트 off")
    }
    updateGood({
            isHeartOnOff,
            boardNo,
            memberNo
    });
}

// 좋아요 개수 그려주는 함수
function drawCountGood(count){
    $("#count-good").html(count);
}

/****************************  댓글   ****************************/
//댓글 갯수 및 목록 초기화
function setReplyData(commentsList){
        $("#reply-count").html(commentsList.length); //댓글 개수를 List의 길이만큼
        drawReplyList(document.querySelector("#all-reply-wrapper"), commentsList);
}

function drawReplyList(tbody, commentsList) {
    tbody.innerHTML = ""; // 기존 내용을 초기화

    let str = "";
    for (const comment of commentsList) {
        str += `
        <hr>
        <div class="comments-body">
            <div class="main-comment">
                <div id="comment-left">
                    <p class="user-name">${comment.nickName}</p>
                    <p>${comment.date}&nbsp;</p>
                    <button class="add-sub-comment">답글쓰기</button>
                </div>
                <div class="comment-middle" id="comment-area">${comment.content}</div>
                <div class="comment-right">
                    <button class="reply-update-btn" data-target="updateReply" onclick="updateReply()">수정</button>
                    <button class="reply-delete-btn" onclick="deleteReply('${comment.boardNo}', '${comment.replyNo}')">삭제</button>
                </div>
            </div>
        </div>
        `;
    }
    tbody.innerHTML += str;
}



//댓글 등록
function addReply(boardNo, memberNo){
    const replyContent = $("#write-comment").val();
    boardNo = parseInt(boardNo); //혹시 몰라서 형변환

    addReplyAjax({
        boardNo: boardNo,
        memberNo: memberNo,
        replyContent: replyContent
    }, function(){
        $("#write-comment").val(""); // div 비우고

        getReplyList(boardNo, setReplyData);
    })
}

//댓글 삭제
function deleteReply(boardNo, replyNo){
    deldeteReplyAjax({
        boardNo: boardNo,
        replyNo: replyNo
    }, function(){
        getReplyList(boardNo, setReplyData);
    }
)}


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


