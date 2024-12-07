// 오늘 날짜 계산 (YYYY-MM-DD 형식)
const today = new Date();
const todayStr = today.toISOString().split('T')[0]; // YYYY-MM-DD 형식

// 모든 statusContent 요소를 가져옴
const statusElements = document.querySelectorAll('.statusContent');

statusElements.forEach(function (statusElement) {
    const endDate = statusElement.getAttribute('data-end-date'); // data-end-date 값
    if (endDate < todayStr) {
        // 마감된 상태: 배경색 변경 및 텍스트 변경
        statusElement.style.backgroundColor = 'black';
        statusElement.style.color = 'white';
        statusElement.textContent = '마감';
    }
});