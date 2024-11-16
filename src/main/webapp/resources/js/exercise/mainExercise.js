window.onload = function () {
    const urlParams = new URLSearchParams(window.location.search);
    const selectedParts = urlParams.getAll("part");
    const selectedDifficulties = urlParams.getAll("difficulty");

    // 부위별 선택 유지
    selectedParts.forEach(part => {
        const checkbox = document.querySelector(`input[name="part"][value="${part}"]`);
        if (checkbox) {
            checkbox.checked = true;
        }
    });

    // 난이도 선택 유지
    selectedDifficulties.forEach(difficulty => {
        const checkbox = document.querySelector(`input[name="difficulty"][value="${difficulty}"]`);
        if (checkbox) {
            checkbox.checked = true;
        }
    });
};
