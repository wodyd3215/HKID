// 서머노트 사용주의
//  - jQuery 파일이 먼저 로드 되어야함!
//  >> 앞 줄에 제이쿼리가 써머노트보다 먼저 추가 되어야 한다는 뜻(jQuery중복도 체크!)

function initSummerNote() {
    console.log($('#sumHe').data('he'))
    
    $('#content').summernote({ 
        placeholder: '글을 입력하세요.', 
        tabsize: 2,
        minHeight: $('#sumHe').data('he') || 400,
        maxHeight: $('#sumHe').data('he') || 400,
        width: '100%',
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
        ],
        callbacks: {
            onImageUpload: fileUpload
        }
});
}



//썸머노트에 이미지업로드가 발생하였을 때 동작하는 함수
function fileUpload(files){
   console.log(files)
   
   const fd = new FormData();
   for(let file of files) {
       fd.append("fileList", file);
   }
   
   insertFile(fd, function(nameList){
       for(let name of nameList){
           $("#content").summernote("insertImage","resources/image/" + name);
       }
   })
}

function insertFile(data, callback){
   $.ajax({
       url: "upload",
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