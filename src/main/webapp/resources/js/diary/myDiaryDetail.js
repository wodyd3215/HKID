// type 인자를 받아 form태그 action에 주소를 넣어주는 함수
function postFormSubmit(type) {
    const formEl = $("#postForm");
    switch(type) {
        case "edit": {
            $(formEl).attr("action", 'updateDiaryForm.di')
        } break;
        case "delete": {
            $(formEl).attr("action", 'delete.di')
        } break;
    }

    $(formEl).submit();
}