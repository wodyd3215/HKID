function selectAll(selectAll){
    const checkboxes = document.querySelectorAll('input[type="checkBox"]');

    checkboxes.forEach((checkbox) =>{
        checkbox.checked = selectAll.checked
    })
}