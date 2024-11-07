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
