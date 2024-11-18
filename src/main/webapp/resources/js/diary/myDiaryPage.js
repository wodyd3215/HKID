function initDiaryPage(optional) {
    initScrollPaging(optional)
}

function initScrollPaging(mNo) {
    let timer;

    let pageInfo = {
        memberNo: mNo,
        currentPage: 1,
        diaryLimit: 10,
        isLoad: true,
    }

    const loadEl = (dList) => {
        if(dList) {
            drawDiaryPreview(dList)
            pageInfo.currentPage++
        } else {
            pageInfo.isLoad = false;
        }
        
    }

    // loadDiary가 실행될 때 매개 변수로 사용되는 pageInfo를 기억하고 있음(계속 참조)
    // 이후 호출 시, loadDiary가 기억하고 있는 pageInfo를 가지고 옴
    const loadDiary = loadMyDiaryAjax(pageInfo, loadEl)
    loadDiary()

    // $(window).scrollTop() : 스크롤이 시작하는 부분부터 스크롤바 맨 위 부분의 사이 간격(스크롤바 맨 위 부분 위치)
    // $(window).height() : 우리가 보는 화면 크기(100vh)
    // $(document).height() : 전체(모든 요소 포함) 화면 크기
    document.onscroll = () => {
        clearTimeout(timer)

        timer = setTimeout(() => {
            if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
                if(pageInfo.isLoad === true) {
                    loadDiary()
                }        
            }
        }, 200)    
    } 
}
 
function loadMyDiaryAjax(pageInfo, callback) {
    return function() {
        $.ajax({
            type: 'POST',
            url: 'selectDiaryList.me',
            data: pageInfo,
            success: callback,
            error: () => {
                console.log('회원 조회 실패')
            }
        })
    } 
}

function drawDiaryPreview(dList) {
    const listArea = $('.list-area')

    dList.forEach(diary => {
        const conPre = $("<div>").addClass("my-content");
        const conArea = $("<div>").addClass("content-area");
        const dTitle = $("<div>").addClass("diary-title").text(diary.diaryTitle).click(() => {
            location.href = `detailDiary.di?diaryNo=${diary.diaryNo}`;
        });
        const dContent = $("<p>").addClass("diary-content").html(diary.diaryContent);
        const enrollDate = $("<div>").addClass("enroll-date").text(diary.createDate);

        listArea.append(conPre)
        conPre.append(conArea)
        conArea.append(dTitle, dContent, enrollDate)
    });
}