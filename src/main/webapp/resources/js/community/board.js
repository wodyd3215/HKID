function boardInit(contextPath, boardContent) {
    const setting = {
        placeholder: "내용을 입력해 주세요",
        height: 400,
        width: 900,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
        ],
        setRoot: "board/",
    }

    initSummernote(setting, contextPath)

    if (boardContent) {
        initUpdateSummernote(boardContent)
    }
}

function btnDisable1() {
    const submitBtn = $("#submit-btn")
    const category = $("#search-category").val()
    const title = $("#board-title").val()
    const content = $("#content").val()

    if (category === null || category === "" || title === null || title === "" || content === null || content === "") {
        submitBtn.prop('disabled', true);
        submitBtn.css("color", "rgb(145, 144, 144)");
        submitBtn.css("cursor", "default");
    } else {
        submitBtn.prop('disabled', false);
        submitBtn.css("color", "#00a6fb");
        submitBtn.css("cursor", "pointer")
    }
}
