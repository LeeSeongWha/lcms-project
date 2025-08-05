<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%--
    파일명 : facilityList.jsp
    프로그렴명 : 시설 전체 조회 화면
    설 명 : 등록된 시설물 전체를 조회할 수 있음.
    작성자 : 이 성 화
    작성일 : 2025. 07. 16
--%>

<title>시설 목록</title>
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">

<div class="card max-w-6xl mx-auto p-6">

	<!-- ======================================== -->
	<div class="sectionHeaderLine">
		<!-- 왼쪽 제목 및 설명 -->
		<div>
			<div class="sectionHeaderTitle">시설 목록</div>
			<div class="sectionHeaderDescription">전체 ${count}개의 게시글</div>
		</div>
	</div>
	<div class="mb-6">
		<div style="display: flex; justify-content: flex-end;">
			<div style="position: relative; width: 20%;">
				<input type="text" id="facilitySearchInput"
					placeholder="시설명 또는 시설 유형으로 검색" class="inputField"
					style="padding-right: 3rem;" />
				<button type="button" onclick="searchFacilities()"
					style="position: absolute; right: 0.5rem; top: 50%; transform: translateY(-50%); background: none; border: none; color: #3b82f6; cursor: pointer; font-size: 1rem;">
					🔍</button>
			</div>
		</div>

	</div>
	<!-- ======================================== -->

	<!-- 시설 검색 -->

	<!-- 시설 목록 -->
	<div class="tableContainer overflow-x-auto">
		<table class="defaultTable">
			<thead class="tableHead">
				<tr>
					<!-- <th class="tableTh">시설 코드</th> -->
					<th class="tableTh text-left">번호</th>
					<th class="tableTh text-left">시설명</th>
					<th class="tableTh text-left">시설 유형</th>
					<th class="tableTh text-left">위치</th>
					<th class="tableTh text-left">수용 인원</th>
					<th class="tableTh text-left">시설 상태</th>
				</tr>
			</thead>
			<tbody id="facilityTableBody"
				class="bg-white divide-y divide-gray-100">
				<c:choose>
					<c:when test="${not empty facility }">
						<c:forEach items="${facility }" var="facility" varStatus="status">
							<tr class="tableRowHover tableRowStripe" style="cursor: pointer;"
								onclick="openFacilityModal('${facility.facilityNo}', '${facility.facilityName}', '${facility.facilityType}', '${facility.location}', '${facility.facilityMp}', '${facility.facilityStatus}')">
								<td class="tableTd">${status.index+1 }</td>
								<td class="tableTd">${facility.facilityName}</td>
								<td class="tableTd">${facility.facilityType}</td>
								<td class="tableTd">${facility.location}</td>
								<td class="tableTd">${facility.facilityMp}</td>
								<td class="tableTd"><c:choose>
										<c:when test="${facility.facilityStatus == 'AVAILABLE'}">
											<span
												class="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-green-100 text-green-800">
												🟢 이용 가능 </span>
										</c:when>
										<c:when test="${facility.facilityStatus == 'UNAVAILABLE' || facility.facilityStatus == 'MAINTENANCE'}">
											<span
												class="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-red-100 text-red-800">
												🔴 이용 불가능 </span>
										</c:when>
										<c:otherwise>
											<span
												class="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-gray-100 text-gray-800">
												상태 미정 </span>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</c:when>

					<c:otherwise>
						<tr>
							<td colspan="6" class="tableTd noticeInfo text-center">아직 시설
								없음.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

