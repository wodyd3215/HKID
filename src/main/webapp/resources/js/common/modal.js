function openModal(e) {
    document.getElementById(e.target.dataset.target).style.display = 'block'
}

function closeModal() {
    document.querySelectorAll('.modal').forEach(modal=>{
       if( modal.style.display !== 'none') {
            modal.style.display = 'none'
       }
    })
}

