function init(contextPath, diaryContent) {
    const setting = {
        placeholder: "오늘 하루는 어떠셨나요?",
        height: 460,
        width: '100%',
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
        ],
        setRoot: "diary/",
    }
    
    initSummernote(setting, contextPath)

    if(diaryContent) {
        initUpdateSummernote(diaryContent)
    }
}