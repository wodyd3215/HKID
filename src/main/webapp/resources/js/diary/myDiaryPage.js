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
            console.log(dList)
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
        // 이전에 설정된 타이머를 초기화하여 연속 호출 방지
        clearTimeout(timer) 

        // 200ms 대기 후 로직 실행(디바운싱)
        // 디바운싱 : 마지막 이벤트를 기준으로 일정 시간이 지나면 이벤트를 1번만 발생시키는 기법
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
        const dEdit = diary.diaryContent
        const conPre = $("<div>").addClass("my-content");
        const conArea = $("<div>").addClass("content-area");
        const dTitle = $("<div>").addClass("diary-title").text(diary.diaryTitle).click(() => {
            location.href = `detailDiary.di?diaryNo=${diary.diaryNo}`;
        });
        const dImg = searchImg(dEdit)
        // dEdit에서 모든 <img>태그를 제거
        /**
         * 정규식 설명
         * <img : <img로 시작하는 태그를 찾음
         * \b : 단어의 경계를 의미하며, <img 뒤에 공백이나 속성이 오는 경우를 포함한다.
         * [^>]* : <img 뒤에서 닫는 꺽쇠(>) 전까지의 모든 내용을 선택한다.
         * > : 태그의 닫는 꺽쇠
         * /g : 문자열 전체에서 해당 패턴을 전역적으로 검색하여 모든 <img> 태그를 제거한다.
         */
        const dContent = $("<p>").addClass("diary-content").html(dEdit.replace(/<img\b[^>]*>/g, ''));
        const enrollDate = $("<div>").addClass("enroll-date").text(diary.createDate);

        listArea.append(conPre)
        if(dImg !== null) {
            conPre.append(dImg)
        }
        conPre.append(conArea)
        conArea.append(dTitle, dContent, enrollDate)
    });
}

function searchImg(content) {
    const container = document.createElement("div"); // 임시 DOM 컨테이너
    container.innerHTML = content; // HTML 문자열 삽입

    const image = container.querySelector('img'); // 첫 번째 <img> 태그 검색

    if (image) { // 이미지가 있는 경우
        const imgArea = $("<div>").addClass("img-area"); // 이미지 컨테이너
        const imgTag = $("<img>").attr('src', image.getAttribute('src')); // <img> 태그 생성
        imgArea.append(imgTag);
        return imgArea;
    } else {
        return null; // 이미지가 없으면 null 반환
    }
}