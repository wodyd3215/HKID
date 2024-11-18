function openFile() {
    document.querySelector('#select-profile').click()
}

function previewProfile(input, contextPath, imgUrl) {
  // 가져온 파일이 있는지 검수
  if(input.files && input.files[0]) {
    // 파일이나 Blob 객체를 읽어들여 데이터를 비동기적으로 처리할 수 있도록
    // 도와주는 Web API
    const reader = new FileReader();

    // 파일 읽기 성공 시, 콜백 함수 실행
    reader.onload = (e) => {
      $('.profile-img').attr('src', e.target.result)
    }
    
    // 파일 객체를 읽은 후 데이터 url로 변환
    reader.readAsDataURL(input.files[0])
  } else {
      $('.profile-img').attr('src', contextPath + imgUrl)
  }
}

function showBtn() {
  const btnShow = $('.btn.sub-btn.custom-btn')

  btnShow.css("display") === "none" ? btnShow.show() : btnShow.hide()
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