<!-- 시설 상세 정보 모달 -->
<div id="facilityModal" style="display: none; position: fixed; z-index: 9999; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4);">
    <div style="background-color: #fefefe; margin: 5% auto; padding: 20px; border: 1px solid #888; border-radius: 10px; width: 80%; max-width: 800px; max-height: 80vh; overflow-y: auto;">
        <!-- 모달 헤더 -->
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; border-bottom: 1px solid #eee; padding-bottom: 15px;">
            <h2 style="font-size: 1.5em; font-weight: bold; margin: 0;">시설 상세 정보</h2>
            <button onclick="closeFacilityModal()" style="background: none; border: none; font-size: 24px; cursor: pointer; color: #aaa;">&times;</button>
        </div>

        <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 30px;">
            <!-- 기본 정보 -->
            <div>
                <h3 style="font-size: 1.2em; font-weight: bold; margin-bottom: 15px;">🏢 기본 정보</h3>
                
                <div>
                    <div style="margin-bottom: 15px;">
                        <label style="display: block; font-weight: bold; margin-bottom: 5px;">시설명</label>
                        <div style="border: 1px solid #ddd; padding: 8px 12px; border-radius: 4px; background-color: #f9f9f9;" id="modalFacilityName">
                        </div>
                    </div>

                    <div style="margin-bottom: 15px;">
                        <label style="display: block; font-weight: bold; margin-bottom: 5px;">시설 유형</label>
                        <div style="border: 1px solid #ddd; padding: 8px 12px; border-radius: 4px; background-color: #f9f9f9;" id="modalFacilityType">
                        </div>
                    </div>

                    <div style="margin-bottom: 15px;">
                        <label style="display: block; font-weight: bold; margin-bottom: 5px;">위치</label>
                        <div style="border: 1px solid #ddd; padding: 8px 12px; border-radius: 4px; background-color: #f9f9f9;" id="modalLocation">
                        </div>
                    </div>

                    <div style="margin-bottom: 15px;">
                        <label style="display: block; font-weight: bold; margin-bottom: 5px;">수용 인원</label>
                        <div style="border: 1px solid #ddd; padding: 8px 12px; border-radius: 4px; background-color: #f9f9f9;" id="modalFacilityMp">
                        </div>
                    </div>

                    <div style="margin-bottom: 15px;">
                        <label style="display: block; font-weight: bold; margin-bottom: 5px;">시설물 상태</label>
                        <div style="border: 1px solid #ddd; padding: 8px 12px; border-radius: 4px; background-color: #f9f9f9;" id="modalFacilityStatus">
                        </div>
                    </div>
                </div>
            </div>

            <!-- 이용 안내 -->
            <div>
                <h3 style="font-size: 1.2em; font-weight: bold; margin-bottom: 15px;">📋 이용 안내</h3>
                
                <div style="background-color: #e3f2fd; border: 1px solid #90caf9; border-radius: 8px; padding: 15px; margin-bottom: 15px;">
                    <h4 style="font-weight: bold; margin-bottom: 10px; color: #1565c0;">💡 이용 시 참고사항</h4>
                    <ul style="margin: 0; padding-left: 20px; color: #1976d2;">
                        <li style="margin-bottom: 5px;">예약은 이용일 7일 전부터 가능합니다</li>
                        <li style="margin-bottom: 5px;">예약 취소는 이용일 1일 전까지 가능합니다</li>
                        <li style="margin-bottom: 5px;">시설 이용 시간은 09:00 ~ 22:00 입니다</li>
                        <li style="margin-bottom: 5px;">시설 이용 후 정리정돈을 부탁드립니다</li>
                    </ul>
                </div>

                <div id="modalUnavailableNotice" style="background-color: #ffebee; border: 1px solid #ef9a9a; border-radius: 8px; padding: 15px; display: none;">
                    <h4 style="font-weight: bold; margin-bottom: 10px; color: #c62828;">⚠️ 이용 불가 안내</h4>
                    <p style="margin: 0; color: #d32f2f;" id="modalUnavailableText">
                    </p>
                </div>
            </div>
        </div>

        <!-- 하단 버튼 영역 -->
        <div style="margin-top: 30px; text-align: center; border-top: 1px solid #eee; padding-top: 20px;">
            <button onclick="closeFacilityModal()" 
                   style="background-color: #6c757d; color: white; padding: 10px 24px; border: none; border-radius: 4px; margin-right: 10px; cursor: pointer;">
                닫기
            </button>
            <button id="modalReservationBtn" onclick="goToReservation()" 
                   style="background-color: #007bff; color: white; padding: 10px 24px; border: none; border-radius: 4px; cursor: pointer; display: none;">
                예약하기
            </button>
        </div>
    </div>
