<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학적 변경 신청 관리 시스템</title>
    <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
    <link rel="stylesheet" href="/dist/assets/css/staff/requestCollection.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
    
</head>
<body>
    <div class="container">
        <h1 class="pageTitle">
            <i class="fas fa-graduation-cap"></i>
            학적 변경 신청 관리 시스템
        </h1>

        <!-- 통계 카드 -->
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-number">${requestStatus.total }</div>
                <div class="stat-label">전체 신청</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);">
                <div class="stat-number">${requestStatus.waiting }</div>
                <div class="stat-label">대기 중</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);">
                <div class="stat-number">${requestStatus.rejected }</div>
                <div class="stat-label">반려 처리</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);">
                <div class="stat-number">${requestStatus.complete }</div>
                <div class="stat-label">승인 완료</div>
            </div>
        </div>

        <!-- 탭 네비게이션 -->
        <div class="tabContainer">
            <button class="tabButton tabButtonActive" onclick="showTab('all')">
                <i class="fas fa-list"></i> 전체 신청
            </button>
            <button class="tabButton" onclick="showTab('AC_MAJOR')">
                <i class="fas fa-book"></i> 전공 변경
            </button>
            <button class="tabButton" onclick="showTab('AC_DOUBLE')">
                <i class="fas fa-bookmark"></i> 복수 전공
            </button>
            <button class="tabButton" onclick="showTab('AC_SUSPEND')">
                <i class="fas fa-exchange-alt"></i> 휴학
            </button>
            <button class="tabButton" onclick="showTab('AC_RETURN')">
                <i class="fas fa-user-minus"></i> 복학
            </button>
            <button class="tabButton" onclick="showTab('AC_GRADSUS')">
                <i class="fas fa-door-open"></i> 졸업 유예
            </button>
        </div>

        <!-- 검색 및 필터 -->
        <div class="card">
            <h2>
                <i class="fas fa-search"></i>
                검색 및 필터
            </h2>
            <form method="get" action="/staff/requestCollection/requestCollection.do" style="margin-bottom: 1rem;">
            <div class="form-row">
                <div class="form-group">
                    <label class="inputLabel">처리 상태</label>
                    <select class="selectBox" id="statusFilter" name="status">
					    <option value="" ${status == null ? 'selected' : ''}>전체</option>
					    <option value="대기중" ${status == '대기중' ? 'selected' : ''}>대기 중</option>
					    <option value="승인" ${status == '승인' ? 'selected' : ''}>승인</option>
					    <option value="반려" ${status == '반려' ? 'selected' : ''}>반려</option>
					</select>
                </div>
                <div class="form-group">
                    <label class="inputLabel">검색 항목</label>
                    <select class="selectBox" name="searchType">
                        <option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
						<option value="requestNo" ${searchType == 'requestNo' ? 'selected' : ''}>신청번호</option>
						<option value="userNo" ${searchType == 'userNo' ? 'selected' : ''}>학번</option>
						<option value="userName" ${searchType == 'userName' ? 'selected' : ''}>이름</option>
						<option value="departmentName" ${searchType == 'departmentName' ? 'selected' : ''}>학과</option>
						<option value="collegeName" ${searchType == 'collegeName' ? 'selected' : ''}>단과대학</option>
						<option value="typeName" ${searchType == 'typeName' ? 'selected' : ''}>신청유형</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="inputLabel">검색어</label>
                    <input type="text" class="inputField" name="keyword" id="searchInput" placeholder="학번 또는 이름을 입력하세요" value="${keyword}">
                </div>
				<div class="form-group" style="flex: 0;">
					<button class="searchButton" type="submit" class="submitButton">
						<i class="fas fa-search"></i> 검색
					</button>
				</div>
			</div>
			</form>
        </div>

        <!-- 신청 목록 -->
        <div class="card">
            <div class="sectionHeaderLine">
                <div>
                    <h2 class="sectionHeaderTitle">학적 변경 신청 목록</h2>
                    <p class="sectionHeaderDescription">학생들의 학적 변경 신청을 관리하고 처리할 수 있습니다.</p>
                </div>
            </div>

            <div class="tableContainer">
                <table class="defaultTable" id="applicationsTable">
                    <thead class="tableHead">
                        <tr>
                            <th class="tableTh">
                                <input type="checkbox" class="checkbox" id="selectAll" onchange="toggleSelectAll()">
                            </th>
                            <th class="tableTh">신청번호</th>
                            <th class="tableTh">신청일</th>
                            <th class="tableTh">학번</th>
                            <th class="tableTh">이름</th>
                            <th class="tableTh">학과</th>
                            <th class="tableTh">단과대학</th>
                            <th class="tableTh">신청 유형</th>
                            <th class="tableTh">신청 내용</th>
                            <th class="tableTh">처리 상태</th>
