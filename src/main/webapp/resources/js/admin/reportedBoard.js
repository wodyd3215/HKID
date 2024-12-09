function inputDetailData(optional) {
    const modals = document.querySelectorAll('#report-info .content div')
    const textarea = document.querySelector('#report-detail textarea')
    let index = 0

    for(const modal of modals) {
        modal.innerHTML = optional[index++]
    }

    textarea.value = optional[index]
}

function loadContent(optional) {
    console.log(typeof optional);
    const contentArea = $('#content-detail .custom-modal-content')

    loadBoardAjax({boardNo: optional}, (res) => {
        const title = $('#board-title p').text(res.boardTitle)
        const writer = $('#writer-date div').text(res.nickName)
        const content = $('#content').html(res.content)

        contentArea.append(title, writer, content)
    })
}

function loadBoardAjax(data, callback) {
    $.ajax({
        url: 'loadBoardAjax',
        type: 'POST',
        data: data,
        success: callback,
        error: () => {
            console.log('게시글 불러오기 실패')
        }
    })
}