</div>

<script>
	let currentFacilityNo = '';

	function searchFacilities() {
		const searchInput = document.getElementById('facilitySearchInput').value
				.toLowerCase();
		const tableRows = document.getElementById('facilityTableBody')
				.getElementsByTagName('tr');

		for (let i = 0; i < tableRows.length; i++) {
			const row = tableRows[i];
			const facilityName = row.cells[1] ? row.cells[1].textContent
					.toLowerCase() : '';
			const facilityType = row.cells[2] ? row.cells[2].textContent
					.toLowerCase() : '';

			if (facilityName.includes(searchInput)
					|| facilityType.includes(searchInput)) {
				row.style.display = '';
			} else {
				row.style.display = 'none';
			}
		}
	}

	document.getElementById('facilitySearchInput').addEventListener('keyup',
			function(event) {
				if (event.key === 'Enter') {
					searchFacilities();
				}
			});

	function showAddFacilityPage() {
		alert('새 시설 등록 페이지로 이동합니다.');
		window.location.href = '/staff/facility/facilityInsert.do';
	}

	function openFacilityModal(facilityNo, facilityName, facilityType, location, facilityMp, facilityStatus) {
		currentFacilityNo = facilityNo;
		
		// 모달에 데이터 설정
		document.getElementById('modalFacilityName').textContent = facilityName;
		document.getElementById('modalFacilityType').textContent = facilityType;
		document.getElementById('modalLocation').textContent = location;
		document.getElementById('modalFacilityMp').textContent = facilityMp + '명';
		
		// 시설 상태 설정
		const statusElement = document.getElementById('modalFacilityStatus');
		const unavailableNotice = document.getElementById('modalUnavailableNotice');
		const unavailableText = document.getElementById('modalUnavailableText');
		const reservationBtn = document.getElementById('modalReservationBtn');
		
		if (facilityStatus === 'AVAILABLE') {
			statusElement.innerHTML = '<span class="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-green-100 text-green-800">✅ 이용 가능</span>';
			unavailableNotice.style.display = 'none';
			reservationBtn.style.display = 'inline-block';
		} else if (facilityStatus === 'MAINTENANCE') {
			statusElement.innerHTML = '<span class="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-yellow-100 text-yellow-800">🔧 유지보수중 (이용 불가능)</span>';
			unavailableText.textContent = '현재 이 시설은 유지보수 중이므로 예약이 불가능합니다.';
			unavailableNotice.style.display = 'block';
			reservationBtn.style.display = 'none';
		} else {
			statusElement.innerHTML = '<span class="inline-flex items-center px-2 py-1 rounded-full text-xs font-medium bg-red-100 text-red-800">❌ 이용 불가능</span>';
			unavailableText.textContent = '현재 이 시설은 이용이 불가능한 상태입니다.';
			unavailableNotice.style.display = 'block';
			reservationBtn.style.display = 'none';
		}
		
		// 모달 표시
		document.getElementById('facilityModal').style.display = 'block';
	}

	function closeFacilityModal() {
		document.getElementById('facilityModal').style.display = 'none';
	}

	function goToReservation() {
		window.location.href = '/student/facility/reservation.do?facilityNo=' + currentFacilityNo;
	}

	// 모달 외부 클릭 시 닫기
	window.onclick = function(event) {
		const modal = document.getElementById('facilityModal');
		if (event.target === modal) {
			closeFacilityModal();
		}
	}

	// ESC 키로 모달 닫기
	document.addEventListener('keydown', function(event) {
		if (event.key === 'Escape') {
			closeFacilityModal();
		}
	});
</script>