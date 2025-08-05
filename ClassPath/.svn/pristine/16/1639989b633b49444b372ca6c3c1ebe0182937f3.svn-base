<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학적 변경 신청 관리 시스템</title>
    <link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
    <style>
        .container {
            max-width: 1400px;
            margin: 0 auto;
            padding: 20px;
        }
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 1.5rem;
            margin-bottom: 2rem;
        }
        .stat-card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .stat-number {
            font-size: 2.5rem;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .stat-label {
            font-size: 1rem;
            opacity: 0.9;
        }
        .form-row {
            display: flex;
            gap: 1rem;
            margin-bottom: 1rem;
            align-items: end;
        }
        .form-group {
            flex: 1;
        }
        .button-group {
            display: flex;
            gap: 1rem;
            flex-wrap: wrap;
            margin-bottom: 1rem;
        }
        .action-buttons {
            display: flex;
            gap: 0.5rem;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.5);
        }
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 0;
            border-radius: 10px;
            width: 90%;
            max-width: 600px;
            max-height: 80vh;
            overflow-y: auto;
        }
        .modal-header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            border-radius: 10px 10px 0 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .modal-body {
            padding: 20px;
        }
        .close {
            color: white;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }
        .close:hover {
            opacity: 0.7;
        }
        .status-pending { background-color: #fef3c7; color: #92400e; }
        .status-approved { background-color: #d1fae5; color: #065f46; }
        .status-rejected { background-color: #fee2e2; color: #b91c1c; }
        .status-processing { background-color: #e0e7ff; color: #3730a3; }
    </style>
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
                <div class="stat-number">24</div>
                <div class="stat-label">전체 신청</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);">
                <div class="stat-number">8</div>
                <div class="stat-label">대기 중</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);">
                <div class="stat-number">12</div>
                <div class="stat-label">처리 중</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);">
                <div class="stat-number">4</div>
                <div class="stat-label">승인 완료</div>
            </div>
        </div>

        <!-- 탭 네비게이션 -->
        <div class="tabContainer">
            <button class="tabButton tabButtonActive" onclick="showTab('all')">
                <i class="fas fa-list"></i> 전체 신청
            </button>
            <button class="tabButton" onclick="showTab('major')">
                <i class="fas fa-book"></i> 전공 변경
            </button>
            <button class="tabButton" onclick="showTab('minor')">
                <i class="fas fa-bookmark"></i> 복수 전공
            </button>
            <button class="tabButton" onclick="showTab('transfer')">
                <i class="fas fa-exchange-alt"></i> 휴학
            </button>
            <button class="tabButton" onclick="showTab('dropout')">
                <i class="fas fa-user-minus"></i> 복학
            </button>
            <button class="tabButton" onclick="showTab('leave')">
                <i class="fas fa-door-open"></i> 졸업 유예
            </button>
        </div>

        <!-- 검색 및 필터 -->
        <div class="card">
            <h2>
                <i class="fas fa-search"></i>
                검색 및 필터
            </h2>
            <div class="form-row">
                <div class="form-group">
                    <label class="inputLabel">신청 유형</label>
                    <select class="selectBox" id="typeFilter">
                        <option value="">전체</option>
                        <option value="전공변경">전공 변경</option>
                        <option value="복수전공">복수 전공</option>
                        <option value="휴학">휴학</option>
                        <option value="복학">복학</option>
                        <option value="졸업유예">졸업 유예</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="inputLabel">처리 상태</label>
                    <select class="selectBox" id="statusFilter">
                        <option value="">전체</option>
                        <option value="대기">대기 중</option>
                        <option value="처리중">처리 중</option>
                        <option value="승인">승인</option>
                        <option value="반려">반려</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="inputLabel">학번/이름 검색</label>
                    <input type="text" class="inputField" id="searchInput" placeholder="학번 또는 이름을 입력하세요">
                </div>
                <div class="form-group" style="flex: 0;">
                    <button class="searchButton" onclick="filterApplications()">
                        <i class="fas fa-search"></i> 검색
                    </button>
                </div>
            </div>
        </div>

        <!-- 신청 목록 -->
        <div class="card">
            <div class="sectionHeaderLine">
                <div>
                    <h2 class="sectionHeaderTitle">학적 변경 신청 목록</h2>
                    <p class="sectionHeaderDescription">학생들의 학적 변경 신청을 관리하고 처리할 수 있습니다.</p>
                </div>
                <div class="button-group">
                    <button class="submitButton" onclick="exportData()">
                        <i class="fas fa-download"></i> 엑셀 다운로드
                    </button>
                    <button class="editButton" onclick="showBulkActions()">
                        <i class="fas fa-tasks"></i> 일괄 처리
                    </button>
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
                            <th class="tableTh">신청 유형</th>
                            <th class="tableTh">신청 내용</th>
                            <th class="tableTh">처리 상태</th>
                            <th class="tableTh">처리자</th>
                            <th class="tableTh">관리</th>
                        </tr>
                    </thead>
                    <tbody id="tableBody">
                        <tr class="tableRowHover tableRowStripe">
                            <td class="tableTd"><input type="checkbox" class="checkbox" value="1"></td>
                            <td class="tableTd">AC2024001</td>
                            <td class="tableTd">2024-01-15</td>
                            <td class="tableTd">20240101</td>
                            <td class="tableTd">김학생</td>
                            <td class="tableTd">전공변경</td>
                            <td class="tableTd">컴퓨터공학과 → 소프트웨어학과</td>
                            <td class="tableTd">
                                <span class="badge status-pending">대기 중</span>
                            </td>
                            <td class="tableTd">-</td>
                            <td class="tableTd">
                                <div class="action-buttons">
                                    <button class="editButton" onclick="viewDetail(1)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                    <button class="submitButton" onclick="approveApplication(1)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-check"></i>
                                    </button>
                                    <button class="deleteButton" onclick="rejectApplication(1)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <tr class="tableRowHover tableRowStripe">
                            <td class="tableTd"><input type="checkbox" class="checkbox" value="2"></td>
                            <td class="tableTd">AC2024002</td>
                            <td class="tableTd">2024-01-16</td>
                            <td class="tableTd">20240102</td>
                            <td class="tableTd">이학생</td>
                            <td class="tableTd">복수전공</td>
                            <td class="tableTd">경영학과 복수전공 신청</td>
                            <td class="tableTd">
                                <span class="badge status-processing">처리 중</span>
                            </td>
                            <td class="tableTd">관리자1</td>
                            <td class="tableTd">
                                <div class="action-buttons">
                                    <button class="editButton" onclick="viewDetail(2)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                    <button class="submitButton" onclick="approveApplication(2)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-check"></i>
                                    </button>
                                    <button class="deleteButton" onclick="rejectApplication(2)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <tr class="tableRowHover tableRowStripe">
                            <td class="tableTd"><input type="checkbox" class="checkbox" value="3"></td>
                            <td class="tableTd">AC2024003</td>
                            <td class="tableTd">2024-01-17</td>
                            <td class="tableTd">20240103</td>
                            <td class="tableTd">박학생</td>
                            <td class="tableTd">휴학</td>
                            <td class="tableTd">일반휴학 (2024-1학기)</td>
                            <td class="tableTd">
                                <span class="badge status-approved">승인</span>
                            </td>
                            <td class="tableTd">관리자2</td>
                            <td class="tableTd">
                                <div class="action-buttons">
                                    <button class="editButton" onclick="viewDetail(3)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                    <button class="saveButton" onclick="printCertificate(3)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-print"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <tr class="tableRowHover tableRowStripe">
                            <td class="tableTd"><input type="checkbox" class="checkbox" value="4"></td>
                            <td class="tableTd">AC2024004</td>
                            <td class="tableTd">2024-01-18</td>
                            <td class="tableTd">20240104</td>
                            <td class="tableTd">최학생</td>
                            <td class="tableTd">복학</td>
                            <td class="tableTd">일반복학 (2024-2학기)</td>
                            <td class="tableTd">
                                <span class="badge status-rejected">반려</span>
                            </td>
                            <td class="tableTd">관리자1</td>
                            <td class="tableTd">
                                <div class="action-buttons">
                                    <button class="editButton" onclick="viewDetail(4)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                    <button class="cancelButton" onclick="viewRejectReason(4)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-info"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <tr class="tableRowHover tableRowStripe">
                            <td class="tableTd"><input type="checkbox" class="checkbox" value="5"></td>
                            <td class="tableTd">AC2024005</td>
                            <td class="tableTd">2024-01-19</td>
                            <td class="tableTd">20240105</td>
                            <td class="tableTd">정학생</td>
                            <td class="tableTd">졸업유예</td>
                            <td class="tableTd">졸업유예 신청 (논문 준비)</td>
                            <td class="tableTd">
                                <span class="badge status-pending">대기 중</span>
                            </td>
                            <td class="tableTd">-</td>
                            <td class="tableTd">
                                <div class="action-buttons">
                                    <button class="editButton" onclick="viewDetail(5)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-eye"></i>
                                    </button>
                                    <button class="submitButton" onclick="approveApplication(5)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-check"></i>
                                    </button>
                                    <button class="deleteButton" onclick="rejectApplication(5)" style="padding: 0.25rem 0.5rem; font-size: 0.75rem;">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <!-- 페이지네이션 -->
            <div class="pagination">
                <button class="pageButton">이전</button>
                <button class="pageButton active">1</button>
                <button class="pageButton">2</button>
                <button class="pageButton">3</button>
                <button class="pageButton">다음</button>
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
    </script>
</body>
</html>