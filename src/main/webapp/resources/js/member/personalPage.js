function openFile() {
    document.querySelector('#select-profile').click()
}

function previewProfile(input) {
    if (input.files && input.files[0]) {
      // type이 file인 input태그 <input type="file" /> 또는 
      // API 요청과 같은 File 또는 Blob 객체를 편리z하게 처리할 수 있는 방법을 제공하는 객체
        const reader = new FileReader();
        reader.onload = function(e) {
          document.querySelector('.profile-image').src = e.target.result;
        };
        // 파일 객체를 읽은 후 데이터 URL으로 변환
        reader.readAsDataURL(input.files[0]);
      } else {
        document.querySelector('.profile-image').src = "";
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
