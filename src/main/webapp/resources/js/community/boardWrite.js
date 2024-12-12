function btnDisable1() {
    // Summernote 내용과 textarea 동기화
    const content = $('#content').summernote ? $('#content').summernote('code').trim() : $('#content').val().trim();
    const category = $("#search-category").val();
    const submitBtn = $("#submit-btn");
    const title = $("#board-title").val()?.trim();

    // 유효성 검사
    if (!category || !title || !content || content === '<p><br></p>') {
        submitBtn.prop('disabled', true).css({
            color: "rgb(145, 144, 144)",
            cursor: "default",
        });
    } else {
        submitBtn.prop('disabled', false).css({
            color: "#00a6fb",
            cursor: "pointer",
        });
    }
}
