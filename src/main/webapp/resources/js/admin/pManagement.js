function postFormSubmit(type) {
    const formEl = document.querySelector("#postForm");
    switch(type) {
        case "edit": {
            $(formEl).attr("action", "updateForm.pr")
        } break;
        case "delete": {
            $(formEl).attr("action", "delete.pr")
        } break;
    }

    $(formEl).submit();
}