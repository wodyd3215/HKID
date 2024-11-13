function init(pageName, optional) {
    // initDiaryEnroll()
    // initSummerNote()

    switch(pageName) {
        // case "ex":
        //     initpagename(optional); // 인자가 있을 경우
        //     initpagename();         // 인자가 없을 경우
        //     break;
        case "myDiaryList":
            initDiaryPage(optional)
            break;
    }
}