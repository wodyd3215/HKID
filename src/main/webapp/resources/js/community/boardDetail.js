// 처음 실행
function detailOnload(bnoMno){ //DOM이 로드된 후 자동실행
    const boardData = JSON.parse(bnoMno);   //String으로 온 데이터를 JSON으로 파싱
    // console.log("detailOnload의 매개변수: "+bnoMno)

    //좋아요 비활성화

    //좋아요 상태를 확인
    checkGood(bnoMno, function(res){   });

    //좋아요 개수
    countGood(boardData, drawCountGood);

    //댓글 목록 가져오기
    getReplyList(boardData.boardNo, setReplyData)
}

// 하트 버튼누르면 실행되는 함수
function HeartChangeBtn(_this, boardNo, memberNo) {
    let isHeartOnOff = null;
    if (($("#heart-img").attr('src')) === 'resources/image/board/heart.png') {
        $("#heart-img").attr("src", "resources/image/board/emptyHeart.png")
        isHeartOnOff = false;
    } else {
        $("#heart-img").attr("src", "resources/image/board/heart.png")
        isHeartOnOff = true;
    }
    console.log("boardNo: " + boardNo);
    changeHeart({ _this, boardNo, memberNo, isHeartOnOff },
        function(){
            countGood({ boardNo }, drawCountGood)
        }
    )
}


// 좋아요 개수 그려주는 함수
function drawCountGood(count){
    $("#count-good").html(count);
}

/****************************  댓글   ****************************/
//댓글 갯수 및 목록 초기화
function setReplyData(data){
    const commentsList = data.replyList;
    console.log("data.replyList: " + data.replyList);
    console.log("data.loginMemberNo" + data.loginMemberNo);
    
    $("#reply-count").html(commentsList.length); //댓글 개수를 List의 길이만큼
    drawReplyList(document.querySelector("#all-reply-wrapper"), data.replyList, data.loginMemberNo);
}

//댓글 그려주는 함수
function drawReplyList(tbody, commentsList, loginMemberNo) {
    tbody.innerHTML = ""; // 기존 내용을 초기화

    let str = "";
    for (const comment of commentsList) {
        str += `
            <hr>
                <div class="comments-body">
                    <div class="main-comment" id="main-comment${comment.replyNo}">
                        <div class="comment-left">
                            <p class="user-name">${comment.nickName}</p>
                            <p>${comment.date}&nbsp;</p>
                            
                        </div>
                        <div class="comment-middle">${comment.content}</div>
                        <div class="comment-right">
                            ${comment.memberNo === loginMemberNo ? `
                                <button class="reply-update-btn" data-target="updateReply" onclick="changeUpdate('${comment.replyNo}', '${comment.boardNo}', '${comment.memberNo}')">수정</button>
                                <button class="reply-delete-btn" onclick="deleteReply('${comment.boardNo}', '${comment.replyNo}')">삭제</button>
                            ` : ''}
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



/************************* 댓글 수정 *************************/
// [수정] 누르면 -> [수정완료] 변환함수
function changeUpdate(replyNo, boardNo, memberNo) {

    // const mainComment = button.closest(".main-comment"); // 강사님:"closest()는 바뀌는 경우가 있을 수 있어서 현업에서 안 씁니다"
    const mainComment = document.querySelector("#main-comment"+replyNo); //replyNo를 id에 넣어서 특정시킬 수 있게 함
    // console.log("mainComment: " + mainComment)

    const commentMiddle = mainComment.querySelector(".comment-middle"); // 댓글 내용 영역
    const beforeContent = commentMiddle.innerText; // 기존 댓글 내용 가져오기

    // textarea 생성
    const innerTextarea = document.createElement("textarea");
    innerTextarea.setAttribute("class", "comment-middle-input");
    innerTextarea.style.width = "100%";
    innerTextarea.style.height = "100%";
    innerTextarea.style.border = "1px solid black";
    innerTextarea.style.resize = "none";
    innerTextarea.style.lineHeight = "20px";

    innerTextarea.value = beforeContent; // 기존 댓글 내용을 textarea에 삽입

    // 기존 댓글 내용을 textarea로 교체
    commentMiddle.innerHTML = ""; // 기존 댓글 내용 제거
    commentMiddle.appendChild(innerTextarea); // textarea 삽입

    const btnDiv = mainComment.querySelector(".comment-right"); //수정, 삭제 버튼 div
    btnDiv.innerHTML=""; // 내용 지우기
    
    //수정완료 버튼
    // btnDiv = mainComment.querySelector(`#main-comment"  replyNo .comment-right`);
    const replyUpdateComplate = document.createElement("button");  //[수정완료] 버튼 생성
    replyUpdateComplate.setAttribute("class", "update-btn");    //class 생성
    replyUpdateComplate.innerText = "수정 완료";
    replyUpdateComplate.setAttribute(
        "onclick", 
        `updateReply(${replyNo}, ${boardNo}, ${memberNo})`);    //여기까지@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    btnDiv.appendChild(replyUpdateComplate); // div에 [수정완료] 삽입
}

// [수정완료] 기능
function updateReply(replyNo, boardNo, memberNo){
    // textarea의 값 가져오기
    const content = $(`#main-comment${replyNo} .comment-middle-input`).val();
    console.log(content);

    //ajax에 data로 보내기
    // console.log("boardNo: " + boardNo)
    // console.log("replyNo: " + replyNo)
    // console.log("memberNo: " + memberNo)

    updateReplyAjax({
        boardNo, replyNo, content
    }, function(){
        getReplyList(boardNo, setReplyData);
    });
}

function btnDisable2() {
    const category = $("#report-textarea").val()
    const submitBtn = $("#report-submit-btn")

    if (category === null || category === "") {
        submitBtn.prop('disabled', true);
        submitBtn.css("color", "rgb(145, 144, 144)");
        submitBtn.css("cursor", "default");
    } else {
        submitBtn.prop('disabled', false);
        submitBtn.css("color", "#00a6fb");
        submitBtn.css("cursor", "pointer")
    }
}
