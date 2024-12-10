function initNoticeEnroll(contextPath, noticeContent) {
    console.log("n : " + noticeContent)
    const setting = {
        placeholder: "오늘 하루는 어떠셨나요?",
        height: 578,
        width: '100%',
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
        ],
        setRoot: 'notice/',
    }

    initSummernote(setting, contextPath)

    if(noticeContent) {
        initUpdateSummernote(noticeContent)
    }
}