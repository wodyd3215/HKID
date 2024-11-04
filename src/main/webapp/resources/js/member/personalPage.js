function openFile() {
    document.querySelector('.select-profile').click()
}

function previewProfile(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();
        reader.onload = function(e) {
          document.querySelector('.profile-image').src = e.target.result;
        };
        reader.readAsDataURL(input.files[0]);
      } else {
        document.querySelector('.profile-image').src = "";
      }
}

function showBtn() {
    const showBtn = document.querySelector('.btn.sub-btn.custom-btn')

    showBtn.style.display === "none" ? showBtn.style.display = "block" : showBtn.style.display = "none"
}