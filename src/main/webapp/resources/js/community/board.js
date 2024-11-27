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