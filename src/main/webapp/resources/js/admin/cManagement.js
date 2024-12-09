function addFormChallenge() {
    const body = $('tbody')
    const addHtml = `<tr id="common-table-body">
                        <td id="preview-img">
                            <input type="file" class="include-img" name="upfile" onchange="showPreview(this)">
                            <div class="material-symbols-outlined" onclick="previewImg()">add</div>
                        </td>
                        <td><input type="text" name="challengeTitle" placeholder="챌린지 제목을 입력해주세요"></td>
                        <td><input type="date" name="startDate"></td>
                        <td><input type="date" name="endDate"></td>
                        <td><div class="management">
                            <button class="material-symbols-outlined btn btn-primary custom-btn" onclick="addChallenge()">
                                check
                            </button>
                            <button class="material-symbols-outlined btn btn-danger custom-btn" onclick="closeAddForm()">
                                close
                            </button>
                        </td>
                    </tr>`
    
    body.children().not('.common-table-body').remove()

    body.prepend(addHtml)
}

function previewImg() {
    document.querySelector('.include-img').click()
}

function showPreview(input) {
    if (input.files && input.files[0] && validation(input.files[0])) {
        draw(input.files[0])
    } else {
        return
    }
}

function draw(input) {
    const reader = new FileReader();     
    // 파일이 성공적으로 읽히면 실행
    reader.onload = (event) => {
        $('#preview-img').children().not('input[type="file"]').remove()

        const img = $('<img>').attr('src', event.target.result).click(() => {
            previewImg()
        });
        $('#preview-img').append(img)
    }

    // Base64 형식의 데이터 URL로 읽힘
    reader.readAsDataURL(input) 
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

function closeAddForm() {
    const body = $('tbody')

    body.children().not('.common-table-body').remove()
}

function addChallenge() {
    const fd = new FormData();

    fd.append("challengeTitle", $('input[name="challengeTitle"]').val())
    fd.append("startDate", $('input[name="startDate"').val())
    fd.append("endDate", $('input[name="endDate"').val())
    fd.append("upfile", $('input[type="file"]')[0].files[0])

    insertChallenge(fd, function(res) {
        if(res === 'success') {
            alert('챌린지 등록 성공')
            window.location.href = 'challenges'
        } else {
            alert("챌린지 등록 실패")
        }
    })
}

function insertChallenge(data, callback) {
    $.ajax({
        url: "insertChallenge",
        type: 'post',
        data: data,
        processData: false, //기본이 true -> 전송하는 data를 string으로 변환해서 요청
        contentType: false,  // 요청할 때 타입 -> false -> multipart/form-data 형식
        success: callback,
        error: () => {
            console.log("챌린지 등록 ajax 실패")
        }
    })
}