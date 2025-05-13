function initProduct(contextPath, optional) {
    const files = {
        // input내 요소가 존재하면 해당 값을 가져오고, 없다면 null로 설정
        fileNo: $('input[name="fileNo"]').length > 0 ? $('input[name="fileNo"]').val() : null,
        changeName: $('input[name="changeName"]').length > 0 ? $('input[name="changeName"]').val() : null,
    }

    initProductEnroll(contextPath, optional)
    initFile(contextPath, files)
}

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

function initFile(contextPath, files) {
    // 파일 정보 객체 초기화
    let fileInfo = {
        fileNo: null,
        filesArr: [], // 이미지 파일 누적시키는 배열
    };

    // 상품 정보 수정 시 파일 정보가 존재할 경우 실행
    if(files.fileNo && files.changeName) {
        insertArr(contextPath, fileInfo, files)
    }

    // 파일 입력 요소 가져오기
    const include = document.querySelector('.include-img');
    const form = document.querySelector('.submit-btn')

    // 첨부 파일 누적 저장
    include.onchange = () => {
        addFiles(contextPath, fileInfo, include) 
    };

    form.onclick = () => {
        submitFile(fileInfo.filesArr, form.dataset.url) 
    }
}

// 수정 파일 정보를 업데이트하고 화면에 반영하는 함수
function insertArr(contextPath, fileInfo, files) {
    fileInfo.fileNo = files.fileNo

    for(let file of files.changeName.split(",")) {
        fileInfo.filesArr.push(file)
    }

    drawView(contextPath, fileInfo.filesArr);
}

function includeImg() {
    document.querySelector('.include-img').click()
}

// 파일 추가 감지 시 작동하는 함수
function addFiles(contextPath, fileInfo, include) {
    const maxFileCnt = 4 // 첨부 파일 최대 개수
    const attFileCnt = fileInfo.filesArr.length; // 기존 추가된 첨부파일 개수
    const remainFileCnt = maxFileCnt - attFileCnt; // 추가로 첨부 가능한 개수
    const currFileCnt = include.files.length; // 현재 선택된 첨부파일 개수

    if (currFileCnt > remainFileCnt) {
        alert("첨부 파일은 최대 " + maxFileCnt + "개 까지 첨부 가능합니다.");
        return;
    }

    // Math.min(): 두 값을 비교하여 더 작은 값을 반환
    for (let cnt = 0; cnt < Math.min(currFileCnt, remainFileCnt); cnt++) {
        const file = include.files[cnt];

        if(validation(file)) {
            fileInfo.filesArr.push(file); // filesArr에 파일 추가
        }
    }

    drawView(contextPath, fileInfo.filesArr)
}

// 파일 상태 유효 확인 함수
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

async function drawView(contextPath, filesArr) {
    let imgSrc = null;

    const pre = $('#img-area')
    // children() : 요소의 직계 자식 요소 선택
    // not() : 직계 자식 요소 제외시켜줌 
    pre.children().not('input[type="file"]').remove()

    // const [] : 구조 분해 할당(객체나 배열을 변수로 분해할 수 있게 해주는 특별한 문법)
    // Object.entries() : 객체를 배열로 변환해주는 메소드
    for(const [index, file] of filesArr.entries()) {
        if(typeof file === 'string') {  
            imgSrc = contextPath + file
            console.log(imgSrc)
        } else {
            imgSrc = await readFileAsDataURL(file);
        } 
        
        const previewArea = $('<div>').addClass('previewImg')
        const imgArea = $('<img>').attr('src', imgSrc)
        const closeBtn = $('<div>').addClass('material-symbols-outlined close-btn').text('close').click(() => {
            excludeFile(contextPath, filesArr, index)
        })
    
        previewArea.append(imgArea, closeBtn)
        pre.append(previewArea)
    }

    if(filesArr.length < 4) {
        const addArea = $('<div>').addClass('material-symbols-outlined').text('add').click(() => {
            includeImg()
        })

        pre.append(addArea)
    }
}

// 이미지 미리보기 비동기과정을 동기처럼 만들어줌 
function readFileAsDataURL(file) {
    return new Promise((resolve) => {
        // 파일 내용을 비동기로 읽을 수 있는 브라우저 API
        const reader = new FileReader();
            
        // 파일이 성공적으로 읽히면 실행
        reader.onload = (event) => {
            // 파일의 Base64데이터(URL 형식)가 담겨 있음
            resolve(event.target.result)
        }

        // Base64 형식의 데이터 URL로 읽힘
        reader.readAsDataURL(file) 
    })
}

function excludeFile(contextPath, filesArr, index) {
    // 배열의 특정 인덱스 제거 : .splice(시작 위치, 갯수)
    filesArr.splice(index, 1)

    drawView(contextPath, filesArr)
}

// 등록 버튼 눌렀을 때 작동하는 함수
function submitFile(filesArr, url) {
    if(filesArr.length < 1) {
        alert("이미지는 1개 이상 첨부해야합니다")
        return
    }

    const fd = new FormData()

    fd.append("productName", $('.productName').val())
    fd.append("category", $('.category').val())
    fd.append("quantity", $('.quantity').val())
    fd.append("price", $('.price').val())
    fd.append("content", $('.content').val())

    for(const file of filesArr) {
        if(typeof file !== "string") {
            fd.append("fileList", file) 
        } else {
            fd.append("srcList", file)
        }
    }

    if(url === 'updateProduct') {
        fd.append("productNo", $('.productNo').val())
    }

    registrationProduct(fd, url, function(res) {
        if(res === 'success') {
            alert("상품 등록 성공")

            window.location.href = 'product.ad';
        } else {
            alert("상품 등록 실패")
        }
    })
}

// 상품 등록 및 수정 AJax
function registrationProduct(data, url, callback) {
    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        processData: false, //기본이 true -> 전송하는 data를 string으로 변환해서 요청
        contentType: false,  // 요청할 때 타입 -> false -> multipart/form-data 형식
        success: callback,
        error: () => {
            alert('비어있는 양식이 있습니다.')
            console.log("ajax 실패")
        },
    })
}