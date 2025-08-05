/**
 * 
 */


document.addEventListener("DOMContentLoaded", () => {
	document.getElementById('searchType').addEventListener('change', function() {
		if (this.value === 'all') {
			document.getElementById('keywordInput').value = '';
		}
	});
});
