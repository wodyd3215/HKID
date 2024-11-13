function init(contextPath, pageName, optional) {
    initWidth()
    initSummerNote()
}

// 테이블 th의 크기를 dataset을 통해서 자동으로 적용시킴
function initWidth() {
    const elements = document.getElementsByTagName('th');

    for(const el of elements) {
        const width = el.getAttribute('data-width');
        if(width) {
            el.style.width = width
        }
    }
}