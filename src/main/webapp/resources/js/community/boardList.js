function defaultCategory(cate) {
    cate = cate || '전체';

    const opt = document.querySelector(`.table-category option[value=${cate}]`);
    opt.setAttribute("selected", true);
}
