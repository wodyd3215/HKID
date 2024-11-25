function openfunction(e, optional) {
    inputBoardData(optional)
    openModal(e) 
}

function inputBoardData(optional) {
    const modals = document.querySelectorAll('#report-info .content div')
    const textarea = document.querySelector('#report-detail textarea')
    let index = 0

    for(const modal of modals) {
        modal.innerHTML = optional[index++]
    }

    textarea.value = optional[index]
}