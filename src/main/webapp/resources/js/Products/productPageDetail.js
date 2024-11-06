const reviewBtn = document.getElementsByTagName("li");

for(let i=0; i<reviewBtn.length; i++){
    reviewBtn[i].addEventListener('click',function(e){
        e.preventDefault();
        document.querySelector('.detailMenuReview'(i+1)).scrollIntoView(true);
    });
}

