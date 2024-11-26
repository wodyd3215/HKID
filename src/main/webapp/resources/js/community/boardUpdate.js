function defaultCategory2(cate) {
    cate = cate || '1';

    const opt = document.querySelector(`#search-category option[value=${cate}]`);
    opt.setAttribute("selected", true);
}
