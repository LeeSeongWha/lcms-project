document.addEventListener("DOMContentLoaded", 
function() {
	showTab('year1');
});

function showTab(tabId) {
	const tabButtons = document.querySelectorAll('.tab-button');
    const tabContents = document.querySelectorAll('.tab-content');

    tabButtons.forEach(button => button.classList.remove('active'));
    tabContents.forEach(content => content.classList.remove('active'));

    document.querySelector(`.tab-button[onclick="showTab('${tabId}')"]`).classList.add('active');
            
    document.getElementById(tabId).classList.add('active');
}