function changeImg() {
    document.querySelector('#select-profile').click()
}

function previewProfile(input, contextPath, imgUrl) {
  // 가져온 파일이 있는지 검수
  if(input.files && input.files[0]) {
    const fd = new FormData();
    fd.append("imgProfile", input.files[0])

    imgChangeAjax(fd, (res) => {
      if(res === 'false') {
        $('.profile-img').attr('src', contextPath + imgUrl)
      } else {
        $('.profile-img').attr('src', contextPath + res)
      }
    })
  } else {
      $('.profile-img').attr('src', contextPath + imgUrl)
  }
}

function resetImg(contextPath, imgUrl) {
  const data = {
    profileImg: imgUrl,
  }

  resetImgAjax(data, (res) => {
    if(res === 'false') {
      $('.profile-img').attr('src', contextPath + imgUrl)
    } else {
      $('.profile-img').attr('src', contextPath + res)
    }
  })
}

function checkPwd() {
  const newPwd = $('#memberPwd').val()
  const checknewPwd = $('#checkMemberPwd').val()

  if(newPwd === checknewPwd) {
    return true
  } else {
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