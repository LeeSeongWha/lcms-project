function fillDemoData() {
		const profSelect = document.getElementById("profNo");
		const dateSelect = document.getElementById("preferredDate");

		// 1. 교수 자동 선택
		if (profSelect.options.length > 1) {
			profSelect.selectedIndex = 1;

			// 2. onchange 이벤트 강제로 트리거 (AJAX 호출)
			profSelect.dispatchEvent(new Event("change"));
		}

		// 3. AJAX로 날짜가 채워질 시간이 필요하므로 약간 기다림
		setTimeout(() => {
			if (dateSelect.options.length > 1) {
				dateSelect.selectedIndex = 1;
			}
		}, 500); // 0.5초 기다림 (필요시 조정 가능)

		// 4. 상담 유형 및 내용 입력
		document.getElementById("reqType").value = "대면";
		document.querySelector("textarea[name='counselComment']").value = "학업 관련 진로 상담을 받고 싶습니다.";
	}
	
	function fillDemoNotice() {
		document.getElementById("typeCode").value = "SUG";
		document.getElementById("boardTitle").value = "학사 일정 개선 건의";
		document.getElementById("boardContent").value = "기말고사 일정과 과제 제출일이 너무 겹쳐 있어 학생들이 과중한 스트레스를 받고 있습니다. 일정 조정을 건의드립니다.";
		
		showCustomModal("데모 데이터가 입력되었습니다.", "alert");
	}
	
	function fillDemoSchedule() {
	// 데모 일정 제목
	document.getElementById("scheduleTitle").value = "2025학년도 2학기 수강신청 일정";

	// 일정 유형이 셀렉트박스로 구성되어 있고 옵션이 있다면 첫 번째 실제 값 선택
	const scheduleTypeSelect = document.getElementById("scheduleType");
	if (scheduleTypeSelect.options.length > 1) {
		scheduleTypeSelect.selectedIndex = 1; // 두 번째 항목 (0번은 안내문)
	}

	// 오늘 날짜를 기준으로 입력
	const today = new Date().toISOString().split("T")[0];
	document.getElementById("startDate").value = "2025-08-04";
	document.getElementById("endDate").value = "2025-08-08";

	// 시간 설정
	document.getElementById("startTime").value = "10:00";
	document.getElementById("endTime").value = "18:00";

	// 설명
	document.getElementById("scheduleDesp").value = `📢 2025학년도 2학기 수강신청 일정 및 유의사항 안내 📢
안녕하세요, 학생 여러분!

다가오는 2025학년도 2학기 수강신청 일정을 안내해 드립니다. 원활한 수강신청을 위해 아래 내용을 꼼꼼히 확인하시고, 기간 내에 신청을 완료해 주시기 바랍니다.

🗓 주요 일정
수강신청 기간:

예비 수강신청: 2025년 8월 12일(화) 10:00 ~ 8월 14일(목) 17:00

본 수강신청 (학년별):

4학년: 2025년 8월 19일(화) 10:00 ~ 17:00

3학년: 2025년 8월 20일(수) 10:00 ~ 17:00

2학년: 2025년 8월 21일(목) 10:00 ~ 17:00

1학년: 2025년 8월 22일(금) 10:00 ~ 17:00

수강정정 기간: 2025년 9월 2일(화) 10:00 ~ 9월 4일(목) 17:00

수강신청 시스템 오픈: 각 기간 시작일 오전 10시

📍 수강신청 방법
학교 포털 로그인: 학교 홈페이지에서 [수강신청 시스템 바로가기] 링크를 클릭하거나, 직접 수강신청 시스템에 접속합니다.

로그인: 학번과 비밀번호를 입력하여 로그인합니다.

과목 선택: 개설 강좌 목록을 확인하고, 수강하고자 하는 과목을 선택하여 신청합니다.

신청 확인: 신청 완료 후 반드시 [수강신청 내역 조회]에서 정상적으로 신청되었는지 확인합니다.

⚠️ 유의사항
기간 엄수: 정해진 기간 외에는 수강신청 및 정정이 불가능하오니, 반드시 기간 내에 신청을 완료해 주십시오.

학점 제한: 학년별 최대 수강신청 가능 학점을 확인하고, 초과하여 신청하지 않도록 유의해 주십시오. (초과 신청 시 자동 취소될 수 있습니다.)

폐강 기준: 수강신청 인원이 최소 폐강 기준에 미달하는 강좌는 폐강될 수 있습니다. 폐강 강좌 발생 시 개별 안내될 예정입니다.

이수 구분 확인: 졸업 이수 기준에 맞춰 전공, 교양 등의 이수 구분을 정확히 확인하고 신청하시기 바랍니다.

강의 시간표 확인: 동일 시간대에 중복되는 강좌가 없도록 강의 시간표를 철저히 확인하시기 바랍니다.

PC 환경: 원활한 수강신청을 위해 안정적인 인터넷 환경과 PC를 이용해 주시기 바랍니다. (모바일 환경에서는 일부 기능이 제한될 수 있습니다.)

📞 문의처
수강신청 관련 문의: 교무처 (☎ XXXX-XXXX)

시스템 오류 관련 문의: 전산정보원 (☎ XXXX-XXXX)

학생 여러분의 성공적인 수강신청을 기원합니다.

감사합니다.

[학교명] 교무처`;
}

