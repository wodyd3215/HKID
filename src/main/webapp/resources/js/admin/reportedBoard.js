// 신고 확인 메서드(모달)
function inputDetailData(optional) {
    const modals = document.querySelectorAll('#report-info .content div')
    const textarea = document.querySelector('#report-detail textarea')
    let index = 0

    for(const modal of modals) {
        modal.innerHTML = optional[index++]
    }

    textarea.value = optional[index]
}

// 신고된 게시글 미리보기 메서드(모달)
function loadContent(optional) {
    console.log(typeof optional);
    const contentArea = $('#content-detail .custom-modal-content')

    loadBoardAjax({boardNo: optional}, (res) => {
        $('#board-title p').text(res.boardTitle)
        $('#writer-date div').text(res.nickName)
        $('#content').html(res.content)
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