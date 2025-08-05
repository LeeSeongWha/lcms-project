

/**
 * 
 */
function showTab(tabName, event) {
  document.querySelectorAll('.tabButton').forEach(btn => {
    btn.classList.remove('tabButtonActive');
  });
  event.target.classList.add('tabButtonActive');
  console.log('선택된 탭:', tabName);
}

// 전체 선택/해제
function toggleSelectAll() {
	const selectAll = document.getElementById('selectAll');
	const checkboxes = document.querySelectorAll('#tableBody input[type="checkbox"]');

	checkboxes.forEach(checkbox => {
		checkbox.checked = selectAll.checked;
	});
}

// 검색 및 필터 함수
function filterApplications() {
	const typeFilter = document.getElementById('typeFilter').value;
	const statusFilter = document.getElementById('statusFilter').value;
	const searchInput = document.getElementById('searchInput').value;

	console.log('필터 조건:', { typeFilter, statusFilter, searchInput });
	// 실제 필터링 로직 구현
}

// 상세보기 모달 표시
function viewDetail(id) {
	// 샘플 데이터로 모달 채우기
	document.getElementById('detailAppNo').value = 'AC2024' + String(id).padStart(3, '0');
	document.getElementById('detailStudentId').value = '2024010' + id;
	document.getElementById('detailStudentName').value = ['김학생', '이학생', '박학생', '최학생', '정학생'][id - 1];
	document.getElementById('detailType').value = ['전공변경', '복수전공', '휴학', '복학', '졸업유예'][id - 1];
	document.getElementById('detailDate').value = '2024-01-' + (14 + id);
	document.getElementById('detailReason').value = '개인적인 사유로 인한 신청입니다.';

	document.getElementById('detailModal').style.display = 'block';
}

// 모달 닫기
function closeModal(modalId) {
	document.getElementById(modalId).style.display = 'none';
}

// 신청 승인
function approveApplication(id) {
	if (confirm('이 신청을 승인하시겠습니까?')) {
		console.log('신청 승인:', id);
		// 실제 승인 처리 로직
	}
}

// 신청 반려
function rejectApplication(id) {
	const reason = prompt('반려 사유를 입력하세요:');
	if (reason) {
		console.log('신청 반려:', id, '사유:', reason);
		// 실제 반려 처리 로직
	}
}

// 상태 저장
function saveApplicationStatus() {
	const status = document.getElementById('detailStatus').value;
	const comment = document.getElementById('detailComment').value;

	console.log('상태 변경:', { status, comment });
	alert('처리 상태가 저장되었습니다.');
	closeModal('detailModal');
}

// 알림 발송
function sendNotification() {
	alert('학생에게 처리 상태 알림이 발송되었습니다.');
}

// 엑셀 다운로드
function exportData() {
	console.log('엑셀 다운로드 실행');
	alert('엑셀 파일이 다운로드됩니다.');
}

// 일괄 처리
function showBulkActions() {
	const selectedItems = document.querySelectorAll('#tableBody input[type="checkbox"]:checked');
	if (selectedItems.length === 0) {
		alert('처리할 항목을 선택해주세요.');
		return;
	}

	const action = confirm('선택된 항목들을 일괄 승인하시겠습니까?\n취소를 누르면 일괄 반려됩니다.');
	if (action) {
		console.log('일괄 승인');
	} else {
		console.log('일괄 반려');
	}
}

// 증명서 출력
function printCertificate(id) {
	console.log('증명서 출력:', id);
	alert('증명서가 출력됩니다.');
}

// 반려 사유 확인
function viewRejectReason(id) {
	alert('반려 사유: 제출 서류가 불완전합니다. 필요한 서류를 모두 제출해주세요.');
}

// 모달 외부 클릭시 닫기
window.onclick = function(event) {
	const modals = document.querySelectorAll('.modal');
	modals.forEach(modal => {
		if (event.target === modal) {
			modal.style.display = 'none';
		}
	});
}