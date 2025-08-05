/**
 * 
 */
document.addEventListener("DOMContentLoaded", function() {
	const CPATH = document.body.dataset.contextPath;
	
	const selectProf = document.querySelector("#profNo");
	
	axios.get(`${CPATH}/student/counsel/professorList.do`).then(resp => {
		const professorList = resp.data;
		
		if (professorList) {
			const options = professorList.map(item => 
				`<option value="${item.userNo}">${item.userName} 교수</option>`
			).join("\n");
			
			selectProf.innerHTML += options;
			
			selectProf.addEventListener("change", () => {
				const selectedProfUserNo = selectProf.value;
				
				preferredDate.innerHTML = "<option value=''>선택하세요</option>";
				
				axios.get(`${CPATH}/student/counsel/availableTimes.do`, {
					params: { userNo : selectedProfUserNo }
				}).then(resp => {
					const timeList = resp.data;
					
					console.log("체킁 :", timeList);
					
					timeList.forEach((item) => {
						const dayKor = convertDayToKorean(item.RESERVATION_DAY);
						
						const option = document.createElement("option");
						option.value = `${dayKor}요일 ${item.START_HOUR}시`;
						option.text = `${dayKor}요일 ${item.START_HOUR}시`;
						preferredDate.appendChild(option);
					});
				}).catch(err => {
					console.error("상담 시간 불러오기 실패", err);
				});
			})
		}
	});
	
	function convertDayToKorean(day) {
		const dayMap = {
			MON: "월",
			TUE: "화",
			WED: "수",
			THU: "목",
			FRI: "금",
			SAT: "토",
			SUN: "일"
		};
		return dayMap[day] ?? day;
	}
});