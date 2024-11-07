function init(contextPath, pageName, optional) {
    initWidth()
}

function initWidth() {
    const elements = document.getElementsByTagName('th');

    for(const el of elements) {
        console.log(el.getAttribute('data-width'))
        const width = el.getAttribute('data-width');
        if(width) {
            el.style.width = width
        }
    }
}