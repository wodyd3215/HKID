function initProductEnroll(contextPath, productContent) {
    const setting = {
        placeholder: "상품 설명을 입력하세요.",
        height: '100%',
        width: '100%',
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
        ],
        setRoot: 'product/',
    }

    initSummernote(setting, contextPath)

    if(productContent) {
        initUpdateSummernote(productContent)
    }
}

function initFile() {
    // 파일 정보 객체 초기화
    let fileInfo = {
        filesArr: [], // 이미지 파일 누적시키는 배열
        maxFileCnt: 4, // 첨부 파일 최대 개수
    };

    // 파일 입력 요소 가져오기
    const include = document.querySelector('.include-img');
    const form = document.querySelector('.content')

    // 첨부 파일 누적 저장
    include.onchange = () => {
         addFiles(fileInfo, include) 
    };

    form.onsubmit = () => {
        submitFile(fileInfo)
    }
}

function includeImg() {
    document.querySelector('.include-img').click()
}

function addFiles(fileInfo, include) {
    const attFileCnt = fileInfo.filesArr.length; // 기존 추가된 첨부파일 개수
        const remainFileCnt = fileInfo.maxFileCnt - attFileCnt; // 추가로 첨부 가능한 개수
        const currFileCnt = include.files.length; // 현재 선택된 첨부파일 개수

        if (currFileCnt > remainFileCnt) {
            alert("첨부 파일은 최대 " + fileInfo.maxFileCnt + "개 까지 첨부 가능합니다.");
            return;
        }

        for (let cnt = 0; cnt < Math.min(currFileCnt, remainFileCnt); cnt++) {
            const file = include.files[cnt];

            if(validation(file)) {
                fileInfo.filesArr.push(file); // filesArr에 파일 추가
            }
        }

        drawView(fileInfo.filesArr)
        
        console.log(fileInfo.filesArr);
}

function validation(file) {
    const type = ['image/jpeg', 'image/png']

    if(file.size > (95 * 1024 * 1024)) {
        alert('파일 크기가 95MB를 초과할 수 없습니다.')
        return false
    } else if(!type.includes(file.type)) {
        alert('jpg/jpeg, png파일만 업로드 가능합니다.')
        return false
    } else {
        return true
    }
}

function drawView(filesArr) {
    const pre = $('#img-area')
    // children() : 요소의 직계 자식 요소 선택
    // not() : 직계 자식 요소 제외시켜줌 
    pre.children().not('input[type="file"]').remove()

    filesArr.forEach((file, index) => {
        // 파일 내용을 비동기로 읽을 수 있는 브라우저 API
        const reader = new FileReader();
        
        // 파일이 성공적으로 읽히면 실행
        reader.onload = (event) => {
            // 파일의 Base64데이터(URL 형식)가 담겨 있음
            const imgSrc = event.target.result

            const previewArea = $('<div>').addClass('previewImg')
            const imgArea = $('<img>').attr('src', imgSrc)
            const closeBtn = $('<div>').addClass('material-symbols-outlined close-btn').text('close').click(() => {
                excludeFile(filesArr, index)
            })

            previewArea.append(imgArea, closeBtn)
            pre.append(previewArea)
        }

        // Base64 형식의 데이터 URL로 읽힘
        reader.readAsDataURL(file)
    });

    if(filesArr.length < 4) {
        const addArea = $('<div>').addClass('material-symbols-outlined').text('add').click(() => {
            includeImg()
        })

        pre.append(addArea)
    }
}

function excludeFile(filesArr, index) {
    // 배열의 특정 인덱스 제거 : .splice(시작 위치, 갯수)
    filesArr.splice(index, 1)

    drawView(filesArr)
}

function submitFile(fileArr) {

}