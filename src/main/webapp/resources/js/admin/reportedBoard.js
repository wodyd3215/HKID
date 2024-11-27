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
    const contentArea = document.querySelector('#content-detail .custom-modal-content')

    loadBoardAjax(optional, (res) => {

    })
}

function loadBoardAjax(boardNo, callback) {
    $.ajax({
        url: 'loadBoardAjax',
        type: 'POST',
        data: boardNo,
        success: callback,
        error: () => {
            console.log('게시글 불러오기 실패')
        }
    })
}