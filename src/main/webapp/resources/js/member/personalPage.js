function changeImg() {
    document.querySelector('#select-profile').click()
}

function previewProfile(input, contextPath, imgUrl) {
  // 가져온 파일이 있는지 검수하고 파일 유효 확인
  if(input.files && input.files[0] && validation(input.files[0])) {
    const fd = new FormData();
    fd.append("imgProfile", input.files[0])

    imgChangeAjax(fd, (res) => {
      // 파일 업로드 실패 시, 함수를 종료해 기존 이미지로 유지
      if(res === 'false') {
        alert('파일 업로드에 실패했습니다. 다시 시도해주세요.')
        // $('.profile-img').attr('src', contextPath + imgUrl)
        return
      } else {
        $('.profile-img').attr('src', contextPath + res)
      }
    })
  } else {
    return
  }
}

function resetImg(contextPath, imgUrl) {
  const data = {
    profileImg: imgUrl,
  }

  resetImgAjax(data, (res) => {
    if(res !== 'false') {
      $('.profile-img').attr('src', contextPath + res)
    } else {
      return
    }
  })
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

function checkPwd() {
  const newPwd = $('#memberPwd').val()
  const checknewPwd = $('#checkMemberPwd').val()

  if(newPwd === checknewPwd) {
    return true
  } else {
    alert("새 비밀번호가 일치하지 않습니다. 다시 입력해주세요.")    
    return false
  }
}

function imgChangeAjax(data, callback) {
  $.ajax({
    type: 'POST',
    url: 'imgChangeAjax.me',
    data: data,
    processData: false, //기본이 true -> 전송하는 data를 string으로 변환해서 요청
    contentType: false, //
    success: callback,
    error: () => {
      console.log('이미지 변경 실패')
    }
  })
}

function resetImgAjax(data, callback) {
  $.ajax({
    url: 'resetImage.me',
    type: 'POST',
    data: data,
    success: callback,
    error: () => {
      console.log('이미지 변경 실패')
    }
  })
}