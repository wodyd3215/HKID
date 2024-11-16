function init(contextPath) {
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
    }

    initSummerNote(setting, contextPath)
}

function initUnload() {
    initDeleteImg()
}

function initDeleteImg() {
    const images = $('img').attr("src")
    
    alert(images)
}