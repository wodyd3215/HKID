// 서머노트 사용주의
//  - jQuery 파일이 먼저 로드 되어야함!
//  >> 앞 줄에 제이쿼리가 써머노트보다 먼저 추가 되어야 한다는 뜻(jQuery중복도 체크!)

/*
    setting: summernote를 설정이 다 다르기 때문에 페이지 로드 시,
             각자 원하는 세팅을 키-값 형태로 만들어 주면 됨
*/
function initSummerNote(setting, contextPath) {
    $('#content').summernote({ 
        placeholder: setting.placeholder, 
        tabsize: 2,
        height: setting.height,
        width: setting.width,
        disableResizeEditor: true,
        toolbar: setting.toolbar,
        callbacks: {
            onImageUpload: (files) => {fileUpload(files, contextPath, setting.url)},
            onMediaDelete: (target) => {deleteFile($(target[0]), setting.url)},
        }
    });
}

// DB에서 가져온 Content(게시글 내용)을 서머노트에 넣어주는 함수
function initUpdateSummernote(Content) {
    $('#content').summernote('code', Content);
}

//썸머노트에 이미지업로드가 발생하였을 때 동작하는 함수
function fileUpload(files, contextPath, url){
   const fd = new FormData();
   for(let file of files) {
       fd.append("fileList", file);
   }
   
   insertFile(fd, url, function(res){
    if(res !== 'error') {
        for(let img of res){
            $("#content").summernote("insertImage", contextPath + "/resources/image/diary/" + img);
        }
    } else {
        alert('이미지 불러오기 실패')
    }  
   })
}

function insertFile(data, url, callback){
   $.ajax({
       url: url.insert,
       type: "POST",
       data: data,
       processData: false, //기본이 true -> 전송하는 data를 string으로 변환해서 요청
       contentType: false, //
       dataType: "json", //받을 때 타입 
       success: function(res){
           callback(res)
       },
       error: function(){
           console.log("파일업로드 api요청 실패")
       } 
   })
}

// 썸머노트에 업로드한 이미지를 삭제할 때 동작하는 메서드
function deleteFile(target, url) {
    $.ajax({
        url: url.delete,
        type:"POST",
        data: { img: target.attr("src").replace("/HKID", "").trim() },
    })
}