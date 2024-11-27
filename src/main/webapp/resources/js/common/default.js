function init(contextPath, memberNo, pageName, optional) {
    // initDiaryEnroll()
    initChatBox(contextPath, memberNo);

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
        // case "boardUpdate":
        //     defaultCategory2(optional)
        //     break;
        case "myDiaryList":
            initDiaryPage(optional)
            break;
    }
}