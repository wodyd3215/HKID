function defaultCategory2(cate) {
    cate = cate || '1';

    const opt = document.querySelector(`#search-category option[value=${cate}]`);
    opt.setAttribute("selected", true);
}

//  

function btnDisable(){
    const category = $("#search-category").val()
    const submitBtn = $("#submit-btn")
    if (category === null || category === ""){
        submitBtn.prop('disabled', true);
        submitBtn.css("color", "rgb(145, 144, 144)");
    }else{
        submitBtn.prop('disabled', false);
        submitBtn.css("color", "#00a6fb");
    }
}
