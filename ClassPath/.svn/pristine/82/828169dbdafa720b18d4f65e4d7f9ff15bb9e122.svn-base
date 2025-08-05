/**
 * 
 */

document.addEventListener("DOMContentLoaded", () => {
	const CPATH = document.body.dataset.contextPath;
	const pHakgi = document.querySelector("#pHakgi");
	const initVal = pHakgi.dataset.initVal;

	function loadGrades(year, term, allTimeYn) {
        axios.get(`${CPATH}/student/grade/historyList.do`, {
            params: { year, semester: term, allTimeYn }
        }).then(resp => {
            const lectureList = resp.data;
            const tbody = document.querySelector(".defaultTable tbody");
            tbody.innerHTML = "";

            if (!lectureList || lectureList.length === 0) {
                tbody.innerHTML = `<tr><td class="tableTd" colspan='6'>조회된 데이터가 없습니다.</td></tr>`;
                document.querySelector("#pointAvg").innerText = "평균 학점 : -";
                return;
            }

            let html = "";
            let sum = 0;
            let count = 0;

            lectureList.forEach(item => {
                html += `
                    <tr>
                        <td class="tableTd">${item.semester?.semesterName ?? "-"}</td>
                        <td class="tableTd">${item.lectureReq?.lecName ?? "-"}</td>
                        <td class="tableTd">${item.lectureReq?.lecCategory ?? "-"}</td>
                        <td class="tableTd">${item.subject?.credit ?? "-"}</td>
                        <td class="tableTd">${item.grade ?? "-"}</td>
                        <td class="tableTd">${item.gradePoint ?? "-"}</td>
                    </tr>
                `;

                if (item.gradePoint !== undefined && item.gradePoint !== null) {
                    sum += item.gradePoint;
                    count++;
                }
            });
            tbody.innerHTML = html;

            const avg = count > 0 ? (sum / count).toFixed(2) : "-";
            document.querySelector("#pointAvg").innerText = `평균 학점 : ${avg}`;
        }).catch(err => {
            console.error("성적 조회 실패:", err);
        });
    }
	
	axios.get(`${CPATH}/student/grade/semesterList.do`).then(resp => {
        const semesterList = resp.data;

        if (semesterList) {
            const termSet = new Set();
            semesterList.forEach(item => termSet.add(item.term));
            const uniqueTerms = Array.from(termSet);
            const options = uniqueTerms.map(term => `<option value="${term}">${term}</option>`).join("\n");
            pHakgi.innerHTML += options;
            pHakgi.value = initVal ?? "";
        }
    }).catch(err => {
        console.error("학기 목록 로드 실패:", err);
    });

	document.querySelector("#submitButton").addEventListener("click", (e) => {
		e.preventDefault();

		const year = document.querySelector("#pHaknyeondo").value;
		const term = document.querySelector("#pHakgi").value;
		const allTimeYn = document.querySelector("#allTimeYn").checked ? "Y" : "N";

		console.log("year :", year);
		console.log("term :", term);

		axios.get(`${CPATH}/student/grade/historyList.do`, {
			params: {
				year: year,
				semester: term,
				allTimeYn: allTimeYn
			}
		}).then(resp => {
			const lectureList = resp.data;
			console.log(lectureList);

			const tbody = document.querySelector(".defaultTable tbody");
			tbody.innerHTML = ""; // 기존 테이블 초기화

			if (!lectureList || lectureList.length === 0) {
				tbody.innerHTML = `<tr><td class="tableTd" colspan='5'>조회된 데이터가 없습니다.</td></tr>`;

				return;
			}

			let html = "";
			let sum = 0;
			let count = 0;
						
			lectureList.forEach(item => {
				html += `
		            	<tr>
			                <td class="tableTd">${item.semester?.semesterName ?? "-"}</td>
			                <td class="tableTd">${item.lectureReq?.lecName ?? "-"}</td>
							<td class="tableTd">${item.lectureReq?.lecCategory ?? "-"}</td>
			                <td class="tableTd">${item.subject?.credit ?? "-"}</td>
			                <td class="tableTd">${item.grade ?? "-"}</td>
			                <td class="tableTd">${item.gradePoint ?? "-"}</td>
			            </tr>
		            `;
				if (item.gradePoint !== undefined && item.gradePoint !== null) {
                    sum += item.gradePoint;
                    count++;
                }
			});
			tbody.innerHTML = html;
			
			const avg = count > 0 ? (sum / count).toFixed(2) : "-";
			
			document.querySelector("#pointAvg").innerText = `평균 학점 : ${avg}`;
		}).catch(err => {
			console.error("성적 조회 실패:", err);
		});
	});	
	
	loadGrades("", "", "Y");
});