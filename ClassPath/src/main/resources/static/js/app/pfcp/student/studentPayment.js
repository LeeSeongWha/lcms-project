/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	
	document.getElementById('kakaoPayBtn').addEventListener('click', async () => {
		const orderId = '${orderId}';
		
		console.log("체킁 :", orderId);
		
		const popup = window.open(
		        '/student/certificate/kakaopay/ready/' + orderId,
		        'kakaopay',
		        'width=500,height=700'
		    );

		    if (!popup) {
		        alert('팝업 차단을 해제해주세요.');
		    }
	});
});