<!--                             <th class="tableTh">처리자</th> -->
<!--                             <th class="tableTh">관리</th> -->
                        </tr>
                    </thead>
                    <tbody>
				        <c:forEach var="request" items="${requestList}" varStatus="status">
				            <tr>
				                <td class="tableTd">${status.index + 1}</td>
				                <td class="tableTd">${request.requestNo}</td>
				                <td class="tableTd">${request.requestDate}</td>
				                <td class="tableTd">${request.userNo}</td>
				                <td class="tableTd">${request.user.userName}</td>
				                <td class="tableTd">${request.department.departmentName}</td>
				                <td class="tableTd">${request.college.collegeName}</td>
				                <td class="tableTd">${request.type.typeName}</td>
				                <td class="tableTd">${request.reason}</td>
				                <td class="tableTd">
				                    <c:choose>
				                        <c:when test="${request.status == '대기중'}">
				                            <span class="status-waiting badge badgeYellow">대기중</span>
				                        </c:when>
				                        <c:when test="${request.status == '반려'}">
				                            <span class="status-processing badge badgeRed">반려</span>
				                        </c:when>
				                        <c:when test="${request.status == '완료'}">
				                            <span class="status-complete badge badgeGreen">완료</span>
				                        </c:when>
				                        <c:otherwise>
				                            ${request.status}
				                        </c:otherwise>
				                    </c:choose>
				                </td>
				            </tr>
				        </c:forEach>
				    </tbody>
                </table>
            </div>

            <!-- 페이지네이션 -->
            <div class="pagination">
				<c:if test="${paging.currentPageNo > 10}">
					<a href="?page=${paging.firstPageNoOnPageList - paging.pageSize}&keyword=${keyword}" class="pageButton">이전</a>
				</c:if>
			
				<c:forEach var="i" begin="${paging.firstPageNoOnPageList}" end="${paging.lastPageNoOnPageList}">
					<c:choose>
						<c:when test="${i == paging.currentPageNo}">
							<strong class="pageButton active">${i}</strong>
						</c:when>
						<c:otherwise>
							<a href="?page=${i}&keyword=${keyword}" class="pageButton">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			
				<c:if test="${paging.currentPageNo < paging.totalPageCount}">
					<a href="?page=${paging.firstPageNoOnPageList + paging.pageSize}&keyword=${keyword}" class="pageButton">다음</a>
				</c:if>
			</div>
        </div>
    </div>

    <!-- 상세보기 모달 -->
    <div id="detailModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2><i class="fas fa-file-alt"></i> 신청 상세 정보</h2>
                <span class="close" onclick="closeModal('detailModal')">&times;</span>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="inputLabel">신청번호</label>
                    <input type="text" class="inputField" id="detailAppNo" readonly>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label class="inputLabel">학번</label>
                        <input type="text" class="inputField" id="detailStudentId" readonly>
                    </div>
                    <div class="form-group">
                        <label class="inputLabel">이름</label>
                        <input type="text" class="inputField" id="detailStudentName" readonly>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group">
                        <label class="inputLabel">신청 유형</label>
                        <input type="text" class="inputField" id="detailType" readonly>
                    </div>
                    <div class="form-group">
                        <label class="inputLabel">신청일</label>
                        <input type="text" class="inputField" id="detailDate" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label class="inputLabel">신청 사유</label>
                    <textarea class="textareaField" id="detailReason" readonly style="height: 100px;"></textarea>
                </div>
                <div class="attachment-section">
                    <span class="attachment-label">첨부파일:</span>
                    <a href="#" class="download-button">
                        <i class="fas fa-download"></i> 성적증명서.pdf (2.1MB)
                    </a>
                    <a href="#" class="download-button">
                        <i class="fas fa-download"></i> 신청서.pdf (1.5MB)
                    </a>
                </div>
                <div class="form-group">
                    <label class="inputLabel">처리 상태</label>
                    <select class="selectBox" id="detailStatus">
                        <option value="대기">대기 중</option>
                        <option value="처리중">처리 중</option>
                        <option value="승인">승인</option>
                        <option value="반려">반려</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="inputLabel">처리 의견</label>
                    <textarea class="textareaField" id="detailComment" placeholder="처리 의견을 입력하세요..."></textarea>
                </div>
                <div class="button-group">
                    <button class="submitButton" onclick="saveApplicationStatus()">
                        <i class="fas fa-save"></i> 저장
                    </button>
                    <button class="editButton" onclick="sendNotification()">
                        <i class="fas fa-envelope"></i> 알림 발송
                    </button>
                    <button class="cancelButton" onclick="closeModal('detailModal')">
                        <i class="fas fa-times"></i> 닫기
                    </button>
                </div>
            </div>
        </div>
    </div>

<script>
	
	
	// 탭 전환 함수
	function showTab(tabName) {
	    // 모든 탭 버튼에서 active 클래스 제거
	    document.querySelectorAll('.tabButton').forEach(btn => {
	        btn.classList.remove('tabButtonActive');
	    });
	    
	    // 클릭된 탭에 active 클래스 추가
	    event.target.classList.add('tabButtonActive');
	    
	    // 실제 탭별 필터링 로직은 여기에 구현
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
	    document.getElementById('detailStudentName').value = ['김학생', '이학생', '박학생', '최학생', '정학생'][id-1];
	    document.getElementById('detailType').value = ['전공변경', '복수전공', '휴학', '복학', '졸업유예'][id-1];
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
	</script>
</body>
</html>