function fillDemoLectureForm() {
    // 강의명
    document.getElementById("lecName").value = "캡스톤 디자인";

    // 강의 분류 (첫 번째 실제 옵션 선택)
    const lecCategory = document.getElementById("lecCategory");
    if (lecCategory.options.length > 1) lecCategory.selectedIndex = 3;

    // 강의 과목
    const subjectCode = document.getElementById("subjectCode");
    if (subjectCode.options.length > 1) subjectCode.selectedIndex = 37;

    // 희망 요일 및 교시
    document.getElementById("preDay").value = "월, 수";
    document.getElementById("preTime").value = "2, 3교시";

    // 강의실
    const preClassrm = document.getElementById("preClassrm");
    if (preClassrm.options.length > 1) preClassrm.selectedIndex = 11;

    // 수강정원
    document.getElementById("maxCapacity").value = "40";

    // 파일 입력은 보안상 JS로 자동입력 불가능 (수동 업로드 필요)
}

document.addEventListener("DOMContentLoaded", function () {
  const addButton = document.getElementById("addDummyQuestions");
  const questionField = document.querySelector(".questionField");

  addButton.addEventListener("click", function () {
    const countInput = document.querySelector("input[name='questionCount']");
    const count = parseInt(countInput.value);

    if (isNaN(count) || count <= 0) {
      alert("문제 수를 올바르게 입력하세요.");
      return;
    }

    // 기존 내용 초기화
    questionField.innerHTML = "";

    for (let i = 1; i <= count; i++) {
      const questionDiv = document.createElement("div");
      questionDiv.className = "form-group";
      questionDiv.style.marginBottom = "10px";

      questionDiv.innerHTML = `
        <label class="inputLabel">문제 ${i}</label>
        <input type="text" name="questions[${i - 1}].content" placeholder="문제 내용을 입력하세요" class="inputField" required>
        <input type="text" name="questions[${i - 1}].answer" placeholder="정답 입력" class="inputField" required>
      `;

      questionField.appendChild(questionDiv);
    }
  });
});

function fillDemoProgramForm() {
    // 프로그램명
    document.querySelector('[name="programTitle"]').value = "리더십 개발 워크숍";

    // 유형 선택 (typeCode)
    const typeCode = document.querySelector('[name="typeCode"]');
    if (typeCode && typeCode.options.length > 1) typeCode.selectedIndex = 1; // 예: 두 번째 옵션

    // 정원
    document.querySelector('[name="programCapacity"]').value = 25;

    // 장소
    document.querySelector('[name="place"]').value = "국제관 402호";

    // 운영 시작일
    document.querySelector('[name="startDate"]').value = "2025-08-10";

    // 운영 종료일
    document.querySelector('[name="endDate"]').value = "2025-08-12";

    // 사용 여부 (programActive)
    const programActive = document.querySelector('[name="programActive"]');
    if (programActive && programActive.options.length > 0) programActive.value = "Y";

    // 프로그램 설명
    document.querySelector('[name="programDesp"]').value = "학생들의 자기주도성과 협업 능력을 향상시키기 위한 리더십 개발 프로그램입니다.";
}

function fillDemoNoticeForm() {
    const typeCode = document.getElementById("typeCode");
    if (typeCode && typeCode.options.length > 1) typeCode.value = "ACA_SCH"; // 예: [학사]수강신청

    document.getElementById("boardTitle").value = "2학기 수강신청 일정 안내";
    document.getElementById("boardContent").value = `2025학년도 2학기 수강신청 일정은 다음과 같습니다.

- 수강신청 기간: 2025년 8월 2일(월) ~ 8월 5일(금)
- 정정 기간: 2025년 9월 1일(월) ~ 9월 5일(금)

수강신청 관련 문의는 학사팀(02-1234-5678)으로 연락주시기 바랍니다.`;
  }
