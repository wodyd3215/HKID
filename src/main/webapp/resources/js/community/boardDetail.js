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
        //신고 요청
        case "report":
            $formEl.attr("action", "report.bo");
            console.log("신고요청 전달 성공!")
    }
    $formEl.submit(); //공통기능
}

// 처음 실행
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
        url: "insertReply.bo",
        data: data,
        type: "POST",
        success:function(res){
            console.log(res)
            callback(res)
        },
        error: function(xhr, status, error) {
            console.log("댓글 생성 ajax 실패");
            console.log("Error Status: " + status);  // 에러 상태 출력
            console.log("Error Details: " + error);  // 에러 세부 내용 출력
            console.log("Response Text: " + xhr.responseText);  // 서버 응답 내용 출력
        }
    })
}

//댓글 등록
function addReply(){
    const boardNo = 1 //${list.boardNo}
    const memberNo = "1"
    const replyContent = $("#content").val();
    const replyDate = "2024.11.07"//${list.replyDate}
    
    addReplyAjax({
        boardNo: boardNo,
        memberNo: memberNo,
        replyContent: replyContent,
        
    }, function(res){
        if(res === "success"){
            console.log(res)
            $("#content").val(""); // div 비우고
            getReplyList({bno: boardNo}, function(commentsList){ //댓글 리스트 가져오고
                console.log(commentsList)
                
                setReplyCount(commentsList.length);    // 댓글 개수 가져오기

                drawReplyList(document.querySelector("#all-reply-wrapper"), commentsList);
                console.log("drawReplyList 실행")
            });
        }
    })
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
        "<div class=\"comment-middle\">" + comment.content + "</div>\n"+
        "<div class=\"comment-right\">\n"+
        "<button>수정</button>\n" +
        "<button>삭제</button>\n" +
        "</div>\n"+
        "</div>\n"+
        "</div>\n";
    }
    tbody.innerHTML += str;
}

//댓글 수정ajax
function updateReply(data, callback){
    $.ajax({
        url: "updateReply.bo",
        type: "POST",
        data: data,
        success: function(res){
            callback(res)
        },
        error: console.log("댓글 수정 ajax 통신 실패ㅠㅠ")


    })


}

//링크 복사 기능(비동기)
function copyLink(){
    //window는 전역객체라서 생략가능, promise를 반환함
    window.navigator.clipboard.writeText(window.location.href) // 클립보드에 현재 url 넣기
        .then(() => { //성공했을 때
            alert("클립보드에 현재 url이 복사되었습니다.");
        })
        .catch(err =>{
            alert("복사에 실패했습니다. 다시 시도해주세요.");
            console.error("복사에 실패했습니다", err);
        }
    )
}

//신고 모달