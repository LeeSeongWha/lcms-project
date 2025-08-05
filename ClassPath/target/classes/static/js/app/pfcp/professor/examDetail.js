/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	const lecNo = document.querySelector("#lecNo");
	const initVal = lecNo.dataset.initVal;
	
	const CPATH = document.body.dataset.contextPath;
	
	axios.get(`${CPATH}/professor/exam/lecNameList.do`).then(resp => {
		const lecNameList = resp.data;
		
		console.log("lecNameList", lecNameList);
		
		if (lecNameList) {
			const options = lecNameList.filter(item => item.lecNo != initVal)
									   .map((lecture) => `<option value="${lecture.lecNo}">${lecture.lectureReq.lecName}</option>`)
									   .join("\n");
			
			lecNo.innerHTML += options;
			
			lecNo.value = initVal ?? "";
		}
	});
});