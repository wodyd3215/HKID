function init(contextPath, pageName, optional) {
    // initDiaryEnroll()
    // 

    switch(pageName) {
        // case "ex":
        //     initpagename(optional); // 인자가 있을 경우
        //     initpagename();         // 인자가 없을 경우
        //     break;
        case "boardList":
            defaultCategory1(optional)
            break;
        case "boardDetail":
            detailOnload()
            break;
        case "enrollForm":
            boardInit(contextPath)
            break;
        case "updateForm":
            boardInit(contextPath, optional)
            btnDisable()
            changeHeart()
            break;
        case "myDiaryList":
            initDiaryPage(optional)
            break;
    }
}